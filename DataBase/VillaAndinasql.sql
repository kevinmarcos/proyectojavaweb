create database villaandina;
drop database villaandina;
use villaandina;

create table Categoria(
	codcat int primary key auto_increment,
	nomcat varchar(40) binary character set utf8 collate utf8_bin not null,
    estado bit not null
);
alter table Categoria modify estado bit;

insert into Categoria(nomcat,estado) values 
("Granos Andino",1),
("Cacao",1),(
"Super Foods",1);
select * from Categoria;

-- ---------------------------------------------------------------------------------- 
create table Destino(
	coddestino int primary key auto_increment, 
    nomdestino varchar(100) binary character set utf8 collate utf8_bin not null,
	coddistrito int not null,
    estado bit default 1 not null,
    foreign key (codDistrito) references Distrito(codDistrito)
);
insert into Destino(nomdestino,coddistrito,estado) values 
("ventas",2,1);
select * from Destino;
-- ---------------------------------------------------------------------------------- 
create table Distrito(
	codDistrito int primary key auto_increment,
	nomdistrito varchar(60) binary character set utf8 collate utf8_bin not null,
    estado bit default 1 not null
);

select * from Distrito;
insert into Distrito(nomdistrito,estado) values 
("San Juan de Lurigancho",1),
("La Molina",1),
("Pueblo Libre",1),
("Barranco",1),
("San Isidro",1),
("Santa Beatriz",1);

-- ----------------------------------------------------------------------------------
create table Empleado(
	codemple int primary key auto_increment,
    dni varchar(12) not null,
    nomemple varchar(50) binary character set utf8 collate utf8_bin not null,
    apellidPat varchar(30) not null,
    apellidMat varchar(30) not null,
    telfemple varchar(15) not null,
    correoemple varchar(100) binary character set utf8 collate utf8_bin not null,
    sexemple varchar(1) not null,
	coddistritoemple int not null,
    direccion varchar(100) binary character set utf8 collate utf8_bin not null,
    estado bit default 1 not null,
    foreign key (coddistritoemple) references Distrito(codDistrito)
);
alter table Empleado drop column apellid_pat;

select * from Empleado;
insert into Empleado(dni,nomemple,apellidPat,apellidMat,telfemple,correoemple,sexemple,coddistritoemple,direccion,estado) values 
("74053373","Kevin","Zamudio","Espinoza",951951951,"74053373@certus.edu.pe","M",1,"Jr. HolaMundo 1230",1),
("78945612","Anthony","Cesar","Lecarnaque",987654321,"anthony@certus.edu.pe","M",2,"Jr. JavaSpring 1300",1),
("79846513","Yameli","Carbajal","Cuicapuza",945916973,"yameli@certus.edu.pe","F",3,"Jr. Bootstrap 1649",1),
("64875113","Roy","Ventura","De la Rosa",977946031,"roy@certus.edu.pe","M",4,"Jr. Database 1750",1);

-- --------------------------------------------------------------------------------------------------

-- ------------------------------------------------------------------------------------------------------
create table Productos(
	codprod int primary key auto_increment,
    nomprod varchar(100) binary character set utf8 collate utf8_bin not null,
    catprod int not null,
    duraprod date not null,
    cantidad int not null,
    estprod bit default 1 not null,
    foreign key (catprod) references Categoria(codcat)
);

select * from Productos;
insert into Productos(nomprod,catprod,duraprod,cantidad,estprod) values
("Quinua Blanca",1,"2025-10-20",50,1),
("Quinua Roja",1,"2024-5-28",20,1),
("Manteca de Cacao",2,"2023-10-1",10,1),
("Pasta de Cacao",2,"2023-11-15",30,1),
("Maca",3,"2026-09-14",10,1),
("Camu Camu",3,"2022-12-20",20,1);

