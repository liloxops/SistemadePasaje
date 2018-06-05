--Drop database BD_pasaje;
create database BD_pasaje;

use BD_pasaje;

create table ciudad  (
    id int auto_increment,
    nombre varchar(30),
    primary key(id)
);
create table conductor (
    id int auto_increment,
    nombre varchar(30),
    primary key(id)
);
create table vendedor (
    id int auto_increment,
    nombre varchar(30),
    rut varchar(12),
    pass varchar(8),
    primary key(id)
);

create table bus(
    id int auto_increment,
    placa varchar(10),
    asiento int,
    fk_conductor int,
    foreign key (fk_conductor) references conductor(id),
    primary key(id)
);

create table horarioBus (
    id int auto_increment,
    horario date,
    fk_bus int,
    foreign key (fk_bus) references bus(id),
    primary key(id)
);

create table pasaje(
    id int auto_increment,
    fk_origen int,
    fk_destino int,
    fecha date,
    fk_bus int,
    fk_vendedor int,
    foreign key (fk_origen) references ciudad(id),
    foreign key (fk_destino) references ciudad(id),
    foreign key (fk_bus) references bus(id),
    foreign key (fk_vendedor) references vendedor(id),
    primary key(id)
);


select * from pasaje;
select * from horarioBus;