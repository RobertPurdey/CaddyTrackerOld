package com.purdey.robert.caddytracker.domain.entities;

import com.orm.SugarRecord;

/**
 * Created by Robert Purdey on 11/6/2016.
 *
 * Represents a particular hole on a course
 */
public class Hole extends SugarRecord
{
	/**
	 * Min value for par
	 */
	public static final int MIN_PAR = 3;

	/**
	 * Max value for par
	 */
	public static final int MAX_PAR = 9;

    // DB Properties
	/**
     * hole number on the course
     */
    public int holeNumber;

	/**
	 * amount of strokes required for par
     */
    public int par;

	/**
	 * course that owns this hole
     */
    public Course holeOwner;

    /**

    /**
     * Default constructor required for Sugar ORM
     */
    public Hole()
    {
    }

	/**
     * Constructor - sets hole properties
     *
     * @param holeNumber hole number for the course it is for
     * @param par how many strokes par is
     * @param holeOwner course that owns this hole
     */
    public Hole(int holeNumber, int par, Course holeOwner)
    {
        this.holeNumber = holeNumber;
        this.par        = par;
        this.holeOwner  = holeOwner;
    }

	/**
	 * Decreases the par of the hole.
	 *
	 * No change is made if par is MIN_PAR.
	 */
	public void decreasePar()
	{
		if (this.par > MIN_PAR)
		{
			this.par--;
		}
	}

	/**
	 * Increases the par of the hole.
	 *
	 * No change is made if par is MAX_PAR.
	 */
	public void increasePar()
	{
		if (this.par < MAX_PAR)
		{
			this.par++;
		}
	}

	/**
	 * Sets the course this hole belongs to.
	 *
	 * Course will only be set if:
	 * - the course being set as the holeOwner is NOT null
	 * - the hole is not already owned by a course
	 *
	 * @param course - course the hole belongs to
	 */
	public void setCourse(Course course)
	{
		if (course != null && this.holeOwner == null)
		{
			this.holeOwner = course;
		}
	}
}
