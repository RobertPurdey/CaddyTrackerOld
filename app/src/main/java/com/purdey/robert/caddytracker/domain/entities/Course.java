package com.purdey.robert.caddytracker.domain.entities;

import com.google.common.collect.Lists;
import com.orm.SugarRecord;

import java.util.ArrayList;


/**
 * Created by Robert Purdey on 11/6/2016.
 *
 * Represents a golf course.
 * edit pulled
 */
public class Course extends SugarRecord
{
    // DB Properties
	/**
     * Name of this course
     */
    public String name;

	/******************************** temporary solution to list lagging (store hole count and hole par
	 * remove these columns once dtos are implemented
	 */

	/**
	 *
	 */
	public int holeCount;

	/**
	 *
	 */
	public int coursePar;

	public static final int MIN_HOLE_COUNT  = 1;
	public static final int MAX_HOLE_COUNT  = 27;
	public static final int MIN_COURSE_NAME = 1;
	public static final int MAX_COURSE_NAME = 16;

    /**
     * Default constructor required for Sugar ORM
     */
    public Course()
    {
    }

	/**
	 * Constructor - sets course properties
     *
     * @param name name of this course
     */
    public Course(String name)
    {
        this.name = name;
    }

	/**
     * Gets an iterable of holes owned by this course.
     *
     * @return an iterable of holes owned by this course
     */
    public Iterable<Hole> getHoles()
    {
        return Hole.find(Hole.class, "hole_Owner = ?", this.getId().toString() );
    }

	/***
	 * Sets the hole count
	 *
	 */
	public void setHoleCountAndCoursePar(ArrayList<Hole> courseHoles)
	{
		// Set hole count
		this.holeCount = courseHoles.size();

		// Set course par
		int coursePar = 0;

		for (Hole hole : courseHoles)
		{
			coursePar += hole.par;
		}

		this.coursePar = coursePar;
	}
}
