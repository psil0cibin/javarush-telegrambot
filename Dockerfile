FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.test_serhio_bot
ENV BOT_TOKEN=5406054785:AAHi-uFaxGkC_aicDpvivmXpmuT4HG-jIr4
ENV BOT_DB_USERNAME=jrtb_db_user
ENV BOT_DB_PASSWORD=jrtb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]