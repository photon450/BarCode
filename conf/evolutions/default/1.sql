# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table manager (
  id                        bigserial not null,
  username                  varchar(255),
  password                  varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  password_hash             varchar(255),
  date_created              timestamp,
  constraint pk_manager primary key (id))
;

create table product (
  id                        bigserial not null,
  sku                       varchar(255),
  product_name              varchar(255),
  condition                 varchar(255),
  product_desc              varchar(255),
  category                  varchar(255),
  availability              integer,
  constraint pk_product primary key (id))
;

create table sales (
  day_sold                  timestamp)
;

create table users (
  id                        bigserial not null,
  username                  varchar(255),
  password                  varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  password_hash             varchar(255),
  date_created              timestamp,
  constraint pk_users primary key (id))
;




# --- !Downs

drop table if exists manager cascade;

drop table if exists product cascade;

drop table if exists sales cascade;

drop table if exists users cascade;

