# 📦 Release v1.0.1

## ✨ Características Principales

### DeviceUtils
- 📊 Obtener información del dispositivo (modelo, versión Android, API level)
- 🌐 Verificar conectividad de red
- 📏 Obtener dimensiones de pantalla
- 🔐 Verificar permisos
- 📋 Obtener versión de la app

### ValidationUtils  
- 📧 Validación de email
- 📞 Validación de teléfono
- 🔑 Validación de contraseña (con requisitos de seguridad)
- 🔗 Validación de URLs
- 💳 Validación de tarjetas de crédito (algoritmo Luhn)
- 🔤 Validaciones de texto (alfabético, numérico, rango de longitud)

### StringUtils
- ✅ Verificar null o vacío
- 📝 Capitalizar palabras
- 🧹 Remover espacios en blanco
- ✂️ Truncar cadenas
- 📧 Validación de email

### DateUtils
- 📅 Formatear fechas con patrones personalizados
- 🔄 Parsear fechas desde strings
- ⏰ Obtener fecha/hora actual
- ⏱️ Calcular diferencia entre fechas
- 📆 Verificar si una fecha es hoy

## 🔧 Requisitos del Sistema

| Componente | Versión | Estado |
|:----------:|:-------:|:------:|
| Android | 7.0+ (API 24) | ✅ |
| Kotlin | 2.2.20 | ✅ |
| Java | 11 | ✅ |
| Gradle | 8.13.0+ | ✅ |

## 📥 Instalación

### Desde GitHub Packages

```kotlin
dependencies {
    implementation("com.android:android-library:1.0.1")
}
```

## 📝 Changelog - v1.0.1

### Nuevo
- ✅ README mejorado con ejemplos interactivos y tablas visuales
- ✅ Badges de compatibilidad y estado del proyecto
- ✅ Documentación SPDX para licencia Apache 2.0
- ✅ Instrucciones de instalación clarificadas y paso a paso
- ✅ Guías de uso expandibles para cada utilidad

### Mejoras
- 🎨 Diseño visual del README más moderno e interactivo
- 📖 Documentación completa con ejemplos de código
- 🔐 Identificador de licencia explícito
- 📦 Configuración de GitHub Packages optimizada

### Correcciones
- 🐛 Badge de licencia ahora muestra Apache 2.0 correctamente
- 🐛 Enlace del archivo LICENSE ahora es directo
- 🐛 Badges dinámicos mejorados para mejor compatibilidad

## 🎯 Uso Rápido

```kotlin
import com.android.lib.*

// DeviceUtils
val model = DeviceUtils.getDeviceModel()
val isConnected = DeviceUtils.isNetworkAvailable(context)

// ValidationUtils
val isValid = ValidationUtils.isValidEmail("user@example.com")

// StringUtils
val capitalized = StringUtils.capitalizeWords("hello world")

// DateUtils
val today = DateUtils.getCurrentDate()
```

## 📄 Licencia

**Apache License 2.0** - Libre para uso comercial y personal

## 🙏 Contribuidores

¡Gracias a todos los que contribuyeron a esta versión!

---

**Versión**: 1.0.1  
**Fecha**: Octubre 2024  
**Licencia**: Apache 2.0  
**URL**: https://github.com/jcano37/android-library
