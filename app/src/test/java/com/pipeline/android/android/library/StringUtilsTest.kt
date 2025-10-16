package com.pipeline.android.android.library

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for StringUtils
 */
class StringUtilsTest {

    @Test
    fun testIsNullOrEmpty() {
        assertTrue(StringUtils.isNullOrEmpty(null))
        assertTrue(StringUtils.isNullOrEmpty(""))
        assertFalse(StringUtils.isNullOrEmpty("test"))
        assertFalse(StringUtils.isNullOrEmpty(" "))
    }

    @Test
    fun testCapitalizeWords() {
        assertEquals("", StringUtils.capitalizeWords(null))
        assertEquals("", StringUtils.capitalizeWords(""))
        assertEquals("Hello World", StringUtils.capitalizeWords("hello world"))
        assertEquals("Test String", StringUtils.capitalizeWords("TEST STRING"))
        assertEquals("Mixed Case String", StringUtils.capitalizeWords("mIxEd CaSe StRiNg"))
    }

    @Test
    fun testRemoveWhitespace() {
        assertEquals("", StringUtils.removeWhitespace(null))
        assertEquals("helloworld", StringUtils.removeWhitespace("hello world"))
        assertEquals("test", StringUtils.removeWhitespace("  test  "))
        assertEquals("nowhitespace", StringUtils.removeWhitespace("no\twhite\nspace"))
    }

    @Test
    fun testTruncate() {
        assertEquals("", StringUtils.truncate(null, 10))
        assertEquals("hello", StringUtils.truncate("hello", 10))
        assertEquals("hello w...", StringUtils.truncate("hello world", 7))
        assertEquals("test...", StringUtils.truncate("testing", 4))
    }

    @Test
    fun testIsValidEmail() {
        assertFalse(StringUtils.isValidEmail(null))
        assertFalse(StringUtils.isValidEmail(""))
        assertFalse(StringUtils.isValidEmail("invalid"))
        assertFalse(StringUtils.isValidEmail("invalid@"))
        assertFalse(StringUtils.isValidEmail("@invalid.com"))
        assertTrue(StringUtils.isValidEmail("test@example.com"))
        assertTrue(StringUtils.isValidEmail("user.name@domain.org"))
    }
}
