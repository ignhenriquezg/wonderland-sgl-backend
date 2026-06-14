CREATE TABLE Reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_menu INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    cantidad_ninos INT NOT NULL,
    cantidad_adultos INT NOT NULL,
    total_estimado INT,
    observaciones VARCHAR(500),
    estado VARCHAR(20) NOT NULL,
    CONSTRAINT fk_reserva_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    CONSTRAINT fk_reserva_menu FOREIGN KEY (id_menu) REFERENCES Menu(id_menu)
);