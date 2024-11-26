drop database if exists constancias;
create database constancias default character set utf8mb4;
use constancias;

create table tipos_cuenta(
    id_tipo_cuenta int not null auto_increment,
    tipo varchar(64) not null,
    primary key (id_tipo_cuenta)
);

create table cuentas(
    id_cuenta int not null auto_increment,
    id_tipo_cuenta int not null,
    email varchar(64) not null,
    contrasena varchar(64) not null,
    no_trabajador int not null,
    primary key (id_cuenta),
    unique (id_cuenta)
);

create table administrativos(
    id_administrativo int not null auto_increment,
    id_cuenta int not null,
    nombre varchar(64) not null,
    apellidos varchar(64) not null,
    telefono varchar(10) not null,
    primary key (id_administrativo),
    unique (id_administrativo)
);

create table docentes(
    id_docente int not null auto_increment,
    id_cuenta int not null,
    nombre varchar(64) not null,
    apellidos varchar(64) not null,
    telefono varchar(64) not null,
    firma_digital varchar(64),
    unique (id_docente)
);

create table tipo_constancias(
    id_tipo_constancias int not null auto_increment,
    nombre varchar(64) not null,
    primary key (id_tipo_constancias),
    unique (id_tipo_constancias)
);

create table solicitudes(
    id_solicitud int not null auto_increment,
    id_tipo_constancia int not null,
    id_docente int not null,
    fecha_solicitud date not null,
    unique (id_solicitud)
);

create table docentes_ee(
    id int not null auto_increment,
    id_docente int not null,
    id_ee int not null,
    primary key (id)
);

create table experiencias_educativas(
    id_ee int not null auto_increment,
    nombre varchar(128) not null,
    primary key (id_ee)
);

alter table cuentas
    add constraint fk_cuentas_tipos_cuenta
        foreign key (id_tipo_cuenta) references tipos_cuenta(id_tipo_cuenta)  on delete cascade on update cascade;

alter table administrativos
    add constraint fk_administrativos_cuentas
        foreign key (id_cuenta) references cuentas(id_cuenta) on delete cascade on update cascade;

alter table docentes
    add constraint fk_docentes_cuentas
        foreign key (id_cuenta) references cuentas(id_cuenta) on delete cascade on update cascade;

alter table solicitudes
    add constraint fk_solicitudes_tipo_constancias
        foreign key (id_tipo_constancia) references tipo_constancias(id_tipo_constancias);

alter table solicitudes
    add constraint fk_solicitudes_docentes
        foreign key (id_docente) references docentes(id_docente);

alter table docentes_ee
    add constraint fk_docentes_ee_docentes
        foreign key (id_docente) references docentes(id_docente) on delete cascade on update cascade;

alter table docentes_ee
    add constraint fk_docentes_ee_ee
        foreign key (id_ee) references experiencias_educativas(id_ee) on delete cascade on update cascade;

insert into tipos_cuenta(tipo) values ('administrativo');
insert into tipos_cuenta(tipo) values ('docente');

insert into tipo_constancias(nombre) values ('Jurado')
,('Impartición de EE')
,('Proyecto')
,('PLADEA');

INSERT INTO experiencias_educativas (nombre) VALUES
('Bases de Datos Relacionales'),
('Sistemas Operativos'),
('Inteligencia Artificial'),
('Cálculo Integral'),
('Introducción a Redes');

INSERT INTO cuentas (id_tipo_cuenta, email, contrasena, no_trabajador) VALUES
(2, 'docente1@example.com', 'aaa', 2003),
(2, 'docente2@example.com', 'aaa', 2004),
(2, 'docente3@example.com', 'aaa', 2005);

INSERT INTO docentes (id_cuenta, nombre, apellidos, telefono, firma_digital) VALUES
(1, 'Chris', 'Taylor', '5553334455', 'signature3'),
(2, 'Jessica', 'Williams', '5554445566', 'signature4'),
(3, 'Daniel', 'Moore', '5555556677', NULL);

INSERT INTO solicitudes (id_tipo_constancia, id_docente, fecha_solicitud) VALUES
(1, 1, '2024-11-01'),
(2, 1, '2024-11-02'),
(3, 1, '2024-11-03'),
(2, 1, '2024-11-04'),
(4, 1, '2024-11-05');

INSERT INTO docentes_ee (id_docente, id_ee) VALUES
(1, 1), -- Alice teaches Bases de Datos Relacionales
(1, 2), -- Alice teaches Sistemas Operativos
(2, 3), -- Bob teaches Inteligencia Artificial
(3, 4), -- Chris teaches Cálculo Integral
(1, 5), -- Jessica teaches Introducción a Redes
(3, 1), -- Daniel teaches Bases de Datos Relacionales
(2, 3); -- Daniel teaches Inteligencia Artificial