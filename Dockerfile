# Bước 1: Build với Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy file pom.xml trước để cache dependency
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build war file
RUN mvn clean package -DskipTests

# Bước 2: Run với Tomcat
FROM tomcat:9.0-jdk17

# Xóa webapp mặc định của Tomcat (ROOT, docs…)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy war đã build từ bước 1 -> ROOT.war
COPY --from=build /app/target/downloadApp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
