CREATE TABLE Cars
(
    CarID NUMBER NOT NULL,
    YearManufactured NUMBER NOT NULL,
    Make VARCHAR2(20) NOT NULL,
    Model VARCHAR2(20) NOT NULL,
    AskingPrice NUMBER(8,2) NOT NULL,
    AmtStillOwed Number (8,2),
  
    CONSTRAINT CarID PRIMARY KEY  (CarId)
);


CREATE SEQUENCE CARSEQ;

INSERT INTO Cars (CarID, YearManufactured, Make, Model, AskingPrice, AmtStillOwed) VALUES (2, 2019, 'Nissan', 'B-13', 35000, 35000);

CREATE TABLE CARS
(
    CarID INT ,
    YearManufactured NUMBER NOT NULL,
    Make VARCHAR2(20) NOT NULL,
    Model VARCHAR2(20) NOT NULL,
    AskingPrice NUMBER(8,2) NOT NULL,
    AmtStillOwed Number (8,2),
  
    CONSTRAINT CarID PRIMARY KEY  (CarId)
);

CREATE SEQUENCE CARSEQ;


--------------------------EMPLOYEE TABLE----------------------------------

CREATE TABLE EMPLOYEES
(
    EmployeeID INT ,
    FirstName VARCHAR2(30) NOT NULL,
    LastName VARCHAR2(30) NOT NULL,
    UserName VARCHAR2(30) NOT NULL,
    Password VARCHAR2(30) NOT NULL,
  
    CONSTRAINT EmployeeID PRIMARY KEY  (EmployeeID)
);

CREATE SEQUENCE EMPSEQ;


--------------------------CUSTOMER TABLE----------------------------------

CREATE TABLE CUSTOMERS
(
    CustomerID INT ,
    FirstName VARCHAR2(30) NOT NULL,
    LastName VARCHAR2(30) NOT NULL,
    UserName VARCHAR2(30) NOT NULL,
    Password VARCHAR2(30) NOT NULL,
  
    CONSTRAINT CustomerID PRIMARY KEY  (CustomerID)
);

CREATE SEQUENCE CUSSEQ;

SELECT * FROM EMPLOYEES WHERE USERNAME = 'night' AND PASSWORD = 'wrongtable';

CREATE TABLE OFFERS
(
    OfferID INT, 
    OfferAmount NUMBER (8,2) NOT NULL,
    CarID INT NOT NULL REFERENCES CARS (CarID),
    CustomerID INT NOT NULL REFERENCES CUSTOMERS (CustomerID),
    Status VARCHAR(20) DEFAULT 'Pending',
    ReviewingEmployee VARCHAR(500) DEFAULT 'PENDING',
    
    CONSTRAINT OfferID PRIMARY KEY (OfferID)   
);

CREATE SEQUENCE OFFSEQ;

UPDATE CUSTOMERS SET FIRSTNAME = 'Pimp', LASTNAME = 'NameSlickback', USERNAME = 'goget', PASSWORD = 'mymoney' WHERE CUSTOMERID = 24; 

SELECT * FROM OFFERS WHERE CUSTOMERID = 26;


CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID INT,
    EMPLOYEE_FIRSTNAME VARCHAR(20),
    EMPLOYEE_LASTNAME VARCHAR(20), 
    DEPARTMENT_ID INT,
    SALARY NUMBER (8,2),
    EMP_EMAIL VARCHAR2(30),
    
    CONSTRAINT EMPLOYEE_ID PRIMARY KEY (EMPLOYEE_ID)
);

CREATE SEQUENCE EMPLOYEESEQ;


-- ATTENTION ! Please note that the majority of entries in out tables were created from the Java side in the console
-- as a result, only the SQL code for creating tables and testing the prepared statement queries are contained in this file.


CREATE TABLE DEPARTMENT
(
    DEPARTMENT_ID INT,
    DEPARTMENT_NAME VARCHAR(20),
    
    CONSTRAINT DEPARTMENT_ID PRIMARY KEY (DEPARTMENT_ID)
);

CREATE SEQUENCE DEPARTMENTSEQ;

CREATE OR REPLACE TRIGGER DEPARTMENT
BEFORE INSERT ON BEAR_TYPE --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT DEPARTMENTSEQ.NEXTVAL INTO :NEW.DEPARTMENT FROM DUAL;
END;

/

SELECT CUSTOMERID FROM CUSTOMERS WHERE USERNAME = 'green' AND PASSWORD = 'machine'; --testing to make sure my prepared statements work properly.