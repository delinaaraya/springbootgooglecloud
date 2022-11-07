DROP SCHEMA IF EXISTS `cst_339`;
CREATE SCHEMA IF NOT EXISTS `cst_339` DEFAULT CHARACTER SET utf8;
USE `cst_339`;
DROP TABLE IF EXISTS `cst_339`.`UserRegistration`;
CREATE TABLE IF NOT EXISTS `cst_339`.`UserRegistration` (
  `UserID` INT(15) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(50) NOT NULL,
  `UserPassword` VARCHAR(50) NOT NULL,
  `UserFName` VARCHAR(50) NOT NULL,
  `UserLName` VARCHAR(50) NOT NULL,
  `UserEmail` VARCHAR(50) NOT NULL,
  `UserPhone` INT(15) NOT NULL,
  PRIMARY KEY (`UserID`),
  KEY `Regname` (`Username`),
  KEY `Regpass` (`UserPassword`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cst_339`.`UserLogin`;
CREATE TABLE IF NOT EXISTS `cst_339`.`UserLogin` (
  `UserID` INT(15) NOT NULL,
  `Username` VARCHAR(50) NOT NULL,
  `UserPassword` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`UserID`),
-- KEY `Regname` (`Username`),
-- KEY `Regpass` (`UserPassword`),
  CONSTRAINT FOREIGN KEY UserLogin_FK_UserRegistration (`UserID`) REFERENCES UserRegistration(`UserID`)
-- CONSTRAINT FOREIGN KEY UserLogin_FK_UserRegistration (`Username`) REFERENCES UserRegistration(`Username`),
-- CONSTRAINT FOREIGN KEY UserLogin_FK_UserRegistration (`UserPassword`) REFERENCES UserRegistration(`UserPassword`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cst_339`.`Product`;
CREATE TABLE IF NOT EXISTS `cst_339`.`Product` (
  `id` INT(15) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `price` FLOAT(50) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  -- `vendor` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
  -- CONSTRAINT FOREIGN KEY Product_FK_UserLogin (`vendor`) REFERENCES UserLogin(`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

INSERT INTO `cst_339`.`UserRegistration` (`UserID`,`Username`,`UserPassword`,`UserFName`,
`UserLName`,`UserEmail`, `UserPhone`) VALUES (0, "TestUser", "TestPass", "TestF", "TestL", "Test@google.com", 1234567890);
-- INSERT INTO `cst_339`.`UserLogin` (`UserID`,`Username`,`UserPassword`) VALUES (0, "TestUser", "TestPass");
-- INSERT INTO `cst_339`.`Product` (`id`,`name`,`price`,`description`,`vendor`) VALUES (105, "TestProduct", 10, "TestDescription", "TestUser");
INSERT INTO `cst_339`.`Product` (`id`,`name`,`price`,`description`) VALUES (105, "TestProduct", 10, "TestDescription");