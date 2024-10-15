-- Inserción en la tabla doctor
INSERT INTO doctor (employee_id, department, name, status) VALUES
(356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
(564134, 'immunology', 'Sam Ortega', 'ON'),
(761527, 'cardiology', 'German Ruiz', 'OFF'),
(166552, 'pulmonary', 'Maria Lin', 'ON'),
(156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
(172456, 'psychiatric', 'John Paul Armes', 'OFF');

-- Inserción en la tabla patient
INSERT INTO patient (patient_id, name, age, doctor_id, admission_date) VALUES
(101, 'Miguel Perez', 45, 356712, '2023-01-15'),
(102, 'Luisa Martinez', 52, 564134, '2023-02-20'),
(103, 'Juan Torres', 30, 761527, '2023-03-05'),
(104, 'Ana Gonzalez', 28, 166552, '2023-04-12'),
(105, 'Carlos Romero', 60, 156545, '2023-05-07');
