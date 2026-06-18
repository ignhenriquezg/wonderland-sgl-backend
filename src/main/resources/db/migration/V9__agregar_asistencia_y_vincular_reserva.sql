-- 1. Agregar campos de control de asistencia
ALTER TABLE Turno_Operativo ADD COLUMN estado_asistencia VARCHAR(20) DEFAULT 'PENDIENTE';
ALTER TABLE Turno_Operativo ADD COLUMN justificacion VARCHAR(1000);
ALTER TABLE Turno_Operativo ADD COLUMN ruta_archivo VARCHAR(255);

-- 2. Migrar de Evento (antiguo) a Reserva (nuevo motor logístico)
ALTER TABLE Turno_Operativo ADD COLUMN id_reserva INT;
ALTER TABLE Turno_Operativo ADD CONSTRAINT fk_turno_reserva FOREIGN KEY (id_reserva) REFERENCES Reserva(id_reserva);

-- Permitimos que id_evento sea nulo para no romper el historial de datos de prueba
ALTER TABLE Turno_Operativo MODIFY COLUMN id_evento INT NULL;