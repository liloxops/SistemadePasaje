--Drop database BD_pasaje;
create database BD_pasaje;

use BD_pasaje;

create table vendedor(
    id int auto_increment,
    nombre varchar(30),
    rut varchar(30),
    pass varchar(50),
    primary key(id)
);
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

create table bus(
    id int auto_increment,
    placa varchar(10),
    fk_conductor int,
    foreign key (fk_conductor) references conductor(id),
    primary key(id)
);

create table horarioBus (
    id int auto_increment,
    fk_bus int,
    hora_Salida time,
    fk_origen int,
    fk_destino int,
    precio int,
    foreign key (fk_origen) references ciudad(id),
    foreign key (fk_destino) references ciudad(id),    
    foreign key (fk_bus) references bus(id),
    primary key(id)
);

select horarioBus.id, bus.placa, horarioBus.hora_salida, ciudad.nombre, horarioBus.precio from horarioBus,bus,ciudad where bus.id = horarioBus.fk_bus and horarioBus.fk_destino = ciudad.id;

create table pasaje(
    id int auto_increment,
    asiento int,
    fecha date,
    fk_horario int,
    foreign key (fk_horario) references horarioBus(id),
    primary key(id)
);

select asiento from pasaje where fk_horario = 3;

/*--------------INSERT--------------*/

-- select 
-- 
-- insert into vendedor value(null,'Alexis Sanchez','13569874-6','as7');

insert into vendedor value(null,'juan','11-1',md5('1234'));
insert into vendedor value(null,'pato','22-2',md5('1234'));
insert into vendedor value(null,'pedro','33-3',md5('1234'));

select vendedor.nombre from vendedor where rut = '11-1';

insert into ciudad value(null,'Las Cabras');
insert into ciudad value(null,'Peumo');
insert into ciudad value(null,'San Vicente T.T');
insert into ciudad value(null,'Rancagua');
insert into ciudad value(null,'Santiago');

insert into conductor value(null,'Juan Perez');
insert into conductor value(null,'Diego Lopez');
insert into conductor value(null,'Edunaldo Rubio');
insert into conductor value(null,'Lilixops');
insert into conductor value(null,'Pabli');

insert into bus value(null,'uf-as-45',1);
insert into bus value(null,'sd-xc-00',2);
insert into bus value(null,'qw-tr-78',3);
insert into bus value(null,'ty-pp-22',4);
insert into bus value(null,'ca-ca-66',5);

insert into horarioBus value(null,1,'09:30:00',3,4,2000);
insert into horarioBus value(null,2,'10:30:00',3,5,3500);
insert into horarioBus value(null,3,'11:30:00',3,4,2000);
insert into horarioBus value(null,4,'12:30:00',3,5,3500);
insert into horarioBus value(null,5,'13:30:00',3,4,2000);

insert into pasaje value(null,4,now(),3);
insert into pasaje value(null,6,now(),3);
insert into pasaje value(null,28,now(),1);
insert into pasaje value(null,19,now(),3);
/*----------------------------------*/

-- select bus.placa,horarioBus.hora from bus,horarioBus where bus.id = horarioBus.fk_bus;

-- select asiento from pasaje where fk_horario = 3;



select * from pasaje;
select * from horarioBus;
select * from bus;
select * from conductor;
select * from ciudad;
select * from vendedor;
