CREATE TABLE `topics`(
   `creation_time` INT(11) NOT NULL, 
   `topicid` INT(11) NOT NULL AUTO_INCREMENT,
   `parentid` INT(11),
   PRIMARY KEY `topicid` (`topicid`),
   INDEX `creation_time` (`creation_time`),
   INDEX `parentid` (`parentid`)
);

CREATE TABLE `topic_revisions`(
   `revisionid` INT(11) NOT NULL AUTO_INCREMENT,
   `topicid` INT(11) NOT NULL,
   `title` VARCHAR(150),
   `text` VARCHAR(255),
   `authorid` INT(11),
   PRIMARY KEY `revisionid` (`revisionid`), 
   INDEX `topicid` (`topicid`),
   INDEX `authorid` (`authorid`)
);
