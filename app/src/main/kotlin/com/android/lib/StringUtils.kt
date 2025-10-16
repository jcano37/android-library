package com.android.lib

/**
 * Utility class for string operations
 * Provides common string manipulation functions for Android applications
 */
object StringUtils {
    
    /**
     * Checks if a string is null or empty
     * @param str The string to check
     * @return true if the string is null or empty, false otherwise
     */
    fun isNullOrEmpty(str: String?): Boolean {
        return str.isNullOrEmpty()
    }
    
    /**
     * Capitalizes the first letter of each word in a string
     * @param str The string to capitalize
     * @return The capitalized string
     */
    fun capitalizeWords(str: String?): String {
        if (str.isNullOrEmpty()) return ""
        
        return str.split(" ").joinToString(" ") { word ->
            if (word.isNotEmpty()) {
                word.first().uppercase() + word.drop(1).lowercase()
            } else {
                word
            }
        }
    }
    
    /**
     * Removes all whitespace from a string
     * @param str The string to process
     * @return The string without whitespace
     */
    fun removeWhitespace(str: String?): String {
        return str?.replace("\\s".toRegex(), "") ?: ""
    }
    
    /**
     * Truncates a string to a specified length and adds ellipsis if needed
     * @param str The string to truncate
     * @param maxLength The maximum length of the string
     * @return The truncated string with ellipsis if needed
     */
    fun truncate(str: String?, maxLength: Int): String {
        if (str.isNullOrEmpty() || str.length <= maxLength) return str ?: ""
        return str.substring(0, maxLength) + "..."
    }
    
    /**
     * Validates if a string is a valid email address
     * @param email The email string to validate
     * @return true if the email is valid, false otherwise
     */
    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrEmpty()) return false
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
}
