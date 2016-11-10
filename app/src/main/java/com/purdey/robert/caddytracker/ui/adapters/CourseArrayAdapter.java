package com.purdey.robert.caddytracker.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Course;
import com.purdey.robert.caddytracker.ui.viewholders.CourseViewHolder;
import com.purdey.robert.caddytracker.ui.viewholders.IViewHolder;

import java.util.ArrayList;

/**
 * Created by Robert on 11/9/2016.
 *
 * Adapter to display Course info
 */
public class CourseArrayAdapter extends EntityArrayAdapter<Course, CourseViewHolder>
{
	public CourseArrayAdapter(Context context, ArrayList<Course> courses)
	{
		super(context, courses);
	}

	@Override
	protected int getLayoutID()
	{
		return R.layout.row_item_course;
	}

	@Override
	protected CourseViewHolder setupViewHolder(View convertView)
	{
		CourseViewHolder crsVwHolder = new CourseViewHolder();

		crsVwHolder.tvPkey      = (TextView) convertView.findViewById(R.id.txtv_course_pkey);
		crsVwHolder.tvName      = (TextView) convertView.findViewById(R.id.txtv_course_name);
		crsVwHolder.tvHoleCount = (TextView) convertView.findViewById(R.id.txtv_course_holes);
		crsVwHolder.tvPar       = (TextView) convertView.findViewById(R.id.txtv_course_par);

		return crsVwHolder;
	}

	@Override
	protected void setupRowLayout(final CourseViewHolder viewHolder, final Course course)
	{
		// Populate the data into the template view using the data object
		viewHolder.tvPkey.setText(course.getId().toString() );
		viewHolder.tvName.setText(course.name);
		viewHolder.tvHoleCount.setText(Integer.toString(course.holeCount) );
		viewHolder.tvPar.setText(Integer.toString(course.coursePar ) );
	}
}
