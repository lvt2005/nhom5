<?php
// index.php - File chính với toàn bộ CSS inline để giống hệt file HTML lớn
?>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bệnh viện Đa khoa Quốc tế Nam Sài Gòn</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.4/boxicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- <style>
        /* Unified reset and base styles */
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

        body > *:not(footer) {
            flex: 1;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Menu styles from menu.html */
        .header-wrap {
            background-color: #ffffff;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            position: sticky;
            top: 0;
            z-index: 1000;
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
            min-width: 250px;
            margin-right: 30px;
        }

        .logo-img {
            width: 45px;
            height: 45px;
            border-radius: 50%;
            object-fit: cover;
        }

        .logo-text h1 {
            font-size: 14px;
            color: #333;
            font-weight: 600;
            line-height: 1.2;
        }

        .logo-text h1 small {
            display: block;
            font-size: 12px;
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

        /* Responsive for menu */
        @media (max-width: 1024px) {
            .menu-list {
                gap: 0;
            }

            .menu-item > a {
                padding: 20px 12px;
                font-size: 12px;
            }
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

            .menu-item.menu-dropdown:hover .child {
                display: block;
            }
        }

        /* Header banner styles from header.html */
        .header-banner {
            position: relative;
            width: 100%;
            min-height: 420px;
            overflow: hidden;
            background-color: #f5e6f0;
            background-image: url('./Screenshot 2025-10-17 201418.png');
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
            display: flex;
            align-items: center;
        }

        .header-container {
            position: relative;
            z-index: 3;
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 40px;
            align-items: center;
            width: 100%;
        }

        /* Left section */
        .header-left {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .header-boxes {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .header-box-main {
            background: rgba(255, 255, 255, 0.7);
            border-radius: 16px;
            padding: 30px;
            box-shadow: 0 10px 40px rgba(0, 0, 0, 0.08);
            backdrop-filter: blur(8px) saturate(120%);
            -webkit-backdrop-filter: blur(8px) saturate(120%);
        }

        .header-box-main h1 {
            color: #003d99;
            font-size: 34px;
            font-weight: 700;
            margin-bottom: 15px;
            line-height: 1.3;
        }

        .header-box-main p {
            color: #666;
            font-size: 16px;
            line-height: 1.6;
            margin-bottom: 20px;
        }

        .btn-primary {
            background: linear-gradient(135deg, #4a90e2 0%, #357abd 100%);
            color: white;
            border: none;
            padding: 12px 30px;
            border-radius: 25px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            display: inline-flex;
            align-items: center;
            gap: 8px;
            width: fit-content;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(74, 144, 226, 0.3);
            margin-top: 10px;
        }

        .btn-primary:hover {
            background: #f4c430;
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(244, 196, 48, 0.4);
        }

        .btn-icon::before {
            content: '🔍';
            display: inline-block;
            font-size: 16px;
        }

        .header-boxes-secondary {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        .header-box-small.compact {
            padding: 12px;
        }

        .header-box-small {
            background: rgba(255, 255, 255, 0.75);
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.08);
            backdrop-filter: blur(6px) saturate(120%);
            -webkit-backdrop-filter: blur(6px) saturate(120%);
        }

        .header-box-small img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 12px;
        }

        .header-box-small h3 {
            color: #003d99;
            font-size: 15px;
            font-weight: 600;
            margin-bottom: 8px;
        }

        .header-box-small p {
            color: #555;
            font-size: 13px;
            line-height: 1.5;
            margin-bottom: 12px;
        }

        .btn-secondary {
            background: #ffd700;
            color: #003d99;
            border: none;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            width: fit-content;
        }

        .btn-secondary:hover {
            background: #ffed4e;
        }

        .hotline {
            display: flex;
            align-items: center;
            gap: 8px;
            color: #003d99;
            font-weight: 700;
            font-size: 15px;
        }

        .hotline-btn {
            background: linear-gradient(135deg, #4a90e2 0%, #357abd 100%);
            color: white;
            border: none;
            padding: 8px 14px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 700;
            cursor: pointer;
            display: inline-flex;
            align-items: center;
            gap: 8px;
            box-shadow: 0 4px 12px rgba(74,144,226,0.25);
            text-decoration: none;
        }

        .hotline-btn::before {
            content: '☎';
            font-size: 16px;
        }

        .hotline-btn:hover {
            color: #f4c430;
        }

        /* Right section */
        .header-right {
            position: relative;
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding-right: 10px;
        }

        .header-right img {
            width: 90%;
            height: auto;
            max-width: 480px;
            object-fit: contain;
            display: block;
            filter: drop-shadow(0 20px 40px rgba(0,0,0,0.15));
        }

        .header-banner::before {
            content: '';
            position: absolute;
            inset: 0;
            background: linear-gradient(180deg, rgba(0,0,0,0.10) 0%, rgba(0,0,0,0.18) 100%);
            z-index: 2;
            pointer-events: none;
        }

        .header-banner::after {
            content: '';
            position: absolute;
            inset: 0;
            background: rgba(255,255,255,0.12);
            mix-blend-mode: screen;
            z-index: 2;
            pointer-events: none;
        }

        .header-left,
        .header-boxes,
        .header-box-main,
        .header-boxes-secondary {
            position: relative;
            z-index: 4;
        }

        .header-boxes-secondary .header-box-small:first-child {
            padding: 0;
            overflow: hidden;
            background: none;
            box-shadow: none;
            border-radius: 12px;
        }

        .header-boxes-secondary .header-box-small:first-child img {
            width: 100%;
            height: 100%;
            min-height: 220px;
            object-fit: cover;
            border-radius: 12px;
            margin: 0;
            display: block;
        }

        /* Responsive for header */
        @media (max-width: 768px) {
            .header-container {
                grid-template-columns: 1fr;
                padding: 30px 20px;
            }

            .header-box-main h1 {
                font-size: 24px;
            }

            .header-boxes-secondary {
                grid-template-columns: 1fr;
            }
        }

        /* Taisao styles from taisao.html */
        .why-choose {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            gap: 40px;
            align-items: center;
            padding: 60px 0;
        }

        .why-choose__left {
            display: flex;
            flex-direction: column;
            gap: 30px;
        }

        .why-choose__label {
            color: #4a9eff;
            font-size: 14px;
            font-weight: 600;
            letter-spacing: 1px;
            text-transform: uppercase;
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .why-choose__label::before {
            content: '+';
            font-size: 18px;
            font-weight: 300;
        }

        .why-choose__title {
            font-size: 42px;
            font-weight: 700;
            line-height: 1.3;
            color: #1a1a1a;
        }

        .why-choose__description {
            font-size: 15px;
            line-height: 1.6;
            color: #666;
        }

        .why-choose__button {
            display: inline-flex;
            align-items: center;
            gap: 10px;
            padding: 12px 28px;
            background: linear-gradient(135deg, #5b6ef5 0%, #4a5fd9 100%);
            color: white;
            border: none;
            border-radius: 25px;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
            width: fit-content;
            transition: all 0.3s ease;
            margin-top: 10px;
        }

        .why-choose__button:hover {
            background: #f4c430;
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(244, 196, 48, 0.3);
        }

        .why-choose__button::before {
            content: '🔍';
            font-size: 16px;
        }

        .why-choose__center {
            position: relative;
            height: 500px;
        }

        .why-choose__image {
            position: relative;
            height: 100%;
            border-radius: 20px;
            overflow: hidden;
            background: linear-gradient(135deg, #e0f2ff 0%, #f0f8ff 100%);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .why-choose__image::after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            height: 120px;
            background: linear-gradient(to bottom, rgba(255,255,255,0), rgba(144,210,175,0.15));
        }

        .why-choose__badge {
            position: absolute;
            bottom: 30px;
            left: 30px;
            background: rgba(220, 255, 240, 0.9);
            backdrop-filter: blur(10px);
            padding: 20px 30px;
            border-radius: 15px;
            text-align: center;
            z-index: 10;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
        }

        .why-choose__badge-number {
            font-size: 36px;
            font-weight: 700;
            color: #2d5a4a;
            line-height: 1;
        }

        .why-choose__badge-text {
            font-size: 13px;
            color: #4a7c6a;
            margin-top: 8px;
        }

        .why-choose__right {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .why-choose__image-top {
            height: 150px;
            border-radius: 15px;
            background: linear-gradient(135deg, #fff0f5 0%, #ffe0f0 100%);
            overflow: hidden;
            margin-bottom: 10px;
        }

        .feature-item {
            display: flex;
            align-items: flex-start;
            gap: 15px;
            padding: 20px;
            background: white;
            border-radius: 12px;
            border-left: 4px solid #4a9eff;
            transition: all 0.3s ease;
        }

        .feature-item:hover {
            box-shadow: 0 4px 12px rgba(74, 158, 255, 0.15);
            transform: translateX(4px);
        }

        .feature-item__icon {
            font-size: 20px;
            min-width: 20px;
            color: #4a9eff;
        }

        .feature-item__content {
            flex: 1;
        }

        .feature-item__title {
            font-size: 14px;
            font-weight: 700;
            color: #1a1a1a;
            margin-bottom: 6px;
        }

        .feature-item__description {
            font-size: 13px;
            color: #666;
            line-height: 1.5;
        }

        /* Responsive for taisao */
        @media (max-width: 1024px) {
            .why-choose {
                grid-template-columns: 1fr 1fr;
                gap: 30px;
            }

            .why-choose__title {
                font-size: 32px;
            }

            .why-choose__center {
                height: 400px;
            }
        }

        @media (max-width: 768px) {
            .why-choose {
                grid-template-columns: 1fr;
                gap: 30px;
            }

            .why-choose__title {
                font-size: 28px;
            }

            .why-choose__center {
                height: 300px;
            }
        }

        /* Chuyenkhoa styles from chuyenkhoa.html */
        .grid {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 20px;
            max-width: 1200px;
            margin: 24px auto;
            padding: 0 12px;
        }

        .card {
            background: #f8f8f8;
            border: 1px solid #e3e3e3;
            padding: 0;
            position: relative;
            overflow: hidden;
            font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        }

        .card:not(:has(img)) {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 12px;
            min-height: 120px;
            text-align: center;
        }

        .card .ck-title { 
            margin-bottom: 6px; 
        }

        .card .ck-desc { 
            margin-bottom: 4px; 
        }

        .card img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            display: block;
        }

        .ck-title { 
            font-weight: 800; 
            font-size: 1.15rem; 
            margin-bottom: 6px; 
            text-align: center; 
            width: 100%; 
        }

        .ck-desc { 
            color: #444; 
            font-size: 0.95rem; 
            line-height: 1.3; 
        }

        .ck-link { 
            margin-top: 4px; 
        }

        /* Styles for Tìm hiểu thêm button (keep original) */
        .learn-btn:not(.detail-btn) {
            display: inline-block;
            background: linear-gradient(135deg, #4a90e2 0%, #357abd 100%);
            color: #fff;
            border: none;
            padding: 8px 14px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 600;
            text-decoration: none;
            cursor: pointer;
            box-shadow: 0 6px 18px rgba(53,122,189,0.18);
            margin-top: 10px;
        }

        .learn-btn:not(.detail-btn):hover { 
            background: #f4c430;
            transform: translateY(-2px); 
        }

        /* Styles for Xem chi tiết button (restyled) */
        .detail-btn {
            display: inline-block;
            background: #f4c430;
            color: #333;
            border: none;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 13px;
            font-weight: 600;
            text-decoration: none;
            cursor: pointer;
            box-shadow: 0 4px 12px rgba(244, 196, 48, 0.3);
            margin-top: 8px;
            transition: all 0.3s ease;
        }

        .detail-btn:hover { 
            background: #e8b81a;
            transform: translateY(-1px);
            box-shadow: 0 6px 16px rgba(232, 184, 26, 0.4);
        }

        /* Responsive for grid */
        @media (max-width: 768px) {
            .grid {
                grid-template-columns: repeat(2, 1fr);
            }
        }

        /* Timbacsi styles from timbacsi.html */
        .doctors { 
            padding: 60px 0; 
        }

        .section-title { 
            font-size: 32px; 
            margin-bottom: 40px; 
            text-align: center; 
        }

        .doctor-cards { 
            display: flex; 
            gap: 20px; 
            margin-top: 30px; 
        }

        .doctor-cards .doctor-card { 
            flex: 1 0 calc(25% - 15px); 
        }

        .doctor-card {
            background: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            text-align: center;
            position: relative;
        }

        .img-wrap { 
            position: relative; 
            width: 100%; 
            height: 200px; 
            overflow: hidden; 
        }

        .doctor-img { 
            width: 100%; 
            height: 100%; 
            object-fit: cover; 
            display: block; 
        }

        .doctor-info { 
            padding: 15px; 
        }

        .doctor-info h3 { 
            font-size: 16px; 
            margin-bottom: 5px; 
        }

        .doctor-info p { 
            font-size: 12px; 
            color: #666; 
        }

        .overlay { 
            position: absolute; 
            left: 0; 
            right: 0; 
            bottom: 12px; 
            height: 0; 
            display: flex; 
            align-items: flex-end; 
            justify-content: center; 
            pointer-events: none; 
        }

        /* Specific for Tìm hiểu thêm in doctors (keep original hover) */
        .doctor-card .learn-btn {
            pointer-events: auto;
            transform: translateY(calc(120% + 10px));
            transition: transform 320ms cubic-bezier(.2,.8,.2,1);
            margin: 0;
            background: linear-gradient(135deg, #4a90e2 0%, #357abd 100%);
            color: #fff;
            border: none;
            padding: 10px 18px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
            box-shadow: 0 6px 18px rgba(53,122,189,0.25);
            margin-top: 10px;
        }

        .doctor-card:hover .learn-btn { 
            background: #f4c430;
            transform: translateY(0%); 
        }

        .exit-left { 
            transform: translateX(-120%); 
            opacity: 0; 
            transition: transform 420ms ease, opacity 420ms ease; 
        }

        .enter-right { 
            transform: translateX(120%); 
            opacity: 0; 
        }

        .enter-right.entering { 
            transition: transform 420ms ease, opacity 420ms ease; 
            transform: translateX(0); 
            opacity: 1; 
        }

        /* Responsive for doctors */
        @media (max-width: 768px) {
            .doctor-cards { 
                flex-direction: column; 
            }

            .section-title { 
                font-size: 24px; 
            }
        }

        /* Lienhe styles from lienhe.html */
        .steps-wrapper {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 30px;
            margin-top: 40px;
            padding: 40px 0;
        }

        .step-card {
            width: 100%;
            height: 350px;
            border-radius: 20px;
            padding: 30px;
            position: relative;
            color: white;
            display: flex;
            align-items: stretch;
            overflow: hidden;
        }

        .step-card.blue {
            background: linear-gradient(135deg, #2d5aa6 0%, #1e3f7a 100%);
            height: 300px;
        }

        .step-card.yellow {
            background: linear-gradient(135deg, #f4c430 0%, #e6b800 100%);
            color: #333;
            height: 300px;
        }

        .step-card.light-blue {
            background: linear-gradient(135deg, #5ba3d0 0%, #3d88b8 100%);
            height: 300px;
        }

        .step-badge {
            position: absolute;
            top: 20px;
            right: 30px;
            width: 60px;
            height: 60px;
            background: white;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: bold;
            font-size: 28px;
            z-index: 10;
        }

        .step-card.blue .step-badge {
            color: #2d5aa6;
        }

        .step-card.yellow .step-badge {
            color: #f4c430;
        }

        .step-card.light-blue .step-badge {
            color: #5ba3d0;
        }

        .step-content-left {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            padding-right: 30px;
            z-index: 2;
        }

        .step-title {
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 2px solid rgba(255, 255, 255, 0.3);
        }

        .step-card.yellow .step-title {
            border-bottom-color: rgba(0, 0, 0, 0.2);
        }

        .step-description {
            font-size: 18px;
            line-height: 1.5;
        }

        .step-card.blue .step-description {
            font-size: 16px;
        }

        .step-icon-right {
            flex: 0 0 auto;
            width: 100px;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            opacity: 0.8;
        }

        .step-icon-right svg {
            width: 80px;
            height: 80px;
        }

        /* Responsive for steps */
        @media (max-width: 768px) {
            .steps-wrapper {
                grid-template-columns: 1fr;
            }

            .step-card {
                width: 100%;
            }

            .step-title {
                font-size: 24px;
            }

            .step-description {
                font-size: 14px;
            }
        }

        /* Footer styles from footer.html */
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
            width: 45px;
            height: 45px;
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

        h4 {
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
            width: 60px;
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

        /* Responsive for footer */
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

            h4 {
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

            h4 {
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

        /* Additional spacing to prevent breaking between sections */
        .why-choose + h1 {
            padding: 60px 0 20px;
            text-align: center;
            font-size: 28px;
        }

        .grid {
            margin-bottom: 60px;
        }

        .doctors {
            padding: 60px 0;
        }

        .steps-wrapper {
            padding: 40px 0;
            margin-bottom: 60px;
        }
    </style> -->
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

        body > *:not(footer) {
            flex: 1;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }
    </style>
</head>
<body>
    <?php include '../layout/header.html'; ?>
    <?php include '../layout/banner.html'; ?>
    <?php include '../layout/guide.html'; ?>
    <?php include '../layout/why-choose.html'; ?>
    <?php include '../layout/specialties.html'; ?>
    <?php include '../layout/doctors.html'; ?>
    <?php include '../layout/footer.html'; ?>

    <script src="scripts.js"></script> <!-- Script tách riêng -->
</body>
</html>