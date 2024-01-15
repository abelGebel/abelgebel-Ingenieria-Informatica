
--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------
--------------------TP5---------------------------------------------------------------



--Punto 1
 
/*Realice una función que reciba como parámetro la descripción curso y devuelva la 
cantidad de alumnos inscriptos en ese curso. */

CREATE OR REPLACE FUNCTION mostrarCantAluCurso(descripcion varchar(20)) RETURNS integer AS
$$
DECLARE
	nroAluCurso integer :=0;
BEGIN
	nroAluCurso:= (SELECT SUM (cantidad_alumno) FROM profesor_curso 
				   WHERE cod_curso =
				   (SELECT cod_curso FROM curso 
					WHERE descrip_curso=descripcion));
	RETURN nroAluCurso;
END;
$$
LANGUAGE plpgsql;

-- Para probar que funciona
SELECT * FROM curso 
SELECT * FROM profesor_curso
SELECT mostrarCantAluCurso('Inglés Básico')



--2) Realice una función que reciba como parámetro el apellido del profesor y devuelva el
--   monto total cobrado según el precio de cursos que dicta.

CREATE OR REPLACE FUNCTION monto_cobrado_profesor (apellido varchar(20)) RETURNS  numeric (12,2) AS
$$
DECLARE
	monto numeric(12,2):=0;
BEGIN
	monto := (SELECT SUM(c.precio_curso) FROM curso c join profesor_curso pc 
			  on pc.cod_curso=c.cod_curso WHERE c.cod_curso IN
			  (SELECT cod_curso FROM profesor_curso WHERE leg_profesor=
			  (SELECT leg_profesor FROM profesor where apellido_profesor=apellido)));
	RETURN monto;
END;
$$
LANGUAGE plpgsql;

SELECT monto_cobrado_profesor('Zerpa')

select * from curso order by cod_curso 



--PUNTO 3

/*Realice una función que reciba como parámetros el “Nombre Área Curso”, cargue el cursor 
con los datos de los profesores que están en esa área de curso, lea el cursor y grabe 
dichos datos en la tabla “profesor_por_area”*/

CREATE TABLE profesor_por_area (
    leg_profesor integer,
    apellido_profesor varchar(15),
    nombre_area_curso varchar(15)
	--CONSTRAINT unico_legajo_area UNIQUE (leg_profesor, nombre_area_curso)
	);

CREATE OR REPLACE FUNCTION profePorArea(area_curso_parm varchar(15)) RETURNS VOID AS
$$
DECLARE
    profesor_record profesor%ROWTYPE; -- Nos aseguramos que profesor_record tenga las mismas columnas y tipos de datos que la tabla profesor 
	Cur_Profesor CURSOR FOR
				SELECT *
				FROM profesor p
				WHERE EXISTS (
					SELECT 1 
					FROM profesor_curso pc
					JOIN curso c ON pc.cod_curso = c.cod_curso
					JOIN area_curso ac ON c.cod_area = ac.cod_area
					WHERE p.leg_profesor = pc.leg_profesor
					AND ac.nombre_area = area_curso_parm);
BEGIN
    OPEN Cur_Profesor;-- Abrimos el cursor
    LOOP-- Leemos y procesamos los registros del cursor
        FETCH NEXT FROM Cur_Profesor INTO profesor_record;
        EXIT WHEN NOT FOUND; -- Salir del bucle cuando no haya más registros

        -- Insertamos cada registro en la tabla profesor_por_area
        INSERT INTO profesor_por_area (leg_profesor, apellido_profesor, nombre_area_curso)
        VALUES (profesor_record.leg_profesor, profesor_record.apellido_profesor, area_curso_parm);
		--ON CONFLICT (leg_profesor, nombre_area_curso) DO NOTHING; -- Con esto evitamos que hayan registros repetidos
    END LOOP;
	
    CLOSE Cur_Profesor;-- Cerramos el cursor
END;
$$
LANGUAGE plpgsql;

-- Para probar que funciona
select * from profesor_por_area
select profePorArea('Informática')
select profePorArea('Idioma')
select * from profesor_por_area

DELETE FROM profesor_por_area

--4) Realice una función que reciba como parámetros una “Fecha inscripción desde” y una
--   “Fecha inscripcion hasta”, cargue el cursor con los datos de la inscripción, lea el cursor y
--   grabe dichos datos en la tabla “resumen_inscripcion”

CREATE OR REPLACE FUNCTION datos_inscripcion(fecha_desde date,fecha_hasta date) RETURNS VOID AS 
$$
DECLARE 
	inscripcion_record inscripcion%ROWTYPE;
		Cur_inscripcion CURSOR FOR
				SELECT *
				FROM inscripcion i
				WHERE i.fecha_inscripcion > fecha_desde and i.fecha_inscripcion < fecha_hasta;
BEGIN
	OPEN Cur_inscripcion;
	LOOP 
		FETCH NEXT FROM Cur_inscripcion INTO inscripcion_record;
		EXIT WHEN NOT FOUND;
		
		INSERT INTO resumen_inscripcion (nro_inscripcion, fecha_inscripcion, dni_alumno,cod_curso,forma_pago)
        VALUES (inscripcion_record.nro_inscripcion,inscripcion_record.fecha_inscripcion,inscripcion_record.dni_alumno,inscripcion_record.cod_curso,inscripcion_record.forma_pago);
	END LOOP;
    CLOSE Cur_inscripcion;
END;
$$
LANGUAGE plpgsql;


