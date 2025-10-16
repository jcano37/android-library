package com.android.lib

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.Settings
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.annotation.RequiresPermission

/**
 * Utility class for device-related operations
 * Provides common device information and utility functions for Android applications
 */
object DeviceUtils {
    
    /**
     * Gets the device model name
     * @return The device model name
     */
    fun getDeviceModel(): String {
        return "${Build.MANUFACTURER} ${Build.MODEL}"
    }
    
    /**
     * Gets the Android version
     * @return The Android version string
     */
    fun getAndroidVersion(): String {
        return Build.VERSION.RELEASE
    }
    
    /**
     * Gets the API level
     * @return The API level as integer
     */
    fun getApiLevel(): Int {
        return Build.VERSION.SDK_INT
    }
    
    /**
     * Checks if the device has internet connectivity
     * @param context The application context
     * @return true if connected to internet, false otherwise
     */
    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        
        // Since minSdk is 24, we can always use the modern API
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }
    
    /**
     * Gets the screen dimensions
     * @param context The application context
     * @return A Pair containing width and height in pixels
     */
    fun getScreenDimensions(context: Context): Pair<Int, Int> {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val bounds = windowManager.currentWindowMetrics.bounds
            Pair(bounds.width(), bounds.height())
        } else {
            val displayMetrics = DisplayMetrics()
            @Suppress("DEPRECATION")
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            Pair(displayMetrics.widthPixels, displayMetrics.heightPixels)
        }
    }
    
    /**
     * Gets a device identifier for analytics purposes
     * Note: For privacy reasons, consider using advertising ID or instance ID instead
     * @param context The application context
     * @return The Android ID string (may be null or reset on factory reset)
     */
    @Deprecated(
        "Using hardware IDs is not recommended. Consider using advertising ID or instance ID for analytics.",
        ReplaceWith("getAdvertisingId(context)", "com.google.android.gms.ads.identifier.AdvertisingIdClient")
    )
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID) ?: "unknown"
    }
    
    /**
     * Checks if a specific permission is granted
     * @param context The application context
     * @param permission The permission to check
     * @return true if permission is granted, false otherwise
     */
    fun isPermissionGranted(context: Context, permission: String): Boolean {
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }
    
    /**
     * Gets the app version name
     * @param context The application context
     * @return The app version name or "Unknown" if not found
     */
    fun getAppVersion(context: Context): String {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.versionName ?: "Unknown"
        } catch (e: PackageManager.NameNotFoundException) {
            "Unknown"
        }
    }
}
