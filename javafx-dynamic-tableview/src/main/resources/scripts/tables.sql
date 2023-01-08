USE javafx_registration;

CREATE TABLE `CUSTOMER` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(25) NOT NULL,
  `status` int NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

--
-- Dumping data for table `CUSTOMER`
--

INSERT INTO `CUSTOMER` (`name`, `status`, `created`) VALUES
('Albert', 1, '2022-06-20 17:35:33'),
('Bob', 1, '2022-06-20 17:35:33'),
('Cindy', 0, '2022-06-20 17:36:10'),
('Derrik', 1, '2022-06-20 17:36:10'),
('Elaine', 0, '2022-06-20 17:36:10');

commit;
