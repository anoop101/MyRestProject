INSERT INTO MFD_COMPANY (COMPANY_ID,COMPANY_NAME,COMMENT,UPDATED_BY)
VALUES (1,"Rathi Co.","Added today","Anoop");
INSERT INTO MFD_COMPANY (COMPANY_ID,COMPANY_NAME,COMMENT,UPDATED_BY)
VALUES (2,"Prakash Cables","Added today","Anoop");
INSERT INTO MFD_COMPANY (COMPANY_ID,COMPANY_NAME,COMMENT,UPDATED_BY)
VALUES (3,"CPL Co.","Added today","Anoop");



INSERT INTO PRODUCT_CATEGORY (PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY, PRODUCT_SUBCATEGORY, MEASUREMENT, COMMENT, UPDATED_BY)
VALUES (1,"Cable","TV", "Meters", "Added today",  "Anoop");

INSERT INTO PRODUCT_CATEGORY (PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY, PRODUCT_SUBCATEGORY, MEASUREMENT, COMMENT, UPDATED_BY)
VALUES (2,"Cable","Telephone", "Meters", "Added today",  "Anoop");

INSERT INTO PRODUCT_CATEGORY (PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY, PRODUCT_SUBCATEGORY, MEASUREMENT, COMMENT, UPDATED_BY)
VALUES (3,"Switch","1Way", "Quantity", "Added today",  "Anoop");

INSERT INTO PRODUCT_CATEGORY (PRODUCT_CATEGORY_ID,PRODUCT_CATEGORY, PRODUCT_SUBCATEGORY, MEASUREMENT, COMMENT, UPDATED_BY)
VALUES (4,"Switch","2Way", "Quantity", "Added today",  "Anoop");




INSERT INTO PRODUCT (PRODUCT_ID,PRODUCT_NAME, PRODUCT_CATEGORY, COMPANY, COMMENT, UPDATED_BY)
VALUES (1,"Rathi 2Way Switch", 4, 1, "Added today",  "Anoop");

INSERT INTO PRODUCT (PRODUCT_ID,PRODUCT_NAME, PRODUCT_CATEGORY, COMPANY, COMMENT, UPDATED_BY)
VALUES (2,"CPL 2Way Switch", 4, 3, "Added today",  "Anoop");

INSERT INTO PRODUCT (PRODUCT_ID,PRODUCT_NAME, PRODUCT_CATEGORY, COMPANY, COMMENT, UPDATED_BY)
VALUES (3,"Telephone cable - Prakash", 2, 2, "Added today",  "Anoop");