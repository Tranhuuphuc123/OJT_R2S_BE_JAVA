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
 
