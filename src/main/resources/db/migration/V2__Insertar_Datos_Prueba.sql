-- 1. Insertar Roles
INSERT INTO Rol (nombre_rol) VALUES ('Administrador'), ('Cocinero'), ('Animador'), ('Garzon');

-- 2. Insertar Personal (El equipo del proyecto)
INSERT INTO Personal (id_rol, rut, nombres, apellidos, telefono) VALUES
(1, '11111111-1', 'Ignacio Isai', 'Henriquez Galleguillos', '+56912345678'),
(2, '22222222-2', 'Benjamin', 'Ramirez', '+56987654321');

-- 3. Insertar Usuario Login (Para pruebas en Postman después)
INSERT INTO Usuario (id_personal, correo, password_hash) VALUES
(1, 'ignacio@wonderland.cl', 'hash_falso_123');

-- 4. Catálogos y Temáticas
INSERT INTO Tematica (nombre_tematica, descripcion) VALUES ('Alicia en el Pais de las Maravillas', 'Tematica clasica');
INSERT INTO Catalogo_Personaje (nombre_personaje) VALUES ('Sombrerero Loco'), ('Alicia'), ('Conejo Blanco');
INSERT INTO Catalogo_Bebida (nombre_bebida) VALUES ('Jugo Magico de Frambuesa'), ('Te de Manzanilla');
INSERT INTO Catalogo_Plato (nombre_plato, descripcion) VALUES ('Mini Sandwich Blanco', 'Sandwich de ave pimiento');
INSERT INTO Catalogo_Postre (nombre_postre) VALUES ('Cupcake Comeme'), ('Galleta Reloj');

-- 5. Creación del Menú
INSERT INTO Menu (id_tematica, nombre_menu, precio_base) VALUES (1, 'Menu Clasico Alicia', 150000);

-- 6. Receta del Menú (Combos)
INSERT INTO Menu_Postre (id_menu, id_postre, cant_por_nino) VALUES (1, 1, 1);
INSERT INTO Menu_Plato (id_menu, id_plato, cant_por_nino) VALUES (1, 1, 2);

-- 7. Insertar Estado y Cliente
INSERT INTO Estado_Evento (descripcion) VALUES ('PENDIENTE'), ('CONFIRMADO');
INSERT INTO Cliente (nombre, telefono, correo) VALUES ('Familia Silva', '+56900000000', 'silva@correo.cl');

-- 8. Evento de Prueba
INSERT INTO Evento (id_cliente, id_estado, id_menu, fecha_evento, cant_ninos)
VALUES (1, 2, 1, '2026-06-15', 15);