create table resumen_inscripcion (
	nro_inscripcion integer,
	fecha_inscripcion date,
	dni_alumno integer,
	cod_curso varchar(2),
	forma_pago varchar (1)
);
select datos_inscripcion('06/09/2023','07/09/2023');
SELECT * FROM resumen_inscripcion;
DELETE FROM resumen_inscripcion



-- Punto 5

/*
Realice una función que reciba como parámetro el Código Curso, cargue un cursor con los 
datos del curso “profesor_curso”, luego debe abrir el cursor, y calcular el precio por cada 
producto (Precio Curso * Cantidad Alumno), sume el total y cargue la variable que será 
devuelta por la función.
*/


CREATE OR REPLACE FUNCTION calculoPrecioTotal(codigo_curso_parm varchar(2)) RETURNS numeric(12,2) AS
$$
DECLARE
	precio_total numeric(12,2):=0;
	curso_record record;
	cur_Curso CURSOR FOR
			SELECT c.precio_curso, pc.cantidad_alumno
			FROM profesor_curso pc
			JOIN curso c ON pc.cod_curso=c.cod_curso
			WHERE pc.cod_curso=codigo_curso_parm;
BEGIN
    OPEN cur_Curso;-- Abrimos el cursor
   
    LOOP -- Leemos y procesamos los registros del cursor
        FETCH NEXT FROM cur_Curso INTO curso_record;
        EXIT WHEN NOT FOUND; -- Salir del bucle cuando no haya más registros
        precio_total:=precio_total + (curso_record.precio_curso * curso_record.cantidad_alumno);
    END LOOP;

    -- Cerramos el cursor
    CLOSE cur_Curso;
	RETURN precio_total;
END;
$$
LANGUAGE plpgsql;

-- Para probar que funciona
select * from curso
select * from profesor_curso
select calculoPrecioTotal('C3')

-- PUNTO 6
/*
Realice un trigger que antes de guardar un nuevo registro en profesor_curso, cuando el
nombre de curso es “inglés básico”, la cantidad de alumnos permitida en ese curso es
hasta 15 alumnos inclusive. 
*/

CREATE OR REPLACE FUNCTION validar_cantidad_alumnos() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.cod_curso = (select c.cod_curso from curso c where c.descrip_curso='Inglés Básico') AND NEW.cantidad_alumno > 15 THEN
        RAISE EXCEPTION 'La cantidad de alumnos permitida para el curso "inglés básico" es de hasta 15 alumnos.';
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER validar_cantidad_alumnos_trigger BEFORE INSERT ON profesor_curso
FOR EACH ROW EXECUTE FUNCTION validar_cantidad_alumnos();

SELECT * FROM profesor_curso
insert into profesor_curso (leg_profesor,cod_curso,cantidad_alumno) values (1002, 'C2', 111)



-- PUNTO 7
/*
Realice un trigger que guarde un registro en la tabla histórico_precio_curso (codigo de 
curso, descripción curso, precio de curso, fecha de modificación), cada vez que se actualiza 
el precio de curso. Debe crear la tabla histórico_precio_curso previamente sin clave 
primaria. 
*/

CREATE TABLE historico_precio_curso (
	cod_curso varchar(2), 
	descrip_curso varchar(20),
	precio_curso integer, 
	fecha_modificacion date
	);

CREATE OR REPLACE FUNCTION actualizacionPrecioCurso() RETURNS TRIGGER AS 
$$
BEGIN
  	INSERT INTO historico_precio_curso(cod_curso, descrip_curso, precio_curso, fecha_modificacion)
	VALUES (OLD.cod_curso, OLD.descrip_curso, OLD.precio_curso, NOW());
	RETURN NEW;
END;
$$ 
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER registro_precio AFTER UPDATE OF precio_curso
    ON curso FOR EACH ROW EXECUTE PROCEDURE actualizacionPrecioCurso();
	
-- Para probar que funciona
SELECT * FROM curso
UPDATE curso SET precio_curso=20000 WHERE cod_curso='C1'
UPDATE curso SET descrip_curso='Inglés Básico' WHERE cod_curso='C1'
SELECT * FROM curso
SELECT * FROM historico_precio_curso
DELETE FROM historico_precio_curso



-- PUNTO 8
/*
Realice un trigger que permita sumar el precio_curso cada vez que se ingresa un registro a
la tabla Curso cuyo campo “Descripcion Curso” sea “Mongo DB”. Debe crear la tabla
“curso_mongo” con los campos “nombre” y “precio_total”. El campo “nombre” tiene como
valor “Mongo DB” y el campo “precio_total” se actualiza cada vez que se ingresa un nuevo
registro a la tabla Curso.
*/

CREATE TABLE curso_mongo (
    nombre varchar(30),
    precio_total numeric(10,2)
);

CREATE OR REPLACE FUNCTION actualizar_precio_total() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.descrip_curso = 'Mongo DB' THEN
        UPDATE curso_mongo SET precio_total = precio_total + NEW.precio_curso WHERE nombre = 'Mongo DB';
        IF NOT FOUND THEN
            INSERT INTO curso_mongo (nombre, precio_total) VALUES ('Mongo DB', NEW.precio_curso);
        END IF;
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER OR REPLACE actualizar_precio_total_trigger AFTER INSERT ON curso
FOR EACH ROW EXECUTE FUNCTION actualizar_precio_total();

SELECT * FROM curso_mongo
SELECT * FROM curso
insert into curso (cod_curso,precio_curso,descrip_curso,cod_area) values ('C5', 100, 'Mongo DB','INF')
insert into curso (cod_curso,precio_curso,descrip_curso,cod_area) values ('C6', 100, 'Mongo DB','INF')
