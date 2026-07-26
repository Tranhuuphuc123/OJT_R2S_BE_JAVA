-- ############################# TOPIC - DATABASE - OJT R2S ACADEMY ###################################

-- =================================================================================================
/* ## I - NHÓM LỆNH TẠO DATABASE (SCHEMA ~ USER)(TƯƠNG ỨNG DATABASE TRONG MYSQL, SQLSERVER)##*/
-- =================================================================================================
    /* -- lƯU ý: trong mysql, sqlserver.. thì khái niệm này là create, use database, hệ sinh thái 
    Oracle thì không dùng khái niêm database kiểu dậy mà nó dùng hệ sinh thái schema ~ user 
    thường user mặc định khi tọa schema(create new connection á) là system 
     <=> tuy nhiên system lại chứa table, view, procedure mẫu làm lẫn lộn với table bạn tạo 
     ==> nên để khắc phục điều đó ta cần khai báo cấu hình user mới thay vì dùng user mặc 
     định là system của Oracle khi tạo connection mới 
     ==> sau đây là các lệnh thực hiện công việc đó*/
    -- Lệnh này cực kỳ quan trọng cho bản Oracle 12c, 19c, 21c... 
    -- Nó cho phép bạn tạo user tên đơn giản (không cần có chữ C## phía trước)
    
    -- 1/ Tạo Tablespace (vùng không gian lưu trữ) - LƯU Ý TÊN TABLESPACE VÀ FILE.DBF DO MÌNH ĐẶT
    
            CREATE TABLESPACE TS_QUANLY
            DATAFILE 'E:\PRATICE_CODE\ERP_ENGINEERS\SourceCode\DBF\quanly_data1.dbf'
            SIZE 50M
            AUTOEXTEND ON NEXT 10M;
    
    --2/ Cho phép tạo user kiểu đơn giản (local user)
        
        ALTER SESSION SET "_ORACLE_SCRIPT" = true;
    
    -- 3/  Tạo User (Khai sinh Schema ~ USER mới)
    -- Mật khẩu có ký tự đặc biệt như @, #, $ PHẢI để trong dấu ""
    /* >> trong đó: 
         + IDENTIFIED là thiết lặp mật khẩu mới cho user vừa mới tạo
         + DEFAULT TABLESPACE <TÊN TABLESPACE> Chỉ định vùng lưu trữ dữ liệu mặc 
		 định cho User. Nếu không có chỉ định nó sẽ ném values thật vào tablespace 
   		 mặc định là system..
		 + QUOTA UNLIMITED ON TS_QUANLY: Cấp quyền sử dụng dung lượng không giới 
		 hạn trên vùng lưu trữ đó. Quota chính là mức dung lượng, Unlimited là không 
         giới hạn*/
   
    -- #### 3.1/ Tạo User (Khai sinh Schema ~ USER mới cho connectin tên Sales)####
        --> Cho phép tạo user kiểu đơn giản (local user)
        
            ALTER SESSION SET "_ORACLE_SCRIPT" = true;
        
            CREATE USER SALES_OJT_R2S 
            IDENTIFIED BY "Huuphuc1995ct@"
            DEFAULT TABLESPACE TS_QUANLY
            QUOTA UNLIMITED ON TS_QUANLY;
        
        -- > Cấp các quyền cơ bản để user này có thể làm việc    
         -- CONNECT: Quyền đi vào cửa.
            -- RESOURCE: Quyền xây bảng, thêm dữ liệu.
            -- UNLIMITED TABLESPACE: Quyền dùng đất (không gian lưu trữ).
        
             GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO SALES_OJT_R2S;
    
    
    
    
    -- ##### 3.2 Tạo User (Khai sinh Schema ~ USER mới cho connectin tên BikeStores)####
        
            --> Cho phép tạo user kiểu đơn giản (local user)
            
                ALTER SESSION SET "_ORACLE_SCRIPT" = true;
            
                CREATE USER BIKESTORE_OJT_R2S 
                IDENTIFIED BY "Huuphuc1995ct@"
                DEFAULT TABLESPACE TS_QUANLY
                QUOTA UNLIMITED ON TS_QUANLY;
            
            -- > Cấp các quyền cơ bản để user này có thể làm việc  
            
                GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO BIKESTORE_OJT_R2S;
                
                
  -- ##### 3.3 Tạo User (Khai sinh Schema ~ USER mới cho connectin tên PLSQL_OJT_R2S)####
        
            --> Cho phép tạo user kiểu đơn giản (local user)
            
                ALTER SESSION SET "_ORACLE_SCRIPT" = true;
            
                CREATE USER PLSQL_OJT_R2S 
                IDENTIFIED BY "Huuphuc1995ct@"
                DEFAULT TABLESPACE TS_QUANLY
                QUOTA UNLIMITED ON TS_QUANLY;
            
            -- > Cấp các quyền cơ bản để user này có thể làm việc  
            
                GRANT CONNECT, RESOURCE, UNLIMITED TABLESPACE TO PLSQL_OJT_R2S;                
    
    
    /*==> sau khi tạo user mới thì tiếp tục tạo new connection(dấu + hay r-click vào oracle connection)
     để tiến hành "THIẾT LẬP KẾT NỐI TRÊN ORACLE SQL DEVELOPER (GUI) VỚI USER MỚI TẠO"
       - Mở Oracle SQL Developer.
       - Tại cửa sổ "Connections", chuột phải chọn "New Connection" (hoặc bấm dấu +).
       - Điền thông tin:
        + Name: Ten_Ket_Noi (Tùy chọn, ví dụ: Connection_Phuc)
        + Username: User_Phuc (Tên user vừa tạo ở trên)
        + Password: 123456
        + Hostname: localhost (hoặc IP server)
        + Port: 1521 (Mặc định)
        + SID hoặc Service Name: Thường là 'xe' (bản Express) hoặc 'orcl'.
       - Bấm "Test" để kiểm tra, nếu báo "Success" thì chọn "Connect".
    */
    
    /* ##NOTE##
     => lưu ý là với Oracle không có use database mà muốn đổi database(là một connection vừa tạo bằng cách bấm dấu 
     + hay r-click new connection của oracle connection á) thì mình nhìn gốc trên cùng bên phải mà select chọn 
     database cho đúng là xong
    */
    
    
-- =================================================================================================
/* ## II - TẠO DATABASE SALES (SỬ DỤNG SCHEMA = USER SALES_OJT_R2S))##*/
-- =================================================================================================    
/*## LAB01 DDL CREATE TABLE##*/
-- create table 
create table Employees(
 employee_id NUMBER GENERATED ALWAYS AS IDENTITY,
 last_name VARCHAR2(20) NOT NULL,
 first_name VARCHAR2(10)NOT NULL,
 birthdate DATE,
 supervisor_id NUMBER NOT NULL,
  -- khoa chinh 
  CONSTRAINT PK_EMPL PRIMARY KEY(employee_id)
);

-- Create table customers
create table Customers(
 customer_id NUMBER GENERATED ALWAYS AS IDENTITY,
 customer_name VARCHAR2(255),
 contact_name VARCHAR2(255),
 address VARCHAR2(255),
 city VARCHAR2(100),
 postal_code VARCHAR2(10),
 country VARCHAR2(50),
 -- KHOA CHINH
 CONSTRAINT PK_CUS PRIMARY KEY(customer_id)
);

-- thêm ĐK ràng buộc UNIQUE TRÁNH TRÙNG KHI INSERT VALUES
ALTER TABLE Customers ADD CONSTRAINT UN_CUST UNIQUE(customer_name, contact_name, address);

-- create table order 
create table Orders(
 order_id NUMBER GENERATED ALWAYS AS IDENTITY,
 cust_id NUMBER,
 empl_id NUMBER,
 order_date DATE, 
 
 -- khoa chinh 
 CONSTRAINT PK_ORDER PRIMARY KEY(order_id)
);

-- tạo khoa ngoại liên kết 
ALTER TABLE Orders ADD CONSTRAINT FK_Order_Empl FOREIGN KEY(empl_id) REFERENCES Employees(employee_id);
ALTER TABLE Orders ADD CONSTRAINT FK_Order_Cust FOREIGN KEY(cust_id) REFERENCES Customers(customer_id);





-- =================================================================================================
/* ## III - TẠO DATABASE BIKESTORES (SỬ DỤNG SCHEMA = USER BIKESTORE_OJT_R2S)##*/
-- =================================================================================================  
 
 /****LAB02: DDL CREATE TABLE****/
-- table customers
CREATE TABLE customers(
 customer_id NUMBER GENERATED ALWAYS AS IDENTITY,
 first_name VARCHAR2(255) NOT NULL,
 last_name VARCHAR2(255) NOT NULL,
 phone VARCHAR2(25),
 email VARCHAR2(255) NOT NULL,
 street VARCHAR2(255),
 city VARCHAR2(50),
 state VARCHAR2(25),
 zip_code VARCHAR2(5),
 
 -- KHOA CHINH
 CONSTRAINT PK_CUST PRIMARY KEY(customer_id)
);


-- table stores
CREATE TABLE stores(
  store_id NUMBER GENERATED ALWAYS AS IDENTITY,
  store_name VARCHAR2(255) NOT NULL,
  phone VARCHAR2(25),
  email VARCHAR2(255),
  street VARCHAR(255),
  city VARCHAR2(50),
  state VARCHAR2(10),
  zip_code VARCHAR2(10),
  
  -- KHOA CHINH
  CONSTRAINT PK_STORES PRIMARY KEY(store_id)
);

-- able brands 
CREATE TABLE brands(
  brand_id NUMBER GENERATED ALWAYS AS IDENTITY,
  brand_name VARCHAR2(255) NOT NULL,
  
  -- KHOA CHINH
  CONSTRAINT PK_BRANDS PRIMARY KEY(brand_id)
);

-- table categories 
CREATE TABLE categories(
  category_id NUMBER GENERATED ALWAYS AS IDENTITY,
  category_name VARCHAR2(255) NOT NULL,
  
  -- KHOA CHINH
  CONSTRAINT PK_CATEGORY PRIMARY KEY(category_id)
);

-- table product cos khoa ngoai 
CREATE TABLE products(
  product_id NUMBER GENERATED ALWAYS AS IDENTITY,
  product_name VARCHAR2(255) NOT NULL,
  brand_id NUMBER,
  category_id NUMBER,
  model_year NUMBER(5,0) NOT NULL,
   --NUMBER(10,2) la lay so thap phan vaf sau dau phay lay hai chu so thui
  list_price NUMBER(10,2) NOT NULL,
  
  -- khoa chinh
  CONSTRAINT PK_PRO PRIMARY KEY(product_id),
  
  -- khoa ngoai
  CONSTRAINT FK_PRO_BRAND FOREIGN KEY(brand_id) REFERENCES brands(brand_id),
  CONSTRAINT FK_PRO_CATE FOREIGN KEY(category_id) REFERENCES categories(category_id) 
);
-- FIX KIEU MODEL_YEAR TU NUMBER THANH DATE 
ALTER TABLE products MODIFY model_year DATE;


-- table stafts 
CREATE TABLE stafts(
 staft_id NUMBER GENERATED ALWAYS AS IDENTITY,
 first_name VARCHAR2(50) NOT NULL,
 last_name VARCHAR2(50) NOT NULL,
 email varchar2(255) NOT NULL,
 phone VARCHAR2(25),
 active NUMBER NOT NULL,
 store_id NUMBER, 
 manager_id NUMBER, -- khoan ngoai tu tham chieu
 
 -- KHOA CHINH
 CONSTRAINT PK_STAFT PRIMARY KEY(staft_id),
 
 -- KHOA NGOAI
 CONSTRAINT FK_STAFT_STORE FOREIGN KEY(store_id) REFERENCES stores(store_id),
 
 -- KHOA NGOAI TU THAM CHIEU(SEFT REFERENCING)
 /*
        ON DELETE SET NULL 
        
-> Là quy tắc hành động của khoa ngoại khi một dòng ở bảng
cha bị xóa, hệ thống sẽ tự động cập nhât giá trị ở cột khóa 
ngoại của các dòng con liên quan thành NULL thay vì xóa luôn
dòng con đó hoặc báo lỗi ngăn chặn*/
 CONSTRAINT FK_SEFT_STAFT FOREIGN KEY(manager_id) REFERENCES stafts(staft_id)
 ON DELETE SET NULL
);

-- TABLE ORDER
CREATE TABLE orders(
  order_id NUMBER GENERATED ALWAYS AS IDENTITY, 
  customer_id NUMBER,
  order_status NUMBER NOT NULL,
  order_date DATE NOT NULL,
  required_date DATE NOT NULL,
  shipped_date DATE,
  store_id NUMBER,
  staft_id NUMBER, 
  
  -- KHOA CHINH
  CONSTRAINT PK_ORDERS PRIMARY KEY(order_id),
  
  -- KHOA NGOAI
  CONSTRAINT FK_ORDER_STORE FOREIGN KEY(store_id) REFERENCES stores(store_id),
  CONSTRAINT FK_ORDER_STAFT FOREIGN KEY(staft_id) REFERENCES stafts(staft_id),
  
  -- KHOA NGOAI TU THAN SEFT REFERENCING)
  CONSTRAINT FK_SEFT_ORDER FOREIGN KEY(customer_id) REFERENCES orders(order_id)
);


