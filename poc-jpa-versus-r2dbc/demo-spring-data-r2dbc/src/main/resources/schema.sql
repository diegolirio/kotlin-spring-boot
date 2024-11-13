CREATE SEQUENCE SEQ_COSTODY start with 1 increment by 1 nocache;
CREATE TABLE IF NOT EXISTS DBUSER.custody (id NUMBER(38,0) default SEQ_COSTODY.nextval PRIMARY KEY, customer_Id VARCHAR(255));