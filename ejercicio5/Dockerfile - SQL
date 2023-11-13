FROM mysql:latest

ENV MYSQL_DATABASE=pruebatecnica
ENV MYSQL_USER=pruebatecnica
ENV MYSQL_PASSWORD=pruebatecnica

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 3307
