-- 1. Crear 4 insumos básicos
INSERT INTO Insumo (nombre, unidad_medida) VALUES ('Pan de Molde', 'Unidades');
INSERT INTO Insumo (nombre, unidad_medida) VALUES ('Pasta de Ave Pimiento', 'Gramos');
INSERT INTO Insumo (nombre, unidad_medida) VALUES ('Jugo de Frambuesa', 'Litros');
INSERT INTO Insumo (nombre, unidad_medida) VALUES ('Harina', 'Gramos');

-- 2. Receta Plato 1: Mini Sandwich (Usa 2 panes y 50g de pasta)
INSERT INTO Receta_Plato (id_plato, id_insumo, cantidad_necesaria) VALUES (1, 1, 2.00);
INSERT INTO Receta_Plato (id_plato, id_insumo, cantidad_necesaria) VALUES (1, 2, 50.00);

-- 3. Receta Bebida 1: Jugo Magico (Usa 0.2 Litros por niño)
INSERT INTO Receta_Bebida (id_bebida, id_insumo, cantidad_necesaria) VALUES (1, 3, 0.20);

-- 4. Receta Postre 1: Cupcake (Usa 30g de harina)
INSERT INTO Receta_Postre (id_postre, id_insumo, cantidad_necesaria) VALUES (1, 4, 30.00);