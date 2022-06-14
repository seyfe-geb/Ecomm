
--Roles

INSERT INTO roles(name) VALUES('ROLE_BUYER');
INSERT INTO roles(name) VALUES('ROLE_SELLER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


--Users and Roles

-- User 1
INSERT INTO users (approved_seller, cardcvv, card_name, card_number, card_type, city,
                   created_at, email, enabled, first_name, last_name, modified_at, password,
                   state, street, username, zipcode)
VALUES (false, '144', 'VISA', '123456789', 'CREDIT', 'Fairfield', '2022-06-05', 'buyer@ecomm.net', true, 'Buyer', 'Ecomm', '2022-06-05', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        'IA', 'abc123', 'buyer', '123456');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
--
-- --User 2
INSERT INTO users (approved_seller, cardcvv, card_name, card_number, card_type, city,
                   created_at, email, enabled, first_name, last_name, modified_at, password,
                   state, street, username, zipcode)
VALUES (true, '155', 'MASTERCARD', '5642389', 'DEBIT', 'NewYork', '2022-06-05', 'seller@ecomm.net', true, 'Seller', 'Ecomm', '2022-06-05', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        'NY', 'def456', 'seller', '789456');

INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
--
--
-- --User 3
INSERT INTO users (approved_seller, cardcvv, card_name, card_number, card_type, city,
                   created_at, email, enabled, first_name, last_name, modified_at, password,
                   state, street, username, zipcode)
VALUES (false, '243', 'VISA', '12345682', 'CREDIT', 'Seattle', '2022-06-05', 'admin@ecomm.net', true, 'Admin', 'Ecomm', '2022-06-05', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',
        'WA', 'ghi789', 'admin', '159753');

INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);

-- -- --PRODUCTS

INSERT INTO products (price, product_description, product_image, product_name, quantity, user_id)
VALUES (100.00, 'It is a transport mechanism', 'https://www.financialexpress.com/wp-content/uploads/2021/06/world-bicycle-day-2021-hero-lectro-c5.jpg',
        'Bicycle', 14, 2);

INSERT INTO products (price, product_description, product_image, product_name, quantity, user_id)
VALUES (0.50, 'Stationery writing object', 'https://m.media-amazon.com/images/I/71LbzzDezeL._AC_SY355_.jpg',
        'Pen', 5, 2);

INSERT INTO products (price, product_description, product_image, product_name, quantity, user_id)
VALUES (60, 'Maximize your carry', 'https://m.media-amazon.com/images/I/81idlqFqcUL._AC_SL1500_.jpg',
        'Bag', 11, 2);

INSERT INTO products (price, product_description, product_image, product_name, quantity, user_id)
VALUES (1100, 'Cellular phone', 'https://media.wired.com/photos/5d803f5dc891950008ce3447/master/pass/iphone-11_6175-Edit.jpg',
        'IPhone', 57, 2);

-- INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
-- VALUES (4, '2022-04-15', 'essei@miu.com', 1, 'Esei', 0, 'Kahsay', '2022-04-15', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'essei');
--
-- INSERT INTO USER_ROLES(user_id, role_id) VALUES (4, 3);
--
--
-- --User 5
-- INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
-- VALUES (5, '2022-04-16', 'seyfe@miu.com', 1, 'Seyfe', 0, 'Gebriel', '2022-04-16', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'seyfe');
--
-- INSERT INTO USER_ROLES(user_id, role_id) VALUES (5, 3);
--
-- --User 6
-- INSERT INTO users (id, created_at, email, enabled, fname, is_approved_seller, lname, modified_at, password, username)
-- VALUES (6, '2022-04-17', 'admin@miu.com', 1, 'Admin', 0, 'Administrator', '2022-04-17', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 'admin');
--
-- INSERT INTO USER_ROLES(user_id, role_id) VALUES (6, 1);


-- --FOLLOWS
-- INSERT INTO follows (id, followee_id, follower_id) VALUES (1, 1, 3);
--
-- INSERT INTO follows (id, followee_id, follower_id) VALUES (2, 2, 3);
--
-- INSERT INTO follows (id, followee_id, follower_id) VALUES (3, 1, 4);
--
-- INSERT INTO follows (id, followee_id, follower_id) VALUES (4, 2, 4);
--
-- INSERT INTO follows (id, followee_id, follower_id) VALUES (5, 1, 5);
--
-- INSERT INTO follows (id, followee_id, follower_id) VALUES (6, 2, 5);
-- --
-- -- --ADDRESSES
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (1, 'FairField', 'IA', '123ST',   1, '123456', 1);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (2, 'FairField', 'IA', '123ST',   2, '123456', 1);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (3, 'Uttamwa', 'IA', '234ST',   1, '234567', 2);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (4, 'Uttamwa', 'IA', '234ST',   2, '234567', 2);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (5, 'MountPleasant', 'IA', '345ST',   1, '345678', 3);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (6, 'MountPleasant', 'IA', '345ST',   2, '345678', 3);
--
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (7, 'Iowa City', 'IA', '456ST',   1, '456789', 4);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (8, 'Iowa City', 'IA', '456ST',   2, '456789', 4);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (9, 'Des Moins', 'IA', '567ST',   1, '567891', 5);
--
-- INSERT INTO addresses (id, city, state, street, type, zip_code, user_id)
-- values (10, 'Des Moins', 'IA', '567ST',   2, '567891', 5);
-- --
-- --PAYMENT_METHOD
-- INSERT INTO payment_methods (id, csv, is_default, name, number, type, billing_address_id, user_id)
-- values (1, 142, 1, 'seyfe', '1234567891234567', 1, 9, 5);
--
-- -- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- -- values (2, 3, '234567', '2022-04-12', 'DEBIT', 2);
-- --
-- -- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- -- values (3, 5, '345678', '2022-04-13', 'CREDIT', 3);
-- --
-- -- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- -- values (4, 7, '456789', '2022-04-14', 'DEBIT', 4);
-- --
-- -- INSERT INTO payment_method (id, billing_address_id, card_number, created_at, payment_type, user_id)
-- -- values (5, 9, '567891', '2022-04-15', 'CREDIT', 5);
-- --
-- --






-- -- --ShoppingCart
-- INSERT INTO shopping_cart (id,user_id)
-- values (10,3);
--
-- INSERT INTO shopping_cart (id,user_id)
-- values (21,4);
--
-- INSERT INTO shopping_cart (id,user_id)
-- values (33,5);
--
-- -- --ShoppingCart Item
-- INSERT INTO shopping_cart_items (id, quantity, shopping_cart_id, product_id)
-- values (1, 10, 1,1);
-- --
-- INSERT INTO shopping_cart_items (id, quantity, shopping_cart_id, product_id)
-- values (2, 5, 2,2);
--
-- INSERT INTO shopping_cart_items (id, quantity, shopping_cart_id, product_id)
-- values (3, 2, 3,3);