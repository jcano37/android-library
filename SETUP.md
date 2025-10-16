# Configuración del Entorno de Desarrollo - jcanoLib

Esta guía te ayudará a configurar el entorno para desarrollar y compilar jcanoLib.

## Requisitos Previos

### 1. Java Development Kit (JDK)
- **Versión requerida**: JDK 11 o superior
- **Descargar**: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) o [OpenJDK](https://openjdk.org/)

#### Configurar JAVA_HOME (Windows):
```bash
# Agregar a las variables de entorno del sistema
JAVA_HOME=C:\Program Files\Java\jdk-11.0.x
PATH=%JAVA_HOME%\bin;%PATH%
```

#### Verificar instalación:
```bash
java -version
javac -version
```

### 2. Android SDK
- **Instalación**: A través de Android Studio o standalone
- **Ubicación típica**: `C:\Users\%USERNAME%\AppData\Local\Android\Sdk`

#### El archivo `local.properties` debe contener:
```properties
sdk.dir=C\\:\\Users\\LEGION\\AppData\\Local\\Android\\Sdk
```

### 3. Android Studio (Recomendado)
- **Versión**: Arctic Fox o superior
- **Incluye**: Android SDK, herramientas de build, emuladores

## Comandos de Desarrollo

### Compilar la librería:
```bash
./gradlew assembleRelease
```

### Ejecutar tests:
```bash
# Todos los tests
./gradlew test

# Tests específicos
./gradlew app:testDebugUnitTest --tests "com.jcano.lib.StringUtilsTest"
```

### Limpiar proyecto:
```bash
./gradlew clean
```

### Publicar en GitHub Packages:
```bash
./gradlew publish
```

## Solución de Problemas

### Error: "JAVA_HOME is not set"
1. Instalar JDK 11+
2. Configurar variable JAVA_HOME
3. Agregar %JAVA_HOME%\bin al PATH
4. Reiniciar terminal/IDE

### Error: "SDK location not found"
1. Verificar que Android SDK esté instalado
2. Crear/actualizar `local.properties` con la ruta correcta
3. La ruta debe usar doble backslash: `C\\:\\path\\to\\sdk`

### Error: "Could not resolve dependency"
1. Verificar conexión a internet
2. Sincronizar proyecto en Android Studio
3. Limpiar cache: `./gradlew clean`

## Estructura de Archivos Importantes

```
jcanoLib/
├── local.properties          # Configuración local (NO subir a git)
├── gradle.properties         # Configuración global
├── build.gradle.kts         # Configuración del proyecto
├── app/
│   ├── build.gradle.kts     # Configuración del módulo
│   └── src/
│       ├── main/            # Código fuente
│       └── test/            # Tests unitarios
└── .github/workflows/       # CI/CD
```

## Configuración de IDE

### Android Studio:
1. Abrir el proyecto desde la carpeta raíz
2. Esperar sincronización automática
3. Configurar JDK en File → Project Structure

### IntelliJ IDEA:
1. Importar como proyecto Gradle
2. Configurar Android SDK en Project Settings
3. Habilitar plugin de Android

## Variables de Entorno Recomendadas

```bash
# Windows
JAVA_HOME=C:\Program Files\Java\jdk-11.0.x
ANDROID_HOME=C:\Users\%USERNAME%\AppData\Local\Android\Sdk
PATH=%JAVA_HOME%\bin;%ANDROID_HOME%\platform-tools;%PATH%

# Linux/Mac
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$JAVA_HOME/bin:$ANDROID_HOME/platform-tools:$PATH
```

## Verificación de Configuración

Ejecutar estos comandos para verificar que todo esté configurado:

```bash
# Verificar Java
java -version
javac -version

# Verificar Gradle
./gradlew --version

# Verificar Android SDK
adb version

# Compilar proyecto
./gradlew build
```

Si todos los comandos ejecutan sin errores, el entorno está correctamente configurado.
