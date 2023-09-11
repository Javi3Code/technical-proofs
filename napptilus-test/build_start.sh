mvn clean install -DskipTests &&
docker build -t tech-prf . &&
docker run -p 8080:8080 tech-prf