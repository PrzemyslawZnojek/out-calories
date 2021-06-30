-- liquibase formatted sql

-- changeset pznojek:init-001

-- create table

INSERT INTO dbo_core.meal(company_id, "name", kcal_amount, proteins, carbohydrates, fats, prize, currency)
VALUES(1, 'Pierogi', 300, 50, 35, 15, 15, 'PLN');

INSERT INTO dbo_core.meal(company_id, "name", kcal_amount, proteins, carbohydrates, fats, prize, currency)
VALUES(2, 'Bigos', 600, 50, 35, 15, 15, 'PLN');