create table alumno (
	dni_alumno integer primary key,
	apellido_alumno varchar(15)
);
create table profesor (
	leg_profesor integer primary key,
	apellido_profesor varchar(15)
);
create table area_curso (
	cod_area varchar(3) primary key,
	nombre_area varchar(20)
);
create table curso (
	cod_curso varchar(2) primary key,
	precio_curso numeric(12,2),
	descrip_curso varchar(30),
	cod_area varchar(3) references area_curso (cod_area)
);
create table inscripcion (
	nro_inscripcion integer primary key,
	fehca_inscripcion date,
	dni_alumno integer references alumno (dni_alumno),
	cod_curso varchar(2) references curso (cod_curso)
);
create table profesor_curso (
	leg_profesor integer,
	cod_curso varchar(2),
	primary key (leg_profesor,cod_curso),
	cantidad_alumno integer,
	foreign key (leg_profesor) references profesor (leg_profesor),
	foreign key (cod_curso) references curso (cod_curso)
);
--3) Inserte en cada tabla los registros utilizados en el ejemplo.

ALTER TABLE inscripcion RENAME COLUMN fehca_inscripcion TO fecha_inscripcion;



insert into alumno (dni_alumno,apellido_alumno) values 
(11111111,'Álvarez'),
(22222222,'Rodríguez'),
(33333333,'Fernández'),
(44444444,'Velázquez');

insert into profesor (leg_profesor,apellido_profesor) values 
(1001,'Arias'),
(1002,'Zerpa'),
(1003,'Solis');

insert into area_curso (cod_area,nombre_area) values 
('IDI','Idioma'),
('INF','Informática');

insert into curso (cod_curso,precio_curso,descrip_curso,cod_area) values 
('C1',80000.00, 'Inglés Básico', 'IDI'),
('C2', 90000.00, 'Francés Básico', 'IDI'),
('C3', 50000.00, 'SQL Server', 'INF'),
('C4', 80000.00, 'Mongo DB', 'INF');

insert into inscripcion (nro_inscripcion,fecha_inscripcion,dni_alumno,cod_curso) values 
(501, '04/09/2023', 11111111, 'C1'),
(502, '04/09/2023', 22222222, 'C1'), 
(503, '05/09/2023', 33333333, 'C3'),
(504, '05/09/2023', 11111111, 'C4'), 
(505, '06/09/2023', 33333333, 'C2');

insert into profesor_curso (leg_profesor,cod_curso,cantidad_alumno) values 
(1001, 'C1', 10),
(1002, 'C3', 15),
(1002, 'C4', 20),
(1001, 'C2', 8),
(1003, 'C1', 15),
(1003, 'C3', 20);

Alter table alumno add domicilio varchar (30)
alter table inscripcion add forma_pago varchar (1) check (forma_pago='C' or forma_pago='T');

update alumno set domicilio = 'Alvear 209 Centro' where dni_alumno =11111111;
update alumno set domicilio = 'Lavalle 119 Centro' where dni_alumno =22222222;
update alumno set domicilio = 'Ramirez de Velazco 201 Centro' where dni_alumno =33333333;
update alumno set domicilio = 'Gorriti 404 Centro' where dni_alumno =44444444;

update inscripcion set forma_pago = 'C' where nro_inscripcion = 501;
update inscripcion set forma_pago = 'T' where nro_inscripcion = 502;
update inscripcion set forma_pago = 'T' where nro_inscripcion = 503;
update inscripcion set forma_pago = 'C' where nro_inscripcion = 504;
update inscripcion set forma_pago = 'C' where nro_inscripcion = 505;

--7)Modifique el tamaño del campo “domicilio” de carácter de 30 a carácter de 40.

alter table alumno alter column domicilio type varchar (40);
select * from alumno

--9) Borre un registro de alumno que no esté referenciado en otra tabla.

delete from alumno where dni_alumno = 44444444;
select * from alumno

--12) Muestre las inscripciones realizadas entre el 05/09/2023 y el 06/09/2023 inclusive,
--    ordenadas por el DNI del alumno en orden ascendente.

select * from inscripcion where fecha_inscripcion >= '05/09/2023' and fecha_inscripcion <='06/09/2023'
order by dni_alumno asc;

--13) Muestre todos los campos de inscripción y alumno en una sola consulta relacionada.
--    Realice una segunda consulta donde no se presente repetición de campos.

select * from inscripcion, alumno
select * from inscripcion i, alumno a where i.dni_alumno = a.dni_alumno; 

--14) Muestre todos los campos de inscripción, alumno y curso en una sola consulta relacionada. 
--    En el resultado de la consulta no deben existir campos repetidos.

select * from alumno a, curso c, inscripcion i where a.dni_alumno = i.dni_alumno and 
c.cod_curso = i.cod_curso

--15) Muestre el “dni_alumno” y el “cod_ curso” realizados el día 05/09/2023.

select i.fecha_inscripcion,i.dni_alumno,i.cod_curso from inscripcion i where fecha_inscripcion='05/09/2023';

--16) Utilizando subconsulta muestre el ”apellido_alumno” de los alumnos que realizaron alguna inscripción.

select a.apellido_alumno from alumno a where a.dni_alumno in (select dni_alumno from inscripcion)


--17) Utilizando subconsulta muestre los registros de la tabla profesor_curso correspondiente al
--    profesor “”Solis”.

select * from profesor_curso pc where pc.leg_profesor = 
(select leg_profesor from profesor where apellido_profesor='Solis') 


--18) Utilizando subconsulta muestre la tabla profesor_curso correspondiente al área del curso “Informática”.

select * from profesor_curso pc where pc.cod_curso in 
(select cod_curso from curso where cod_area = 
(select cod_area from area_curso where nombre_area ='Informática'))

