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

-- Create the table
CREATE TABLE genres (
  _id VARCHAR(255) NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

-- Insert the given records
INSERT INTO genres (_id, name) VALUES
('5b21ca3eeb7f6fbccd471818', 'Action'),
('5b21ca3eeb7f6fbccd471814', 'Comedy'),
('5b21ca3eeb7f6fbccd471820', 'Thriller');

