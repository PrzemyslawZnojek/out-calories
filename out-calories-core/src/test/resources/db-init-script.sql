CREATE SCHEMA IF NOT EXISTS dbo_core;

create table IF NOT EXISTS dbo_core.company (
	ID BIGINT generated by default as identity primary key,
	NAME VARCHAR(255) not null
);

create table IF NOT EXISTS dbo_core.meal (
	ID BIGINT generated by default as identity primary key,
	COMPANY_ID BIGINT not null references dbo_core.company(ID),
	NAME VARCHAR(255) not null,
	KCAL_AMOUNT int not null,
	PROTEINS int not null,
	CARBOHYDRATES int not null,
	FATS int not null,
	PRIZE numeric(6,2),
	CURRENCY varchar(3)
);

create table IF NOT EXISTS dbo_core.company_address (
	ID BIGINT generated by default as identity primary key,
	COMPANY_ID BIGINT not null references dbo_core.company(ID),
	COUNTRY VARCHAR(50) not null,
	ZIP_CODE VARCHAR(10) not null,
	CITY VARCHAR(50) not null,
	STREET VARCHAR(100),
	APARTMENT VARCHAR(20) not null
);

INSERT INTO dbo_core.company (NAME) values ('Biedronka');
--insert into dbo_core.company(ID, NAME) values (2, 'Dino');
--
insert into dbo_core.company_address(ID, COMPANY_ID, COUNTRY, ZIP_CODE, CITY, STREET, APARTMENT)
values (1, 1, 'POLAND', '00-000', 'Cracow', 'Street', '1C');
--insert into dbo_core.company_address(ID, COMPANY_ID, COUNTRY, ZIP_CODE, CITY, STREET, APARTMENT)
--values (2, 2, "POLAND", "00-000", "City", "Street", "2C");
--
--insert into dbo_core.meal(ID, COMPANY_ID, NAME, KCAL_AMOUNT, PROTEINS, CARBOHYDRATES, FATS, PRIZE, CURRENCY)
--values (1, 1, "Pierogi", 1000, 50, 50, 10, 100, "PLN");