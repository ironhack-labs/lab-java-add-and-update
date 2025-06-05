# 🏥 Hospital Management API – Spring Boot & JPA 1.0

Este proyecto es una API REST desarrollada con Spring Boot y Spring Data JPA. Su objetivo es simular un sistema de gestión para un hospital distribuido en varias ciudades, permitiendo manejar información de empleados (médicos) y pacientes, incluyendo sus relaciones y operaciones CRUD completas.

## 🧱 Estructura de datos

### 🧑‍⚕️ Tabla de Empleados (Employee)

| Campo         | Tipo      |
|---------------|-----------|
| employee_id   | Integer   |
| department    | String    |
| name          | String    |
| status        | Enum (ON, OFF, ON_CALL) |

### 🧍‍♀️ Tabla de Pacientes (Patient)

| Campo         | Tipo      |
|---------------|-----------|
| patient_id    | Integer   |
| name          | String    |
| date_of_birth | LocalDate |
| admitted_by   | Foreign Key (employee_id) |

---

## 🚀 Endpoints implementados

### 🔧 Operaciones sobre empleados

- `POST /employees`: Añadir un nuevo médico
- `PATCH /employees/{id}/status`: Cambiar el estado de un médico
- `PATCH /employees/{id}/department`: Actualizar el departamento de un médico

### 🔧 Operaciones sobre pacientes

- `POST /patients`: Añadir un nuevo paciente
- `PUT /patients/{id}`: Actualizar completamente la información de un paciente

---

## 🧪 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (memoria)
- Maven
- Lombok (opcional)

---

## 📦 Cómo ejecutar el proyecto

1. Clona este repositorio
2. Abre el proyecto en tu IDE (IntelliJ, VS Code...)
3. Asegúrate de tener configurado Java 17 y Maven
4. Ejecuta la clase `HospitalApplication`
5. Accede a la consola H2 para consultar la base de datos (URL: `/h2-console`)

---

## ❓ Preguntas y respuestas

### ❓¿Usaste el mismo tipo de ruta para actualizar el departamento del doctor y la información del paciente?

No. Para el departamento del doctor usé `PATCH` (actualización parcial), y para el paciente usé `PUT` (actualización completa del recurso).

---

### 💭 ¿Por qué elegiste esa estrategia?

Porque cuando quiero actualizar solo un campo (como el estado o departamento), es más lógico usar `PATCH`. En cambio, para actualizar todos los datos de un paciente, usar `PUT` es más estándar.

---

### ⚖️ ¿Ventajas y desventajas de PUT y PATCH?

| Estrategia | Ventajas | Desventajas |
|-----------|----------|-------------|
| PUT       | Reemplaza el recurso completo, más fácil de validar | Menos eficiente si solo cambias 1 campo |
| PATCH     | Solo actualiza lo que cambia, más liviano | Más complejo de validar y puede ser menos predecible |

---

### 💡 Coste-beneficio entre PUT y PATCH

- `PATCH` es ideal para modificaciones rápidas y localizadas.
- `PUT` es más seguro cuando se quiere mantener integridad total en la estructura del recurso.

En este proyecto usamos ambos, según la situación.

---

Creado por Mábel Martínez para un proyecto con Ironhack. 