-- TABLE ORDER_ITEMS CO KHOA NGOAI 
CREATE TABLE order_items(
  item_id NUMBER,
  order_id NUMBER,
  product_id NUMBER,
  quantity NUMBER NOT NULL,
  list_price NUMBER(10,2) NOT NULL,
  discount NUMBER(4,2) NOT NULL, 
  
  -- KHOA CHINH
  CONSTRAINT PK_ORDERITEM PRIMARY KEY(item_id, order_id),
  
  -- KHOA NGOAI 
  CONSTRAINT FK_ORDERITEM_ORDER FOREIGN KEY(order_id) REFERENCES orders(order_id),
  CONSTRAINT FK_ORDERITEM_PRO FOREIGN KEY(product_id) REFERENCES products(product_id)
);

-- TABLE STOCKS 
CREATE TABLE stocks(
  store_id NUMBER,
  product_id NUMBER,
  quantity NUMBER,
  
  -- KHOA CHINH 
  CONSTRAINT PK_STOCK PRIMARY KEY(store_id,product_id),
  
  -- KHOA NGOAI 
  CONSTRAINT FK_STOCK_STORE FOREIGN KEY(store_id) REFERENCES stores(store_id),
  CONSTRAINT FK_STOCK_PRO FOREIGN KEY(product_id) REFERENCES products(product_id)
);




