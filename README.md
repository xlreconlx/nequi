# Documentación para Desplegar la Aplicación Localmente

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalados los siguientes requisitos:

- **Java 17 o superior**
- **Maven**
- **MySQL** (Configurado y en ejecución)

## Configuración de la Base de Datos

1. Crear una base de datos en MySQL:
 ```sql
-- Crear la base de datos
CREATE DATABASE nequi;
USE nequi;

-- Crear tabla franquicia
CREATE TABLE IF NOT EXISTS franquicia (
id_franquicia INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(80) NOT NULL,
PRIMARY KEY (id_franquicia)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;

-- Crear tabla sucursal
CREATE TABLE IF NOT EXISTS sucursal (
id_sucursal INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(45) NULL DEFAULT NULL,
id_franquicia INT NOT NULL,
PRIMARY KEY (id_sucursal),
CONSTRAINT fk_sucursal_franquicia
FOREIGN KEY (id_franquicia)
REFERENCES franquicia (id_franquicia)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;

-- Crear tabla producto
CREATE TABLE IF NOT EXISTS producto (
id_producto INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(80) NOT NULL,
stock INT NOT NULL,
id_sucursal INT NOT NULL,
PRIMARY KEY (id_producto),
CONSTRAINT fk_producto_sucursal1
FOREIGN KEY (id_sucursal)
REFERENCES sucursal (id_sucursal)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3;
```

### Instrucciones para Ejecutar Localmente

1. Clone el repositorio:
   ```sh
   https://github.com/xlreconlx/nequi.git
   cd nequi
   ```

2. Configurar el archivo `application.properties` en `src/main/resources/` con las credenciales de la base de datos:

   **Si usas `application.properties`:**
   ```properties
   spring.application.name=prueba
   server.port: 8080
   server.address=0.0.0.0
   spring.datasource.url=jdbc:mysql://localhost:3306/nequi
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
   spring.jpa.show-sql=true
   ```

3. Compile y empaquete el proyecto:
   ```sh
   mvn clean package
   ```

4. Ejecute la aplicación:
   ```sh
   java -jar target/prueba-0.0.1-SNAPSHOT.jar
   ```

## Uso de la API

## **Registrar Franquicia**

**Endpoint:**
```http
POST /api/franquicia
```

**Json que se debe enviar:**
```json
{
    "nombre":"Microsoft"
}
```

**Ejemplo de Respuesta:**
```json
{
    "idFranquicia": 3,
    "nombre": "Microsoft"
}
```

### **Actualizar Nombre de Franquicia**

**Endpoint:**
```http
PUT /api/franquicia/{idFranquicia}
```

**Json que se debe enviar:**
```json
{
    "nombre":"Xbox"
}
```

**Ejemplo de Respuesta:**
```json
{
    "idFranquicia": 3,
    "nombre": "Xbox"
}
```

## **Registrar Sucursal**

**Endpoint:**
```http
POST /api/sucursal/franquicia/{idFranquicia}
```

**Json que se debe enviar:**
```json
{
    "nombre":"Sucursal 2.3"
}
```

**Ejemplo de Respuesta:**
```json
{
    "idSucursal": 2,
    "nombre": "sucursal 2.3",
    "idFranquicia": 1
}
```

## **Cambiar Nombre Sucursal**

**Endpoint:**
```http
POST /api/sucursal/{idSucursal}
```

**Json que se debe enviar:**
```json
{
    "nombre":"Sucursal 2.4"
}
```

**Ejemplo de Respuesta:**
```json
{
    "idSucursal": 2,
    "nombre": "sucursal 2.4",
    "idFranquicia": 1
}
```

### **Obtener el producto con mayor stock por sucursal en una franquicia**

**Endpoint:**
```http
GET /productos/franquicia/{idFranquicia}/productos-by-stock
```

**Ejemplo de Respuesta:**
```json
[
    {
        "idProducto": 4,
        "nombre": "Xbox series s",
        "stock": 500,
        "idSucursal": 1
    },
    {
        "idProducto": 3,
        "nombre": "Xbox series xs",
        "stock": 300,
        "idSucursal": 2
    }
]
```

### **Registrar Producto**

**Endpoint:**
```http
POST /api/producto
```

**Json que se debe enviar:**
```json
{
    "nombre":"Xbox series s",
    "stock":500,
    "idSucursal":1
}
```

**Ejemplo de Respuesta:**
```json
{
    "idProducto": 4,
    "nombre": "Xbox series s",
    "stock": 500,
    "idSucursal": 1
}
```

## **Actualizar Nombre Producto**

**Endpoint:**
```http
PUT /api/producto/{idProducto}
```

**Json que se debe enviar:**
```json
{
    "nombre":"Xbox series xs"
}
```

**Ejemplo de Respuesta:**
```json
{
    "idProducto": 3,
    "nombre": "Xbox series xs",
    "stock": 300,
    "idSucursal": 2
}
```




