CREATE TABLE `equataions` (
   `equationid` INT(11) NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(255),
   `description` VARCHAR(255),
   `history` VARCHAR(255),
   `view` VARCHAR(255),
   `topicid` INT(11),
   PRIMARY KEY `equationid` (`equationid`),
   INDEX `topicid` (`topicid`)
);

-- DATA
INSERT INTO `equations` (`name`, `description`, `history`, `view`) 
VALUES 
("Newton's Second Law of Motion", "The force (F) acting on an object is equal to the mass (m) of an object times its acceleration (a).", "Isaac Newton's laws of motion were first set down in his Principia Mathematica Philosophiae Naturalis in 1687.", "F = m * a"),
("Hooke's Law", "The extension of a spring (x) is proportional to the load placed on the spring (F), until it reaches the limit of proportionality. K is the spring constant.", "Hooke's law, law of elasticity discovered by the English scientist Robert Hooke in 1660.", "F = K * x"),
("Speed Equation", "Speed equals distance divided by time", "It all started with an apple.", "s = d / t");


-- AST TABLE

CREATE TABLE `ast` (
   `id` INT(11) NOT NULL AUTO_INCREMENT, 
   `term` VARCHAR(255),
   `equationid` INT(11),
   `ast` VARCHAR(255),
   PRIMARY KEY `id` (`id`)
);

-- AST DATA
INSERT INTO `ast` (`term`, `equationid`, `ast`)
VALUES 
("F", 1, "* m a"),
("m", 1, "/ F a"),
("a", 1, "/ F m"),
("F", 2, "* k x"),
("x", 2, "/ F K"),
("K", 2, "/ F x"),
("s", 3, "/ d t"),
("d", 3, "* t s"),
("t", 3, "/ d s");
