# 🧪 Proyecto de Automatización de Pruebas - OpenCart

Este repositorio contiene un proyecto de automatización de pruebas E2E utilizando **Serenity BDD**, **Screenplay Pattern**, **Cucumber** en español y ejecución con **Gradle**.

---

## 🚀 Pasos para clonar y ejecutar el proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu_usuario/tu_proyecto.git
cd tu_proyecto
```

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

---

## 🧰 Requisitos previos

* Java JDK 11 o superior instalado y configurado (`JAVA_HOME`).
* Gradle Wrapper (ya incluido en el proyecto).
* Google Chrome instalado.
* Descargar [ChromeDriver](https://chromedriver.chromium.org/downloads) y colocarlo en la ruta definida en el proyecto (`Accesos.RUTA_DRIVERS`).
* Crear la carpeta para descargas en la ruta definida (`Accesos.RUTA_DESCARGAS`).

---

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

## 📄 Datos de prueba desde CSV

Este proyecto utiliza archivos CSV como fuente de datos, ubicados en la carpeta:

```
src/test/resources/data/
```

Formato esperado:

* El nombre del archivo debe comenzar con `datos_`.
* Debe incluir una columna llamada `idFiltro` para filtrar los datos.

---

## 📋 Reportes

Al finalizar la ejecución, Serenity genera un reporte HTML:

```
build/reports/serenity/index.html
```

Puedes abrirlo con cualquier navegador para ver resultados detallados.

---

## 📁 Estructura del proyecto (resumen)

```
src
 └── test
     ├── java
     │    └── co.com.opencart
     │         ├── stepdefinitions/
     │         ├── tasks/
     │         ├── models/
     │         ├── questions/
     │         └── utils/
     └── resources
          ├── features/
          ├── data/
          └── log4j.properties
```

---

## ✅ Tecnologías usadas

* Serenity BDD
* Cucumber (español)
* Screenplay Pattern
* Gradle
* Java 11
* Selenium WebDriver
* Log4j
* CSV como fuente de datos

---

## ❓ ¿Preguntas?

Si tienes alguna duda sobre cómo ejecutar o configurar el proyecto, puedes abrir un *issue* o contactar al equipo de QA.

---

¡Feliz automatización! 🧪✨
