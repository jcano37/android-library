package com.jcano.lib

/**
 * Utility class for validation operations
 * Provides common validation functions for Android applications
 */
object ValidationUtils {
    
    /**
     * Validates if a phone number has a valid format
     * @param phoneNumber The phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    fun isValidPhoneNumber(phoneNumber: String?): Boolean {
        if (phoneNumber.isNullOrEmpty()) return false
        // Basic phone number validation (10-15 digits, may include +, -, spaces, parentheses)
        val phonePattern = "^[+]?[0-9\\s\\-()]{10,15}$"
        return phoneNumber.replace("\\s".toRegex(), "").matches(phonePattern.toRegex())
    }
    
    /**
     * Validates if a password meets basic security requirements
     * @param password The password to validate
     * @param minLength Minimum length required (default: 8)
     * @return true if the password is valid, false otherwise
     */
    fun isValidPassword(password: String?, minLength: Int = 8): Boolean {
        if (password.isNullOrEmpty()) return false
        if (password.length < minLength) return false
        
        // Check for at least one digit, one lowercase, one uppercase letter
        val hasDigit = password.any { it.isDigit() }
        val hasLower = password.any { it.isLowerCase() }
        val hasUpper = password.any { it.isUpperCase() }
        
        return hasDigit && hasLower && hasUpper
    }
    
    /**
     * Validates if a URL has a valid format
     * @param url The URL to validate
     * @return true if the URL is valid, false otherwise
     */
    fun isValidUrl(url: String?): Boolean {
        if (url.isNullOrEmpty()) return false
        val urlPattern = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"
        return url.matches(urlPattern.toRegex())
    }
    
    /**
     * Validates if a credit card number has a valid format using Luhn algorithm
     * @param cardNumber The credit card number to validate
     * @return true if the card number is valid, false otherwise
     */
    fun isValidCreditCard(cardNumber: String?): Boolean {
        if (cardNumber.isNullOrEmpty()) return false
        
        val cleanNumber = cardNumber.replace("\\s|-".toRegex(), "")
        if (!cleanNumber.matches("\\d+".toRegex()) || cleanNumber.length < 13 || cleanNumber.length > 19) {
            return false
        }
        
        // Luhn algorithm
        var sum = 0
        var alternate = false
        
        for (i in cleanNumber.length - 1 downTo 0) {
            var digit = cleanNumber[i].toString().toInt()
            
            if (alternate) {
                digit *= 2
                if (digit > 9) {
                    digit = digit / 10 + digit % 10
                }
            }
            
            sum += digit
            alternate = !alternate
        }
        
        return sum % 10 == 0
    }
    
    /**
     * Validates if a string contains only alphabetic characters
     * @param str The string to validate
     * @param allowSpaces Whether to allow spaces in the string
     * @return true if the string contains only alphabetic characters, false otherwise
     */
    fun isAlphabetic(str: String?, allowSpaces: Boolean = false): Boolean {
        if (str.isNullOrEmpty()) return false
        val pattern = if (allowSpaces) "^[a-zA-Z\\s]+$" else "^[a-zA-Z]+$"
        return str.matches(pattern.toRegex())
    }
    
    /**
     * Validates if a string contains only numeric characters
     * @param str The string to validate
     * @return true if the string contains only numeric characters, false otherwise
     */
    fun isNumeric(str: String?): Boolean {
        if (str.isNullOrEmpty()) return false
        return str.matches("^\\d+$".toRegex())
    }
    
    /**
     * Validates if a string is within a specified length range
     * @param str The string to validate
     * @param minLength Minimum length (inclusive)
     * @param maxLength Maximum length (inclusive)
     * @return true if the string length is within range, false otherwise
     */
    fun isLengthInRange(str: String?, minLength: Int, maxLength: Int): Boolean {
        if (str == null) return false
        return str.length in minLength..maxLength
    }
}
