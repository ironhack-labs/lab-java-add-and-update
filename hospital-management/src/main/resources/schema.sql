-- Crear tabla doctor
CREATE TABLE doctor (
    employee_id BIGINT PRIMARY KEY,
    department VARCHAR(255),
    name VARCHAR(255),
    status VARCHAR(50)
);

-- Crear tabla patient
CREATE TABLE patient (
    patient_id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    doctor_id BIGINT,
    admission_date DATE,
    FOREIGN KEY (doctor_id) REFERENCES doctor(employee_id)
);
