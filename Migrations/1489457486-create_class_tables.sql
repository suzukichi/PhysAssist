CREATE TABLE `classrooms` (
   `classroomid` INT(11) AUTO_INCREMENT,
   `title` VARCHAR(100),
   `description` VARCHAR(150),
   `ownerid` INT(11),
   `start_date` INT(11),
   `status` TINYINT(1),
   PRIMARY KEY `classroomid` (`classroomid`),
   INDEX `ownerid` (`ownerid`),
   INDEX `status` (`status`)
);

-- FILL CLASSROOMS
INSERT INTO `classrooms` (`title`, `description`, `ownerID`, `start_date`, `status`) 
VALUES 
("Physics1", "A physics class.", 1, UNIX_TIMESTAMP(NOW()), 0),
("Physics2", "Another physics class.", 1, UNIX_TIMESTAMP(NOW()), 0),
("Physics3", "A third physics class.", 1, UNIX_TIMESTAMP(NOW()), 1);

-- STUDENT TABLES
CREATE TABLE `students` (
   `userid` INT(11),
   `classroomid` INT(11),
   PRIMARY KEY `userid` (`userid`, `classroomid`)
);

-- FILL STUDENTS
INSERT INTO `students` (`userid`, `classroomid`)
VALUES 
(1, 1),
(2, 1),
(2, 2);

