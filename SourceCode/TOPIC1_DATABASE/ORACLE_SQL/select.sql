-- =============================================================================================================
/*## LAB01: Sales SCHEMA, INSERT VALUES FOR SALES SCHEMA, T/H 6 QUERY CHO SCHEMA SALES##*/
-- =============================================================================================================

-- insert nhieuf values vào table customers 
INSERT INTO Customers(customer_name, contact_name, address, city, postal_code, country)
    SELECT 'Tran Huu', 'Phuc', 'Phong dien', 'Can Tho', 90, 'VietNam' FROM DUAL UNION ALL
    SELECT 'Trieu Nhu', 'Ngoc', 'Cai Rang', 'Can Tho', 90, 'VietNam' FROM DUAL UNION ALL
    SELECT 'Tran Huu', 'Long', 'Buu Son', 'Hue', 40, 'VietNam' FROM DUAL UNION ALL
    SELECT 'Ton A', 'Bang', 'Phat Son', 'Da Nang', 55, 'VietNam' FROM DUAL UNION ALL
    SELECT 'Ha Khanh', 'Nhu', 'Cai Khe', 'Tra Vinh', 70, 'VietNam' FROM DUAL UNION ALL
    SELECT 'Huynh Le Ngoc', 'Phuong', 'Ninh Kieu', 'Can Tho', 90, 'VietNam' FROM DUAL;
-- LỆNH COMMIT  ĐÓI VỚI DML TRONG ORACLE CẦN LỆNH COMMIT THÌ VALUE MỚI ĐC LƯU VĨNH VIỄN
COMMIT;

-- insert table order
INSERT INTO Employees(last_name, first_name, birthdate, supervisor_id)
    SELECT 
        'Tran' AS c1, 
        'Phuc' AS c2, 
        TO_DATE('1990-08-12', 'YYYY-MM-DD') AS c3, 
        1 AS c4 
    FROM DUAL UNION ALL
    SELECT 'Le', 'Chi', TO_DATE('1995-12-05', 'YYYY-MM-DD'), 1 FROM DUAL UNION ALL
    SELECT 'Pham', 'Danh', TO_DATE('1988-03-25', 'YYYY-MM-DD'), 1 FROM DUAL UNION ALL
    SELECT 'Hoang', 'Em', TO_DATE('1993-07-19', 'YYYY-MM-DD'), 2 FROM DUAL;
COMMIT;

-- insert table orders 
INSERT INTO Orders(cust_id, empl_id, order_date)
    SELECT 
        13 AS c1, 
        2 AS c2, 
        TO_DATE('2026-01-10', 'YYYY-MM-DD') AS c3 
    FROM DUAL UNION ALL
    SELECT 14, 3, TO_DATE('2026-01-15', 'YYYY-MM-DD') FROM DUAL UNION ALL
    SELECT 15, 2, TO_DATE('2026-01-20', 'YYYY-MM-DD') FROM DUAL UNION ALL
    SELECT 7, 1, TO_DATE('2026-02-01', 'YYYY-MM-DD') FROM DUAL UNION ALL
    SELECT 8, 4, TO_DATE('2026-02-05', 'YYYY-MM-DD') FROM DUAL UNION ALL
    SELECT 9, 2, TO_DATE('2026-02-10', 'YYYY-MM-DD') FROM DUAL UNION ALL
    SELECT 9, 2, TO_DATE('2026-02-12', 'YYYY-MM-DD') FROM DUAL;
COMMIT;

-- #### LỆNH XÓA DELETE ####

        -- DELETE FROM CUSTOMERS WHERE customer_id in (1, 2, 3, 4, 5, 6);
        
-- XOA HET LAN CO THE DUNG: 
            
        -- TRUNCATE TABLE ten_bang; NHO COMMIT


-- #### LỆNH UPDATE ####
UPDATE customers SET country = 'China' WHERE customer_id = 21;


-- ## truy vấn với groupby, having, và các hàm ràng buộc như count... ### 
SELECT * FROM orders;
SELECT * FROM employees;
SELECT * FROM customers;


-- *>>>>>>>>>>>>>>>>>>>>6  QUESTION CHO SALES SCHEMA<<<<<<<<<<<<<<<<<<<<<<<<:#*/
-- Question 1: To return all columns and rows
SELECT * FROM Customers;

-- Question 2: Select all the different countries from the "Customers" tabl
SELECT DISTINCT Customer_name from Customers;

