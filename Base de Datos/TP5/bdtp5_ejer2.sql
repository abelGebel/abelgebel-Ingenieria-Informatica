create table cargo (
	id_cargo varchar(3) primary key,
	nombre_cargo varchar(30)
);

-----------------------TIPO CLIENTE------------------------

create table tipo_cliente (
	id_tipo_cliente varchar(2) primary key,
	nombre_tipo_cliente varchar(30)
);

------------------------PROVEEDOR------------------------


create table proveedor (
	cuit_proveedor varchar(13) primary key,
	nombre_proveedor varchar(30)
);

------------------------PROVINCIA------------------------

create table provincia (
	cod_provincia integer primary key,
	nombre_provincia varchar(30)
);

------------------------EMPLEADO------------------------

create table empleado (
	cod_empleado integer primary key,
	nombre_empleado varchar(30),
	dni_empleado integer,
	id_cargo varchar(3) references cargo (id_cargo)
);

-----------------------CLIENTE------------------------

create table cliente (
	cod_cliente integer primary key,
	cuit_cliente varchar(13),
	nombre_cliente varchar(30),
	telef_cliente integer,
	id_tipo_cliente varchar(2) references tipo_cliente (id_tipo_cliente)
);

-----------------------PRODUCTO------------------------

create table producto (
	cod_producto integer primary key,
	nombre_producto varchar(30),
	precio_producto numeric(12,2),
	cuit_proveedor varchar(13) references proveedor (cuit_proveedor)
);

create table compania_envio (
	cod_compania integer primary key,
	nombre_compania varchar(30),
	telef_compania integer,
	cod_provincia integer references provincia (cod_provincia)
);

-----------------------PEDIDO------------------------

create table pedido (
	cod_pedido integer primary key,
	cod_cliente integer references cliente (cod_cliente),
	cod_empleado integer references empleado (cod_empleado),
	cod_compania integer references compania_envio (cod_compania),
	fecha_pedido date,
	fecha_envio date,
	direccion_destinatario varchar(30)
);

-----------------------DETALLE PEDIDO------------------------

create table detalle_pedido (
	cod_pedido integer,
	cod_producto integer,
	primary key (cod_pedido,cod_producto),
	cantidad integer,
	porcentaje_descuento numeric(4,2),
	foreign key (cod_pedido) references pedido (cod_pedido),
	foreign key (cod_producto) references producto (cod_producto)
);



insert into cargo (id_cargo,nombre_cargo) values 
('GER','Gerente'),
('ENC','Encargado'),
('VEN','Vendedor');

insert into tipo_cliente (id_tipo_cliente,nombre_tipo_cliente) values
('CF','Consumidor Final'),
('RI','Responsable Inscripto'),
('EX','Exento');


insert into proveedor (cuit_proveedor,nombre_proveedor) values
('11-11111111-1','Proveedor1'),
('22-22222222-2','Proveedor2'),
('33-33333333-3','Proveedor3');

insert into provincia (cod_provincia,nombre_provincia) values
(388,'Jujuy'),
(381,'Tucuman'),
(387,'Salta');

insert into empleado (cod_empleado,nombre_empleado,dni_empleado,id_cargo) values
(2810, 'Empleado1', 22222222, 'VEN'), 
(2811, 'Empleado2', 33333333, 'VEN'), 
(2812, 'Empleado3', 44444444, 'ENC'),
(2813, 'Empleado4', 55555555, 'GER'),
(2814, 'Empleado5', 11111111, 'VEN');

insert into cliente (cod_cliente, cuit_cliente,nombre_cliente,telef_cliente,id_tipo_cliente) values
(1001, '20-2110010-1', 'Cliente1', 111, 'CF'), 
(2002, '20-2120020-2', 'Cliente2', 222, 'EX'),
(3003, '20-2130030-3', 'Cliente3', 333, 'CF'), 
(4004, '20-2140040-4', 'Cliente4', 444, 'RI'), 
(5005, '20-2150050-5', 'Cliente5', 555, 'RI');

