INSERT INTO customers(first_name,last_name,email) VALUES ('Ada','Lovelace','ada@example.test'),('Grace','Hopper','grace@example.test');
INSERT INTO products(sku,name,description,price,stock_quantity) VALUES ('KB-100','Mechanical Keyboard','Compact keyboard',89.90,30),('MS-200','Wireless Mouse','Ergonomic mouse',35.50,50),('MN-300','27-inch Monitor','IPS display',249.00,12);
INSERT INTO customer_orders(customer_id,status,total) VALUES (1,'PAID',125.40),(2,'PENDING',35.50);
INSERT INTO order_items(order_id,product_id,quantity,unit_price) VALUES (1,1,1,89.90),(1,2,1,35.50),(2,2,1,35.50);
