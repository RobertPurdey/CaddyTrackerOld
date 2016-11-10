package com.purdey.robert.caddytracker.utilities.types;

import java.util.ArrayList;

/**
 * Created by Robert on 11/9/2016.
 *
 * ArrayList utility mehtods
 */
public class ArrayLists
{
	/**
	 * Gets last object in an arraylist
	 *
	 * @param arrayList - array list to get the last object from
	 * @param <T> - type the array list holds
	 *
	 * @return - if array list is not null AND has size > 0 returns last object in an arraylist,
	 *           otherwise null is returned
	 */
	public static <T> T getLast(ArrayList<T> arrayList)
	{
		T type = null;

		if (arrayList != null && arrayList.size() > 0)
			type = arrayList.get(arrayList.size() - 1);

		return type;
	}
}