insert into producto (cod_producto, nombre_producto,precio_producto,cuit_proveedor) values
(111, 'Pendrive 32Gb', 3550.00, '11-11111111-1'),
(222, 'Cámara web', 16000.00, '11-11111111-1'),
(333, 'Resma A4', 3000.00, '22-22222222-2'),
(444, 'Caja 100DVD', 12000.00, '33-33333333-3'),
(555, 'Pendrive 64Gb', 5000.00, '22-22222222-2');

insert into compania_envio (cod_compania,nombre_compania,telef_compania,cod_provincia) values
(10, 'Compañía1', 155155155, 381),
(20, 'Compañía2', 152152152, 388),
(30, 'Compañía3', 153153153, 388),
(40, 'Compañía4', 154154154, 387);

insert into pedido (cod_pedido,cod_cliente,cod_empleado,cod_compania,fecha_pedido,fecha_envio,direccion_destinatario) values
(1, 1001, 2814, 10, '29/09/2023', '02/10/2021', 'Dirección1'), 
(2, 4004, 2814, 20, '29/09/2023', '03/10/2021', 'Dirección2'), 
(3, 1001, 2810, 40, '29/09/2023', '10/10/2021', 'Dirección3'), 
(4, 2002, 2814, 30, '02/10/2023', '02/10/2021', 'Dirección4'),
(5, 3003, 2811, 10, '02/10/2023', '03/10/2021', 'Dirección5'),
(6, 5005, 2810, 20, '03/10/2023', '05/10/2021', 'Dirección6');

insert into detalle_pedido (cod_pedido,cod_producto,cantidad,porcentaje_descuento) values
(1, 111, 2, 0),
(1, 222, 5, 0),
(1, 444, 20, 10.00),
(2, 333, 10, 5.00),
(2, 555, 1, 0),
(3, 111, 1, 0),
(4, 555, 2, 0),
(5, 111, 1, 0),
(5, 222, 1, 15.00),
(5, 333, 1, 0),
(6, 555, 5, 10.00);

/*
9) Realice una función que muestre por pantalla la cantidad total de registros de todas las
   tablas.
*/

CREATE OR REPLACE FUNCTION contar_registros_totales() RETURNS VOID AS
$$
DECLARE
    tabla record;
    total_registros integer := 0;
BEGIN
    FOR tabla IN SELECT relname FROM pg_class WHERE relkind = 'r' AND relname NOT LIKE 'pg_%' AND relname NOT LIKE 'sql_%' LOOP
        EXECUTE 'SELECT count(*) FROM ' || tabla.relname INTO total_registros;
        RAISE NOTICE 'La tabla % tiene % registros.', tabla.relname, total_registros;
    END LOOP;
END;
$$
LANGUAGE plpgsql;
SELECT contar_registros_totales();


CREATE OR REPLACE FUNCTION registros_totales() RETURNS integer AS
$$
DECLARE
    total_registros integer := 0;
BEGIN
	total_registros= (SELECT count(*) FROM cargo) + (SELECT count(*) FROM proveedor);
	RETURN total_registros;
	
END;
$$
LANGUAGE plpgsql;
SELECT registros_totales();



/*
10) Realice una función que reciba como parámetro el código de provincia y devuelva el
    nombre de las compañías asociadas con el mismo.
*/

CREATE OR REPLACE FUNCTION companias_asociadas(cod_provincia_param integer) RETURNS VOID AS
$$
BEGIN
	SELECT cod_provincia, nombre_compania FROM compania_envio WHERE cod_provincia=cod_provincia_param;
END;
$$
LANGUAGE plpgsql;
DROP FUNCTION companias_asociadas(integer)

SELECT companias_asociadas(388)

/*
11) Realice una función que reciba como parámetro una fecha de pedido y devuelva el monto
    total de pedidos para esa fecha.
*/



CREATE OR REPLACE FUNCTION monto_ventas (fecha date) RETURNS numeric(12,2) AS
$$
DECLARE 
	total numeric(12,2):=0;
