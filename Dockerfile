# FROM -> 어떤 가상 환경에서 실행을 할 것인지 선택
# ARG -> 아규먼트 대문자(스네이크) = TEST_NAME=test
# CMD -> 도커 환경에서 명령어를 실행 할 수 있음 (1번만 가능)
# COPY -> TEST_NAME aaa (AS 느낌)
# ENTRYPOINT -> ["java", "-Dspring.profiles.active=prod1", "-Dserver.env=green", "-jar", "파일명.jar"]

# 서버에 문제가있을땐 jdk 재설정해야함
# adoptopenjdk/openjdk11:latest
FROM amazoncorretto:11-alpine-jdk
# FROM adoptopenjdk/openjdk11:latest

# jar로 시작하는 파일을 jar로 설정할 것이다.
ARG JAR_FILE=target/*.jar
ARG PROFILES
ARG ENV
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}", "-jar", "app.jar"]