DROP TABLE IF EXISTS "bill_info";
CREATE TABLE bill_info (
    Id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    billing_email VARCHAR(255),
    company_name VARCHAR(255),
    country_name VARCHAR(255),
    state_name VARCHAR(255),
    city_name VARCHAR(255),
    address VARCHAR(255),
    zipcode VARCHAR(255),
    phone VARCHAR(255),
    fax VARCHAR(255)
) AS SELECT * FROM CSVREAD('classpath:tables/BillingInfo.csv');