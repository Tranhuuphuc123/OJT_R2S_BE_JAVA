 /* >>>>>>>>>>>>>>>>>>>>>>>>>>>>>PHẦN BÀI TẬP FINAL REVIEW: VỀ STORE PROCEDURE VÀ TRIGGER<<<<<<<<<<<<<<<<<<<<<<<<*/
 -- BÀI NÀY SỬ DỤNG SHCEMA PLSQL_OJT_R2S CỦA TABLESPACE TS_QUANLY 
 
 -- ===============================================================================================
  /*LAB 01: CREATE DATABASE SMS SU DUNG SCHEMA USER PLSQL_OJT_R2S */
 -- ===============================================================================================
 -- create table customer
CREATE TABLE CUSTOMER(
    customer_id NUMBER GENERATED ALWAYS AS IDENTITY,
    customer_name VARCHAR2(255) NOT NULL, 
    
    -- KHOA CHINH 
    CONSTRAINT PK_CUSTOMER PRIMARY KEY(customer_id)
);

-- create table employee
CREATE TABLE EMPLOYEE(
    employee_id NUMBER GENERATED ALWAYS AS IDENTITY,
    employee_name VARCHAR2(255) NOT NULL,
    salary NUMBER(10,2) NOT NULL, 
    supervisor_id NUMBER, 
    
    -- khoa chinh
    CONSTRAINT PK_EMPL PRIMARY KEY(employee_id),
    -- supervisor_id la khoa ngoai tu than self foreign key
    CONSTRAINT FK_SELF_EMPL FOREIGN KEY(supervisor_id) REFERENCES employee(employee_id)
);

-- create table product 
CREATE TABLE product(
    product_id NUMBER GENERATED ALWAYS AS IDENTITY,
    product_name VARCHAR2(255) NOT NULL,
    list_price NUMBER(10,2) NOT NULL, 
    
    -- KHOA CHINH
    CONSTRAINT PK_PRO PRIMARY KEY(product_id)
);

-- create table ORDERS 
CREATE TABLE orders(
    order_id NUMBER GENERATED ALWAYS AS IDENTITY,
    order_date DATE NOT NULL, 
    customer_id NUMBER, 
    employee_id NUMBER,
    total NUMBER(10,2),
    
    -- khoa chinh
    CONSTRAINT PK_ORDERS PRIMARY KEY(order_id),
    -- khoa ngoai
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    CONSTRAINT FK_ORDER_EMPLOYEE FOREIGN KEY(employee_id) REFERENCES employee(employee_id)
);


-- create table lineitem
CREATE TABLE LineItem(
    order_id NUMBER,
    product_id NUMBER, 
    quantity NUMBER NOT NULL,
    price NUMBER(10,2),
    
    -- khoa chinh 
    CONSTRAINT PK_LINEITEM PRIMARY KEY(order_id, product_id),
    -- khoa ngoai
    CONSTRAINT FK_LINEITEM_ORDER FOREIGN KEY(order_id) REFERENCES orders(order_id),
    CONSTRAINT FK_LINEITEM_PRO FOREIGN KEY(product_id) REFERENCES product(product_id)
);

 -- ===============================================================================================
  /*LAB 02: INSERT VALUES DATABASE SMS SU DUNG SCHEMA USER PLSQL_OJT_R2S */
 -- ===============================================================================================
 
 -- 1. INSERT TABLE CUSTOMER
INSERT INTO CUSTOMER (customer_name)
    SELECT 'Nguyen Van A' FROM DUAL UNION ALL
    SELECT 'Tran Thi B' FROM DUAL UNION ALL
    SELECT 'Le Van C' FROM DUAL UNION ALL
    SELECT 'Pham Minh D' FROM DUAL;

-- 2. INSERT TABLE EMPLOYEE
-- Chèn Sếp/Giám sát viên trước (supervisor_id là NULL)
INSERT INTO EMPLOYEE (employee_name, salary, supervisor_id)
    SELECT 'Truong Phong A', 25000000, NULL FROM DUAL UNION ALL
    SELECT 'Truong Phong B', 22000000, NULL FROM DUAL;

