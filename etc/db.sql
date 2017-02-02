DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id`                    INT AUTO_INCREMENT,
  `login`                 VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;