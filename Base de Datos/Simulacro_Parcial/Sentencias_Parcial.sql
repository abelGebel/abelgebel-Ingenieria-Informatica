
/*
Cree la base de datos que tiene por nombre ApellidoNombre_LU y sus correspondientes tablas en el orden que
corresponda, incorporando las la/s clave/s foránea/s en la/s tabla/s respectivas.
 _Inserte todos los registros que figuran en cada una de las tablas.
 _A partir de la base de datos creada realice los siguientes ejercicios:
 */
 
CREATE DATABASE ApellidoNombre_LU;

CREATE TABLE Nivel(
	Cod_Nivel varchar(3) primary key,
	Nom_Nivel varchar(50),
	Duracion integer
);

CREATE TABLE Profesor(
	Legajo integer primary key,
	Nombre Varchar(50)
);

CREATE TABLE Alumno(
	DNI integer primary key,
	Nom_Alumno varchar(50),
	Domicilio varchar(50)
);

CREATE TABLE Idioma(
	Cod_Idioma varchar(2) primary key,
	Nom_Idioma varchar(50),
	Precio numeric(12,2),
	Cod_Nivel varchar(3),
	foreign key (Cod_Nivel) references Nivel (Cod_Nivel)
);

CREATE TABLE Clase(
	DNI integer,
	Cod_Idioma varchar(2),
	Legajo integer,
	Dia date,
	Aula integer,
	primary key(DNI,Cod_Idioma,Legajo),
	foreign key (DNI) references Alumno (DNI),
	foreign key (Cod_Idioma) references Idioma(Cod_Idioma),
	foreign key (Legajo) references Profesor(Legajo)
);

INSERT INTO Nivel(Cod_Nivel,Nom_Nivel,Duracion) VALUES
('BAS', 'Básico', 6), 
('INT', 'Intermedio', 3),
('AVA', 'Avanzado', 2);

INSERT INTO Profesor(Legajo,Nombre) VALUES
(87, 'Castro'), 
(88, 'Ferreyra'), 
(89, 'Juarez');

INSERT INTO Alumno (DNI,Nom_Alumno,Domicilio) VALUES
(111, 'Maria Rocha', 'Dom111'),
(222, 'Juan Perez', 'Dom222'),
(333, 'Pedro Paz', 'Dom333'),
(444, 'Rosa Quispe', 'Dom444');

INSERT INTO Idioma(Cod_Idioma,Nom_Idioma,Precio,Cod_Nivel) VALUES
('IN', 'Inglés', 1200.00, 'AVA'),
('FR', 'Francés', 1100.00, 'INT'),
('PO', 'Portugués', 1000.00, 'BAS'),
('AL', 'Alemán', 1000.00, 'BAS');

INSERT INTO Clase(DNI,Cod_Idioma,Legajo,Dia,Aula) VALUES
(111, 'IN', 87, '25/10/2019', 13),
(222, 'PO', 88, '26/10/2019', 11),
(111, 'FR', 89, '26/10/2019', 12),
(444, 'IN', 87, '28/10/2019', 11),
(333, 'AL', 89, '28/10/2019', 13);

--Ejercicio A:
--1) Utilice pareo de tablas y muestre la cantidad de idiomas que dicta cada profesor, 
--   agrupados por nombre de profesor.

SELECT p.nombre, COUNT(c.Cod_Idioma) FROM Profesor p, Clase c Where p.Legajo=c.Legajo GROUP BY p.nombre

--2) Utilice inner join y muestre la duración, el nombre de nivel, el nombre del idioma 
--   y el precio de las clases dictadas el día 26/10/2019.

--SELECT (n.Duracion,n.Nom_Nivel,i.Nom_Idioma,i.Precio) FROM Nivel n JOIN Idioma i ON n.Cod_Nivel=i.Cod_Nivel

SELECT n.Duracion,n.Nom_Nivel,i.Nom_Idioma,i.Precio FROM Nivel n JOIN Idioma i
ON n.Cod_Nivel=i.Cod_Nivel

--3) Utilice subconsultas y muestre para el profesor “Castro” las aulas donde dicta clases.

SELECT * FROM Clase c WHERE c.Legajo= (SELECT p.Legajo FROM Profesor p WHERE p.Nombre='Castro');


--4) Utilice subconsultas y muestre para el alumno “Maria Rocha” los días y aulas 
--   asignados para su clase de “Inglés”.

SELECT c.Dia, c.Aula FROM Clase c WHERE c.DNI=(SELECT a.DNI FROM Alumno a WHERE Nom_Alumno='Maria Rocha')
AND c.Cod_Idioma = (SELECT i.Cod_Idioma FROM Idioma i WHERE i.Nom_Idioma='Inglés');


--5) Muestre el nombre del profesor y el precio de los idiomas cuyo precio son menores a 1100,00. 

SELECT p.Nombre,sum(i.Precio) FROM Profesor p JOIN Clase c ON p.Legajo=c.Legajo JOIN Idioma i ON 
c.Cod_Idioma=i.Cod_Idioma AND i.Precio<1101 group by p.Nombre



--Ejercicio B:

--6) Realice una función que permita ingresar el Código de idioma y muestre 
--   la cantidad de clases que se dictan para ese idioma.

