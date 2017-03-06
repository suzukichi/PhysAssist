USE `physassist`;

CREATE TABLE `constants` (
   `symbol` VARCHAR(11),
   `value` DECIMAL(15, 5),
   `units` VARCHAR(255),
   `name` VARCHAR(255),
   `description` VARCHAR (255),
   INDEX `name` (`name`),
   PRIMARY KEY `symbol` (`symbol`, `value`)
);
