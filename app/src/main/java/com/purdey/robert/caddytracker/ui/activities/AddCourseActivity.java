package com.purdey.robert.caddytracker.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Course;
import com.purdey.robert.caddytracker.domain.entities.Hole;
import com.purdey.robert.caddytracker.services.CourseService;
import com.purdey.robert.caddytracker.services.HoleService;
import com.purdey.robert.caddytracker.services.IEntityService;
import com.purdey.robert.caddytracker.ui.adapters.HoleArrayAdapter;
import com.purdey.robert.caddytracker.ui.helpers.ActivityHelper;
import com.purdey.robert.caddytracker.utilities.types.ArrayLists;
import com.purdey.robert.caddytracker.utilities.types.Strings;

import java.util.ArrayList;

public class AddCourseActivity extends AppCompatActivity
{
	private static final IEntityService<Course> courseService = new CourseService();
	private static final IEntityService<Hole> holeService     = new HoleService();
	private static HoleArrayAdapter holeAdapter;

	public ArrayList<Hole> courseHoles;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_course);

		initializeCourseHoles();
	}

	/**
	 * Removes last course hole in course hole list only if hole amount is not less than min hole
	 * count
	 *
	 * @param view
	 */
	public void decreaseHoleAmount(View view)
	{
		if (this.getTextHoleAmount() > Course.MIN_HOLE_COUNT)
		{
			holeAdapter.remove(ArrayLists.getLast(courseHoles));
			updateCourseHoles();
		}
	}

	/**
	 * Adds new course hole to course hole list only if hole amount does not exceed max hole count
	 *
	 * @param view
	 */
	public void increaseHoleAmount(View view)
	{
		if (this.getTextHoleAmount() < Course.MAX_HOLE_COUNT)
		{
			holeAdapter.add(new Hole(courseHoles.size() + 1, 3, null));
			updateCourseHoles();
		}
	}


	/**
	 * Adds course to the db.
	 *
	 * If successful, the ManageCoursesActivity is started. Otherwise, user errors are shown.
	 *
	 * @param view - view calling the method
	 */
	public void addCourse(View view)
	{
		Course course_to_add  = new Course();
		EditText courseName   = (EditText) findViewById(R.id.etxt_course_name);
		course_to_add.name    = ( (EditText) findViewById(R.id.etxt_course_name) ).getText().toString();
		boolean isCourseSaved = false;
		boolean isHolesSaved  = false;

		// temporary solution remove once dtos implemented
		course_to_add.setHoleCountAndCoursePar(courseHoles);

		if (Strings.isEmptyOrNull(course_to_add.name) || course_to_add.name.length() > Course.MAX_COURSE_NAME)
		{
			courseName.setError("Course name must be between 1-16 characters inclusive.");
		}
		else if ( (isCourseSaved = courseService.save(course_to_add) ) == true )
		{
			// Set saved course as owner for each hole
			for (Hole hole : courseHoles)
			{
				hole.setCourse(course_to_add);
			}

			if ( (isHolesSaved = holeService.save(courseHoles) ) == false)
			{
				// Hole save error
			}
		}
		else
		{
			courseName.setError("Course name must be unique.");
		}

		if (isCourseSaved && isHolesSaved)
		{
			ActivityHelper.startManageCoursesActivity(this);
		}
		else
		{
			//display error message
		}
	}

	/**
	 * Updates holeAdapter and sets hole amount to the size of course holes
	 */
	private void updateCourseHoles()
	{
		holeAdapter.notifyDataSetChanged();

		TextView tvHoleAmount = (TextView) findViewById(R.id.txtv_hole_amount);
		tvHoleAmount.setText(Integer.toString(courseHoles.size() ) );
	}

	/**
	 * Gets int value of hole amount text field
	 *
	 * @return hole amount value
	 */
	private int getTextHoleAmount()
	{
		TextView tvHoleAmount = (TextView) findViewById(R.id.txtv_hole_amount);

		return Integer.parseInt(tvHoleAmount.getText().toString() );
	}


	/**
	 * Initializes course list and sets initializes course hole adapter
	 */
	private void initializeCourseHoles()
	{
		String holeAmount        = ( (TextView) findViewById(R.id.txtv_hole_amount) ).getText().toString();
		int numOfHoles           = Integer.parseInt(holeAmount);
		courseHoles              = new ArrayList(numOfHoles);
		ListView holeListView    = (ListView) findViewById(R.id.edit_hole_list_view);

		for (int i = 0; i < numOfHoles; i++)
		{
			courseHoles.add(new Hole(i + 1, 3, null) );
		}

		holeAdapter = new HoleArrayAdapter(this, courseHoles);
		holeListView.setAdapter(holeAdapter);
	}

}
