-- abcd.student definition

CREATE TABLE `student` (
  `id` int NOT NULL,
  `hoten` varchar(45) COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `mssv` int NOT NULL,
  `gpa` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `mssv_UNIQUE` (`mssv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO student (id,hoten,mssv,gpa) VALUES
	 (1,'Phạm Huy Cường Thịnh',20121234,9.9),
	 (2,'Huy Cường Thịnh Phạm',20124321,9.1),
	 (3,'Cường Phạm',20129876,10.0);