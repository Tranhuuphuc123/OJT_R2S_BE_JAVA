/*############### PHẦN BÀI TẬP VÊ JOIN ###############*/
-- ==================================================================================
/*lab 01: PHẦN JOIN CỦA SCHEMA SALES*/
-- ==================================================================================
SELECT * FROM orders;
SELECT * FROM customers;
SELECT * FROM employees;

-- Question 1: thuc hien Join giua customer voi order dung inner join
SELECT o.order_id, c.customer_id, c.customer_name 
FROM customers c 
INNER JOIN orders o 
ON c.customer_id = o.cust_id;

-- Question 2: thuc hien Join giua customer voi order dung left join(outer join) 
SELECT c.customer_id, c.customer_name, o.order_id
FROM customers c 
LEFT JOIN orders o 
ON c.customer_id = o.cust_id;

-- Question 3: bài tập SELF JOIN TỰ LIÊN KẾT CHÍNH NÓ cho bang customers
/*Note: Bản chất của câu lệnh này là đem bảng employees nhân bản lên
làm hai để tìm xem ai là sếp của ai.
    + Bảng a (Đóng vai trò là Nhân viên): Dùng để lấy
    thông tin của nhân viên.
    + Bảng b (Đóng vai trò là Sếp): Dùng để lấy thông 
    tin của người quản lý.*/

SELECT a.employee_id, a.last_name || ' '  || a.first_name AS "EmployeeName",
b.employee_id AS "SupervisorID", b.last_name || ' ' ||  b.first_name AS "SupervisorName"
FROM employees a INNER JOIN employees b 
ON a.supervisor_id = b.employee_id;


-- Question 4: bai tap la self join tu bang customers voi dieu kien hien thi mot cap k/h khac nhau nhung cung quoc gia 
SELECT a.customer_id, a.customer_name, a.country 
FROM customers a INNER JOIN customers b
ON a.customer_id <> b.customer_id 
WHERE a.country = b.country;

-- Question 5: lien ket ba table employees, orders va customers
SELECT order_id, customer_name, first_name || ' ' || last_name AS "EmployeeName"
FROM employees e 
INNER JOIN orders o ON e.employee_id = o.empl_id 
INNER JOIN customers c ON c.customer_id = o.cust_id;



-- ==================================================================================
/*lab 02: PHẦN JOIN CỦA SCHEMA BIKESTORES*/
-- ==================================================================================


/*Question 1: Retrieve the product name and list price from the "products" table along with the 
corresponding brand name from the "brands" table. Only include products with a list 
price greater than $1000*/
SELECT * FROM products;
SELECT * FROM brands;

SELECT p.product_name, p.list_price, b.brand_name 
FROM products p 
INNER JOIN brands b 
ON p.brand_id = b.brand_id 
WHERE p.list_price > 1000;


/*Question 2: Retrieve all customers from the "customers" table along with their corresponding 
orders from the "orders" table. Include only customers who have placed orders with an 
order status of “Completed" (order_status = 4*/
SELECT * FROM customers;
SELECT * FROM orders;

SELECT c.customer_id, c.first_name || ' ' || c.last_name AS "Customer_name", o.required_date, shipped_date 
FROM customers c 
LEFT JOIN orders o 
ON c.customer_id = o.customer_id 
WHERE o.order_status = 4;


/*Question 3: Retrieve the first and last names of employees along with the first and last names of 
their respective managers. Assume the "staffs" table contains a column "manager_id" 
that references another row in the same "staffs" table
 => bai nay la seft join tu ket noi voi bang stafts tim kiem nhan vien do dc quan ly voi ai 
 trong cung bang
*/
SELECT * FROM stafts;

SELECT st1.first_name || ' ' || st1.last_name AS "Fullname_staffs",
       st1.email, 
       st2.first_name || ' ' || st2.last_name AS "Manager_name",
       st2.email AS "manager_email"
FROM stafts st1
INNER JOIN stafts st2
ON st1.manager_id = st2.staft_id; 

/*Question 4: Retrieve all products from the "products" table along with their corresponding brand 
names from the "brands" table. Include products even if they don't have a matching(y la dung 
outer join de lk ca thg hieu khong trung khop hai table)
brand.*/
SELECT * FROM products;
SELECT * FROM brands;

SELECT p.product_name, b.brand_name 
FROM products p
LEFT JOIN brands b 
ON p.brand_id = b.brand_id;


/*Question 5: Retrieve the product name and model year from the "products" table along with the 
corresponding brand name from the "brands" table. Only include products with a model 
year of 2016 and above*/
SELECT p.product_name, p.model_year, b.brand_name 
FROM products p
LEFT JOIN brands b 
ON p.brand_id = b.brand_id
WHERE p.model_year >= 2016;
-- WHERE EXTRACT(YEAR FROM p.model_year) >= 2016;
-- hoac co the dung to_date de chi chinhs xac ngay thang nam 
--ON p.brand_id = b.brand_id
-- WHERE p.model_year >= TO_DATE('2016-01-01', 'YYYY-MM-DD');


/*Question 6: Retrieve the order ID, product name, and quantity from the "order_items" table along 
with the corresponding product information from the "products" table*/
SELECT * FROM order_items;
SELECT * FROM products;

SELECT o.order_id, p.product_name, o.quantity 
FROM order_items o
LEFT JOIN products p 
ON o.product_id = p.product_id ;

/*Question 7: Retrieve all products from the "products" table along with their corresponding 
category names from the "categories" table. Include all products, but limit the results to 
products in the 'Mountain Bikes' category*/
SELECT * FROM products;
SELECT * FROM categories;

SELECT p.product_name, c.category_name, p.list_price 
FROM products p 
INNER JOIN categories c 
ON p.category_id = c.category_id 
WHERE p.category_id = 6;

/*Question 8: Retrieve the product name, list price, and category name from the "products" table 
along with the corresponding brand name from the "brands" table. Only include products 
where the list price is greater than $500 and the category name is 'Electric Bikes'.*/

SELECT P.product_name,c.category_name, b.brand_name ,p.list_price
FROM products p 
LEFT JOIN categories c ON p.category_id = c.category_id 
LEFT JOIN brands b ON p.brand_id = b.brand_id
WHERE c.category_id = 5 
AND p.list_price > 500;

/*Retrieve all customers from the "customers" table along with their corresponding 
orders from the "orders" table. Include all customers, but only include orders where the 
shipped date is null*/
SELECT * FROM customers;
SELECT * FROM orders; 

SELECT c.first_name || ' ' || c.last_name AS "customer_name", o.order_id, o.shipped_date 
FROM customers c 
LEFT JOIN orders o 
ON c.customer_id = o.customer_id
WHERE o.shipped_date IS NULL;

/*Question 10:  Retrieve the store name from the "stores" table along with the count of orders placed 
from each store. Include all stores, even if they haven't received any orders.
=> lk hai bang table stores vaf order lay ca nhung ca nhung cua hang chua nhan dc don hang nao*/
SELECT * FROM stores;
SELECT * FROM orders;

SELECT s.store_name ,COUNT(o.order_id) AS "order_count"
FROM stores s 
LEFT JOIN orders o 
ON s.store_id = o.store_id 
GROUP BY s.store_name;

/**/