-- Chèn Nhân viên cấp dưới (supervisor_id tham chiếu tới ID của sếp: 1 và 2)
INSERT INTO EMPLOYEE (employee_name, salary, supervisor_id)
    SELECT 'Nhan Vien X', 12000000, 1 FROM DUAL UNION ALL
    SELECT 'Nhan Vien Y', 10000000, 1 FROM DUAL UNION ALL
    SELECT 'Nhan Vien Z', 11000000, 2 FROM DUAL;

-- 3. INSERT TABLE PRODUCT
INSERT INTO PRODUCT (product_name, list_price)
    SELECT 'Laptop Dell XPS', 35000000 FROM DUAL UNION ALL
    SELECT 'Chuot Logi MX Master 3S', 2500000 FROM DUAL UNION ALL
    SELECT 'Man hinh Dell UltraSharp', 9500000 FROM DUAL UNION ALL
    SELECT 'Ban phim Co Keychron', 1800000 FROM DUAL;

-- 4. INSERT TABLE ORDERS (Tương ứng customer_id từ 1-4, employee_id từ 1-5)
INSERT INTO ORDERS (order_date, customer_id, employee_id, total)
    SELECT DATE '2026-03-01', 1, 3, 37500000 FROM DUAL UNION ALL
    SELECT DATE '2026-03-02', 2, 4, 1800000 FROM DUAL UNION ALL
    SELECT DATE '2026-03-03', 3, 3, 12000000 FROM DUAL UNION ALL
    SELECT DATE '2026-03-04', 4, 5, 2500000 FROM DUAL;

-- 5. INSERT TABLE LINEITEM (Khóa chính kết hợp: order_id + product_id)
INSERT INTO LINEITEM (order_id, product_id, quantity, price)
    SELECT 1, 1, 1, 35000000 FROM DUAL UNION ALL
    SELECT 1, 2, 1, 2500000 FROM DUAL UNION ALL
    SELECT 2, 4, 1, 1800000 FROM DUAL UNION ALL
    SELECT 3, 2, 1, 2500000 FROM DUAL UNION ALL
    SELECT 3, 3, 1, 9500000 FROM DUAL UNION ALL
    SELECT 4, 2, 1, 2500000 FROM DUAL;

-- LƯU DỮ LIỆU
COMMIT;


 -- ===============================================================================================
  /*LAB 03: PHAN BAI TAP */
 -- ===============================================================================================
 
-- ---------------------------------------------------------------------------------------------

 /*Ex1: List all customers consist of customer id, customer name in the database, returns a 
list with all customers in the order table.
(Lấy ra danh sách gồm customer_id và customer_name của những khách hàng đã từng có đơn hàng
trong bảng ORDERS)
 => huong lam: dung store procedure in xuat danhsach ra man hinh 
 ==> su dung cach TRẢ VỀ TẬP KẾT QUẢ (RESULT SET / CURSOR) trong k/t trongj 
 tam cua store procedure cua oracle trong pl/sql*/
 