-- =============================================================================================
/*########LAB02: DML INSERT VALUE VAO CAC TABLE##############*/
-- INSERT TABLE BRANDS 
INSERT INTO brands (brand_name)
    SELECT 'Electra' FROM DUAL UNION ALL
    SELECT 'Haro' FROM DUAL UNION ALL
    SELECT 'Heller' FROM DUAL UNION ALL
    SELECT 'Pure Cycles' FROM DUAL UNION ALL
    SELECT 'Ritchey' FROM DUAL UNION ALL
    SELECT 'Strider' FROM DUAL UNION ALL
    SELECT 'Surly' FROM DUAL UNION ALL
    SELECT 'Trek' FROM DUAL;

COMMIT;


-- INSERT TABLE CATEGORIES 
INSERT INTO categories(category_name)
    SELECT 'Children Bicycles' FROM DUAL UNION ALL
    SELECT 'Comfort Bicycles' FROM DUAL UNION ALL
    SELECT 'Cruisers Bicycles' FROM DUAL UNION ALL
    SELECT 'Cyclocross Bicycles' FROM DUAL UNION ALL
    SELECT 'Electric Bikes' FROM DUAL UNION ALL
    SELECT ' Mountain Bikes' FROM DUAL UNION ALL
    SELECT 'Road Bikes' FROM DUAL