--19) Utilizando subconsulta muestre el “nro_inscripcion” y la “fecha_inscripcion” para el alumno
--    “Alvarez” correspondiente al nombre de área del curso “Idioma”.

select nro_inscripcion, fecha_inscripcion from inscripcion i where i.dni_alumno = 
(select dni_alumno from alumno where apellido_alumno='Álvarez')

--20) Realice una vista denominada “v_profesor_curso” que muestre los datos relacionados de
--    profesor y curso.

create view v_profesor_curso as 
select pc.leg_profesor, p.apellido_profesor, pc.cod_curso, c.precio_curso, c.descrip_curso, c.cod_area 
from profesor p, curso c, profesor_curso pc 
where p.leg_profesor = pc.leg_profesor and c.cod_curso = pc.cod_curso

select * from v_profesor_curso

--21) Cree una vista denominada “v_inscripcion” que muestre los datos del alumno y los cursos
--    en los que se encuentra inscripto.

create view v_inscripcion as 
select i.dni_alumno, a.apellido_alumno,  i.cod_curso,  c.precio_curso, c.descrip_curso, c.cod_area 
from inscripcion i, alumno a, curso c where i.dni_alumno = a.dni_alumno and i.cod_curso = c.cod_curso
select * from v_inscripcion

--22) Muestre el número de registros que contiene la tabla profesor_curso.

select count(leg_profesor) from profesor_curso
select count(*) from profesor_curso

--23) Muestre el máximo “precio_curso” de los cursos.

select max(precio_curso) from curso

--24) Muestre el promedio del “precio_curso”.

select avg(precio_curso) from curso

--25) Muestre el importe total (precio_curso*cantidad_alumno) para todos los cursos.

SELECT c.descrip_curso, SUM(pc.cantidad_alumno)*c.precio_curso AS importe
FROM curso c,profesor_curso pc WHERE pc.cod_curso=c.cod_curso
GROUP BY pc.cod_curso,c.cod_curso;

--26) Muestre el importe total (precio_curso*cantidad_alumno) para el curso “Francés Básico” y
--    considere aplicar un descuento del 10%.

select c.descrip_curso,SUM(pc.cantidad_alumno)*c.precio_curso*0.90 
as importe_total from curso c, profesor_curso pc 
where pc.cod_curso=c.cod_curso and pc.cod_curso=(select c.cod_curso where c.descrip_curso='Francés Básico') 
GROUP BY c.cod_curso,pc.cod_curso

--27) Muestre el importe total (pu_practica*cantidad) para cada “cod_curso” ordenado de forma ascendente.

select c.cod_curso,SUM(pc.cantidad_alumno)*c.precio_curso as importe_total from curso c, profesor_curso pc 
where pc.cod_curso = c.cod_curso GROUP BY c.cod_curso,pc.cod_curso
order by importe_total asc

--28) Muestre los alumnos que se inscribieron al curso “Ingles Básico”.

select i.dni_alumno, a.apellido_alumno from inscripcion i, alumno a where i.dni_alumno=a.dni_alumno and i.cod_curso=
(select c.cod_curso from curso c where c.descrip_curso='Inglés Básico'); 

--29) Muestre la descripción de los cursos que dicta el profesor “Arias” y al que asiste el alumno “Rodríguez”.

select c.descrip_curso from curso c where c.cod_curso in 
(select i.cod_curso from inscripcion i where i.dni_alumno=
(select a.dni_alumno from alumno a where a.apellido_alumno='Rodríguez')) 
and c.cod_curso in (select pc.cod_curso from profesor_curso pc where pc.leg_profesor= 
(select p.leg_profesor from profesor p where p.apellido_profesor = 'Arias'))


--30) Utilice subconsultas y muestre el “nombre_area” del curso en el que se encuentra el
--    profesor “Zerpa”.

select ac.nombre_area from area_curso ac where ac.cod_area in
(select c.cod_area from curso c where c.cod_curso in
(select pc.cod_curso from profesor_curso pc where pc.leg_profesor =
(select p.leg_profesor from profesor p where p.apellido_profesor = 'Zerpa')))


--31) Utilice subconsultas y muestre la descripción de los cursos en los que se inscribió el alumno “Fernández”.
SELECT c.descrip_curso FROM curso c
WHERE cod_curso IN
	(SELECT i.cod_curso FROM inscripcion i WHERE i.dni_alumno=
	(SELECT a.dni_alumno FROM alumno a WHERE apellido_alumno='Fernández'));
	
	
--32) Muestre la cantidad de alumnos que se inscribieron al curso “Mongo DB”.
SELECT COUNT(*) FROM inscripcion
WHERE cod_curso=
(SELECT cod_curso FROM curso WHERE descrip_curso='Mongo DB');

--33) Muestre el total pagado por los cursos que realiza el alumno “Álvarez”.
SELECT SUM(precio_curso) FROM curso
WHERE cod_curso IN
(SELECT cod_curso FROM inscripcion WHERE dni_alumno=
(SELECT dni_alumno FROM alumno WHERE apellido_alumno='Álvarez'));


--34) Muestre el apellido del profesor junto con la cantidad de cursos que este dicta.
SELECT apellido_profesor, count(cod_curso)
FROM profesor AS p JOIN profesor_curso AS pc ON p.leg_profesor=pc.leg_profesor
GROUP BY apellido_profesor;


--35) Muestre el apellido del profesor junto con el precio total de los cursos que dicta.
SELECT apellido_profesor, SUM(precio_curso)
FROM profesor p
INNER JOIN profesor_curso pc ON p.leg_profesor=pc.leg_profesor
INNER JOIN curso c ON pc.cod_curso=c.cod_curso
GROUP BY apellido_profesor;