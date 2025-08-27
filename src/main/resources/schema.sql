DROP TABLE IF EXISTS t_image;
DROP TABLE IF EXISTS t_product;
DROP TABLE IF EXISTS t_seller;
DROP TABLE IF EXISTS t_category;
DROP TABLE IF EXISTS t_user;

CREATE TABLE t_category (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            category1 VARCHAR(100) NOT NULL DEFAULT '',
                            category2 VARCHAR(100) NOT NULL DEFAULT '',
                            category3 VARCHAR(100) DEFAULT ''
);

CREATE TABLE t_seller (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL DEFAULT '',
                          email VARCHAR(100) NOT NULL DEFAULT '',
                          phone VARCHAR(20) NOT NULL DEFAULT ''
);

CREATE TABLE t_product (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           product_name VARCHAR(200) NOT NULL DEFAULT '',
                           product_price INT NOT NULL DEFAULT 0,
                           delivery_price INT NOT NULL DEFAULT 0,
                           add_delivery_price INT NOT NULL DEFAULT 0,
                           tags VARCHAR(100),
                           outbound_days INT NOT NULL DEFAULT 5,
                           seller_id INT NOT NULL,
                           category_id INT NOT NULL,
                           active_yn VARCHAR(1) NOT NULL DEFAULT 'Y',
                           created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (seller_id) REFERENCES t_seller(id),
                           FOREIGN KEY (category_id) REFERENCES t_category(id)
);

CREATE TABLE t_image (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         product_id INT NOT NULL,
                         type INT NOT NULL DEFAULT 1,
                         path VARCHAR(150) NOT NULL DEFAULT '',
                         FOREIGN KEY (product_id) REFERENCES t_product(id)
);

CREATE TABLE t_user (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        email VARCHAR(50),
                        type INT NOT NULL DEFAULT 1,
                        nickname VARCHAR(50)
);
