-- INIT BRAND
CREATE TABLE IF NOT EXISTS BRAND(
  ID INT PRIMARY KEY,
  NAME VARCHAR(36) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  CREATED_AT TIMESTAMP NOT NULL DEFAULT current_timestamp(),
  UPDATED_AT TIMESTAMP NOT NULL DEFAULT current_timestamp()
);
INSERT INTO BRAND(ID,NAME,DESCRIPTION)
VALUES(1,'Brand-sample','Brand name created to simulate the brand name to which the prices point');
-- END BRAND

--DISCLAIMER
--I take the liberty of changing the date format to TIMESTAMP in database and ZonedDateTime or OffsetDateTime in java, it's the most
--appropriate, always saving them in UTC.

-- INIT PRICE
CREATE TABLE IF NOT EXISTS APPLICABLE_PRICE (
  ID UUID PRIMARY KEY,
  BRAND_ID INT NOT NULL,
  START_DATE TIMESTAMP NOT NULL,
  END_DATE TIMESTAMP NOT NULL,
  APPLICABLE_TARIFF_ID INT NOT NULL,
  PRODUCT_ID INT NOT NULL,
  PRIORITY TINYINT NOT NULL DEFAULT 0,
  AMOUNT DECIMAL(10,2) NOT NULL,
  CURRENCY VARCHAR(3) NOT NULL DEFAULT 'EUR',
  CREATED_AT TIMESTAMP NOT NULL DEFAULT current_timestamp(),
  UPDATED_AT TIMESTAMP NOT NULL DEFAULT current_timestamp(),
  CONSTRAINT fk_prices_brand FOREIGN KEY (BRAND_ID) REFERENCES BRAND (ID)
);

INSERT INTO APPLICABLE_PRICE(ID,BRAND_ID,START_DATE,END_DATE,APPLICABLE_TARIFF_ID,PRODUCT_ID,PRIORITY,AMOUNT)
VALUES('2D1EBC5B7D2741979CF0E84451C5BBB1',1,'2020-06-14 00.00.00','2020-12-31 23.59.59',1,35455,0,35.50);
INSERT INTO APPLICABLE_PRICE(ID,BRAND_ID,START_DATE,END_DATE,APPLICABLE_TARIFF_ID,PRODUCT_ID,PRIORITY,AMOUNT)
VALUES('1D1EBC5B7D2741979CF0E84451C5BBB1',1,'2020-06-14 15.00.00','2020-06-14 18.30.00',2,35455,1,25.45);
INSERT INTO APPLICABLE_PRICE(ID,BRAND_ID,START_DATE,END_DATE,APPLICABLE_TARIFF_ID,PRODUCT_ID,PRIORITY,AMOUNT)
VALUES('3D1EBC5B7D2741979CF0E84451C5BBB1',1,'2020-06-15 00.00.00','2020-06-15 11.00.00',3,35455,1,30.50);
INSERT INTO APPLICABLE_PRICE(ID,BRAND_ID,START_DATE,END_DATE,APPLICABLE_TARIFF_ID,PRODUCT_ID,PRIORITY,AMOUNT)
VALUES('4D1EBC5B7D2741979CF0E84451C5BBB1',1,'2020-06-15 16.00.00','2020-12-31 23.59.59',4,35455,1,38.95);

-- END PRICE
