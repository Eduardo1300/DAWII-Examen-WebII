# DAWII-Examen-WebII
Proyecto de examen de Desarrollo de Aplicaciones Web II: implementación de microservicios msvc-users y msvc-clients con Spring Boot
Curso: Desarrollo de Aplicaciones Web II
Profesor: César Enrique Santos Torres
Seccion: 4697
Alumno: Christopher Eduardo Valdivia Baca

## Estructura

- msvc-users
  - Endpoint: GET /users
  - Puerto configurable en application.yml
  - Contiene datos de usuarios en memoria
- msvc-clients
  - Endpoint: GET /clients
  - Consume msvc-users con OpenFeign
  - Genera usuario y contraseña aleatoria
  - Balanceo RoundRobin entre dos instancias de msvc-users
## Ejecución

1. Ejecutar **msvc-users** en dos instancias:


# Terminal 1: msvc-users puerto 8001
cd msvc-users
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8001"

# Terminal 2: msvc-users puerto 8002
cd msvc-users
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8002"

# Terminal 3: msvc-clients puerto 9001
cd msvc-clients
mvn spring-boot:run


GET http://localhost:8001/users → msvc-users instancia 1

GET http://localhost:8002/users → msvc-users instancia 2

GET http://localhost:9001/clients → msvc-clients con balanceo

- La contraseña de cada cliente se genera aleatoriamente en cada ejecución.
- El balanceo RoundRobin alterna entre las dos instancias de msvc-users.
