drop database if exists BDTwitterClon;
create database if not exists BDTwitterClon;
use BDTwitterClon;

create table tweet(
	id_tweet int primary key auto_increment,
    usu_tweet varchar(100) not null,
    hora_tweet datetime not null,
	content_tweet varchar(140) not null
);

insert into tweet values(null, "Miguelito Barraza", now(), "No me funen mas, Soy aliade");
insert into tweet values(null, "Leon de las Casas", now(), "Correle mi hijo que la inteligencia artificial nos va matar");