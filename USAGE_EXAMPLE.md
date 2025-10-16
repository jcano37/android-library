# Ejemplo de Uso - jcanoLib

Este documento muestra cómo integrar y usar la librería en un proyecto Android real.

## Proyecto de Ejemplo

### 1. Configuración en build.gradle.kts (Proyecto)

```kotlin
// build.gradle.kts (Project level)
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

### 2. Configuración en build.gradle.kts (App)

```kotlin
// build.gradle.kts (App level)
dependencies {
    implementation("com.jcano:jcanoLib:1.0.0")
    
    // Otras dependencias...
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
}
```

### 3. Ejemplo de Activity

```kotlin
package com.example.myapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jcano.lib.*

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Ejemplo de uso de StringUtils
        demonstrateStringUtils()
        
        // Ejemplo de uso de ValidationUtils
        demonstrateValidationUtils()
        
        // Ejemplo de uso de DeviceUtils
        demonstrateDeviceUtils()
        
        // Ejemplo de uso de DateUtils
        demonstrateDateUtils()
    }
    
    private fun demonstrateStringUtils() {
        val userInput = "  hello world  "
        
        // Limpiar y formatear texto
        val cleanText = StringUtils.removeWhitespace(userInput)
        val capitalizedText = StringUtils.capitalizeWords(userInput.trim())
        val truncatedText = StringUtils.truncate(capitalizedText, 10)
        
        showToast("Texto procesado: $truncatedText")
    }
    
    private fun demonstrateValidationUtils() {
        val email = "user@example.com"
        val phone = "+1 (555) 123-4567"
        val password = "MySecurePass123"
        
        val isValidEmail = ValidationUtils.isValidEmail(email)
        val isValidPhone = ValidationUtils.isValidPhoneNumber(phone)
        val isValidPassword = ValidationUtils.isValidPassword(password)
        
        if (isValidEmail && isValidPhone && isValidPassword) {
            showToast("Todos los datos son válidos")
        } else {
            showToast("Algunos datos no son válidos")
        }
    }
    
    private fun demonstrateDeviceUtils() {
        val deviceModel = DeviceUtils.getDeviceModel()
        val androidVersion = DeviceUtils.getAndroidVersion()
        val hasInternet = DeviceUtils.isNetworkAvailable(this)
        val (width, height) = DeviceUtils.getScreenDimensions(this)
        
        val deviceInfo = """
            Dispositivo: $deviceModel
            Android: $androidVersion
            Internet: ${if (hasInternet) "Conectado" else "Desconectado"}
            Pantalla: ${width}x${height}px
        """.trimIndent()
        
        showToast(deviceInfo)
    }
    
    private fun demonstrateDateUtils() {
        val currentDate = DateUtils.getCurrentDate()
        val currentDateTime = DateUtils.getCurrentDateTime()
        
        val dateInfo = """
            Fecha: $currentDate
            Fecha y hora: $currentDateTime
        """.trimIndent()
        
        showToast(dateInfo)
    }
    
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
```

### 4. Ejemplo de Fragment con Validación de Formulario

```kotlin
package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jcano.lib.StringUtils
import com.jcano.lib.ValidationUtils

class RegistrationFragment : Fragment() {
    
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initViews(view)
        setupClickListeners()
    }
    
    private fun initViews(view: View) {
        etName = view.findViewById(R.id.etName)
        etEmail = view.findViewById(R.id.etEmail)
        etPhone = view.findViewById(R.id.etPhone)
        etPassword = view.findViewById(R.id.etPassword)
        btnRegister = view.findViewById(R.id.btnRegister)
    }
    
    private fun setupClickListeners() {
        btnRegister.setOnClickListener {
            validateAndRegister()
        }
    }
    
    private fun validateAndRegister() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val phone = etPhone.text.toString()
        val password = etPassword.text.toString()
        
        // Validar nombre
        if (StringUtils.isNullOrEmpty(name)) {
            etName.error = "El nombre es requerido"
            return
        }
        
        if (!ValidationUtils.isAlphabetic(name, allowSpaces = true)) {
            etName.error = "El nombre solo debe contener letras"
            return
        }
        
        // Validar email
        if (!ValidationUtils.isValidEmail(email)) {
            etEmail.error = "Email inválido"
            return
        }
        
        // Validar teléfono
        if (!ValidationUtils.isValidPhoneNumber(phone)) {
            etPhone.error = "Número de teléfono inválido"
            return
        }
        
        // Validar contraseña
        if (!ValidationUtils.isValidPassword(password)) {
            etPassword.error = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número"
            return
        }
        
        // Si todas las validaciones pasan
        val formattedName = StringUtils.capitalizeWords(name)
        showToast("Registro exitoso para: $formattedName")
        
        // Aquí harías el registro real
        performRegistration(formattedName, email, phone, password)
    }
    
    private fun performRegistration(name: String, email: String, phone: String, password: String) {
        // Implementar lógica de registro
        showToast("Usuario registrado correctamente")
    }
    
    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
```

### 5. Ejemplo de Utilidad de Red con DeviceUtils

```kotlin
package com.example.myapp.utils

import android.content.Context
import com.jcano.lib.DeviceUtils

class NetworkHelper(private val context: Context) {
    
    fun checkNetworkAndExecute(action: () -> Unit, onNoNetwork: () -> Unit) {
        if (DeviceUtils.isNetworkAvailable(context)) {
            action()
        } else {
            onNoNetwork()
        }
    }
    
    fun getDeviceInfo(): String {
        val model = DeviceUtils.getDeviceModel()
        val version = DeviceUtils.getAndroidVersion()
        val apiLevel = DeviceUtils.getApiLevel()
        val appVersion = DeviceUtils.getAppVersion(context)
        
        return """
            Device: $model
            Android: $version (API $apiLevel)
            App Version: $appVersion
        """.trimIndent()
    }
}

// Uso en Activity/Fragment
class SomeActivity : AppCompatActivity() {
    
    private lateinit var networkHelper: NetworkHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        networkHelper = NetworkHelper(this)
        
        // Verificar red antes de hacer una operación
        networkHelper.checkNetworkAndExecute(
            action = {
                // Hacer llamada a API
                makeApiCall()
            },
            onNoNetwork = {
                showToast("No hay conexión a internet")
            }
        )
    }
    
    private fun makeApiCall() {
        // Implementar llamada a API
    }
    
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
```

### 6. Layout de ejemplo (fragment_registration.xml)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">

        <EditText
            android:id="@+id/etName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Nombre completo"
            android:inputType="textPersonName" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">

        <EditText
            android:id="@+id/etEmail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Email"
            android:inputType="textEmailAddress" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">

        <EditText
            android:id="@+id/etPhone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Teléfono"
            android:inputType="phone" />

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="24dp">

        <EditText
            android:id="@+id/etPassword"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Contraseña"
            android:inputType="textPassword" />

    </com.google.android.material.textfield.TextInputLayout>

    <Button
        android:id="@+id/btnRegister"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Registrarse" />

</LinearLayout>
```

## Notas Importantes

1. **Permisos**: Algunas funciones de `DeviceUtils` pueden requerir permisos específicos en el AndroidManifest.xml
2. **Contexto**: Siempre pasa el contexto de aplicación para evitar memory leaks
3. **Validaciones**: Las validaciones son básicas, puedes extenderlas según tus necesidades
4. **Threading**: Para operaciones pesadas, considera usar corrutinas o threads en segundo plano

## Próximos Pasos

- Agregar más utilidades según las necesidades del proyecto
- Implementar logging y analytics
- Añadir soporte para más tipos de validación
- Crear extensiones para View y Context
