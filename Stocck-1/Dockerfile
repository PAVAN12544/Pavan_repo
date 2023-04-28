FROM openjdk:11
ADD target/Stocck-1-0.0.1-SNAPSHOT.jar Stocck-1.jar
ENTRYPOINT ["java","-jar","Stocck-1.jar"]
EXPOSE 9000
ENV spring.datasource.url=jdbc:mysql://host.docker.internal:3306/pavanreddydb