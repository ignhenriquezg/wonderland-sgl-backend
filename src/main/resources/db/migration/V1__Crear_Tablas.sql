-- 1. TABLAS MAESTRAS Y CATÁLOGOS
CREATE TABLE Rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL
);

CREATE TABLE Tematica (
    id_tematica INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tematica VARCHAR(50) NOT NULL,
    descripcion VARCHAR(500)
);

CREATE TABLE Catalogo_Personaje (
    id_personaje INT AUTO_INCREMENT PRIMARY KEY,
    nombre_personaje VARCHAR(100) NOT NULL
);

CREATE TABLE Catalogo_Plato (
    id_plato INT AUTO_INCREMENT PRIMARY KEY,
    nombre_plato VARCHAR(100) NOT NULL,
    descripcion VARCHAR(250)
);

CREATE TABLE Catalogo_Bebida (
    id_bebida INT AUTO_INCREMENT PRIMARY KEY,
    nombre_bebida VARCHAR(100) NOT NULL
);

CREATE TABLE Catalogo_Postre (
    id_postre INT AUTO_INCREMENT PRIMARY KEY,
    nombre_postre VARCHAR(100) NOT NULL
);

CREATE TABLE Insumo (
    id_insumo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    unidad_medida VARCHAR(20) NOT NULL
);

-- 2. RECURSOS HUMANOS Y USUARIOS
CREATE TABLE Personal (
    id_personal INT AUTO_INCREMENT PRIMARY KEY,
    id_rol INT NOT NULL,
    rut VARCHAR(12) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    FOREIGN KEY (id_rol) REFERENCES Rol(id_rol)
);

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    id_personal INT NOT NULL,
    correo VARCHAR(100) NOT NULL,
    password_hash VARCHAR(60) NOT NULL,
    FOREIGN KEY (id_personal) REFERENCES Personal(id_personal)
);

-- 3. MENÚ Y SUS TABLAS INTERMEDIAS
CREATE TABLE Menu (
    id_menu INT AUTO_INCREMENT PRIMARY KEY,
    id_tematica INT NOT NULL,
    nombre_menu VARCHAR(100) NOT NULL,
    precio_base NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (id_tematica) REFERENCES Tematica(id_tematica)
);

CREATE TABLE Menu_Plato (
    id_m_plato INT AUTO_INCREMENT PRIMARY KEY,
    id_menu INT NOT NULL,
    id_plato INT NOT NULL,
    cant_por_nino INT NOT NULL,
    FOREIGN KEY (id_menu) REFERENCES Menu(id_menu),
    FOREIGN KEY (id_plato) REFERENCES Catalogo_Plato(id_plato)
);

CREATE TABLE Menu_Bebida (
    id_m_bebida INT AUTO_INCREMENT PRIMARY KEY,
    id_menu INT NOT NULL,
    id_bebida INT NOT NULL,
    cant_por_nino INT NOT NULL,
    FOREIGN KEY (id_menu) REFERENCES Menu(id_menu),
    FOREIGN KEY (id_bebida) REFERENCES Catalogo_Bebida(id_bebida)
);

CREATE TABLE Menu_Postre (
    id_m_postre INT AUTO_INCREMENT PRIMARY KEY,
    id_menu INT NOT NULL,
    id_postre INT NOT NULL,
    cant_por_nino INT NOT NULL,
    FOREIGN KEY (id_menu) REFERENCES Menu(id_menu),
    FOREIGN KEY (id_postre) REFERENCES Catalogo_Postre(id_postre)
);

CREATE TABLE Menu_Personaje (
    id_m_personaje INT AUTO_INCREMENT PRIMARY KEY,
    id_menu INT NOT NULL,
    id_personaje INT NOT NULL,
    FOREIGN KEY (id_menu) REFERENCES Menu(id_menu),
    FOREIGN KEY (id_personaje) REFERENCES Catalogo_Personaje(id_personaje)
);

-- 4. EVENTOS, TURNOS Y BITÁCORA
CREATE TABLE Estado_Evento (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    correo VARCHAR(100)
);

CREATE TABLE Evento (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_estado INT NOT NULL,
    id_menu INT NOT NULL,
    fecha_evento DATE NOT NULL,
    cant_ninos INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_estado) REFERENCES Estado_Evento(id_estado),
    FOREIGN KEY (id_menu) REFERENCES Menu(id_menu)
);

CREATE TABLE Turno_Operativo (
    id_turno INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT NOT NULL,
    id_personal INT NOT NULL,
    id_personaje INT, 
    hora_inicio DATETIME NOT NULL,
    hora_fin DATETIME NOT NULL,
    FOREIGN KEY (id_evento) REFERENCES Evento(id_evento),
    FOREIGN KEY (id_personal) REFERENCES Personal(id_personal),
    FOREIGN KEY (id_personaje) REFERENCES Catalogo_Personaje(id_personaje)
);

CREATE TABLE Bitacora (
    id_nota INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT NOT NULL,
    id_usuario INT NOT NULL,
    comentario VARCHAR(1000) NOT NULL,
    es_critica INT NOT NULL,
    FOREIGN KEY (id_evento) REFERENCES Evento(id_evento),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- 5. RECETAS (Para calcular Insumos)
CREATE TABLE Receta_Plato (
    id_receta_plato INT AUTO_INCREMENT PRIMARY KEY,
    id_plato INT NOT NULL,
    id_insumo INT NOT NULL,
    cantidad_necesaria NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (id_plato) REFERENCES Catalogo_Plato(id_plato),
    FOREIGN KEY (id_insumo) REFERENCES Insumo(id_insumo)
);

CREATE TABLE Receta_Bebida (
    id_receta_bebida INT AUTO_INCREMENT PRIMARY KEY,
    id_bebida INT NOT NULL,
    id_insumo INT NOT NULL,
    cantidad_necesaria NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (id_bebida) REFERENCES Catalogo_Bebida(id_bebida),
    FOREIGN KEY (id_insumo) REFERENCES Insumo(id_insumo)
);

CREATE TABLE Receta_Postre (
    id_receta_postre INT AUTO_INCREMENT PRIMARY KEY,
    id_postre INT NOT NULL,
    id_insumo INT NOT NULL,
    cantidad_necesaria NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (id_postre) REFERENCES Catalogo_Postre(id_postre),
    FOREIGN KEY (id_insumo) REFERENCES Insumo(id_insumo)
);