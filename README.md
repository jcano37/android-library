# jcanoLib

Una librería de Android modular y reutilizable con funciones utilitarias esenciales.

## Características

- 🛠️ **StringUtils**: Manipulación y validación de cadenas
- 📅 **DateUtils**: Operaciones con fechas y tiempo  
- 📱 **DeviceUtils**: Información del dispositivo
- ✅ **ValidationUtils**: Validaciones comunes
- 🧪 **Tests incluidos**: Completamente probado
- 📦 **GitHub Packages**: Fácil distribución

## Instalación

### Paso 1: Configurar el repositorio

Agrega el repositorio de GitHub Packages en tu archivo `build.gradle.kts` (nivel proyecto):

```kotlin
allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/YOUR_USERNAME/jcanoLib")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}
```

### Paso 2: Agregar la dependencia

En tu archivo `build.gradle.kts` (nivel módulo):

```kotlin
dependencies {
    implementation("com.jcano:jcanoLib:1.0.0")
}
```

### Paso 3: Configurar credenciales

Crea un archivo `gradle.properties` en tu directorio raíz o agrega las siguientes líneas:

```properties
gpr.user=TU_USUARIO_GITHUB
gpr.key=TU_TOKEN_GITHUB
```

## Uso

### StringUtils

```kotlin
import com.jcano.lib.StringUtils

// Verificar si una cadena es nula o vacía
val isEmpty = StringUtils.isNullOrEmpty("") // true

// Capitalizar palabras
val capitalized = StringUtils.capitalizeWords("hello world") // "Hello World"

// Remover espacios en blanco
val noSpaces = StringUtils.removeWhitespace("hello world") // "helloworld"

// Truncar texto
val truncated = StringUtils.truncate("Hello World", 5) // "Hello..."

// Validar email
val isValidEmail = StringUtils.isValidEmail("user@example.com") // true
```

### DateUtils

```kotlin
import com.jcano.lib.DateUtils
import java.util.Date

// Formatear fecha actual
val currentDate = DateUtils.getCurrentDate() // "2024-01-15"

// Formatear fecha con patrón personalizado
val customFormat = DateUtils.formatDate(Date(), "dd/MM/yyyy") // "15/01/2024"

// Parsear fecha
val parsedDate = DateUtils.parseDate("2024-01-15")

// Calcular días entre fechas
val daysBetween = DateUtils.daysBetween(startDate, endDate)

// Verificar si es hoy
val isToday = DateUtils.isToday(someDate)
```

### DeviceUtils

```kotlin
import com.jcano.lib.DeviceUtils

// Obtener modelo del dispositivo
val deviceModel = DeviceUtils.getDeviceModel() // "Samsung Galaxy S21"

// Verificar conectividad
val hasInternet = DeviceUtils.isNetworkAvailable(context)

// Obtener dimensiones de pantalla
val (width, height) = DeviceUtils.getScreenDimensions(context)

// Obtener versión de Android
val androidVersion = DeviceUtils.getAndroidVersion() // "11"

// Verificar permisos
val hasPermission = DeviceUtils.isPermissionGranted(context, Manifest.permission.CAMERA)
```

### ValidationUtils

```kotlin
import com.jcano.lib.ValidationUtils

// Validar número de teléfono
val isValidPhone = ValidationUtils.isValidPhoneNumber("+1 (555) 123-4567") // true

// Validar contraseña
val isValidPassword = ValidationUtils.isValidPassword("MyPass123") // true

// Validar URL
val isValidUrl = ValidationUtils.isValidUrl("https://example.com") // true

// Validar tarjeta de crédito (algoritmo Luhn)
val isValidCard = ValidationUtils.isValidCreditCard("4532015112830366") // true

// Verificar si es alfabético
val isAlphabetic = ValidationUtils.isAlphabetic("HelloWorld") // true

// Verificar si es numérico
val isNumeric = ValidationUtils.isNumeric("12345") // true
```

## Configuración del Entorno

Para configurar el entorno de desarrollo, consulta [SETUP.md](SETUP.md).

**Requisitos mínimos:**
- JDK 11+
- Android SDK
- Gradle (incluido en el proyecto)

## Comandos útiles

```bash
# Ejecutar tests
./gradlew test

# Construir librería
./gradlew assembleRelease

# Publicar en GitHub Packages
./gradlew publish
```

## Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia

Este proyecto está licenciado bajo la Licencia Apache 2.0 - ver el archivo [LICENSE](LICENSE) para más detalles.

