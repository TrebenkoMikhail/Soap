CREATE TABLE categories (categoryId bigserial primary key, productTitle varchar(255), categoryTitle varchar(255));
insert into categories (categories)
values
('fruits')

CREATE TABLE products (productId serial, title varchar(255), price integer, category-id integer REFERENCES categories(id));

insert into products (title,categories, price)
values
('apple', 'fruits', 1), ('orange', 'fruits', 2)
