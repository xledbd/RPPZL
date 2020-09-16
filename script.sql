-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rppzl
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rppzl
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rppzl` DEFAULT CHARACTER SET utf8 ;
USE `rppzl` ;

-- -----------------------------------------------------
-- Table `rppzl`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rppzl`.`country` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  `citizenship` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rppzl`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rppzl`.`city` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`city_id`),
  INDEX `FK_CITY_COUNTRY_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `FK_CITY_COUNTRY`
    FOREIGN KEY (`country_id`)
    REFERENCES `rppzl`.`country` (`country_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rppzl`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rppzl`.`client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `lastname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `passport_series` VARCHAR(45) NOT NULL,
  `passport_number` VARCHAR(45) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  `date_of_issue` DATE NOT NULL,
  `identification_number` VARCHAR(45) NOT NULL,
  `place_of_birth` VARCHAR(45) NOT NULL,
  `city_of_residence_id` INT NOT NULL,
  `adress_of_residence` VARCHAR(45) NOT NULL,
  `lendline_phone` VARCHAR(45) NULL,
  `mobile_phone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `place_of_work` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `city_of_registration_id` INT NOT NULL,
  `family_status` VARCHAR(45) NOT NULL,
  `citizenship_id` INT NOT NULL,
  `disability` VARCHAR(45) NOT NULL,
  `retiree` TINYINT NOT NULL,
  `monthly_income` FLOAT NULL,
  PRIMARY KEY (`client_id`),
  INDEX `FK_CLIENT_CITY_idx` (`city_of_residence_id` ASC) VISIBLE,
  INDEX `FK_CLIENT_CITY_REGISTRATION_idx` (`city_of_registration_id` ASC) VISIBLE,
  INDEX `FK_CLIENT_COUNTRY_idx` (`citizenship_id` ASC) VISIBLE,
  CONSTRAINT `FK_CLIENT_CITY_RESIDENCE`
    FOREIGN KEY (`city_of_residence_id`)
    REFERENCES `rppzl`.`city` (`city_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_CLIENT_CITY_REGISTRATION`
    FOREIGN KEY (`city_of_registration_id`)
    REFERENCES `rppzl`.`city` (`city_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_CLIENT_COUNTRY`
    FOREIGN KEY (`citizenship_id`)
    REFERENCES `rppzl`.`country` (`country_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `rppzl`.`country`
-- -----------------------------------------------------
START TRANSACTION;
USE `rppzl`;
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (1, 'Беларусь', 'белорус/белоруска');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (2, 'Россия', 'россиянин/россиянка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (3, 'США', 'американец/американка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (4, 'Украина', 'украинец/украинка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (5, 'Латвия', 'латвиец/латвийка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (6, 'Литва', 'литовец/литовка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (7, 'Польша', 'поляк/полька');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (8, 'Германия', 'немец/немка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (9, 'Франция', 'француз/француженка');
INSERT INTO `rppzl`.`country` (`country_id`, `country`, `citizenship`) VALUES (10, 'Китай', 'китаец/китаянка');

COMMIT;


-- -----------------------------------------------------
-- Data for table `rppzl`.`city`
-- -----------------------------------------------------
START TRANSACTION;
USE `rppzl`;
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (1, 'Минск', 1);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (2, 'Москва', 2);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (3, 'Вашингтон', 3);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (4, 'Киев', 4);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (5, 'Рига', 5);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (6, 'Вильнюс', 6);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (7, 'Варшава', 7);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (8, 'Берлин', 8);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (9, 'Париж', 9);
INSERT INTO `rppzl`.`city` (`city_id`, `name`, `country_id`) VALUES (10, 'Пекин', 10);

COMMIT;