-- Question 3: Select all customers have conditional where ountry =  ''VN 
SELECT * FROM customers WHERE country = 'VietNam';

-- Question 4: Lists the number of customers in each countr -> group by
SELECT country, COUNT(customer_id) AS "NumberOfCustomers"
FROM customers 
GROUP BY country;

/* Question 5: Lists the number of customers in each country. Only include
countries with more than 1 customer 
==> su dung dieu king HAVING KET HOP GROUPBY*/
SELECT country, COUNT(customer_id) AS "NumberOfCustomers"
FROM customers 
GROUP BY country 
HAVING COUNT(customer_id) >= 2;

-- Question 6: Sort(Order vy - sap xep tang dang) the customers alphabetical by CustomerName
SELECT customer_id, customer_name, country 
FROM customers 
ORDER BY customer_name;



-- =============================================================================================================
/*## LAB02: BIKESTORES SCHEMA, T/H 14 QUERY  QUESTION CHO SCHEMA BIKESTORES##*/
-- =============================================================================================================
-- Question 1: Retrieve the first name, last name, and email of all customer
SELECT first_name, last_name, email 
FROM customers;

-- Question2: Returns the customers located in California (state is CA
SELECT * FROM customers WHERE state = 'CA';

-- Question3: Sorts the customers by their first names in ascending order
SELECT * FROM customers
ORDER BY first_name;

/* Question4: Returns all the cities of customers located in California and the number of customers
in each city*/
SELECT city, COUNT(customer_id) AS "NumberOfCustomers"
FROM customers 
GROUP BY city;

-- Question 5: Return the city in California which has more than ten customer
SELECT city, COUNT(customer_id) AS "NumberOfCustomers" 
FROM customers 
GROUP BY city 
HAVING COUNT(customer_id) >= 10;

/* Question 6: Retrieve the product name and model year from the "products" table where the list 
price is from 1000 to 200*/
SELECT product_name, model_year 
FROM products 
WHERE list_price BETWEEN 1000 AND 2000;

-- Question 7: Retrieve the first name and email from the "staffs" table where the active status is 1
SELECT first_name, email 
FROM stafts 
WHERE active = 1;

/* Question 8: 8) Retrieve the product name and brand ID from the "products" table where the model 
year is 2016 and the list price is greater than 1000*/
SELECT product_name, brand_id, list_price 
FROM products 
WHERE model_year = 2016 AND list_price >= 1000;

/*Question 9-  Retrieve the order ID and customer ID from the "orders" table where the shipped date
is not null*/
SELECT order_id, customer_id 
FROM orders 
WHERE shipped_date IS NOT NULL;

/*Question 10/ Retrieve the product ID, list price and quantity from the "order_items" table where 
the discount is greater than 0 and quantity equal 2 */
SELECT product_id, list_price, quantity 
FROM order_items
WHERE discount >= 0 AND quantity  = 2;


/*Question 11/ Find Stores with more than 5 Products in Stock(kho) table and ordered by the number of
products*/
SELECT store_id, COUNT(quantity) AS product_count
FROM stocks 
WHERE quantity > 5
GROUP BY store_id;

/*Question 12) This query retrieves customers whose email address ends with "@yahoo.com" and 
orders the result by customer name*/
SELECT first_name || ' ' || last_name AS customer_name, email 
FROM customers 
WHERE email LIKE '%@yahoo.com' 
ORDER BY customer_name;

-- or co the dung voi REGEXP_LIKE TRONG ORACLE
SELECT first_name || ' ' || last_name AS customer_name, email 
FROM customers 
WHERE REGEXP_LIKE(email, '@yahoo\.com$')
ORDER BY customer_name;

/*Question 13) This query calculates the average list price of products for each category and 
includes only categories with an average price greater than 500, ordered by the average 
price in descending order.*/
SELECT category_id, ROUND(AVG(list_price), 2) AS avg_price
FROM products 
GROUP BY category_id
HAVING AVG(list_price) > 500
ORDER BY avg_price DESC;

/*14) This query counts the total number of products for each brand and includes only 
brands that have more than 2 products, ordering the result by the total number of 
products in descending order*/
SELECT brand_id, COUNT(product_id) As total_products
FROM products 
GROUP BY brand_id 
HAVING COUNT(product_id) > 2
ORDER BY total_products DESC;
