USE `physassist`;

CREATE TABLE `constants` (
   `symbol` VARCHAR(11),
   `value` VARCHAR(255),
   `units` VARCHAR(255),
   `name` VARCHAR(255),
   `description` VARCHAR (255),
   INDEX `name` (`name`),
   PRIMARY KEY `symbol` (`symbol`, `value`)
);

-- Fill constants table:
insert into `constants` (`symbol`, `value`, `units`, `name`, `description`)
values
("c", "299792458.0", "m * s^-1", "speed of light", "speed of light in a vacuum"),
("G", "0.0000000000667408", "m^3 * k^-1 * s ^ -2", "Gravitational Constant", "Newtonian constant of gravitation"),
("h", "0.0000000000000000000000000000000006626", "J * s", "Planck Constant", "Links the amount of energy a photon carries with the frequency of its electromagnetic wave"),
("q", "0.00000000000000000016", "C", "Elementary Charge", "Electric charge carried by a single proton"),
("R", "8.314", "J * K^-1 * mol^-1", "Gas Constant", "Ideal gas constant"),
("g", "9.8", "m * s^-2", "Acceleration of Gravity", "Acceleration due to gravity"),
("k", "8987500000", "N * m^2 * C^-2", "Coulomb Constant", "Coulomb constant"),
("F", "96485.309", "C * mol^-1", "Faraday Constant", "Faraday constant");