CREATE OR REPLACE FUNCTION cantidad_clases_idioma(codigo varchar(2)) RETURNS integer AS
$$
DECLARE 
	cantidad_clases integer:=0;

BEGIN
	cantidad_clases = (SELECT COUNT(c.Cod_Idioma) FROM CLASE c WHERE c.Cod_Idioma=codigo);
	RETURN cantidad_clases;
END;
$$
LANGUAGE plpgsql;

SELECT cantidad_clases_idioma('IN');


--7) Realice una función que reciba como parámetro el Legajo de Profesor, cargue un cursor con los 
--   códigos y precios de los idiomas que tiene a su cargo y muestre el total recaudado. 
--   Considere que se realiza el 20% de descuento cuando el idioma es “Alemán”.

CREATE OR REPLACE FUNCTION total_recaudado (legajo_param integer) RETURNS numeric(12,2) AS
$$
DECLARE
	cursor_record record;
	total numeric(12,2):=0;
	Cursor_idioma CURSOR FOR
		SELECT i.Cod_Idioma, i.Precio FROM Idioma i, Clase c WHERE i.Cod_Idioma=c.Cod_Idioma
		AND c.Legajo=legajo_param;
BEGIN
	OPEN Cursor_idioma;
	LOOP
		 FETCH NEXT FROM Cursor_idioma INTO cursor_record;
		 EXIT WHEN NOT FOUND;
		 IF cursor_record.Cod_Idioma=(SELECT Cod_Idioma FROM Idioma WHERE Nom_Idioma='Alemán') THEN
		 	total:=total+cursor_record.Precio*0.8;
		 ELSE
		 	total:=total+cursor_record.Precio;
		 END IF;
	END LOOP;
	CLOSE Cursor_idioma;
	RETURN total;
END;
$$
LANGUAGE plpgsql;
		 
SELECT total_recaudado(89);
		
		
--8) Realice un cursor que reciba como parámetro un “Dia” y guarde el DNI, nombre del idioma,
--   nombre del profesor y nombre del alumno, luego recorra el cursor y muestre el contenido del mismo.

--PREGUNTARRRRRR
DROP FUNCTION dia_de_clase(date)

CREATE OR REPLACE FUNCTION dia_de_clase (dia_param date) RETURNS void AS
$$
DECLARE
	clase_record record;
	cursor_clase CURSOR FOR
		SELECT c.DNI, i.Nom_Idioma, p.Nombre, a.Nom_Alumno FROM Clase c, Idioma i, Profesor p, Alumno a
		WHERE c.Dia = dia_param AND c.DNI = a.DNI AND c.Cod_Idioma = i.Cod_Idioma AND c.Legajo=p.Legajo;
BEGIN
	OPEN cursor_clase;
	LOOP
		FETCH NEXT FROM cursor_clase INTO clase_record;
		EXIT WHEN NOT FOUND;
		RAISE NOTICE 'DNI: %, Idioma: %, Profesor: %, Alumno: %', clase_record.DNI, clase_record.Nom_Idioma, clase_record.Nombre, clase_record.Nom_Alumno;
		
	END LOOP;
	CLOSE cursor_clase;
END;
$$
LANGUAGE plpgsql;

SELECT dia_de_clase('2019-10-26');


--9) Realice un trigger que antes de ingresar una nueva clase verifique que se haya asignado un aula,
--   y si el campo aula está vacío no inserte ese registro y debe mostrar el mensaje 
--   “debe asignar un aula para la clase”.

CREATE OR REPLACE FUNCTION verificar_aula() RETURNS TRIGGER AS
$$
BEGIN
	IF NEW.Aula IS NULL THEN
		RAISE EXCEPTION 'debe asignar un aula para la clase';
	END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER actualizar_clase BEFORE INSERT ON Clase
FOR EACH ROW EXECUTE FUNCTION verificar_aula();

INSERT INTO Clase VALUES (444,'IN',89,'2019-10-26',NULL);
INSERT INTO Clase VALUES (444,'PO',89,'2019-10-26',30);
DELETE FROM Clase where aula is NULL 
SELECT * FROM Clase


/*10)Realice un trigger que luego de insertar un registro en la tabla “clase”, 
inserte un nuevo registro en la tabla “historial_clase”, ésta última tabla posee la misma 
estructura de la tabla “clase”, pero se le adiciona el campo “fecha_registro” de tipo fecha, 
en el cual debe registrar la fecha actual (con current_date puede registrar la fecha del sistema).*/

CREATE TABLE Historial_Clase(
	DNI integer,
	Cod_Idioma varchar(2),
	Legajo integer,
	Dia date,
	Aula integer,
	Fecha_Registro date
)

CREATE OR REPLACE FUNCTION registro_historial() RETURNS TRIGGER AS
$$
BEGIN
	INSERT INTO Historial_Clase VALUES (NEW.DNI,NEW.Cod_Idioma,NEW.Legajo,NEW.Dia,NEW.Aula,current_date);
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER registro_clase_trigger AFTER INSERT ON CLase
FOR EACH ROW EXECUTE FUNCTION registro_historial();

INSERT INTO Clase VALUES (111,'PO',89,'2019-10-25',90);
SELECT * FROM Historial_Clase
