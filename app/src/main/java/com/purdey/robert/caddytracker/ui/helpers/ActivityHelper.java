package com.purdey.robert.caddytracker.ui.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.purdey.robert.caddytracker.ui.activities.AddPlayerActivity;
import com.purdey.robert.caddytracker.ui.activities.MainMenuActivity;
import com.purdey.robert.caddytracker.ui.activities.ManageCoursesActivity;
import com.purdey.robert.caddytracker.ui.activities.ManagePlayersActivity;

/**
 * Created by Robert on 11/8/2016.
 *
 * Helper methods for activities
 */
public class ActivityHelper
{
	/**
	 * Starts Main Menu Activity
	 *
	 * @param context
	 */
	public static void startMainMenuActivity(Context context)
	{
		startActivity(context, MainMenuActivity.class);
	}

	/**
	 * Starts Manage Courses Activity
	 *
	 * @param context
	 */
	public static void startManageCoursesActivity(Context context)
	{
		startActivity(context, ManageCoursesActivity.class);
	}

	/**
	 * Starts Manage Players Activity
	 *
	 * @param context
	 */
	public static void startManagePlayersActivity(Context context)
	{
		startActivity(context, ManagePlayersActivity.class);
	}

	/**
	 * Starts Add Player Activity
	 *
	 * @param context
	 */
	public static void startAddPlayerActivity(Context context)
	{
		startActivity(context, AddPlayerActivity.class);
	}

	/**
	 * starts an Activity
	 *
	 * @param context
	 * @param activityClass activity class to start
	 */
	public static void startActivity(Context context, Class<? extends Activity> activityClass)
	{
		Intent intent = new Intent(context, activityClass);
		context.startActivity(intent);
	}
}
