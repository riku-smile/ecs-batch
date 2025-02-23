FROM amazoncorretto:17-alpine

WORKDIR /app

# Gradleでビルドされたjarファイルをコピー
COPY ./build/libs/*.jar ./batch-application.jar

# 実行コマンドの設定
ENTRYPOINT ["java", "-jar", "/app/batch-application.jar"] 