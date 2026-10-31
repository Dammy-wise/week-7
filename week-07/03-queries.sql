-- Read products, customers and orders
SELECT * FROM products ORDER BY name;
SELECT id,first_name,last_name,email FROM customers WHERE email='ada@example.test';
SELECT o.id,c.email,o.status,o.total,o.created_at FROM customer_orders o JOIN customers c ON c.id=o.customer_id ORDER BY o.created_at DESC;
-- Update stock safely (constraint prevents negative values)
UPDATE products SET stock_quantity=stock_quantity-1 WHERE sku='KB-100' AND stock_quantity>=1;
-- Sales summary by status and best-selling product
SELECT status,COUNT(*) order_count,SUM(total) sales FROM customer_orders GROUP BY status;
SELECT p.sku,p.name,SUM(i.quantity) units_sold FROM order_items i JOIN products p ON p.id=i.product_id GROUP BY p.sku,p.name ORDER BY units_sold DESC;
-- Delete only a disposable test customer (FK protects referenced customers)
-- DELETE FROM customers WHERE email='test@example.test';
