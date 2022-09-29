-- create table order
-- (
--     id   bigint auto_increment primary key,
--     product_code varchar(100) null,
--     customer_id varchar(100) null,
--     req_value  decimal(15,2)  null,
--     status_odr varchar(100) null
-- );

create table orders
(
    id   bigint auto_increment primary key,
    product varchar(100) null,
    createat TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);