ALTER SESSION SET CONTAINER = FREEPDB1;
ALTER SESSION SET CURRENT_SCHEMA = dbuser;

CREATE TABLE IF NOT EXISTS DBUSER.custody (id NUMBER(38,0) PRIMARY KEY, customer_Id VARCHAR(255))