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

CREATE TABLE `students` (
   `userid` INT(11),
   `classroomid` INT(11),
   PRIMARY KEY `userid` (`userid`, `classroomid`)
);
