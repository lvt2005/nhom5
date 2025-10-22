<?php
// datlichhen.php - Trang đặt lịch hẹn với CSS header từ index.php, inline để tránh nested HTML
// Xử lý form submit (ví dụ đơn giản)
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Xử lý dữ liệu form ở đây (ví dụ: lưu DB, gửi email)
    $success_message = "Đặt lịch thành công! Chúng tôi sẽ liên hệ sớm.";
}
?>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt Lịch Hẹn - Bệnh viện Đa khoa Quốc tế Nam Sài Gòn</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.4/boxicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <!-- CSS layout và spacing từ datlichhen.php gốc -->
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        html, body {
            margin: 0;
            padding: 0;
            height: 100%;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            line-height: 1.6;
            color: #333;
            overflow-x: hidden;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        body > *:not(.footer-container) {
            flex: 1;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Header container */
        .header-container {
            position: sticky;
            top: 0;
            z-index: 1000;
            width: 100%;
            margin: 0;
            padding: 0;
        }

        /* Section spacing */
        .section-spacing {
            margin-bottom: 50px;
        }

        .banner-container {
            margin-bottom: 60px;
        }

        .form-container {
            margin-bottom: 60px;
            width: 100%;
            position: relative;
            left: auto;
            right: auto;
            margin-left: auto;
            margin-right: auto;
        }

        .banner-container section,
        .form-container .wrapper {
            margin-left: auto;
            margin-right: auto;
        }

        .header-container > *:first-child {
            margin-top: 0 !important;
            padding-top: 0 !important;
        }

        /* Footer container */
        .footer-container {
            margin-top: auto;
            width: 100%;
        }

        @media (max-width: 768px) {
            .section-spacing {
                margin-bottom: 30px;
            }
            .banner-container,
            .form-container {
                margin-bottom: 40px;
            }
        }

        @media (max-width: 480px) {
            .section-spacing {
                margin-bottom: 20px;
            }
            .banner-container,
            .form-container {
                margin-bottom: 30px;
            }
        }
    </style>

    <!-- CSS header từ index.php và header.html (tích hợp đầy đủ, updated logo size) -->
    <style>
        .header-wrap {
            background-color: #ffffff;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            margin: 0;
            padding: 0;
        }

        .header-nav {
            max-width: 1400px;
            margin: 0 auto;
            padding: 0 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            height: 80px;
        }

        .logo-section {
            display: flex;
            align-items: center;
            gap: 10px;
            min-width: 280px;
            margin-right: 30px;
        }

        .logo-img {
            width: 280px;
            height: 70px;
            border-radius: 50%;
            object-fit: cover;
        }

        .logo-text h1 {
            font-size: 16px;
            color: #333;
            font-weight: 600;
            line-height: 1.2;
        }

        .logo-text h1 small {
            display: block;
            font-size: 13px;
            color: #666;
            font-weight: 400;
        }

        .search-box {
            flex: 0 0 200px;
            margin-right: 30px;
        }

        .search-box input {
            width: 100%;
            padding: 8px 12px;
            border: 1px solid #ddd;
            border-radius: 20px;
            font-size: 13px;
            color: #999;
            background-color: #f9f9f9;
        }

        .search-box input::placeholder {
            color: #bbb;
        }

        .menu-list {
            display: flex;
            align-items: center;
            list-style: none;
            flex: 1;
            gap: 0;
            margin: 0;
        }

        .menu-item {
            position: relative;
        }

        .menu-item > a {
            display: flex;
            align-items: center;
            padding: 25px 15px;
            color: #333;
            text-decoration: none;
            font-size: 13px;
            font-weight: 500;
            white-space: nowrap;
            transition: color 0.3s ease;
        }

        .menu-item > a:hover {
            color: #3498db;
        }

        .menu-item.menu-item-has-children > a {
            display: flex;
            gap: 5px;
        }

        .menu-item i {
            font-size: 14px;
            transition: transform 0.3s ease;
        }

        .menu-item.menu-dropdown:hover > i {
            transform: rotate(180deg);
        }

        /* Dropdown Menu */
        .child {
            position: absolute;
            top: 100%;
            left: 0;
            background-color: #ffffff;
            list-style: none;
            min-width: 200px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            border-radius: 4px;
            overflow: hidden;
            opacity: 0;
            visibility: hidden;
            transform: translateY(-10px);
            transition: all 0.3s ease;
            z-index: 100;
        }

        .menu-item.menu-dropdown:hover .child {
            opacity: 1;
            visibility: visible;
            transform: translateY(0);
        }

        .child li {
            list-style: none;
        }

        .child li a {
            display: block;
            padding: 12px 20px;
            color: #666;
            text-decoration: none;
            font-size: 13px;
            transition: all 0.3s ease;
            white-space: normal;
        }

        .child li a:hover {
            background-color: #f0f8ff;
            color: #3498db;
            padding-left: 25px;
        }

        /* Mega Menu */
        .menu-mega {
            position: absolute;
            top: 100%;
            left: 0;
            background-color: #ffffff;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            border-radius: 4px;
            overflow: hidden;
            opacity: 0;
            visibility: hidden;
            transform: translateY(-10px);
            transition: all 0.3s ease;
            z-index: 100;
            display: flex;
            min-width: 600px;
        }

        .menu-mega ul {
            flex: 1;
            list-style: none;
            padding: 15px 0;
            border-right: 1px solid #f0f0f0;
        }

        .menu-mega ul:last-child {
            border-right: none;
        }

        .menu-mega li {
            list-style: none;
        }

        .menu-mega .menu-link {
            display: block;
            padding: 10px 20px;
            color: #666;
            text-decoration: none;
            font-size: 13px;
            transition: all 0.3s ease;
        }

        .menu-mega .menu-link:hover {
            background-color: #f0f8ff;
            color: #3498db;
            padding-left: 25px;
        }

        .menu-chuyen-khoa:hover .menu-mega {
            opacity: 1;
            visibility: visible;
            transform: translateY(0);
        }

        /* Right Section */
        .header-right {
            display: flex;
            align-items: center;
            gap: 15px;
            margin-left: auto;
        }

        .language-selector {
            background-color: transparent;
            border: none;
            color: #333;
            font-size: 13px;
            font-weight: 500;
            cursor: pointer;
            padding: 8px 10px;
            transition: color 0.3s ease;
        }

        .language-selector:hover {
            color: #3498db;
        }

        .btn-register {
            background-color: #f4c430;
            color: #fff;
            border: none;
            padding: 10px 25px;
            border-radius: 25px;
            font-size: 13px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            white-space: nowrap;
        }

        .btn-register:hover {
            background-color: #e8b81a;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(244, 196, 48, 0.3);
        }

        /* Responsive menu */
        @media (max-width: 1024px) {
            .menu-list { gap: 0; }
            .menu-item > a { padding: 20px 12px; font-size: 12px; }
        }

        @media (max-width: 768px) {
            .header-nav {
                height: auto;
                padding: 15px 20px;
                flex-wrap: wrap;
            }
            .menu-list {
                flex-direction: column;
                width: 100%;
                margin-top: 15px;
            }
            .child {
                position: static;
                opacity: 1;
                visibility: visible;
                transform: none;
                display: none;
                box-shadow: none;
                background-color: #f9f9f9;
            }
            .menu-item.menu-dropdown:hover .child { display: block; }
        }
    </style>

    <!-- CSS banner từ banner3.html (inline) -->
    <style>
        .banner-section {
            position: relative;
            width: 100%;
            height: 500px;
            background-image: url('../img/banner1.png');
            background-size: cover;
            background-position: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding: 40px;
            box-sizing: border-box;
        }

        .banner-header {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            margin-bottom: 20px;
        }

        .banner-logo {
            font-size: 2em;
            margin-right: 15px;
        }

        .banner-text {
            color: white;
            font-size: 2.2em;
            font-weight: bold;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
        }

        .banner-buttons {
            display: flex;
            justify-content: center;
            gap: 0;
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.95), rgba(255, 255, 255, 0.85));
            padding: 0;
            border-radius: 25px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
            width: fit-content;
            align-self: center;
            position: absolute;
            bottom: 40px;
            left: 50%;
            transform: translateX(-50%);
            overflow: hidden;
        }

        .banner-btn {
            padding: 15px 25px;
            border: none;
            font-size: 1em;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            transition: all 0.3s ease;
            position: relative;
            min-width: 140px;
            text-align: center;
        }

        .banner-btn::before {
            content: '';
            display: inline-block;
            width: 20px;
            height: 20px;
            margin-right: 8px;
            background-size: contain;
            background-repeat: no-repeat;
        }

        .banner-btn:first-child {
            background-color: #007bff;
            border-top-left-radius: 25px;
            border-bottom-left-radius: 25px;
        }

        .banner-btn:first-child::before {
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='white'%3E%3Cpath d='M6.62 10.79c1.44 2.83 3.76 5.14 6.59 6.59l2.2-2.2c.27-.27.67-.36 1.02-.24 1.12.37 2.33.57 3.57.57.55 0 1 .45 1 1V20c0 .55-.45 1-1 1-9.39 0-17-7.61-17-17 0-.55.45-1 1-1h3.5c.55 0 1 .45 1 1 0 1.25.2 2.45.57 3.57.11.35.03.74-.25 1.02l-2.2 2.2z'/%3E%3C/svg%3E");
        }

        .banner-btn:nth-child(2) {
            background-color: #ffc107;
            color: black;
        }

        .banner-btn:nth-child(2)::before {
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='black'%3E%3Cpath d='M19 3h-1V1h-2v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm0 16H5V8h14v11zM7 10h5v5H7z'/%3E%3C/svg%3E");
        }

        .banner-btn:last-child {
            background-color: #007bff;
            border-top-right-radius: 25px;
            border-bottom-right-radius: 25px;
        }

        .banner-btn:last-child::before {
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='white'%3E%3Cpath d='M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z'/%3E%3C/svg%3E");
        }

        .banner-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        }

        @media (max-width: 768px) {
            .banner-section {
                padding: 20px;
                height: 500px;
            }
            .banner-text {
                font-size: 1.8em;
            }
            .banner-buttons {
                flex-direction: column;
                border-radius: 15px;
                bottom: 20px;
            }
            .banner-btn {
                border-radius: 0;
                min-width: auto;
                width: 100%;
            }
            .banner-btn:first-child {
                border-top-left-radius: 15px;
                border-top-right-radius: 15px;
            }
            .banner-btn:last-child {
                border-bottom-left-radius: 15px;
                border-bottom-right-radius: 15px;
            }
        }
    </style>

    <!-- CSS form từ phieudat.html (inline) -->
    <style>
        .form-wrapper {
            max-width: 1200px;
            margin: 0 auto;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
            background: white;
            border-radius: 16px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.12);
            min-height: 700px;
        }

        .form-section {
            padding: 40px;
            display: flex;
            flex-direction: column;
        }

        .form-image-section {
            background-image: url('../img/why.jpg');
            background-size: cover;
            background-position: center;
            border-radius: 0;
        }

        .form-title {
            font-size: 28px;
            font-weight: 700;
            color: #1e5ba8;
            margin-bottom: 30px;
            text-align: center;
        }

        .form-content {
            flex: 1;
            overflow-y: auto;
        }

        .form-group {
            margin-bottom: 14px;
        }

        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 16px;
            margin-bottom: 0px;
        }

        .form-row-full {
            grid-column: 1 / -1;
        }

        label {
            display: block;
            font-size: 13px;
            font-weight: 600;
            color: #333;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="tel"],
        input[type="date"],
        select,
        textarea {
            width: 100%;
            padding: 12px 14px;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 14px;
            font-family: inherit;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus,
        input[type="tel"]:focus,
        input[type="date"]:focus,
        select:focus,
        textarea:focus {
            outline: none;
            border-color: #1e5ba8;
            box-shadow: 0 0 0 3px rgba(30, 91, 168, 0.1);
        }

        input[type="text"]::placeholder,
        input[type="tel"]::placeholder,
        textarea::placeholder {
            color: #999;
        }

        textarea {
            resize: vertical;
            min-height: 100px;
            padding: 14px;
        }

        select {
            cursor: pointer;
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' viewBox='0 0 12 12'%3E%3Cpath fill='%23333' d='M6 9L1 4h10z'/%3E%3C/svg%3E");
            background-repeat: no-repeat;
            background-position: right 12px center;
            padding-right: 36px;
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
        }

        .radio-group {
            display: flex;
            gap: 12px;
            margin-top: 8px;
            flex-wrap: wrap;
            width: 100%;
        }

        .radio-item {
            display: flex;
            align-items: center;
            gap: 8px;
            cursor: pointer;
            padding: 10px 14px;
            border: 1px solid #ddd;
            border-radius: 6px;
            background: white;
            transition: all 0.3s ease;
            flex: 1;
            justify-content: center;
        }

        .radio-item:hover {
            border-color: #1e5ba8;
            background: #f5f9fd;
        }

        input[type="radio"]:checked + label {
            color: #1e5ba8;
            font-weight: 600;
        }

        input[type="radio"],
        input[type="checkbox"] {
            width: 18px;
            height: 18px;
            cursor: pointer;
            accent-color: #1e5ba8;
            flex-shrink: 0;
        }

        .radio-item label,
        .checkbox-item-simple label {
            margin: 0;
            cursor: pointer;
            font-weight: 500;
            font-size: 13px;
            color: #333;
        }

        .checkbox-item-simple {
            display: flex;
            align-items: center;
            gap: 8px;
            cursor: pointer;
        }

        .submit-btn {
            width: 100%;
            padding: 14px 24px;
            background: #1e5ba8;
            color: white;
            font-size: 14px;
            font-weight: 700;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.3s ease;
            margin-top: 20px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .submit-btn:hover {
            background: #1a4a8a;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(30, 91, 168, 0.3);
        }

        .success-message {
            background: #d4edda;
            color: #155724;
            padding: 10px;
            border-radius: 6px;
            margin-bottom: 20px;
            text-align: center;
        }

        @media (max-width: 968px) {
            .form-wrapper {
                grid-template-columns: 1fr;
                min-height: auto;
            }
            .form-section {
                padding: 30px;
            }
            .form-image-section {
                min-height: 400px;
            }
            .form-row {
                grid-template-columns: 1fr;
            }
        }
    </style>

    <!-- CSS footer từ footer.html (inline, chỉ cần cho trang này) -->
    <style>
        footer {
            background: linear-gradient(135deg, #2563eb 0%, #1e40af 100%);
            color: #ffffff;
            padding: 50px 0 30px;
            margin-top: auto;
        }

        .footer-content {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 50px;
            margin-bottom: 40px;
        }

        .footer-logo-section {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .footer-logo {
            display: flex;
            align-items: center;
            gap: 12px;
            margin-bottom: 10px;
        }

        .footer-logo img {
            width: 170px;
            height: 100px;
            border-radius: 50%;
            background-color: rgba(255, 255, 255, 0.1);
            padding: 8px;
        }

        .footer-logo h3 {
            font-size: 16px;
            font-weight: 700;
            line-height: 1.2;
        }

        .footer-logo-section p {
            font-size: 13px;
            line-height: 1.7;
            color: rgba(255, 255, 255, 0.85);
            margin-bottom: 8px;
        }

        .footer-section h4 {
            font-size: 15px;
            font-weight: 700;
            margin-bottom: 18px;
            color: #ffffff;
            text-transform: uppercase;
            letter-spacing: 0.3px;
        }

        .footer-section ul {
            list-style: none;
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        .footer-section ul li {
            font-size: 13px;
            color: rgba(255, 255, 255, 0.8);
            transition: all 0.3s ease;
        }

        .footer-section ul li a {
            color: rgba(255, 255, 255, 0.8);
            text-decoration: none;
            transition: all 0.3s ease;
        }

        .footer-section ul li a:hover {
            color: #fbbf24;
            padding-left: 8px;
        }

        .working-hours {
            font-size: 13px;
            color: rgba(255, 255, 255, 0.85);
            line-height: 1.8;
            margin-bottom: 15px;
        }

        .working-hours strong {
            color: #ffffff;
            font-weight: 700;
        }

        .hotline-btn {
            display: inline-block;
            background-color: #fbbf24;
            color: #1e40af;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 13px;
            font-weight: 700;
            text-decoration: none;
            margin-top: 10px;
            transition: all 0.3s ease;
        }

        .hotline-btn:hover {
            background-color: #fcd34d;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(251, 191, 36, 0.3);
        }

        .contact-section {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .social-icons {
            display: flex;
            gap: 12px;
            align-items: center;
        }

        .social-icons a {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 38px;
            height: 38px;
            background-color: #fbbf24;
            color: #1e40af;
            border-radius: 50%;
            text-decoration: none;
            font-size: 18px;
            transition: all 0.3s ease;
        }

        .social-icons a:hover {
            background-color: #fcd34d;
            transform: translateY(-3px);
            box-shadow: 0 4px 12px rgba(251, 191, 36, 0.4);
        }

        .newsletter-section p {
            font-size: 13px;
            color: rgba(255, 255, 255, 0.85);
            margin-bottom: 12px;
            font-weight: 500;
        }

        .newsletter-form {
            display: flex;
            gap: 8px;
            margin-bottom: 15px;
        }

        .newsletter-form input {
            flex: 1;
            padding: 10px 15px;
            border: none;
            border-radius: 25px;
            font-size: 13px;
            color: #333;
            background-color: #ffffff;
        }

        .newsletter-form input::placeholder {
            color: #999;
        }

        .newsletter-form input:focus {
            outline: none;
            box-shadow: 0 0 8px rgba(255, 255, 255, 0.3);
        }

        .newsletter-form button {
            padding: 10px 20px;
            background-color: #1e3a8a;
            color: #ffffff;
            border: none;
            border-radius: 25px;
            font-size: 13px;
            font-weight: 700;
            cursor: pointer;
            transition: all 0.3s ease;
            white-space: nowrap;
        }

        .newsletter-form button:hover {
            background-color: #1e40af;
            transform: translateY(-2px);
        }

        .dmca-badge {
            display: flex;
            align-items: center;
            gap: 8px;
            font-size: 12px;
            color: rgba(255, 255, 255, 0.8);
        }

        .dmca-badge img {
            width: 160px;
            height: auto;
        }

        .footer-divider {
            border: none;
            border-top: 1px solid rgba(255, 255, 255, 0.2);
            margin: 30px 0;
        }

        .footer-bottom {
            text-align: center;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .footer-bottom p {
            font-size: 12px;
            color: rgba(255, 255, 255, 0.7);
        }

        .footer-links {
            display: flex;
            justify-content: center;
            gap: 0;
            list-style: none;
            flex-wrap: wrap;
        }

        .footer-links li {
            font-size: 12px;
        }

        .footer-links li a {
            color: rgba(255, 255, 255, 0.7);
            text-decoration: none;
            padding: 0 15px;
            border-right: 1px solid rgba(255, 255, 255, 0.2);
            transition: all 0.3s ease;
        }

        .footer-links li:last-child a {
            border-right: none;
        }

        .footer-links li a:hover {
            color: #fbbf24;
        }

        /* Responsive footer */
        @media (max-width: 1024px) {
            .footer-content {
                grid-template-columns: repeat(2, 1fr);
                gap: 40px;
            }
        }

        @media (max-width: 768px) {
            footer {
                padding: 40px 0 20px;
            }
            .footer-content {
                grid-template-columns: 1fr;
                gap: 30px;
            }
            .footer-section h4 {
                font-size: 14px;
                margin-bottom: 12px;
            }
            .newsletter-form {
                flex-direction: column;
            }
            .newsletter-form input,
            .newsletter-form button {
                width: 100%;
            }
            .social-icons {
                justify-content: flex-start;
            }
            .footer-links {
                gap: 10px;
                justify-content: center;
            }
            .footer-links li a {
                padding: 0 10px;
            }
        }

        @media (max-width: 480px) {
            .container {
                padding: 0 15px;
            }
            .footer-content {
                gap: 20px;
            }
            .footer-section h4 {
                font-size: 13px;
            }
            footer p {
                font-size: 12px;
            }
            .social-icons {
                gap: 10px;
            }
            .social-icons a {
                width: 35px;
                height: 35px;
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <!-- Header Section (inline content từ header.html body) -->
    <div class="header-container">
        <div class="header-wrap">
            <nav class="header-nav">
                <!-- Logo Section -->
                <div class="logo-section">
                    <img src="../img/logomau.jpg" alt="Logo" class="logo-img">
                    <!-- Thêm .logo-text nếu cần, nhưng trong header.html gốc không có, chỉ img -->
                </div>

                <!-- Search Box -->
                <div class="search-box">
                    <input type="text" placeholder="Tìm kiếm từ khoá">
                </div>

                <!-- Main Menu -->
                <ul id="menu-menu-main" class="menu-list">
                    <!-- Về Chúng Tôi -->
                    <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-dropdown">
                        <a class="menu-link" href="javascript:;" title="Về Chúng Tôi">Về Chúng Tôi</a>
                        <i class="bx bxs-chevron-down"></i>
                        <ul class="child">
                            <li class="menu-item menu-item-type-post_type menu-item-object-page">
                                <a class="menu-link" href="#" title="Giới Thiệu">Giới Thiệu</a>
                            </li>
                            <li class="menu-item menu-item-type-post_type menu-item-object-page">
                                <a class="menu-link" href="#" title="Cơ Sở Vật Chất">Cơ Sở Vật Chất</a>
                            </li>
                            <li class="menu-item menu-item-type-post_type menu-item-object-page">
                                <a class="menu-link" href="#" title="Hoạt Động Đào Tạo">Hoạt Động Đào Tạo</a>
                            </li>
                            <li class="menu-item menu-item-type-post_type menu-item-object-page">
                                <a class="menu-link" href="#" title="Không gian NSG">Không gian NSG</a>
                            </li>
                        </ul>
                    </li>

                    <!-- Đội Ngũ Bác Sĩ -->
                    <li class="menu-item menu-item-type-custom menu-item-object-custom">
                        <a class="menu-link" href="#" title="Đội Ngũ Bác Sĩ">Đội Ngũ Bác Sĩ</a>
                    </li>

                    <!-- Chuyên Khoa -->
                    <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-chuyen-khoa">
                        <a class="menu-link" href="#" title="Chuyên Khoa">Chuyên Khoa</a>
                        <i class="bx bxs-chevron-down"></i>
                        <div class="menu-mega">
                            <ul>
                                <li class="menu-item">
                                    <a class="menu-link" href="#">Khoa Khám Bệnh</a>
                                </li>
                                <li><a class="menu-link" href="#">Phòng Khám Ngoài Thần Kinh</a></li>
                                <li><a class="menu-link" href="#">Phòng Khám Nội Tổng Quát</a></li>
                                <li><a class="menu-link" href="#">Phòng Khám Chấn thương Chỉnh Hình, Cơ-Xương-Khớp</a></li>
                                <li><a class="menu-link" href="#">Phòng Khám Tiêu Hóa</a></li>
                                <li><a class="menu-link" href="#">Phòng Khám Tai - Mũi - Họng</a></li>
                                <li><a class="menu-link" href="">Phòng Khám Nội Tiết</a></li>
                            </ul>
                            <ul>
                                <li><a class="menu-link" href="#">Khoa Vật Lý Trị Liệu - Phục Hồi Chức Năng</a></li>
                                <li><a class="menu-link" href="#">Khoa Gây mê - Hồi Sức</a></li>
                                <li><a class="menu-link" href="#">Khoa Hồi Sức Tích Cực - Cấp Cứu</a></li>
                                <li><a class="menu-link" href="#">Khoa Xét Nghiệm</a></li>
                                <li><a class="menu-link" href="#">Khoa Chẩn đoán Hình ảnh - Thăm Dò Chức Năng</a></li>
                                <li><a class="menu-link" href="#">Khoa Dược</a></li>
                            </ul>
                        </div>
                    </li>

                    <!-- Dịch Vụ -->
                    <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-dropdown">
                        <a class="menu-link" href="#" title="Dịch Vụ">Dịch Vụ</a>
                        <i class="bx bxs-chevron-down"></i>
                        <ul class="child">
                            <li><a class="menu-link" href="#">Tầm Soát Ung Thư</a></li>
                            <li><a class="menu-link" href="#">Dịch Vụ Nội Soi</a></li>
                            <li><a class="menu-link" href="#">Khám Sức Khỏe Định Kỳ</a></li>
                        </ul>
                    </li>

                    <!-- Hướng Dẫn Khách Hàng -->
                    <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-dropdown">
                        <a class="menu-link" href="#" title="Hướng Dẫn Khách Hàng">Hướng Dẫn Khách Hàng</a>
                        <i class="bx bxs-chevron-down"></i>
                        <ul class="child">
                            <li><a class="menu-link" href="#">Bảng Giá Tiền Giường</a></li>
                            <li><a class="menu-link" href="#">Bảo Hiểm</a></li>
                            <li><a class="menu-link" href="#">Thông tin lịch khám bệnh</a></li>
                            <li><a class="menu-link" href="#">Thông Tin Viện Phí</a></li>
                            <li><a class="menu-link" href="#">Chuẩn Bị Trước Mổ</a></li>
                            <li><a class="menu-link" href="#">Quyền và Nghĩa Vụ Của Người Bệnh</a></li>
                        </ul>
                    </li>

                    <!-- Tin Tức -->
                    <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-dropdown">
                        <a class="menu-link" href="#" title="Tin Tức">Tin Tức</a>
                        <i class="bx bxs-chevron-down"></i>
                        <ul class="child">
                            <li><a class="menu-link" href="#">Câu Chuyện Khách Hàng</a></li>
                            <li><a class="menu-link" href="#">Tin Tức Sự Kiện</a></li>
                            <li><a class="menu-link" href="#">Chương Trình Ưu Đãi</a></li>
                            <li><a class="menu-link" href="#">Cảm Nang Bệnh</a></li>
                            <li><a class="menu-link" href="#">Tra Cứu Bệnh A-Z</a></li>
                        </ul>
                    </li>

                    <!-- Liên Hệ -->
                    <li class="menu-item menu-item-type-post_type menu-item-object-page">
                        <a class="menu-link" href="#" title="Liên Hệ">Liên Hệ</a>
                    </li>
                </ul>

                <!-- Right Section -->
                <div class="header-right">
                    <button class="btn-register">Đăng Nhập</button>
                </div>
            </nav>
        </div>
    </div>

    <!-- Banner Section (inline từ banner3.html) -->
    <div class="banner-container section-spacing">
        <section class="banner-section">
            <div class="banner-header">
                <div class="banner-text">ĐẶT LỊCH HẸN KHÁM BỆNH</div>
            </div>
            <div class="banner-buttons">
                <a href="tel:+0123456789" class="banner-btn">Gọi tổng đài</a>
                <a href="/doan/frontend/pages/datlichhen.php" class="banner-btn">Đặt lịch hẹn</a>
                <a href="/doan/frontend/pages/timkiembacsi.php" class="banner-btn">Tìm bác sĩ</a>
            </div>
        </section>
    </div>

    <!-- Form Section (inline từ phieudat.html, với PHP xử lý) -->
    <div class="form-container section-spacing">
        <div class="form-wrapper">
            <div class="form-section">
                <h1 class="form-title">Thông tin bệnh nhân</h1>
                <?php if (isset($success_message)): ?>
                    <div class="success-message"><?php echo $success_message; ?></div>
                <?php endif; ?>
                <div class="form-content">
                    <form method="POST" action="">
                        <!-- Name and Birthday -->
                        <div class="form-row">
                            <div class="form-group">
                                <label>Họ và Tên*</label>
                                <input type="text" name="fullname" placeholder="Nhập Họ và Tên" required>
                            </div>
                            <div class="form-group">
                                <label>Ngày sinh</label>
                                <input type="date" name="birthday" placeholder="dd/mm/yyyy">
                            </div>
                        </div>

                        <!-- Phone -->
                        <div class="form-group form-row-full">
                            <label>Số điện thoại*</label>
                            <input type="tel" name="phone" placeholder="Nhập số điện thoại" required>
                        </div>

                        <!-- Address -->
                        <div class="form-group form-row-full">
                            <label>Địa chỉ*</label>
                            <input type="text" name="address" placeholder="Chi tiết địa chỉ" required>
                        </div>

                        <!-- Specialty and Doctor -->
                        <div class="form-row">
                            <div class="form-group">
                                <label>Chuyên khoa</label>
                                <select name="specialty" required>
                                    <option value="">Chọn chuyên khoa</option>
                                    <option value="tim">Chuyên khoa Tim mạch</option>
                                    <option value="noi-tiet">Chuyên khoa Nội tiết</option>
                                    <option value="tham-niem">Chuyên khoa Thần kinh</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Bác sĩ</label>
                                <select name="doctor" required>
                                    <option value="">Chọn bác sĩ</option>
                                    <!-- Có thể populate động từ DB -->
                                </select>
                            </div>
                        </div>

                        <!-- Appointment Date and Time -->
                        <div class="form-row">
                            <div class="form-group">
                                <label>Ngày khám*</label>
                                <input type="date" name="appointment_date" placeholder="dd/mm/yyyy" required>
                            </div>
                            <div class="form-group">
                                <label>Sáng/ Chiều</label>
                                <div class="radio-group">
                                    <div class="radio-item">
                                        <input type="radio" id="morning" name="time" value="Sáng" checked>
                                        <label for="morning">Sáng</label>
                                    </div>
                                    <div class="radio-item">
                                        <input type="radio" id="afternoon" name="time" value="Chiều">
                                        <label for="afternoon">Chiều</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Reason -->
                        <div class="form-group">
                            <label>Lý do khám</label>
                            <textarea name="reason" placeholder="Nhập lý do khám"></textarea>
                        </div>

                        <!-- Checkboxes -->
                        <div class="form-group">
                            <div class="checkbox-item-simple">
                                <input type="checkbox" id="foreign" name="foreign">
                                <label for="foreign">Đặt hẹn cho người nước ngoài (phụ thu 25%)</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="checkbox-item-simple">
                                <input type="checkbox" id="relatives" name="relatives">
                                <label for="relatives">Đặt hẹn cho người thân</label>
                            </div>
                        </div>

                        <!-- Submit Button -->
                        <button type="submit" class="submit-btn">Đặt hẹn ngay</button>
                    </form>
                </div>
            </div>

            <div class="form-image-section"></div>
        </div>
    </div>

    <!-- Footer Section (inline từ footer.html body) -->
    <div class="footer-container">
        <footer>
            <div class="container">
                <div class="footer-content">
                    <!-- Logo & Info -->
                    <div class="footer-logo-section">
                        <div class="footer-logo">
                            <img src="../img/logomau.jpg" alt="Logo">
                        </div>
                        <p>Địa chỉ: Số 88, Đường số 8, Khu dân cư Trung Sơn, Xã Bình Hưng, TP. Hồ Chí Minh</p>
                        <p>Email: info@nih.com.vn</p>
                        <p>GPDKKD: 0312088602 cấp ngày 14/12/2012 bởi Sở Kế hoạch và Đầu tư TPHCM. Giấy phép hoạt động khám bệnh, chữa bệnh số 230/BYT-GPHD do Bộ Y Tế cấp.</p>
                    </div>

                    <!-- About -->
                    <div class="footer-section">
                        <h4>Về chúng tôi</h4>
                        <ul>
                            <li><a href="#">Đội ngũ bác sĩ</a></li>
                            <li><a href="#">Cơ sở vật chất</a></li>
                            <li><a href="#">Câu chuyện khách hàng</a></li>
                            <li><a href="#">Tuyên dụng</a></li>
                            <li><a href="#">Cảm nang bệnh</a></li>
                            <li><a href="#">Chính sách bảo mật</a></li>
                        </ul>
                    </div>

                    <!-- Working Hours -->
                    <div class="footer-section">
                        <h4>Giờ làm việc</h4>
                        <div class="working-hours">
                            <p><strong>Từ thứ 2 đến thứ 7</strong></p>
                            <p>Buổi sáng:<br>7:00 - 12:00</p>
                            <p>Buổi chiều:<br>13:30 - 17:00</p>
                        </div>
                        <a href="#" class="hotline-btn">Hotline: 1800 6767</a>
                    </div>

                    <!-- Contact -->
                    <div class="contact-section">
                        <h4>Liên hệ</h4>
                        <div class="social-icons">
                            <a href="#" title="Facebook"><i class="fab fa-facebook-f"></i></a>
                            <a href="#" title="YouTube"><i class="fab fa-youtube"></i></a>
                            <a href="#" title="TikTok"><i class="fab fa-tiktok"></i></a>
                            <a href="#" title="Twitter"><i class="fab fa-twitter"></i></a>
                            <a href="#" title="Instagram"><i class="fab fa-instagram"></i></a>
                        </div>
                        <div class="newsletter-section">
                            <p><strong>Theo dõi bản tin chúng tôi</strong></p>
                            <form class="newsletter-form">
                                <input type="email" placeholder="Email" required>
                                <button type="submit">Đăng ký</button>
                            </form>
                        </div>
                        <div class="dmca-badge">
                            <img src="../img/dmca_protected_16_120.png" alt="">
                        </div>
                    </div>
                </div>

                <hr class="footer-divider">

                <div class="footer-bottom">
                    <p>&copy; 2023 Bệnh viện Đa khoa Quốc tế Nam Sài Gòn. Tất cả các quyền được bảo vệ.</p>
                    <ul class="footer-links">
                        <li><a href="#">Chính sách bảo mật</a></li>
                        <li><a href="#">Điều khoản sử dụng</a></li>
                        <li><a href="#">Liên hệ</a></li>
                    </ul>
                </div>
            </div>
        </footer>
    </div>

    <script>
        // JS đơn giản cho form (ví dụ: populate doctor dựa trên specialty)
        document.querySelector('[name="specialty"]').addEventListener('change', function() {
            const doctorSelect = document.querySelector('[name="doctor"]');
            doctorSelect.innerHTML = '<option value="">Chọn bác sĩ</option>';
            // Logic populate (có thể AJAX từ DB)
        });
    </script>
</body>
</html>