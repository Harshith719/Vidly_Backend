CREATE TABLE `movies` (
  `_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `genre_id` varchar(255) DEFAULT NULL,
  `numberInStock` int DEFAULT NULL,
  `dailyrentalrate` decimal(38,2) DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  `daily_rental_rate` decimal(38,2) DEFAULT NULL,
  `number_in_stock` int DEFAULT NULL,
  `publish_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `genre_id` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


