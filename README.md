# Desafío Microservicios - Spring Boot con Docker

Este proyecto implementa una arquitectura basada en microservicios utilizando Spring Boot y Docker. Contiene dos microservicios: `estudiante` y `evaluacion`. Cada microservicio cuenta con su propio Dockerfile y se orquesta junto a una base de datos MySQL mediante `docker-compose`.

## Requisitos previos

- Docker
- Docker Compose
- Java 17 o superior
- Maven
- Postman (o cualquier herramienta para pruebas de API)

## Levantar el proyecto

1. Clonar el repositorio
2. Ejecutar el siguiente comando para construir las imágenes y levantar los contenedores:
    "docker-compose up --build"

Este comando inicializa los siguientes servicios:
- `db`: servicio de base de datos MySQL en el puerto 3306
- `estudiante`: microservicio desplegado en el puerto 8081
- `evaluacion`: microservicio desplegado en el puerto 8082

## Configuración de base de datos

Ambos microservicios deben tener una configuración de conexión similar en su archivo `application.properties`:

spring.datasource.url=jdbc:mysql://db:3306/microservicios
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update

El host `db` corresponde al nombre del servicio definido para MySQL en el archivo `docker-compose.yml`.

## Compilación manual

Si se desea compilar manualmente cada microservicio fuera de Docker, se puede utilizar:

cd estudiante
./mvnw clean install -DskipTests

cd ../evaluacion
./mvnw clean install -DskipTests


## Pruebas de los endpoints

A continuación se presentan ejemplos de solicitudes POST y GET utilizando Postman o una herramienta similar.

### Microservicio estudiante

**POST** `http://localhost:8081/api/estudiantes`

Encabezado:  
`Content-Type: application/json`

Cuerpo (JSON):

```json
{
  "rut": "12345678-9",
  "nombre": "Juan Pérez",
  "edad": 21,
  "curso": "Matemáticas"
}
GET http://localhost:8081/api/estudiantes

Retorna la lista de estudiantes registrados

Lo mismo se puede realizar para Evaluaciones, siguiendo los mismos pasos.
