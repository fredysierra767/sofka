# 🧪 Proyecto de Automatización de Pruebas - PetStore API

Este repositorio contiene un proyecto de automatización de pruebas para la API pública de **PetStore** (https://petstore.swagger.io/) utilizando **Karate DSL** para pruebas REST.

---

## 🚀 Pasos para clonar y ejecutar el proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu_usuario/tu_proyecto_petstore.git
cd tu_proyecto_petstore

### 2️⃣ Abrir el proyecto en tu IDE

* Abre tu IDE favorito (IntelliJ IDEA recomendado).
* Selecciona **"Open existing project"** y elige la carpeta raíz del proyecto.
* Asegúrate de que se detecte como proyecto **Gradle**.

### 3️⃣ Configurar dependencias y construir el proyecto

Desde la terminal o el panel Gradle del IDE:

```bash
gradlew clean build
```

Esto descargará todas las dependencias y compilará el proyecto.

> ⚠️ Asegúrate de tener conexión a Internet para la primera descarga de dependencias.

## 💪 Ejecutar pruebas

Puedes ejecutar todos los tests desde terminal con:

```bash
gradlew clean test
```

O ejecutar un `feature` específico:

```bash
gradlew clean test --tests "*NombreDelRunner*"
```

---

## 📄 Datos de prueba desde json

Los datos de prueba (ej. cuerpos JSON para las mascotas) se encuentran en:

```
src/test/resources/data/
```

## 📋 Reportes

Al finalizar la ejecución, Karate genera reportes HTML en:

```
build/karate-reports/
```

Abre karate-summary.html con cualquier navegador para ver el resumen y detalles.

---

## 📁 Estructura del proyecto (resumen)

```
src
 └── test
     ├── java
     │    └── mascotas
     │         ├── ParallelTest.java
     │         └── runners y demás clases Java si aplica
     └── resources
          ├── mascotas
          │    ├── 1_crear_mascota.feature
          │    ├── 2_consultar_mascota.feature
          │    ├── 3_actualizar_mascota.feature
          │    └── 4_consultar_por_status.feature
          ├── data
          │    ├── mascota_nueva.json
          │    └── mascota_actualizada.json
          └── karate-config.js
---

## ✅ Tecnologías usadas

Karate DSL para pruebas REST
Cucumber para definición de escenarios
Java 11
Gradle para build y ejecución
JSON para datos de prueba
Reportes HTML automáticos generados por Karate
---

## ❓ ¿Preguntas?

Si tienes alguna duda sobre cómo ejecutar o configurar el proyecto, puedes abrir un *issue* o contactar al equipo de QA.

---

¡Feliz automatización! 🧪✨
