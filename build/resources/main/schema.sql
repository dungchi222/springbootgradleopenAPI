-- MarketingDb database
-- CREATE DATABASE MarketingDb;


DROP TABLE IF EXISTS `rules`;
DROP TABLE IF EXISTS `campaigns`;

-- -- campaigns table
-- CREATE TABLE campaigns (
--   id INT NOT NULL AUTO_INCREMENT,
--   description VARCHAR(200) NULL DEFAULT NULL,
--   From DATETIME NULL DEFAULT NULL,
--   name VARCHAR(200) NULL DEFAULT NULL,
--   pictureUri VARCHAR(200) NULL DEFAULT NULL,
--   to DATETIME NULL DEFAULT NULL,
--   detailsUri VARCHAR(200) NULL DEFAULT NULL,
--   pictureName VARCHAR(200) NULL DEFAULT NULL,
--    PRIMARY KEY (id)
-- );
--
CREATE TABLE campaigns (
                           id INT PRIMARY KEY,
                           description VARCHAR(200),
                           start_date  TIMESTAMP WITH TIME ZONE,
                           name VARCHAR(200),
                           pictureUri VARCHAR(200),
                           end_date  TIMESTAMP WITH TIME ZONE,
                           detailsUri VARCHAR(200),
                           pictureName VARCHAR(200)
);

CREATE TABLE rules (
                       id INT NOT NULL AUTO_INCREMENT,
                       campaignId INT NULL DEFAULT NULL,
                       description VARCHAR(200) NULL DEFAULT NULL,
                       ruletypeid INT NULL DEFAULT NULL,
                       locationId INT NULL DEFAULT NULL,
                       PRIMARY KEY (id)
    -- INDEX `fk_campaigns_rules_idx` (`campaignId` ASC),
    -- CONSTRAINT `fk_element_campaignId` FOREIGN KEY (`campaignId`) REFERENCES `campaigns` (`id`)
);