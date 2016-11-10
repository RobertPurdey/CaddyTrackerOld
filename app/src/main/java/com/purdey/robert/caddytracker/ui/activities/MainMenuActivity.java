package com.purdey.robert.caddytracker.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.ui.helpers.ActivityHelper;

/**
 * Provides navigation to all parts of the application
 */
public class MainMenuActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}

	/**
	 * Start Manage Courses activity
	 *
	 * @param view - view calling the method
	 */
	public void onClickManageCourses(View view)
	{
		ActivityHelper.startManageCoursesActivity(this);
	}

	/**
	 * Start Manage Players activity
	 *
	 * @param view - view calling the method
	 */
	public void onClickManagePlayers(View view)
	{
		ActivityHelper.startManagePlayersActivity(this);
	}
}
