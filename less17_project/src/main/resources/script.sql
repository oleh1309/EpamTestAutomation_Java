CREATE SCHEMA `new_schema`;

CREATE TABLE `new_schema`.`city`
(
    `City` varchar(25) NOT NULL,
    PRIMARY KEY (`City`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `new_schema`.`bank`
(
    `IDBank` int         NOT NULL AUTO_INCREMENT,
    `Name`   varchar(25) NOT NULL,
    `City`   varchar(25) NOT NULL,
    PRIMARY KEY (`IDBank`),
    KEY `City_idx` (`City`),
    CONSTRAINT `City_idx` FOREIGN KEY (`City`) REFERENCES `city` (`City`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1023
  DEFAULT CHARSET = utf8;

CREATE TABLE `new_schema`.`client`
(
    `IDClient`        int         NOT NULL AUTO_INCREMENT,
    `Surname`         varchar(25) NOT NULL,
    `Name`            varchar(25) NOT NULL,
    `City`            varchar(25) NOT NULL,
    `Email`           varchar(45) DEFAULT NULL,
    `Password`        varchar(25) NOT NULL,
    `QuestionToReset` varchar(50) NOT NULL,
    `AnswerToReset`   varchar(25) NOT NULL,
    `IDBank`          int         DEFAULT NULL,
    PRIMARY KEY (`IDClient`),
    KEY `City` (`City`),
    KEY `IDBank_idx` (`IDBank`),
    CONSTRAINT `client_ibfk_1` FOREIGN KEY (`City`) REFERENCES `city` (`City`),
    CONSTRAINT `IDBank` FOREIGN KEY (`IDBank`) REFERENCES `bank` (`IDBank`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

CREATE TABLE `new_schema`.`type`
(
    `IDType`     int         NOT NULL AUTO_INCREMENT,
    `TypeName`   varchar(45) NOT NULL,
    `Commission` double      NOT NULL,
    `Duration`   int         NOT NULL,
    PRIMARY KEY (`IDType`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

CREATE TABLE `new_schema`.`account`
(
    `IDAccount` int          NOT NULL AUTO_INCREMENT,
    `IDClient`  int          NOT NULL,
    `IDType`    int          NOT NULL,
    `Amount`    int unsigned NOT NULL,
    `DateStart` date         NOT NULL,
    `DateEnd`   date         NOT NULL,
    PRIMARY KEY (`IDAccount`),
    KEY `IDType` (`IDType`) /*!80000 INVISIBLE */,
    KEY `IDClient` (`IDClient`) /*!80000 INVISIBLE */,
    CONSTRAINT `fk_1` FOREIGN KEY (`IDClient`) REFERENCES `client` (`IDClient`),
    CONSTRAINT `fk_2` FOREIGN KEY (`IDType`) REFERENCES `type` (`IDType`) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8;

CREATE TABLE `new_schema`.`transaction`
(
    `IDTransaction`  int    NOT NULL AUTO_INCREMENT,
    `IDClient_from`  int    NOT NULL,
    `IDAccount_from` int    NOT NULL,
    `IDClient_to`    int    NOT NULL,
    `IDAccount_to`   int    NOT NULL,
    `Amount`         double NOT NULL,
    `IsSuccess`      int DEFAULT '0',
    PRIMARY KEY (`IDTransaction`),
    KEY `account_ibfk_1` (`IDClient_from`) /*!80000 INVISIBLE */,
    KEY `account_ibfk_2` (`IDAccount_from`) /*!80000 INVISIBLE */,
    KEY `account_ibfk_3` (`IDClient_to`) /*!80000 INVISIBLE */,
    KEY `account_ibfk_4` (`IDAccount_to`),
    CONSTRAINT `IDAccount_from` FOREIGN KEY (`IDAccount_from`) REFERENCES `account` (`IDAccount`),
    CONSTRAINT `IDAccount_to` FOREIGN KEY (`IDAccount_to`) REFERENCES `account` (`IDAccount`),
    CONSTRAINT `IDClient_from` FOREIGN KEY (`IDClient_from`) REFERENCES `account` (`IDClient`),
    CONSTRAINT `IDClient_to` FOREIGN KEY (`IDClient_to`) REFERENCES `account` (`IDClient`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8;



INSERT INTO `new_schema`.`city` (`City`) VALUES ('Uzhorod');
INSERT INTO `new_schema`.`city` (`City`) VALUES ('Herson');
INSERT INTO `new_schema`.`city` (`City`) VALUES ('Kyiv');
INSERT INTO `new_schema`.`city` (`City`) VALUES ('Lviv');
INSERT INTO `new_schema`.`city` (`City`) VALUES ('Poltava');
INSERT INTO `new_schema`.`city` (`City`) VALUES ('Ternopil');

INSERT INTO `new_schema`.`type` (`IDType`, `TypeName`, `Commission`, `Duration`) VALUES ('1', 'DEBIT_LIGHT', '0.01', '2');
INSERT INTO `new_schema`.`type` (`IDType`, `TypeName`, `Commission`, `Duration`) VALUES ('2', 'DEBIT_MEDIUM', '0.005', '3');
INSERT INTO `new_schema`.`type` (`IDType`, `TypeName`, `Commission`, `Duration`) VALUES ('3', 'CREDIT_LIGHT', '0.03', '2');
INSERT INTO `new_schema`.`type` (`IDType`, `TypeName`, `Commission`, `Duration`) VALUES ('4', 'CREDIT_MEDIUM', '0.04', '3');
INSERT INTO `new_schema`.`type` (`IDType`, `TypeName`, `Commission`, `Duration`) VALUES ('5', 'DEPOSIT_LIGHT', '0.03', '3');
INSERT INTO `new_schema`.`type` (`IDType`, `TypeName`, `Commission`, `Duration`) VALUES ('6', 'DEPOSIT_MEDIUM', '0.06', '6');