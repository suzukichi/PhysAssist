CREATE TABLE `users` (
   `userid` INT(11) AUTO_INCREMENT,
   `username` VARCHAR(100),
   `password` VARCHAR(100),
   `first_name` VARCHAR(100),
   `last_name` VARCHAR(100),
   `email` VARCHAR(100),
   `registration_date` INT(11),
   PRIMARY KEY `userid` (`userid`),
   INDEX `username` (`username`)
);
