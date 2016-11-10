package com.purdey.robert.caddytracker.services;

import com.purdey.robert.caddytracker.domain.entities.Course;
import com.purdey.robert.caddytracker.utilities.types.Strings;

/**
 * Created by Robert on 11/9/2016.
 *
 * Service to handle course entities
 */
public class CourseService extends EntityService<Course>
{
	/**
	 * Default constructor
	 */
	public CourseService()
	{
	}

	/**
	 * Gets Course type
	 *
	 * @return type of Course
	 */
	@Override
	protected Class<Course> getClassType()
	{
		return Course.class;
	}

	@Override
	protected boolean isValidateUniqueness()
	{
		return true;
	}

	/**
	 * Validates course name to be unique
	 *
	 * @param course - course being validated
	 * @param existingEntity - entity to validate uniqueness against
	 *
	 * @return true if course's name is unique, false otherwise
	 */
	@Override
	protected boolean validateUniqueEntity(Course course, Course existingEntity)
	{
		return existingEntity.name.equals(course.name) == false;
	}

	/**
	 * Validates Course entity to be saved:
	 * - name must be between 1 and 16 characters.
	 *
	 * @param course - course to be saved to the db
	 *
	 * @return true if course name is valid, false otherwise.
	 */
	@Override
	protected Boolean validateEntityToSave(Course course)
	{
		return Strings.isEmptyOrNull(course.name) == false
			&& course.name.length() >= Course.MIN_COURSE_NAME
			&& course.name.length() <= Course.MAX_COURSE_NAME;
	}
}