COMMIT;    


-- INSERT table PRODUCT
INSERT INTO products(product_name, brand_id, category_id, model_year, list_price)
    SELECT 'Trek 820-2016', 9, 6, 2016, 379.99 FROM DUAL UNION ALL
    SELECT 'Ritchey Timberwoff Frameset-2016', 5, 6, 2016, 379.99 FROM DUAL UNION ALL
    SELECT 'Surly Wednesday Frameset-2016', 8, 6, 2016, 749.99 FROM DUAL UNION ALL
    SELECT 'Trek Fuel Ex8 29-2016', 9, 6, 2016, 999.99 FROM DUAL UNION ALL
    SELECT 'Heller Shagamaw Frame-2016', 8, 6, 2016, 2899.99 FROM DUAL UNION ALL
    SELECT 'Surly Ice Cream Truck Frameset-2016', 9, 6, 2016, 1320.99 FROM DUAL UNION ALL
    SELECT 'Trek Slash 8 27.5-2016', 9, 6, 2016, 469.99 FROM DUAL UNION ALL
    SELECT 'Trek Remedy 29 Carbon Frameset-2016', 9, 6, 2016, 3999.99 FROM DUAL UNION ALL
    SELECT 'Trek Conduit+-2016', 9, 6, 2016, 1799.99 FROM DUAL UNION ALL
    SELECT 'Surly Straggler-2016', 8, 4, 2016, 1549.00 FROM DUAL
