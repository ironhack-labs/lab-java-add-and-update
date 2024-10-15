# Hospital Management API (Spring Boot)

# Este proyecto es una API REST desarrollada con **Spring Boot** para gestionar doctores y pacientes en un hospital multi-ciudad. La API permite realizar operaciones CRUD sobre los doctores y los pacientes, y realizar consultas avanzadas para obtener información específica.

## Características

- **Gestión de Doctores**: Crear, leer, actualizar y eliminar doctores.
- **Gestión de Pacientes**: Crear, leer, actualizar y eliminar pacientes.
- **Consultas avanzadas**:
  - **Buscar doctores por departamento.**
  - **Actualizar el estado de los doctores (ON_CALL, ON, OFF).**
  - **Consultar pacientes por doctor.**
  - **Filtrar pacientes por rango de fechas de nacimiento.**

## Requisitos

# Antes de ejecutar la aplicación, asegúrate de que tienes lo siguiente instalado:

- **Java 17** o superior
- **Maven** (para gestionar las dependencias y compilar el proyecto)
- **IDE**: IntelliJ IDEA, Eclipse, VS Code, etc.

## Instalación y Configuración

# Sigue los siguientes pasos para instalar y ejecutar el proyecto:

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/abde955/hospital-management.git
   cd hospital-management
  
  **Maven descargará las dependencias necesarias y arrancará el servidor embebido de Spring Boot en http://localhost:8080.**
  
2. **Ejecutar la aplicación con Maven:**:

- **mvn spring-boot:run**

3. **Base de datos H2**
- **La base de datos es en memoria y se configura automáticamente.**
- **Acceso a consola: http://localhost:8080/h2-console.**
- **Credenciales:**
   - **URL: jdbc:h2:mem:testdb**
   - **Usuario: sa (sin contraseña).**

# Endpoints

## Doctores

**Agregar nuevo doctor**
- **POST /api/doctors**
- **{
  "name": "Dr. Ana Pérez",
  "department": "Cardiology",
  "status": "ON_CALL" 
}**
**Actualizar estado del doctor:**
- **PATCH /api/doctors/{id}/status?status=ON_CALL**
**Obtener doctores por estado (ON_CALL, ON, OFF):**
- **Actualizar departamento del doctor:**
**PATCH /api/doctors/{id}/department?department=Neurology**


## Pacientes

**Agregar nuevo paciente:**
- **POST /api/patients**
- **{
  "name": "John Doe",
  "dateOfBirth": "1985-04-12",
  "admittedBy": {
  "employeeId": 1
  }
  }**
- **Actualizar información del paciente:**
  **PUT /api/patients**

# Ejemplo de uso

1. **Agregar un nuevo doctor**
- **POST http://localhost:8080/api/doctors**
- **Body {
  "name": "Dr. Ana Pérez",
  "department": "Cardiology",
  "status": "ON_CALL"
  }**
  **Response**
- **{
  "employeeId": 7,
  "name": "Dr. Ana Pérez",
  "department": "Cardiology",
  "status": "ON_CALL"
  }**
2. **Actualizar el estado de un doctor**
- **PATCH http://localhost:8080/api/doctors/1/status?status=ON**
- **{
  "employeeId": 1,
  "name": "Dr. Alonso Flores",
  "department": "Cardiology",
  "status": "ON"
  }**
3. **Agregar un nuevo paciente**
- **POST http://localhost:8080/api/patients**
- **Body
{
  "name": "Jane Doe",
  "dateOfBirth": "1990-01-15",
  "admittedBy": {
  "employeeId": 1
  }
  }**
- **response**
- **{
  "patientId": 6,
  "name": "Jane Doe",
  "dateOfBirth": "1990-01-15",
  "admittedBy": {
  "employeeId": 1,
  "name": "Dr. Alonso Flores",
  "department": "Cardiology",
  "status": "ON"
  }
  }**

1. ¿Usaste el mismo tipo de ruta para actualizar la información del paciente y el departamento del doctor?

- **No. Para el paciente utilicé PUT porque actualiza toda la información de un recurso existente, mientras que para el doctor utilicé PATCH para actualizar parcialmente solo el departamento o el estado.**

2. ¿Por qué elegiste esa estrategia?

- **La elección entre PUT y PATCH depende de si estoy actualizando todo el recurso o solo una parte. PUT es más adecuado cuando se reemplaza el recurso completo, mientras que PATCH es útil cuando solo se actualiza una parte específica.**

3. ¿Cuáles son las ventajas y desventajas de estas estrategias?

- **PUT es más simple cuando se necesita actualizar todo el recurso, pero puede ser innecesario enviar toda la información si solo una parte necesita cambiar.**
- **PATCH es más eficiente para cambios parciales, pero puede requerir más lógica en el servidor para manejar actualizaciones parciales correctamente.**

4. ¿Cuál es el costo-beneficio entre usar PUT y PATCH?

- **PATCH es más eficiente para actualizaciones parciales, ahorrando ancho de banda y tiempo de procesamiento. Sin embargo, puede ser más complejo de implementar, ya que se debe manejar cuidadosamente qué campos se actualizan.**
- **PUT es más simple de implementar cuando se reemplaza todo el recurso, pero puede ser ineficiente si solo cambian pocos campos.**
