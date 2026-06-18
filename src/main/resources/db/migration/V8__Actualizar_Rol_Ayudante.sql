-- Si el rol 'Supervisor' existe, lo renombramos a 'Ayudante'
UPDATE Rol SET nombre_rol = 'Ayudante' WHERE nombre_rol = 'Supervisor';

-- Por si acaso no existía ni Supervisor ni Ayudante, lo insertamos para asegurarnos
INSERT INTO Rol (nombre_rol) 
SELECT 'Ayudante' 
WHERE NOT EXISTS (SELECT 1 FROM Rol WHERE nombre_rol = 'Ayudante');