@echo off
setlocal enabledelayedexpansion

:: === CẤU HÌNH ===
set allowed_user=as
set repo_path=C:\xampp\htdocs\SystemDoctor\nhom5
set log_file=%repo_path%\sync-log_%date:~-4%%date:~3,2%%date:~0,2%.txt
set interval=10
set lock_file=%repo_path%\auto-sync.lock

:: Kiểm tra instance đang chạy
if exist "%lock_file%" (
    echo [%date% %time%] ❌ Script đang chạy ở instance khác >> "%log_file%"
    exit /b
)
echo Running > "%lock_file%"

:: Kiểm tra người dùng
if /I not "%USERNAME%"=="%allowed_user%" (
    echo [%date% %time%] ❌ User %USERNAME% không được phép >> "%log_file%"
    del "%lock_file%"
    exit /b
)

:: Kiểm tra thư mục tồn tại
if not exist "%repo_path%" (
    echo [%date% %time%] ❌ Thư mục %repo_path% không tồn tại >> "%log_file%"
    del "%lock_file%"
    exit /b
)

cd /d "%repo_path%"

:: Kiểm tra Git repository
git status >nul 2>&1
if errorlevel 1 (
    echo [%date% %time%] ❌ Không phải thư mục Git hợp lệ >> "%log_file%"
    del "%lock_file%"
    exit /b
)

:: Kiểm tra Git config
git config user.name >nul 2>&1
if errorlevel 1 (
    echo [%date% %time%] ❌ Git user.name chưa được cấu hình. Chạy: git config --global user.name "Your Name" >> "%log_file%"
    del "%lock_file%"
    exit /b
)
git config user.email >nul 2>&1
if errorlevel 1 (
    echo [%date% %time%] ❌ Git user.email chưa được cấu hình. Chạy: git config --global user.email "your.email@example.com" >> "%log_file%"
    del "%lock_file%"
    exit /b
)

echo [%date% %time%] 🚀 Auto Git Sync started by %USERNAME% >> "%log_file%"

:loop
(
    echo ------------------------------------------------------
    echo [%date% %time%] 🔄 Bắt đầu đồng bộ...
    echo.

    echo 🔽 PULL từ GitHub...
    :: Lưu stash nếu có thay đổi
    git diff --quiet && git diff --cached --quiet
    if errorlevel 1 (
        echo 📦 Stashing thay đổi cục bộ...
        git stash
    )
    git pull --rebase
    if errorlevel 1 (
        echo ⚠️ Lỗi khi PULL, thử reset và pull lại...
        git rebase --abort >nul 2>&1
        git reset --hard
        git pull
        if errorlevel 1 (
            echo [%date% %time%] ❌ Lỗi PULL không thể khắc phục >> "%log_file%"
            del "%lock_file%"
            exit /b
        )
    )
    :: Áp dụng lại stash nếu có
    git stash pop >nul 2>&1

    echo 🔼 ADD thay đổi...
    git add -A

    echo 💾 Kiểm tra thay đổi để commit...
    git diff --cached --quiet
    if errorlevel 1 (
        echo ✅ Có thay đổi, thực hiện COMMIT và PUSH...
        git commit -m "Auto sync at %date% %time%"
        git push
        if errorlevel 1 (
            echo [%date% %time%] ⚠️ Lỗi khi PUSH, thử pull và push lại... >> "%log_file%"
            git pull --rebase
            if errorlevel 1 (
                echo [%date% %time%] ❌ Lỗi PULL khi xử lý PUSH >> "%log_file%"
                del "%lock_file%"
                exit /b
            )
            git push
            if errorlevel 1 (
                echo [%date% %time%] ❌ Lỗi PUSH không thể khắc phục >> "%log_file%"
                del "%lock_file%"
                exit /b
            )
        )
    ) else (
        echo ⏸ Không có gì thay đổi.
    )

    echo.
    echo [%date% %time%] ✅ Xong 1 chu kỳ, chờ %interval%s...
    echo ------------------------------------------------------
    echo.
) >> "%log_file%" 2>&1

timeout /t %interval% >nul
goto loop

:: Xóa lock file khi thoát
del "%lock_file%"