BEGIN
	total:= (SELECT SUM(pr.precio_producto*dp.cantidad) FROM pedido pe JOIN detalle_pedido dp
			ON pe.cod_pedido=dp.cod_pedido JOIN producto pr ON dp.cod_producto=pr.cod_producto);
	RETURN total;
END;
$$
LANGUAGE plpgsql;

SELECT monto_ventas ('2021-10-02')

/*
12) Realice una función que reciba como parámetros una “Fecha Pedido desde” y una “Fecha
    Pedido hasta”, cargue el cursor con los datos de pedidos, lea el cursor y grabe dichos
    datos en la tabla “pedido_especial”*/


CREATE OR REPLACE FUNCTION cargar_pedido_especial (fecha_desde date,fecha_hasta date) RETURNS VOID AS
$$
DECLARE 
	reg pedido%ROWTYPE;
	cursor_pedidos CURSOR FOR
		SELECT * FROM pedido WHERE fecha_pedido>fecha_desde AND fecha_pedido<fecha_hasta;
BEGIN
	OPEN cursor_pedidos;
	LOOP 
		FETCH NEXT FROM cursor_pedidos INTO reg;
		EXIT WHEN NOT FOUND;
		INSERT INTO pedido_especial VALUES (reg.cod_pedido,reg.cod_cliente,reg.cod_empleado,reg.cod_compania,reg.fecha_pedido,reg.fecha_envio,reg.direccion_destinatario );
	END LOOP;
	CLOSE cursor_pedidos;
END;
$$
LANGUAGE plpgsql;

SELECT cargar_pedido_especial('2023-09-29','2023-10-03');

SELECT * FROM pedido_especial

create table pedido_especial (
	cod_pedido integer,
	cod_cliente integer,
	cod_empleado integer,
	cod_compania integer,
	fecha_pedido date,
	fecha_envio date,
	direccion_destinatario varchar(30)
);

/*13) Realice una función que reciba como parámetro el “Codigo Compañía”, cargue un cursor
    con todos los pedidos realizados por esa compañía, lea el cursor y devuelva los nombres
    de dichas compañías.*/

CREATE OR REPLACE FUNCTION  pedidos_compania (codigo_param integer) RETURNS VOID AS
$$
DECLARE 
	reg record;	
	cursor_pedidos CURSOR FOR 
		SELECT p.cod_pedido,ce.nombre_compania FROM pedido p, compania_envio ce WHERE p.cod_compania=ce.cod_compania AND p.cod_compania=codigo_param;
BEGIN
	OPEN cursor_pedidos;
	LOOP 
		FETCH NEXT FROM cursor_pedidos INTO reg;
		EXIT WHEN NOT FOUND;
		RAISE NOTICE 'Nombre de compañía: %', reg.nombre_compania;
	END LOOP;
	CLOSE cursor_pedidos;
END;
$$
LANGUAGE plpgsql;

SELECT pedidos_compania(10);



/*14) Realice una función que reciba como parámetro el Cuit de proveedor, cargue un cursor con
    los productos y el detalle pedido, luego debe abrir el cursor, y calcular el precio por cada
    producto (Precio Producto * Cantidad - Porcentaje Descuento), sume el total y cargue la
    variable que será devuelta por la función.*/
DROP FUNCTION precio_producto(character varying) 

CREATE OR REPLACE FUNCTION precio_producto (cuit_proveedor_param VARCHAR(13)) RETURNS numeric(12,2) AS
$$
DECLARE 
	total numeric(12,2):=0;
	reg RECORD;
	cursor_productos CURSOR FOR 
		SELECT pr.precio_producto,dp.cantidad,dp.porcentaje_descuento FROM producto pr, detalle_pedido dp,
		proveedor prov WHERE pr.cod_producto=dp.cod_producto AND prov.cuit_proveedor=pr.cuit_proveedor
		AND prov.cuit_proveedor=cuit_proveedor_param;
