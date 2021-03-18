CREATE DATABASE IF NOT EXISTS projectname;
USE projectname;

CREATE TABLE `projectname`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idusers_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

INSERT INTO users(firstname, lastname, email, phone, address) VALUES('sample1', 'sample1', 'sample1@gmail.com', 'samplephone', 'sample address')