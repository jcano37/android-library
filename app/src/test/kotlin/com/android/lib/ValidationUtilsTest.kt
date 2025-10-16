package com.android.lib

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for ValidationUtils
 */
class ValidationUtilsTest {

    @Test
    fun testIsValidPhoneNumber() {
        assertFalse(ValidationUtils.isValidPhoneNumber(null))
        assertFalse(ValidationUtils.isValidPhoneNumber(""))
        assertFalse(ValidationUtils.isValidPhoneNumber("123"))
        assertTrue(ValidationUtils.isValidPhoneNumber("1234567890"))
        assertTrue(ValidationUtils.isValidPhoneNumber("+1 (555) 123-4567"))
        assertTrue(ValidationUtils.isValidPhoneNumber("555-123-4567"))
    }

    @Test
    fun testIsValidPassword() {
        assertFalse(ValidationUtils.isValidPassword(null))
        assertFalse(ValidationUtils.isValidPassword(""))
        assertFalse(ValidationUtils.isValidPassword("short"))
        assertFalse(ValidationUtils.isValidPassword("alllowercase123"))
        assertFalse(ValidationUtils.isValidPassword("ALLUPPERCASE123"))
        assertFalse(ValidationUtils.isValidPassword("NoNumbers"))
        assertTrue(ValidationUtils.isValidPassword("ValidPass123"))
        assertTrue(ValidationUtils.isValidPassword("AnotherGood1"))
    }

    @Test
    fun testIsValidUrl() {
        assertFalse(ValidationUtils.isValidUrl(null))
        assertFalse(ValidationUtils.isValidUrl(""))
        assertFalse(ValidationUtils.isValidUrl("invalid"))
        assertFalse(ValidationUtils.isValidUrl("www.example.com"))
        assertTrue(ValidationUtils.isValidUrl("https://www.example.com"))
        assertTrue(ValidationUtils.isValidUrl("http://example.com"))
        assertTrue(ValidationUtils.isValidUrl("ftp://files.example.com"))
    }

    @Test
    fun testIsAlphabetic() {
        assertFalse(ValidationUtils.isAlphabetic(null))
        assertFalse(ValidationUtils.isAlphabetic(""))
        assertFalse(ValidationUtils.isAlphabetic("test123"))
        assertTrue(ValidationUtils.isAlphabetic("test"))
        assertTrue(ValidationUtils.isAlphabetic("TestString"))
        assertFalse(ValidationUtils.isAlphabetic("test string"))
        assertTrue(ValidationUtils.isAlphabetic("test string", true))
    }

    @Test
    fun testIsNumeric() {
        assertFalse(ValidationUtils.isNumeric(null))
        assertFalse(ValidationUtils.isNumeric(""))
        assertFalse(ValidationUtils.isNumeric("123abc"))
        assertFalse(ValidationUtils.isNumeric("12.34"))
        assertTrue(ValidationUtils.isNumeric("123"))
        assertTrue(ValidationUtils.isNumeric("0"))
    }

    @Test
    fun testIsLengthInRange() {
        assertFalse(ValidationUtils.isLengthInRange(null, 1, 10))
        assertTrue(ValidationUtils.isLengthInRange("", 0, 10))
        assertTrue(ValidationUtils.isLengthInRange("test", 1, 10))
        assertFalse(ValidationUtils.isLengthInRange("test", 5, 10))
        assertFalse(ValidationUtils.isLengthInRange("very long string", 1, 10))
    }
}