-- -------------------------------------------------------------------------------------------------------
create table Proveedores(
	codprov int primary key auto_increment,
    rucprov varchar(20) not null,
    nombprov varchar(100) binary character set utf8 collate utf8_bin not null,
    direccionprov varchar(100) not null,
    correoprov varchar(100) binary character set utf8 collate utf8_bin not null,
    telefprov int not null,
    estado bit default 1 not null
);

select * from Proveedores;
insert into Proveedores(nombprov,rucprov,direccionprov,correoprov,telefprov,estado) values
("TechNews Co.","12345678910","Av. Technologi N° 1000","technewsco@gmail.com",957182465,1),
("HealthApp Co.","15975314630","Av. BootCamp N° 2000","healthappco@gmail.com",945916972,1),
("Cinestres Co.","14789632530","Av. VisualStudio Code N° 3000","cinestresco@gmail.com",947914920,1);

-- --------------------------------------------------------------------------------------------------------
create table Entrada_Producto(
	codEntrada int primary key auto_increment,
    codEmpleado int not null,
    coddest int not null,
    fechaentrada date not null,
    estado bit default 1 not null,
    foreign key (codDest) references Destino(codDestino),
    foreign key (codEmpleado) references Empleado(codemple)
);
select * from Entrada_Producto;
insert into Entrada_Producto(fechaentrada,coddest,codempleado,estado) values
("2022-09-20",1,2,1),
("2022-08-21",1,2,1),
("2022-09-24",1,3,1),
("2022-09-26",1,1,1),
("2022-07-28",1,4,1),
("2022-09-12",1,3,1),
("2022-06-24",1,2,1),
("2022-09-13",1,1,1),
("2022-11-16",1,4,1),
("2022-10-24",1,2,1),
("2022-09-05",1,3,1);

create table Salida_Producto(
	codSalida int primary key auto_increment,
    fechasalida date not null,
    coddestino int not null,
	codempleado int not null,    
    estado bit default 1 not null,
    foreign key (codDestino) references Destino(codDestino),
    foreign key (codEmpleado) references Empleado(codemple)
);
select * from Salida_Producto;
insert into Salida_Producto(fechasalida,coddestino,codempleado,estado) values
("2022-10-20",1,2,1),
("2022-09-21",1,2,1),
("2022-10-24",1,3,1),
("2022-10-26",1,1,1),
("2022-08-28",1,4,1),
("2022-10-12",1,3,1),
("2022-07-24",1,2,1),
("2022-10-13",1,1,1),
("2022-12-16",1,4,1),
("2022-11-24",1,2,1),
("2022-10-05",1,3,1);

-- -------------------------------------------------------------------------------------------------------------
create table Detalle_Entrada(
	codDetalle_Entrada int primary key auto_increment,
	codEntrada int not null,
    codprod int not null,
    cantidad int not null,    
    estado bit default 1 not null,
    foreign key (codEntrada) references Entrada_Producto(codEntrada),
    foreign key (codProd) references Productos(codprod)
);
select * from Detalle_Entrada;
insert into Detalle_Entrada(codprod,cantidad,estado)values
(1,20,1),
(3,80,1),
(7,60,1),
(8,30,1),
(10,100,1),
(1,20,1),
(3,90,1),
(9,30,1),
(4,10,1),
(2,40,1);

-- ------------------------------------------------------------------------------------------------------------

create table Detalle_Salida(
	codDetalle_Salida int primary key auto_increment,
	codsalida int not null,
    codprod int not null,
    cantidad int not null,
    estado bit default 1 not null,
    foreign key (codProd) references Productos(codprod),
	foreign key (codSalida) references Salida_Producto(codSalida)
);
select * from Detalle_Salida;
insert into Detalle_Salida(codprod,cantidad,estado)values
(1,20,1),
(4,5,1),
(3,7,1),
(8,3,1),
(2,13,1),
(11,22,1),
(3,9,1),
(6,25,1),
(9,32,1),
(2,16,1);