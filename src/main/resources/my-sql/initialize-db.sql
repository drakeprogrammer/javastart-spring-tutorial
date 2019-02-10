CREATE DATABASE spring_framework_db;

CREATE USER 'spring_framework_admin'@'localhost'
  IDENTIFIED BY 'spring_framework_admin_pass';
CREATE USER 'spring_framework_admin'@'%'
  IDENTIFIED BY 'spring_framework_admin_pass';

GRANT ALL PRIVILEGES ON spring_framework_db.* TO 'spring_framework_admin'@'localhost'
  WITH GRANT OPTION;

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON spring_framework_db.* TO 'spring_framework_admin'@'%'
  WITH GRANT OPTION;

FLUSH PRIVILEGES;
