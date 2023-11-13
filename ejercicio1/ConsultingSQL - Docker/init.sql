 -- Crear la base de datos
CREATE DATABASE IF NOT EXISTS pruebatecnica;

-- Crear un usuario y asignarle permisos a la base de datos
CREATE USER 'pruebatecnica'@'%' IDENTIFIED BY 'pruebatecnica';
GRANT ALL PRIVILEGES ON pruebatecnica.* TO 'pruebatecnica'@'%';