/*##VIET CHUONG TRINH PROCEDURE****/
CREATE OR REPLACE PROCEDURE sp_get_customers_with_orders (
    p_result_cursor OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_result_cursor FOR
        SELECT DISTINCT 
            c.customer_id,
            c.customer_name
        FROM customer c
        JOIN orders o ON c.customer_id = o.customer_id
        ORDER BY c.customer_id;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
        RAISE;
END sp_get_customers_with_orders;
/


-- ---------------------------------------------------------------------------------------------
/*Ex2: List all orders consist of order id, order date, customer id, employee id, total for a 
customer, returns a list with all the orders for a given customer id. 
 => dung procedure voi     p_result_cursor OUT SYS_REFCURSOR
tra ve danh sanh theo yeu cau tu table customer va order 
*/

CREATE OR REPLACE PROCEDURE sp_get_orders_by_customers(
    p_customer_id IN customer.customer_id%TYPE,
    p_result_cursor OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_result_cursor FOR
        SELECT 
            o.order_id,
            o.order_date,
            o.customer_id,
            o.employee_id,
            o.total
        FROM orders o
        WHERE o.customer_id = p_customer_id
        ORDER BY o.order_date DESC;
EXCEPTION
    WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('Looi khi lay danh sach don hang: ' || SQLERRM);
         RAISE;
END sp_get_orders_by_customers;
/


-- ---------------------------------------------------------------------------------------------
/*Ex3: List all line items for an order, returns a list with all line items for a given order id.
 => liet ke toan bo cac chi tieet san pham thuoc ve mot don hang 
  + input: order_id truyen mot don hang cu the
  + ouput: mot danh sach chua toan bo cac dong chi tiet don hang do
  -> table hien dien: LineItem, order, product
*/
CREATE OR REPLACE PROCEDURE sp_get_lineitem_by_order(
    p_order_id IN lineitem.order_id%TYPE,
    p_result_cursor OUT SYS_REFCURSOR
)
IS 
BEGIN
    OPEN p_result_cursor FOR
        SELECT 
            l.order_id,
            l.product_id,
            l.quantity,
            l.price,
            (l.quantity * l.price) AS total_price
        FROM lineitem l 
        WHERE l.order_id = p_order_id ;
EXCEPTION
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('Loi khi lay chi tiet don hang ' || SQLERRM);
        RAISE;
END sp_get_lineitem_by_order;
/

/*Ex4:) Compute order total (quantity * price) from the line items for a given order id. You 
must use an User Define Function. 
 -> muc tieu: tinh tong tin cua toan bo don hang bang cach cong 
 tat ca cac dong(quantity * price) trong bang lineitem 
 cho mot don hang cu the 
 + yeu cau: dung function khong dung procedure 
 + input: order_id cua don hang 
 + output: tong tien down hang cua don hang do 
*/
CREATE OR REPLACE FUNCTION f_get_order_total(
    p_order_id IN lineitem.order_id%TYPE
)
RETURN NUMBER
IS 
    v_total NUMBER := 0;
BEGIN 
    -- TINH TONG TIEN: QUANTITY * PRICE TU BANG LINEITEM
    SELECT NVL(SUM(quantity * price), 0)
    INTO v_total
    FROM lineitem 
    WHERE order_id = p_order_id;
    
    RETURN v_total;
EXCEPTION
    WHEN OTHERS THEN 
        RETURN 0;
END f_get_order_total;
/


/*`Ex5:Add a customer into the database, you must use a Stored Procedure.
=> muc tieu: them moi mot khach hang vao csdl
+ yeu cau: procedure khong dung function 
+ input: thong tin tao mot khach: customer_id, customer_name ....sp_get_customers_with_orders
+ output: them moi  thanh cong khach hang moi vao csdl 
*/
CREATE OR REPLACE PROCEDURE sp_add_customer(
    p_customer_name IN customer.customer_name%TYPE
)
IS 
BEGIN
    -- THAO TAC THEM MOI CUSTOMER VAO TABLE CUSTOMER 
    INSERT INTO customer(customer_name)
    VALUES(p_customer_name);
    
    -- xac nhan luu du lieu vao database
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Them moi khach hang thanh cong! name ' || p_customer_name);

EXCEPTION
    WHEN OTHERS THEN
        -- hoan tac neu gap bat ky loi nao khac
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Loi he thong khi them khach hang ' || SQLERRM);
        RAISE;
END sp_add_customer;
/

-- *******************************************************************************
-- *******************************************************************************
/**DEV TEST PROCEDURE VUA VIET**/
VARIABLE x REFCURSOR;
-- EXEC sp_get_customers_with_orders(:x);
-- EXEC sp_get_orders_by_customers(1, :x);
EXEC sp_get_lineitem_by_order(1, :x);
PRINT x;

/**DEV TEST CHO FUNCTION**/
SELECT f_get_order_total(1) AS total_amount FROM dual;

/**DEV TEST PROCEDURE THEM MOI**/
SET SERVEROUTPUT ON;
EXEC sp_add_customer('Trieu le Ngoc')
SELECT * FROM customer ORDER BY customer_id DESC;
