create table if not exists halls (id int(11) NOT NULL AUTO_INCREMENT, title varchar(45), seats int(11), PRIMARY KEY (id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
# CREATE TABLE  if not exists `genres` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `title` varchar(255) NOT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# CREATE TABLE  if not exists `sessions` (
#     `id` int(11) NOT NULL AUTO_INCREMENT,
#     `time` varchar(5) NOT NULL,
#     `day` varchar(12) NOT NULL,
#     'price' int(11) NOT NULL,
#     `movie_id` int(11) NOT NULL,
#     `hall_id` int(11) NOT NULL,
#     PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
# CREATE TABLE  if not exists `movies` (
#     `id` int(11) NOT NULL AUTO_INCREMENT,
#     `title` varchar(5) NOT NULL,
#     `year` int(4) NOT NULL,
#     `duration` int(11) NOT NULL,
#     PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
CREATE TABLE  if not exists `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `password` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;