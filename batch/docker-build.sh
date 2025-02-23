#!/bin/bash

# Gradleのパーミッションを修正
chmod +x ./gradlew

# テストをスキップしてビルド
./gradlew clean build -x test

# jarファイルの存在確認
if [ ! -f build/libs/*.jar ]; then
    echo "Error: Jar file not found!"
    exit 1
fi

# Dockerイメージをビルド
docker compose build

# 完了メッセージ
echo "Docker build completed!" 