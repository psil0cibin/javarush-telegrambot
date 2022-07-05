FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.test_serhio_bot
ENV BOT_TOKEN=5406054785:AAHi-uFaxGkC_aicDpvivmXpmuT4HG-jIr4
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]