BEGIN
	OPEN cursor_productos;
	LOOP
		FETCH NEXT FROM cursor_productos INTO reg;
		EXIT WHEN NOT FOUND;
		total:=total+(reg.precio_producto*reg.cantidad)-(reg.precio_producto*reg.cantidad*(reg.porcentaje_descuento/100));
	END LOOP;
	CLOSE  cursor_productos;
	RETURN total;
END;
$$
LANGUAGE plpgsql;

SELECT precio_producto('11-11111111-1');


/*15) Realice un trigger que antes de guardar un nuevo detalle de pedido con un producto cuyo
    precio sea superior a $10.000,00; le aplique un porcentaje descuento a 10% (valor a
    guardar en la columna respectiva). */

CREATE OR REPLACE FUNCTION verificar_precio() RETURNS TRIGGER AS
$$

BEGIN 
	IF (SELECT pr.precio_producto FROM producto pr WHERE pr.cod_producto=NEW.cod_producto)>10000 THEN
		NEW.porcentaje_descuento=10.00;
	END IF;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER descuento_trigger BEFORE INSERT ON detalle_pedido
FOR EACH ROW EXECUTE FUNCTION verificar_precio();

 SELECT * FROM detalle_pedido
INSERT INTO detalle_pedido values(6,444,1,0);

/*
16) Realice la creación de la tabla “Pedidos Pendientes” con los siguientes campos: código
    pedido, nombre cliente, nombre empleado, nombre compania, fecha pedido. Crear un
    trigger que luego de insertar un pedido sin fecha de envío, le asigne la fecha actual, guarde
    sus datos en la tabla “Pedidos Pendientes”. 
*/
DROP TABLE pedidos_pendientes

CREATE TABLE pedidos_pendientes(
	codigo_pedido integer,
	nombre_cliente varchar(30),
	nombre_empleado varchar(30),
	nombre_compania varchar(30),
	fecha_pedido date
);

CREATE OR REPLACE FUNCTION verificar_fecha() RETURNS TRIGGER AS
$$
DECLARE 
	nombre_c varchar(30):='';
	nombre_emp varchar(30):='';
	nombre_comp varchar(30):='';
	fecha date;
BEGIN
	fecha:=NEW.fecha_pedido;
	IF NEW.fecha_pedido IS NULL THEN
		UPDATE pedido SET fecha_pedido=current_date WHERE cod_pedido=NEW.cod_pedido;
		fecha:=current_date;
	END IF;
	
	nombre_c:=(SELECT nombre_cliente FROM cliente where cod_cliente=NEW.cod_cliente);
	nombre_emp:=(SELECT nombre_empleado FROM empleado where cod_empleado= NEW.cod_empleado);
	nombre_comp:=(SELECT nombre_compania FROM compania_envio where cod_compania=NEW.cod_compania);
	
	INSERT INTO pedidos_pendientes values(new.cod_pedido,nombre_c,nombre_emp,nombre_comp,fecha);
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER insertar_fecha AFTER INSERT ON pedido
FOR EACH ROW EXECUTE FUNCTION verificar_fecha();

SELECT * FROM pedido
SELECT * FROM pedidos_pendientes
INSERT INTO pedido VALUES(13,2002,2810,20,null,'2021-10-05','Direccion6');


/*
17) Realice un trigger que guarde un registro en una tabla AuditoriaProducto (Codigo de
    Producto, Nombre de producto, Precio de Producto, Tipo de Operacion cuyos valores
    serán 'Nuevo', 'Modificado' o ‘Eliminado’) cada vez que se crea, actualiza o elimina un
    Producto. Debe crear la tabla AuditoriaProducto previamente sin clave primaria. 
*/

/*
18) Realice un trigger que guarde un registro en una tabla AuditoriaProducto (creada en el
    punto anterior) cada vez que se agregue un producto cuyo precio sea mayor a $50.000,00.
    En este caso en Tipo de operación debe guardarse “NuevoProductoDeLujo”.
*/
