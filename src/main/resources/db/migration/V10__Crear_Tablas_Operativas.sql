-- 1. Catálogo de Tareas por Rol
CREATE TABLE Catalogo_Tarea (
    id_tarea INT AUTO_INCREMENT PRIMARY KEY,
    id_rol INT NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES Rol(id_rol)
);

-- Insertar tareas de prueba asegurando la relación correcta con los roles
INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Preparar insumos base' FROM Rol WHERE nombre_rol = 'Cocinero';
INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Emplatar menú principal' FROM Rol WHERE nombre_rol = 'Cocinero';

INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Realizar bienvenida de los niños' FROM Rol WHERE nombre_rol = 'Animador';
INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Organizar juego de magia' FROM Rol WHERE nombre_rol = 'Animador';

INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Servir jugos a la mesa' FROM Rol WHERE nombre_rol = 'Garzon';
INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Cantar cumpleaños con la torta' FROM Rol WHERE nombre_rol = 'Garzon';

INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Revisar limpieza de baños' FROM Rol WHERE nombre_rol = 'Ayudante';
INSERT INTO Catalogo_Tarea (id_rol, descripcion) SELECT id_rol, 'Barrer salón post-evento' FROM Rol WHERE nombre_rol = 'Ayudante';

-- 2. Checklist dinámica por Turno
CREATE TABLE Checklist_Turno (
    id_checklist INT AUTO_INCREMENT PRIMARY KEY,
    id_turno INT NOT NULL,
    id_tarea INT NOT NULL,
    completada BOOLEAN DEFAULT FALSE,
    hora_completada DATETIME,
    FOREIGN KEY (id_turno) REFERENCES Turno_Operativo(id_turno) ON DELETE CASCADE,
    FOREIGN KEY (id_tarea) REFERENCES Catalogo_Tarea(id_tarea)
);

-- 3. Tabla de Incidencias / Emergencias
CREATE TABLE Incidencia (
    id_incidencia INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT NOT NULL,
    id_personal_reporta INT NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    estado VARCHAR(20) DEFAULT 'PENDIENTE',
    hora_reporte DATETIME NOT NULL,
    hora_resolucion DATETIME,
    FOREIGN KEY (id_reserva) REFERENCES Reserva(id_reserva) ON DELETE CASCADE,
    FOREIGN KEY (id_personal_reporta) REFERENCES Personal(id_personal)
);