create database AkiToy;

use Akitoy;

create table producto(
id int(11) auto_increment,
nombre varchar(150) default null,
precio_venta int default null,
marca varchar (150) default null,
linea varchar (150) default null,
categoria varchar (150) default null,
primary key(id)
);

select * from producto;

CREATE TABLE rol (
  rol_id int(11) NOT NULL AUTO_INCREMENT,
  rol_nombre varchar(255) DEFAULT NULL,
  rol_descripcion varchar(255) DEFAULT NULL,
  PRIMARY KEY (rol_id)
);

INSERT INTO rol VALUES (1,'ADMIN','Usuario con maximos privilegios');
INSERT INTO rol VALUES (2,'USER','Usuario basico');

CREATE TABLE usuario (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  nombres varchar(255) NOT NULL,
  apellidos varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  status varchar(255),
  PRIMARY KEY (user_id)
);

CREATE TABLE usuario_rol (
  user_id int(11) NOT NULL,
  rol_id int(11) NOT NULL,
  PRIMARY KEY (user_id,rol_id),
  KEY FK_user_rol (rol_id),
  CONSTRAINT FK_auth_user FOREIGN KEY (user_id) REFERENCES usuario (user_id),
  CONSTRAINT FK_auth_user_role FOREIGN KEY (rol_id) REFERENCES rol (rol_id)
) ;

insert into usuario (user_id,nombres,apellidos,email,password,status) values (1,'Juan','Niño','admin@idat.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED');
insert into usuario_rol (user_id, rol_id) values ('1','1');
insert into usuario_rol (user_id, rol_id) values ('1','2');

