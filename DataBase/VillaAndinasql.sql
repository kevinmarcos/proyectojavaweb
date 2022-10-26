create database villaandina;
drop database villaandina;
use villaandina;

create table Categoria(
	codcat int primary key auto_increment,
	nomcat varchar(40) binary character set utf8 collate utf8_bin not null,
    estado bit default 1 not null
);

insert into Categoria(nomcat) values ("Granos Andino"),("Cacao"),("Super Foods");
select * from Categoria;

-- ---------------------------------------------------------------------------------- 
create table Destino(
	codDestino int primary key auto_increment, 
    nomDestino varchar(100) binary character set utf8 collate utf8_bin not null,
	codDistrito int not null,
    estado bit default 1 not null,
    foreign key (codDistrito) references Distrito(codDistrito)
);

-- ---------------------------------------------------------------------------------- 
create table Distrito(
	codDistrito int primary key auto_increment,
	nomdistrito varchar(60) binary character set utf8 collate utf8_bin not null,
    estado bit default 1 not null
);

select * from Distrito;
insert into Distrito(nomdistrito) values 
("San Juan de Lurigancho"),
("La Molina"),
("Pueblo Libre"),
("Barranco"),
("San Isidro"),
("Santa Beatriz");

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
insert into Empleado(dni,nomemple,apellidPat,apellidMat,telfemple,correoemple,sexemple,coddistritoemple,direccion) values 
("74053373","Kevin","Zamudio","Espinoza",951951951,"74053373@certus.edu.pe","M",1,"Jr. HolaMundo 1230"),
("78945612","Anthony","Cesar","Lecarnaque",987654321,"anthony@certus.edu.pe","M",2,"Jr. JavaSpring 1300"),
("79846513","Yameli","Carbajal","Cuicapuza",945916973,"yameli@certus.edu.pe","F",3,"Jr. Bootstrap 1649"),
("64875113","Roy","Ventura","De la Rosa",977946031,"roy@certus.edu.pe","M",4,"Jr. Database 1750");

-- ---------------------------------------------------------------------------------------------------
create table Entrada_Producto(
	codEntrada int primary key auto_increment,
    codEmpleado int not null,
    codDest int not null,
    fechaEntrada date not null,
    estado bit default 1 not null,
    foreign key (codDest) references Destino(codDestino),
    foreign key (codEmpleado) references Empleado(codemple)
);



-- ------------------------------------------------------------------------------------------------------
create table Productos(
	codprod int primary key auto_increment,
    nomprod varchar(100) binary character set utf8 collate utf8_bin not null,
    catprod int not null,
    duraprod date not null,
    cantidad int not null,
    estado bit default 1 not null,
    foreign key (catprod) references Categoria(codcat)
);

select * from Productos;
insert into Productos(nomprod,catprod,duraprod,cantidad) values
("Quinua Blanca",1,"2025-10-20",1500),
("Quinua Roja",1,"2024-5-28",2000),
("Manteca de Cacao",2,"2023-10-1",1000),
("Pasta de Cacao",2,"2023-11-15",3000),
("Maca",3,"2026-09-14",1500),
("Camu Camu",3,"2022-12-20",2000);

-- -------------------------------------------------------------------------------------------------------
create table Proveedores(
	codprov int primary key auto_increment,
    rucProv varchar(20) not null,
    nombprov varchar(100) binary character set utf8 collate utf8_bin not null,
    direccionProv varchar(100) not null,
    correoprov varchar(100) binary character set utf8 collate utf8_bin not null,
    telefprov int not null,
    estado bit default 1 not null
);

select * from Proveedores;
insert into Proveedores(nombprov,rucProv,direccionProv,correoprov,telefprov) values
("TechNews Co.",12345678910,"Av. Technologi N° 1000","technewsco@gmail.com",957182465),
("HealthApp Co.",15975314630,"Av. BootCamp N° 2000","healthappco@gmail.com",945916972),
("Cinestres Co.",14789632530,"Av. VisualStudio Code N° 3000","cinestresco@gmail.com",947914920);

-- --------------------------------------------------------------------------------------------------------
create table Salida_Producto(
	codSalida int primary key auto_increment,
    fechaSalida date not null,
    codDestino int not null,
	codEmpleado int not null,    
    estado bit default 1 not null,
    foreign key (codDestino) references Destino(codDestino),
    foreign key (codEmpleado) references Empleado(codemple)
);

-- -------------------------------------------------------------------------------------------------------------
create table Detalle_Entrada(
	codDetalle_Entrada int primary key auto_increment,
	codEntrada int not null,
    codProd int not null,
    cantidad int not null,    
    estado bit default 1 not null,
    foreign key (codEntrada) references Entrada_Producto(codEntrada),
    foreign key (codProd) references Productos(codprod)
);

-- ------------------------------------------------------------------------------------------------------------

create table Detalle_Salida(
	codDetalle_Salida int primary key auto_increment,
	codSalida int not null,
    codProd int not null,
    cantidad int not null,
    estado bit default 1 not null,
    foreign key (codProd) references Productos(codprod),
	foreign key (codSalida) references Salida_Producto(codSalida)
);