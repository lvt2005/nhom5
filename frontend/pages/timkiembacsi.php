<?php
// doctors.php - Trang đội ngũ bác sĩ với cấu trúc modular
?>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đội Ngũ Bác Sĩ - Bệnh viện Đa khoa Quốc tế Nam Sài Gòn</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.4/boxicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            line-height: 1.6;
            color: #333;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Main content styles */
        .main-content {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            padding: 40px 20px;
            flex: 1;
        }

        .header {
            text-align: center;
            margin-bottom: 40px;
        }

        .header-title {
            color: #4a69bd;
            font-size: 14px;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 2px;
            margin-bottom: 10px;
        }

        .header h1 {
            color: #2c3e50;
            font-size: 42px;
            font-weight: 700;
            margin-bottom: 5px;
        }

        .header h1 .highlight {
            font-weight: 900;
        }

        .search-section {
            display: flex;
            gap: 15px;
            max-width: 900px;
            margin: 0 auto 60px;
            background: white;
            padding: 10px;
            border-radius: 50px;
            box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
        }

        .search-input {
            flex: 1;
            padding: 18px 30px;
            border: none;
            border-radius: 50px;
            font-size: 16px;
            outline: none;
            background: #f8f9fa;
        }

        .search-input::placeholder {
            color: #95a5a6;
        }

        .search-select {
            padding: 18px 30px;
            border: none;
            border-radius: 50px;
            font-size: 16px;
            outline: none;
            background: #f8f9fa;
            cursor: pointer;
            min-width: 180px;
            color: #2c3e50;
        }

        .search-btn {
            padding: 18px 40px;
            background: #4a69bd;
            color: white;
            border: none;
            border-radius: 50px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .search-btn:hover {
            background: #3c5aa6;
            transform: translateY(-2px);
            box-shadow: 0 5px 20px rgba(74, 105, 189, 0.4);
        }

        .doctors-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(500px, 1fr));
            gap: 30px;
            margin-top: 40px;
        }

        .doctor-card {
            background: white;
            border-radius: 20px;
            padding: 30px;
            display: flex;
            gap: 25px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
            transition: all 0.3s ease;
        }

        .doctor-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.12);
        }

        .doctor-image {
            flex-shrink: 0;
            position: relative;
        }

        .doctor-image img {
            width: 200px;
            height: 280px;
            object-fit: cover;
            border-radius: 15px;
            background: #e0e0e0;
        }

        .book-btn {
            position: absolute;
            bottom: 15px;
            left: 50%;
            transform: translateX(-50%);
            background: #4a69bd;
            color: white;
            padding: 12px 25px;
            border-radius: 25px;
            border: none;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
            display: flex;
            align-items: center;
            gap: 8px;
            transition: all 0.3s ease;
            white-space: nowrap;
        }

        .book-btn:hover {
            background: #3c5aa6;
            transform: translateX(-50%) translateY(-2px);
        }

        .book-btn::before {
            content: "📅";
            font-size: 16px;
        }

        .doctor-info {
            flex: 1;
        }

        .doctor-name {
            color: #4a69bd;
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 20px;
            text-transform: uppercase;
        }

        .info-item {
            display: flex;
            align-items: flex-start;
            gap: 12px;
            margin-bottom: 15px;
            color: #5a6c7d;
            font-size: 15px;
            line-height: 1.6;
        }

        .info-icon {
            flex-shrink: 0;
            width: 24px;
            height: 24px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #4a69bd;
            font-size: 18px;
        }

        @media (max-width: 768px) {
            .header h1 {
                font-size: 28px;
            }

            .search-section {
                flex-direction: column;
                border-radius: 20px;
            }

            .search-input, .search-select, .search-btn {
                border-radius: 15px;
                width: 100%;
            }

            .doctors-grid {
                grid-template-columns: 1fr;
            }

            .doctor-card {
                flex-direction: column;
                align-items: center;
            }

            .doctor-image img {
                width: 100%;
                max-width: 300px;
            }
        }
    </style>
