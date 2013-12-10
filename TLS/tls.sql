CREATE TABLE "TRANSACTION"  (
   "TRANSCATIONID"      VARCHAR2(10)                    not null,
   "TOYID"              VARCHAR2(10)                    not null,
   "TDATEIN"            DATE,
   "TDATEOUT"           DATE,
   "CUSTID"             VARCHAR2(10)                    not null,
   constraint PK_TRANSCATION primary key ("TRANSCATIONID")
);

CREATE TABLE "RENT" (
   "RENTID"	        VARCHAR2(10)                    not null,
   "CUSTID"             VARCHAR2(10)                    not null,
   "TOYNAME"              VARCHAR2(50)                    not null,
   "DUEDATE"            DATE,
   constraint PK_RENT primary key ("RENTID")
);

CREATE TABLE  "USERS" (	
    "ID" VARCHAR2(2) NOT NULL, 
    "EMAIL" VARCHAR2(4000) NOT NULL, 
    "PASSWORD" VARCHAR2(4000) NOT NULL, 
    "USERTYPE" VARCHAR2(4000) NOT NULL, 
    "ADDRESS" VARCHAR2(4000) NOT NULL, 
    "FIRSTNAME" VARCHAR2(4000) NOT NULL, 
    "LASTNAME" VARCHAR2(4000) NOT NULL, 
    "PHONENUMBER" VARCHAR2(4000), 
    "GENDER" VARCHAR2(1) NOT NULL, 
    "DOB" DATE NOT NULL, 
    "DELIVERYADDRESS" VARCHAR2(4000), 
     CONSTRAINT "USERS_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "TOY" (
   "TOYID"	        VARCHAR2(10)                    not null,
   "TOYNAME"             VARCHAR2(50)                    not null,
   "TPRICE"              VARCHAR2(50)                    not null,
   "QUANTITY"              VARCHAR2(2)                    not null,
   constraint PK_RENT primary key ("TOYID")
);

INSERT INTO ADMIN.RENT (RENTID, CUSTID, TOYNAME, DUEDATE) VALUES ("1", "1", "tennis ball", TO_DATE("2009-08-01", 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO ADMIN.TRANSACTION (TRANSCATIONID, TOYID, TDATEIN, TDATEOUT, CUSTID) VALUES ("1", "1", TO_DATE("2009-03-01", 'YYYY-MM-DD HH24:MI:SS'), TO_DATE("2003-03-05", 'YYYY-MM-DD HH24:MI:SS'), "1");
INSERT INTO ADMIN.USERS (ID, EMAIL, PASSWORD, USERTYPE, ADDRESS, FIRSTNAME, LASTNAME, PHONENUMBER, GENDER, DOB, DELIVERYADDRESS) VALUES ("1", "1@1.com", "1", "2", "1", "1", "1", "1", "m", TO_DATE("2007-01-01", 'YYYY-MM-DD HH24:MI:SS'), '');