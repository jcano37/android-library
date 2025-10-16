package com.pipeline.android.android.library

import java.text.SimpleDateFormat
import java.util.*

/**
 * Utility class for date and time operations
 * Provides common date manipulation functions for Android applications
 */
object DateUtils {
    
    private const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd"
    private const val DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
    
    /**
     * Formats a Date object to a string using the default format
     * @param date The date to format
     * @return The formatted date string
     */
    fun formatDate(date: Date): String {
        val formatter = SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.getDefault())
        return formatter.format(date)
    }
    
    /**
     * Formats a Date object to a string using a custom format
     * @param date The date to format
     * @param pattern The date format pattern
     * @return The formatted date string
     */
    fun formatDate(date: Date, pattern: String): String {
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        return formatter.format(date)
    }
    
    /**
     * Parses a date string using the default format
     * @param dateString The date string to parse
     * @return The parsed Date object or null if parsing fails
     */
    fun parseDate(dateString: String): Date? {
        return try {
            val formatter = SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.getDefault())
            formatter.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
    
    /**
     * Gets the current date as a formatted string
     * @return The current date in default format
     */
    fun getCurrentDate(): String {
        return formatDate(Date())
    }
    
    /**
     * Gets the current date and time as a formatted string
     * @return The current date and time in default format
     */
    fun getCurrentDateTime(): String {
        val formatter = SimpleDateFormat(DEFAULT_DATETIME_FORMAT, Locale.getDefault())
        return formatter.format(Date())
    }
    
    /**
     * Calculates the difference in days between two dates
     * @param startDate The start date
     * @param endDate The end date
     * @return The difference in days
     */
    fun daysBetween(startDate: Date, endDate: Date): Long {
        val diffInMillis = endDate.time - startDate.time
        return diffInMillis / (1000 * 60 * 60 * 24)
    }
    
    /**
     * Checks if a date is today
     * @param date The date to check
     * @return true if the date is today, false otherwise
     */
    fun isToday(date: Date): Boolean {
        val today = Calendar.getInstance()
        val dateCalendar = Calendar.getInstance()
        dateCalendar.time = date
        
        return today.get(Calendar.YEAR) == dateCalendar.get(Calendar.YEAR) &&
                today.get(Calendar.DAY_OF_YEAR) == dateCalendar.get(Calendar.DAY_OF_YEAR)
    }
}
