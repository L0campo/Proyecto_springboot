# 📦 Sistema de Gestión de Bodegas (GestionBodega)

Sistema web full-stack desarrollado para el control de inventarios, bodegas, productos, registro de movimientos y auditoría avanzada, implementando una arquitectura robusta con Spring Boot, PostgreSQL y un frontend dinámico en JavaScript (SPA).

---

## 🚀 Tecnologías Utilizadas

### Backend
* **Java** / **Spring Boot** (Controladores, Servicios, Repositorios)
* **Spring Data JPA / Criteria API (Specifications)** para consultas dinámicas y opcionales.
* **Spring Security / JWT** para autenticación y control de roles (`ADMIN`, `EMPLEADO`).

### Base de Datos
* **PostgreSQL** para el almacenamiento relacional de datos.

### Frontend
* **HTML5 / CSS3** (Diseño moderno y responsivo).
* **JavaScript (Vanilla)** con manejo de rutas asíncronas (`fetchAPI`).

---

## 🛠️ Arquitectura y Características Principales

1. **Gestión de Bodegas y Productos**: CRUD completo con control de stock y alertas de stock bajo.
2. **Control de Movimientos**: Registro de entradas, salidas y transferencias entre bodegas.
3. **Módulo de Reportes y Auditoría Dinámica**: 
   * Uso de `JpaSpecificationExecutor` en el backend para filtrar reportes de movimientos y logs de auditoría de forma opcional mediante múltiples parámetros (`bodegaId`, `productoId`, `tipoMovimiento`, rangos de fechas, etc.).
4. **Seguridad Integrada**: Autenticación basada en tokens JWT y protección de endpoints según el rol del usuario.

---

## ⚙️ Configuración y Ejecución del Proyecto

### 1. Base de Datos (PostgreSQL)
Crea una base de datos en PostgreSQL con el nombre que prefieras (por ejemplo, `gestionbodega`) y configura tus credenciales en el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5430/gestionbodega
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
