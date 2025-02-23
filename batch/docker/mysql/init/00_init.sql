-- データベースとユーザーの作成
CREATE DATABASE IF NOT EXISTS batch_db;
CREATE USER IF NOT EXISTS 'batch_user'@'%' IDENTIFIED BY 'batch_pass';
GRANT ALL PRIVILEGES ON batch_db.* TO 'batch_user'@'%';
FLUSH PRIVILEGES;

USE batch_db; 