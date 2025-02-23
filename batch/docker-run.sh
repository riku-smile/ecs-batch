#!/bin/bash

# 引数チェック
if [ $# -eq 0 ]; then
    echo "Usage: $0 <job-name>"
    exit 1
fi

# 実行するジョブ名を取得
JOB_NAME=$1

# 古いコンテナを停止・削除（もし存在する場合）
docker-compose down

# docker-composeでバッチを実行
docker compose run --rm batch-app $JOB_NAME 