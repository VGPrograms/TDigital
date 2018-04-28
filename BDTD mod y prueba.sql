Create  Database TDIGITAL;
USE TDIGITAL;

Create table empleados (
Id_Empleado int primary key auto_increment,
Nombre VARCHAR(25),
Apellido_P varchar(25),
Apellido_M varchar(25),
Celular varchar (15),
CelularAlt Varchar(15),
Correo nvarchar(50),
CorreoAlt Varchar(50),
Sueldo decimal(9,2),
Acceso int,
Pass Varchar(32),
Estado char(1) default '1'
);

Create table Clientes (
Id_Cliente int primary key auto_increment,
Nombre VARCHAR(25),
Apellido_P varchar(25),
Apellido_M varchar(25),
Empresa varchar(50),
Celular varchar (15),
Correo nvarchar(50),
estado char(1) default '1'
);


create table Categorias(
Id_Categoria int primary key auto_increment,
Categoria varchar(30)
);

insert INTO CATEGORIAS(CATEGORIA) VALUES('Telefonia'),
('Video Vigilancia'),
('Accesorios de computo'),
('Electrodomesticos');

Create table Unidades(
id_unidad int primary key auto_increment,
Unidad varchar(20),
Abrev varchar(5)
);

INSERT INTO UNIDADES(UNIDAD,ABREV) VALUES('Kilogramos','KG'),
('Litro','LTS'),('Pieza','Pza');

Create table Productos(
ID_Producto int primary key auto_increment,
Codigo varchar(9),
Clave varchar(15),
Producto nvarchar(30),
Descripcion varchar(40),
PrecioCompra decimal(9,2),
PrecioVenta decimal(9,2),
PrecioDolar decimal(9,2),
DolarActual decimal(9,2),
Moneda VARCHAR(5),
Stock int,
Id_Categoria int,
Id_unidad int,
FechaConversion datetime,
estado char(1), 
foreign key (id_unidad) references Unidades(id_unidad),
foreign key (Id_Categoria) references Categorias(Id_Categoria)
);


Create table Cotizaciones(
Id_cotizacion int primary key auto_increment,
Fecha datetime,
id_Empleado int,
id_cliente int,
Folio varchar(15),
FechaVencimiento date,
Instalacion char(1),
Descuento decimal(9,2),
Total decimal(9,2),
CantidadProductos int,
Estado char(1) default '1' ,
foreign key (id_Empleado) references empleados(id_Empleado),
foreign key (id_cliente) references Clientes(id_cliente)
);

Create table DetalleCotizacion(
id_detalle int primary key auto_increment,
id_cotizacion int,
id_producto int,
PrecioUnit decimal(9,2),
Cantidad int,
Subtotal decimal(9,2),
foreign key (id_producto) references Productos(id_producto),
foreign key (id_cotizacion) references Cotizaciones(id_cotizacion)
);

-- INSERTS PRUEBA SISTEMA

INSERT INTO `tdigital`.`clientes` (`Nombre`, `Apellido_P`, `Apellido_M`, `Empresa`, `Celular`, `Correo`) VALUES ('Jose Antonio', 'Becerra', 'Contreras', 'QuesiPizzas', '8712096209', 'jossian@gmail.com');
INSERT INTO `tdigital`.`clientes` (`Nombre`, `Apellido_P`, `Apellido_M`, `Empresa`, `Celular`, `Correo`) VALUES ('Juan Carlos', 'Vázquez ', 'González', 'LALA', '8718450428', 'esjunior1504@gmail.com');
INSERT INTO `tdigital`.`clientes` (`Nombre`, `Apellido_P`, `Apellido_M`, `Empresa`, `Celular`, `Correo`) VALUES ('Gabo', 'Contreras', 'Mascorro', 'Sabritas', '8713457641', 'gabo@gmail.com');
INSERT INTO `tdigital`.`clientes` (`Nombre`, `Apellido_P`, `Apellido_M`, `Empresa`, `Celular`, `Correo`) VALUES ('Juan Manuel', 'Fierro', 'Triana', 'QuesiPizzas', '7133131', 'CallCenter@QuesiPizzas.com');


INSERT INTO `tdigital`.`empleados` (`Nombre`, `Apellido_P`, `Apellido_M`, `Celular`, `Correo`, `Acceso`) VALUES ('Mario Iván', 'Martínez', 'Vega', '8713981118', 'Ivanmtz@transmisiondigital.mx', '1');
INSERT INTO `tdigital`.`empleados` (`Nombre`, `Apellido_P`, `Apellido_M`, `Celular`, `Correo`, `Acceso`) VALUES ('Erick Romario', 'Martínez', 'Vega', '8711101926', 'Ericmtz@transmisiondigital.com', '2');
INSERT INTO `tdigital`.`empleados` (`Nombre`, `Apellido_P`, `Apellido_M`, `Celular`, `Correo`, `Acceso`) VALUES ('Jose Romario', 'Martínez', 'Quiñones', '8711247578', 'Romariomtz@hotmail.com', '1');


INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('12365', '1', 'Swtch', '100', '120', 'MXN', '5', '1', '3');
INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('87687', '2', 'Router', '20', '40', 'MXN', '9', '1', '3');
INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('98234', '3', 'Cable UTP', '50', '100', 'MXN', '56', '1', '3');
INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('01284', '4', 'Computadora', '80', '100', 'MXN', '54', '2', '3');
INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('09284', '5', 'Modem', '60', '90', 'MXN', '100', '4', '3');
INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('09821', '6', 'Mouse', '60', '98', 'MXN', '100', '2', '3');
INSERT INTO `tdigital`.`productos` (`Codigo`, `Clave`, `Producto`, `PrecioCompra`, `PrecioVenta`, `Moneda`, `Stock`, `Id_Categoria`, `Id_unidad`) VALUES ('64922', '7', 'Teclado', '90', '110', 'MXN', '100', '3', '3');