COMMIT;   



-- INSERT table CUSTOMERS
INSERT INTO customers(first_name, last_name, phone, email, street, city, state, zip_code)
    SELECT 'Debra', 'Burks', '', 'debra.burks@yahoo.com', '9273 Thome Ave', 'Orchard Park', 'NY', 14127 FROM DUAL UNION ALL
    SELECT 'Kasha', 'Todd', '', 'kasha.todd@yahoo.com', '910 Vine Street', 'Campbell', 'CA', 95008 FROM DUAL UNION ALL
    SELECT 'Tameka', 'Fisher', '', 'tameka.fisher@yahoo.com', '769C Honey Creek St', 'Redondo Beach', 'CA', 90278 FROM DUAL UNION ALL
    SELECT 'Daryl', 'Spence', '', 'daryl.spence@aol.com', '988 Pearl Lane', 'Unlondale', 'NY', 11553 FROM DUAL UNION ALL
    SELECT 'Charolette', 'Rice', '(916) 381 6003', 'daryl.spence@aol.com', '107 Rive Dr.', 'Sacramento', 'CA', 95820 FROM DUAL;
COMMIT;


-- INSERT table STORES
INSERT INTO stores(store_name, phone, email, street, city, state, zip_code)
    SELECT 'Santa Cruz Bikes', '(831) 486-4321', 'santacruz@bikes.shop', '3700 Portbla Drive', 'Santa Cruz', 'CA', 95060 FROM DUAL UNION ALL
    SELECT 'Baldwin Bikes', '(516) 379-8888', 'baldwin@bikes.shop', '4200 Chestnut Lane', 'Baldwin', 'NY', 11432 FROM DUAL UNION ALL
    SELECT 'Rowlett Bikes', '(972) 530-5555', 'rowlett@bikes.shop', '8000 Fairway Avenue', 'Rowlett', 'TX', 75088 FROM DUAL;
COMMIT;


-- INSERT VALUE TABLE STOCKS
INSERT INTO stocks(store_id, product_id, quantity)
    SELECT 1, 21, 27 FROM DUAL UNION ALL
    SELECT 1, 22, 27 FROM DUAL UNION ALL
    SELECT 1, 23, 27 FROM DUAL UNION ALL
    SELECT 1, 24, 27 FROM DUAL UNION ALL
    SELECT 1, 25, 27 FROM DUAL UNION ALL
    SELECT 1, 26, 27 FROM DUAL UNION ALL
    SELECT 1, 27, 27 FROM DUAL UNION ALL
    SELECT 1, 28, 27 FROM DUAL UNION ALL
    SELECT 1, 29, 27 FROM DUAL UNION ALL
    SELECT 1, 30, 27 FROM DUAL;
