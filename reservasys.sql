CREATE DATABASE IF NOT EXISTS reservasys;
USE reservasys;

CREATE TABLE restaurantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- id del restaurante, clave primaria autoincremental.
    nombre VARCHAR(255) NOT NULL,          -- Nombre del restaurante.
    direccion VARCHAR(255) NOT NULL,       -- Dirección del restaurante.
    telefono VARCHAR(15) NOT NULL,         -- Teléfono del restaurante.
    hora_apertura TIME NOT NULL,           -- Hora de apertura del restaurante.
    hora_cierre TIME NOT NULL               -- Hora de cierre del restaurante.
);

CREATE TABLE mesas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,                -- id de la mesa, clave primaria autoincremental.
    codigo_mesa VARCHAR(50) NOT NULL UNIQUE,             -- Código de la mesa, único y no nulo.
    tipo_mesa VARCHAR(50) NOT NULL,                       -- Tipo de mesa (pequeña, mediana, grande).
    capacidad_minima INT NOT NULL,
    capacidad_maxima INT NOT NULL,                        -- Capacidad de la mesa.
    ubicacion VARCHAR(50) NOT NULL,                       -- Ubicación de la mesa (terraza, ventana, general).
    restaurante_id BIGINT NOT NULL,                       -- Clave foránea que referencia a restaurantes.
    FOREIGN KEY (restaurante_id) REFERENCES restaurantes(id) -- Definición de la clave foránea.
);

CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,               -- id del cliente, clave primaria autoincremental.
    nombre VARCHAR(255) NOT NULL,                       -- Nombre del cliente, no nulo.
    telefono VARCHAR(15) NOT NULL UNIQUE               -- Teléfono del cliente, único y no nulo.
);

CREATE TABLE reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,               -- id de la reserva, clave primaria autoincremental.
    fecha_hora_reserva DATETIME NOT NULL,               -- Fecha y hora de la reserva.
    numero_personas INT NOT NULL,                        -- Número de personas.
    costo DOUBLE NOT NULL,                               -- Costo de la reserva.
    estado VARCHAR(50) NOT NULL,                         -- Estado de la reserva (activa, cancelada).
    multa DOUBLE NULL,                                   -- Multa por cancelación, si aplica.
    cliente_id BIGINT NOT NULL,                          -- Clave foránea que referencia a cliente.
    mesa_id BIGINT NOT NULL,                             -- Clave foránea que referencia a mesa.
    restaurante_id BIGINT NOT NULL,                      -- Clave foránea que referencia a restaurante.
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),    -- Definición de la clave foránea para cliente.
    FOREIGN KEY (mesa_id) REFERENCES mesas(id),         -- Definición de la clave foránea para mesa.
    FOREIGN KEY (restaurante_id) REFERENCES restaurantes(id) -- Definición de la clave foránea para restaurante.
);


-- insercion del restaurante
INSERT INTO restaurantes (nombre, direccion, telefono, hora_apertura, hora_cierre)
VALUES ('Restaurante Gourmet', 'Avenida de la Gastronomía 123', '555-1234', '12:00:00', '22:00:00');

-- inserciones de los clientes
INSERT INTO clientes (nombre, telefono) VALUES ('Juan Pérez', '555-1234');
INSERT INTO clientes (nombre, telefono) VALUES ('María Gómez', '555-5678');
INSERT INTO clientes (nombre, telefono) VALUES ('Carlos Rodríguez', '555-8765');
INSERT INTO clientes (nombre, telefono) VALUES ('Ana Martínez', '555-4321');
INSERT INTO clientes (nombre, telefono) VALUES ('Luis Fernández', '555-1111');
INSERT INTO clientes (nombre, telefono) VALUES ('Laura López', '555-2222');
INSERT INTO clientes (nombre, telefono) VALUES ('Pedro Sánchez', '555-3333');
INSERT INTO clientes (nombre, telefono) VALUES ('Lucía Torres', '555-4444');
INSERT INTO clientes (nombre, telefono) VALUES ('José Morales', '555-5555');
INSERT INTO clientes (nombre, telefono) VALUES ('Sofía Díaz', '555-6666');
INSERT INTO clientes (nombre, telefono) VALUES ('Jorge Jiménez', '555-7777');
INSERT INTO clientes (nombre, telefono) VALUES ('Elena Cruz', '555-8888');
INSERT INTO clientes (nombre, telefono) VALUES ('David Ruiz', '555-9999');
INSERT INTO clientes (nombre, telefono) VALUES ('Claudia Romero', '555-0000');
INSERT INTO clientes (nombre, telefono) VALUES ('Fernando Vargas', '555-1235');
INSERT INTO clientes (nombre, telefono) VALUES ('Carla Mendoza', '555-1236');
INSERT INTO clientes (nombre, telefono) VALUES ('Alberto Castillo', '555-1237');
INSERT INTO clientes (nombre, telefono) VALUES ('Mónica Herrera', '555-1238');
INSERT INTO clientes (nombre, telefono) VALUES ('Patricia Ramírez', '555-1239');
INSERT INTO clientes (nombre, telefono) VALUES ('Ricardo Ortega', '555-1240');

-- inserciones para las mesas, como solo tenemos un restaurante todos pertenecen a ese
INSERT INTO mesas (codigo_mesa, tipo_mesa, capacidad_minima, capacidad_maxima, ubicacion, restaurante_id)
VALUES 
    ('MESA001', 'PEQUEÑA', 2, 4, 'VENTANA', 1),
    ('MESA002', 'MEDIANA', 4, 6, 'GENERAL', 1),
    ('MESA003', 'GRANDE', 6, 10, 'TERRAZA', 1),
    ('MESA004', 'PEQUEÑA', 2, 4, 'GENERAL', 1),
    ('MESA005', 'MEDIANA', 4, 6, 'VENTANA', 1),
    ('MESA006', 'GRANDE', 6, 10, 'GENERAL', 1);

-- insertamos reservaciones para hacer unas cuantas pruebas,
INSERT INTO reservas (fecha_hora_reserva, numero_personas, costo, estado, multa, cliente_id, mesa_id, restaurante_id)
VALUES 
    ('2024-10-26 20:00:00', 4, 200.00, 'ACTIVA', NULL, 1, 1, 1),
    ('2024-10-26 20:00:00', 2, 100.00, 'ACTIVA', NULL, 2, 2, 1),
    ('2024-10-27 18:00:00', 6, 300.00, 'ACTIVA', NULL, 3, 3, 1),
    ('2024-10-27 21:00:00', 3, 150.00, 'CANCELADA', 20.00, 4, 4, 1),
    ('2024-10-28 19:30:00', 5, 250.00, 'ACTIVA', NULL, 5, 5, 1),
    ('2024-10-29 12:00:00', 2, 100.00, 'ACTIVA', NULL, 6, 6, 1);
    