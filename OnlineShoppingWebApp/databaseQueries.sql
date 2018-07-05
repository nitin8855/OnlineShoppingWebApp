CREATE TABLE category(

id IDENTITY,
name VARCHAR(50),
discription VARCHAR(260),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)

);


INSERT INTO category  (name,discription,image_url,is_active) values('Laptop','This is Laptop','CAT-3.png',true);