COMMIT;    

-- insert value table staffs
-- ==> hỏi lại vụ chèn null khi dùng cú phap với select from dual union all?????
-- ==> hỏi lại vụ manager_id no la khoa ngoai tu than lam sao tu tem ma vao????
INSERT INTO stafts(first_name, last_name, email, phone, active, store_id, manager_id)
    SELECT 
        'Fabiola' AS c1, 
        'Jackson' AS c2, 
        'fabiola.jackson@bikes.shop' AS c3, 
        '(831) 555-5554' AS c4, 
        1 AS c5, 
        1 AS c6, 
        CAST(NULL AS NUMBER) AS c7 -- Vừa đặt tên c7, vừa ép kiểu số trống
    FROM DUAL UNION ALL
    SELECT 'Mireya', 'Copeland', 'mireya.copeland@bikes.shop', '(831) 555-5555', 1, 1, NULL FROM DUAL UNION ALL
    SELECT 'Genna', 'Serrano', 'genna.serrano@bikes.shop', '(831) 555-5556', 1, 1, NULL FROM DUAL UNION ALL
    SELECT 'Virgie', 'Wiggins', 'virgie.wiggins@bikes.shop', '(831) 555-5557', 1, 1, NULL FROM DUAL UNION ALL
    SELECT 'Jannette', 'David', 'jannette.david@bikes.shop', '(831) 555-4444', 1, 2, NULL FROM DUAL;
COMMIT;

-- insert table orders 
INSERT INTO orders(customer_id, order_status, order_date, required_date, shipped_date, store_id, staft_id)
    SELECT 
        1 AS c1, 
        4 AS c2, 
        TO_DATE('2016-01-01', 'YYYY-MM-DD') AS c3, 
        TO_DATE('2016-01-03', 'YYYY-MM-DD') AS c4, 
        TO_DATE('2016-01-03', 'YYYY-MM-DD') AS c5, 
        1 AS c6, 
        19 AS c7 
    FROM DUAL UNION ALL
    SELECT 2, 4, TO_DATE('2016-01-01', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), 2, 22 FROM DUAL UNION ALL
    SELECT 3, 4, TO_DATE('2016-01-01', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), 2, 22 FROM DUAL UNION ALL
    SELECT 4, 4, TO_DATE('2016-01-01', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), 1, 23 FROM DUAL UNION ALL
    SELECT 5, 4, TO_DATE('2016-01-01', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), TO_DATE('2016-01-03', 'YYYY-MM-DD'), 2, 21 FROM DUAL;
COMMIT;


-- insert value for table order_items
INSERT INTO order_items(order_id, item_id, product_id, quantity, list_price, discount)
    SELECT 
        1 AS c1,
        1 AS c2,
        23 AS c3,
        1 AS c4,
        599.99 AS c5,
        0.20 AS c6
     FROM DUAL UNION ALL 
     SELECT 1, 2, 21, 2, 1799.99, 0.07 FROM DUAL UNION ALL
     SELECT 1, 3, 23, 2, 1549.00, 0.05 FROM DUAL UNION ALL
     SELECT 1, 4, 23, 2, 599.99, 0.05 FROM DUAL UNION ALL
     SELECT 1, 5, 26, 1, 2899.99, 0.20 FROM DUAL UNION ALL
     SELECT 2, 1, 23, 1, 599.99, 0.07 FROM DUAL UNION ALL
     SELECT 2, 2, 23, 2, 599.99, 0.05 FROM DUAL UNION ALL
     SELECT 3, 1, 29, 1, 999.99, 0.05 FROM DUAL UNION ALL
     SELECT 3, 2, 23, 1, 599.99, 0.05 FROM DUAL UNION ALL
     SELECT 4, 1, 30, 2, 749.99, 0.10 FROM DUAL;
COMMIT;    


-- =============================================================================================
/*>>>>TRUY VAN CO BAN<<<<*/
-- cach xem cau truc bang 
DESCRIBE order_items;
SELECT * FROM customers;
SELECT * FROM stores;
SELECT * FROM stafts;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM order_items;

