/*************************************************
    --Creacion de script crea base de datos vacunas
    --Creado por: Pedro Aguirre Arias
    --Fecha creacion: 10/06/2021
    --Fecha modificación: 
    --version: 01
	--Motor: BASE DE DATOS DERBY
**************************************************/

CREATE TABLE ENFERMEDADES (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(50),
    descripcion VARCHAR(200),
    CONSTRAINT enfermedades_pk_id PRIMARY KEY(id)
);

CREATE TABLE ENFERMEDAD_VACUNAS (
    id_enfermedad INTEGER NOT NULL,
    id_vacuna INTEGER,
    CONSTRAINT enfermedad_vacunas_pk_id PRIMARY KEY(id_enfermedad)
);

CREATE TABLE VACUNAS (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nombre VARCHAR(50),
    descripcion VARCHAR(200),
    CONSTRAINT vacunas_pk_id PRIMARY KEY(id)
);

CREATE TABLE DOSIS (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    valor_tiempo INTEGER,
    unidad_tiempo VARCHAR(1),
    id_vacuna INTEGER,
    CONSTRAINT dosis_pk_id PRIMARY KEY(id)
);

CREATE TABLE DOSIS_APLICADA (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    fecha_aplicacion DATE,
    id_historial INTEGER,
    id_dosis INTEGER,
    CONSTRAINT dosis_aplicada_pk_id PRIMARY KEY(id)
);

CREATE TABLE HISTORIAL (
    fecha_creacion DATE,
    id_persona INTEGER,
    CONSTRAINT historial_pk_id PRIMARY KEY(id_persona)
);

CREATE TABLE PERSONAS (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    documento VARCHAR(10),
    tipo_documento VARCHAR(1),
    primer_nombre VARCHAR(50),
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50),
    segundo_apellido VARCHAR(50),
    fecha_nacimiento DATE,
    sexo VARCHAR(1),
    CONSTRAINT personas_pk_id PRIMARY KEY(id)
);

CREATE TABLE FAMILIARES (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    id_persona_padre INTEGER,
    id_persona_hijo INTEGER,
    CONSTRAINT familiares_pk_id PRIMARY KEY(id)
);

-- Create FKs
ALTER TABLE
    ENFERMEDAD_VACUNAS
ADD
    FOREIGN KEY (id_enfermedad) REFERENCES ENFERMEDADES(id);

ALTER TABLE
    ENFERMEDAD_VACUNAS
ADD
    FOREIGN KEY (id_vacuna) REFERENCES VACUNAS(id);

ALTER TABLE
    DOSIS_APLICADA
ADD
    FOREIGN KEY (id_historial) REFERENCES HISTORIAL(id_persona);

ALTER TABLE
    DOSIS_APLICADA
ADD
    FOREIGN KEY (id_dosis) REFERENCES DOSIS(id);

ALTER TABLE
    DOSIS
ADD
    FOREIGN KEY (id_vacuna) REFERENCES VACUNAS(id);

ALTER TABLE
    FAMILIARES
ADD
    FOREIGN KEY (id_persona_padre) REFERENCES PERSONAS(id);

ALTER TABLE
    FAMILIARES
ADD
    FOREIGN KEY (id_persona_hijo) REFERENCES PERSONAS(id);

ALTER TABLE
    HISTORIAL
ADD
    FOREIGN KEY (id_persona) REFERENCES PERSONAS(id);
