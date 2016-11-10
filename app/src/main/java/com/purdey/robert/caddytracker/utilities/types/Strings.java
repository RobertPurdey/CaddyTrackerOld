package com.purdey.robert.caddytracker.utilities.types;

/**
 * Created by Robert on 11/8/2016.
 *
 * Helper methods for strings
 */
public class Strings
{
	/**
	 * Validates if a string is null or empty
	 *
	 * @param s string to validate
	 *
	 * @return true if string is not null and not empty, false otherwise.
	 */
	public static Boolean isEmptyOrNull(String s)
	{
		return s == null || s.isEmpty();
	}

}
