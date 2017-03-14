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

-- TEST DATA
INSERT INTO `users` (`username`, `password`, `first_name`, `last_name`,
 `email`, `registration_date`) 
VALUES
("bob", "123", "Bob", "Smith", "bob@smith.com", UNIX_TIMESTAMP(NOW())),
("prof", "bla", "Professor", "Watt", "prof@something.edu", UNIX_TIMESTAMP(NOW())),
("sam", "argh", "sam", "wise", "sam@theshire.me", UNIX_TIMESTAMP(NOW())),
("slacker", "noschool123", "mister", "truant", "slacker@", UNIX_TIMESTAMP(NOW()))
