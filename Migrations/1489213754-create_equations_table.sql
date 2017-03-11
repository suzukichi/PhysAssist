CREATE TABLE `equataions` (
   `equationid` INT(11) NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(255),
   `description` VARCHAR(255),
   `history` VARCHAR(255),
   `view` VARCHAR(255),
   PRIMARY KEY `equationid` (`equationid`)
);

CREATE TABLE `ast` (
   `id` INT(11) NOT NULL AUTO_INCREMENT, 
   `term` VARCHAR(255),
   `equationid` INT(11),
   `ast` VARCHAR(255),
   PRIMARY KEY `id` (`id`)
);
