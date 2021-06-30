-- liquibase formatted sql

-- changeset pznojek:init-001

-- create table

INSERT INTO dbo_core.company_address(ID, COMPANY_ID, COUNTRY, ZIP_CODE, CITY, STREET, APARTMENT) VALUES (1, 1, 'POLAND', '00-000', 'Cracow', 'Street', '1C');
INSERT INTO dbo_core.company_address(ID, COMPANY_ID, COUNTRY, ZIP_CODE, CITY, STREET, APARTMENT) VALUES (2, 2, 'POLAND', '10-000', 'Kielce', 'Dluga', '2B');