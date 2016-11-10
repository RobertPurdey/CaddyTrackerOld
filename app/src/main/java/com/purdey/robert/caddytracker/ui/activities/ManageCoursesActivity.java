package com.purdey.robert.caddytracker.ui.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.ui.fragments.CourseListFragment;
import com.purdey.robert.caddytracker.ui.helpers.ActivityHelper;

public class ManageCoursesActivity	extends AppCompatActivity
		implements CourseListFragment.OnFragmentInteractionListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_manage_courses);

		// Setup Course List Fragment
		CourseListFragment courseFragment = new CourseListFragment();

		getSupportFragmentManager().beginTransaction()
				.add(R.id.mng_course_select_course_fragment, courseFragment)
				.commit();
	}

	@Override
	public void onFragmentInteraction(Uri uri)
	{

	}

	/**
	 * Start Add Players activity
	 *
	 * @param view - view calling the method
	 */
	public void onClickAddCourse(View view)
	{
		ActivityHelper.startActivity(this, AddCourseActivity.class);
	}
}
