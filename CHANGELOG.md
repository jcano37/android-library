# Changelog - jcanoLib

## [1.0.0] - 2024-10-16

### 🎉 Versión Inicial
- Librería Android modular y reutilizable
- Funciones utilitarias esenciales para desarrollo Android

### 📦 Componentes Incluidos

#### StringUtils
- `isNullOrEmpty()` - Verificar cadenas nulas o vacías
- `capitalizeWords()` - Capitalizar palabras
- `removeWhitespace()` - Eliminar espacios en blanco
- `truncate()` - Truncar texto con ellipsis
- `isValidEmail()` - Validar direcciones de email

#### DateUtils
- `formatDate()` - Formatear fechas con patrones personalizados
- `parseDate()` - Parsear cadenas a objetos Date
- `getCurrentDate()` - Obtener fecha actual
- `getCurrentDateTime()` - Obtener fecha y hora actual
- `daysBetween()` - Calcular días entre fechas
- `isToday()` - Verificar si una fecha es hoy

#### DeviceUtils
- `getDeviceModel()` - Obtener modelo del dispositivo
- `getAndroidVersion()` - Obtener versión de Android
- `getApiLevel()` - Obtener nivel de API
- `isNetworkAvailable()` - Verificar conectividad de red
- `getScreenDimensions()` - Obtener dimensiones de pantalla
- `getDeviceId()` - Obtener ID único del dispositivo
- `isPermissionGranted()` - Verificar permisos
- `getAppVersion()` - Obtener versión de la aplicación

#### ValidationUtils
- `isValidPhoneNumber()` - Validar números de teléfono
- `isValidPassword()` - Validar contraseñas seguras
- `isValidUrl()` - Validar URLs
- `isValidCreditCard()` - Validar tarjetas de crédito (algoritmo Luhn)
- `isAlphabetic()` - Verificar texto alfabético
- `isNumeric()` - Verificar texto numérico
- `isLengthInRange()` - Verificar longitud en rango

### 🧪 Testing
- Tests unitarios completos para StringUtils
- Tests unitarios completos para ValidationUtils
- Cobertura de casos edge y validaciones

### 📚 Documentación
- README.md con guía de instalación y uso
- USAGE_EXAMPLE.md con ejemplos prácticos
- SETUP.md con configuración del entorno
- Documentación completa de API

### 🚀 CI/CD
- GitHub Actions para integración continua
- Publicación automática en GitHub Packages
- Tests automatizados en cada push/PR

### 📋 Configuración
- **Paquete**: `com.jcano.lib`
- **GroupId**: `com.jcano`
- **ArtifactId**: `jcanoLib`
- **Versión**: `1.0.0`
- **Min SDK**: 24
- **Target SDK**: 34
- **JDK**: 11+

### 🔧 Instalación
```kotlin
dependencies {
    implementation("com.jcano:jcanoLib:1.0.0")
}
```

### 📖 Uso Básico
```kotlin
import com.jcano.lib.*

// Validar email
val isValid = ValidationUtils.isValidEmail("user@example.com")

// Formatear texto
val formatted = StringUtils.capitalizeWords("hello world")

// Información del dispositivo
val hasInternet = DeviceUtils.isNetworkAvailable(context)

// Trabajar con fechas
val today = DateUtils.getCurrentDate()
```

### 🏗️ Arquitectura
- Modular y encapsulada
- Sin dependencias externas pesadas
- Optimizada para reutilización
- ProGuard/R8 compatible

### 📄 Licencia
Apache License 2.0
