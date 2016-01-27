# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table login (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  senha                     varchar(255),
  constraint pk_login primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table login;

SET FOREIGN_KEY_CHECKS=1;