</head>
<body>
    <?php include '../layout/header.html'; ?>
    <?php include '../layout/banner2.html'; ?>

    <div class="main-content">
        <div class="container">
            <div class="header">
                <div class="header-title">ĐỘI NGŨ CHÚNG TÔI</div>
                <h1>Đội ngũ bác sĩ chất lượng<br><span class="highlight">chuyên môn cao</span></h1>
            </div>

            <div class="search-section">
                <input type="text" class="search-input" placeholder="Nhập tên bác sĩ...">
                <select class="search-select">
                    <option>Chuyên khoa</option>
                    <option>Ngoại Thần - Cột Sống</option>
                    <option>Tai - Mũi - Họng</option>
                    <option>Nội khoa</option>
                    <option>Ngoại khoa</option>
                </select>
                <button class="search-btn">Tìm kiếm</button>
            </div>

            <div class="doctors-grid">
                <div class="doctor-card">
                    <div class="doctor-image">
                        <img src="https://via.placeholder.com/200x280/4a69bd/ffffff?text=Bác+sĩ" alt="THS.BS.CKII Nguyễn Trường Khương">
                        <button class="book-btn">Đặt lịch hẹn</button>
                    </div>
                    <div class="doctor-info">
                        <h2 class="doctor-name">THS.BS.CKII NGUYỄN<br>TRƯỜNG KHƯƠNG</h2>
                        <div class="info-item">
                            <span class="info-icon">🎓</span>
                            <span>THS.BS.CKII</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">🏥</span>
                            <span>Giám đốc Chuyên môn<br>26 năm kinh nghiệm</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">💼</span>
                            <span>Tai – Mũi – Họng</span>
                        </div>
                    </div>
                </div>

                <div class="doctor-card">
                    <div class="doctor-image">
                        <img src="https://via.placeholder.com/200x280/4a69bd/ffffff?text=Bác+sĩ" alt="THS.BS.CKII Nguyễn Trường Khương">
                        <button class="book-btn">Đặt lịch hẹn</button>
                    </div>
                    <div class="doctor-info">
                        <h2 class="doctor-name">THS.BS.CKII NGUYỄN<br>TRƯỜNG KHƯƠNG</h2>
                        <div class="info-item">
                            <span class="info-icon">🎓</span>
                            <span>THS.BS.CKII</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">🏥</span>
                            <span>Giám đốc Chuyên môn<br>26 năm kinh nghiệm</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">💼</span>
                            <span>Tai – Mũi – Họng</span>
                        </div>
                    </div>
                </div>
                
                <div class="doctor-card">
                    <div class="doctor-image">
                        <img src="https://via.placeholder.com/200x280/4a69bd/ffffff?text=Bác+sĩ" alt="THS.BS.CKII Nguyễn Trường Khương">
                        <button class="book-btn">Đặt lịch hẹn</button>
                    </div>
                    <div class="doctor-info">
                        <h2 class="doctor-name">THS.BS.CKII NGUYỄN<br>TRƯỜNG KHƯƠNG</h2>
                        <div class="info-item">
                            <span class="info-icon">🎓</span>
                            <span>THS.BS.CKII</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">🏥</span>
                            <span>Giám đốc Chuyên môn<br>26 năm kinh nghiệm</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">💼</span>
                            <span>Tai – Mũi – Họng</span>
                        </div>
                    </div>
                </div>
                
                <div class="doctor-card">
                    <div class="doctor-image">
                        <img src="https://via.placeholder.com/200x280/4a69bd/ffffff?text=Bác+sĩ" alt="TS.BS Nguyễn Kim Chung">
                        <button class="book-btn">Đặt lịch hẹn</button>
                    </div>
                    <div class="doctor-info">
                        <h2 class="doctor-name">TS.BS NGUYỄN KIM<br>CHUNG</h2>
                        <div class="info-item">
                            <span class="info-icon">🎓</span>
                            <span>TS.BS</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">🏥</span>
                            <span>Bác sĩ chuyên gia Ngoại Thần kinh – Sọ não – Cột sống<br>30 năm kinh nghiệm</span>
                        </div>
                        <div class="info-item">
                            <span class="info-icon">💼</span>
                            <span>Ngoại Thần Kinh - Cột Sống</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <?php include '../layout/footer.html'; ?>
</body>
</html>

