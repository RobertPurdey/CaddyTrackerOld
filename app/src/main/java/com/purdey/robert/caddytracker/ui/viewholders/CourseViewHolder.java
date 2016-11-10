package com.purdey.robert.caddytracker.ui.viewholders;

import android.widget.TextView;

/**
 * Created by Robert on 11/10/2016.
 *
 * ViewHolder for row_item_course
 */
public class CourseViewHolder implements IViewHolder
{
	/**
	 * Text View that hold pkey of course
	 */
	public TextView tvPkey;

	/**
	 * Text View that holds name of course
	 */
	public TextView tvName;

	/**
	 * Text View that holds hole count of course
	 */
	public TextView tvHoleCount;

	/**
	 * Text View that holds par for the course
	 */
	public TextView tvPar;
}
