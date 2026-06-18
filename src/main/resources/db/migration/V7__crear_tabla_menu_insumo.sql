CREATE TABLE Menu_Insumo (
    id_menu_insumo INT AUTO_INCREMENT PRIMARY KEY,
    id_menu INT NOT NULL,
    id_insumo INT NOT NULL,
    cantidad_necesaria DOUBLE NOT NULL,
    FOREIGN KEY (id_menu) REFERENCES Menu(id_menu) ON DELETE CASCADE,
    FOREIGN KEY (id_insumo) REFERENCES Insumo(id_insumo) ON DELETE CASCADE
);