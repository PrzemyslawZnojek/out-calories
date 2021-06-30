-- liquibase formatted sql

-- changeset pznojek:init-001

-- create table

insert into dbo_core.company(ID, NAME) values (1, 'Biedronka');
insert into dbo_core.company(ID, NAME) values (2, 'Dino');