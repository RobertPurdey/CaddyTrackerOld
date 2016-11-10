package com.purdey.robert.caddytracker.services;

import com.purdey.robert.caddytracker.domain.entities.Hole;


/**
 * Created by Robert on 11/9/2016.
 *
 * Service to handle course entities
 */
public class HoleService extends EntityService<Hole>
{
	/**
	 * Default constructor
	 */
	public HoleService()
	{
	}

	/**
	 * Gets Hole type
	 *
	 * @return type of Hole
	 */
	@Override
	protected Class<Hole> getClassType()
	{
		return Hole.class;
	}

	@Override
	protected boolean isValidateUniqueness()
	{
		return false;
	}

	@Override
	protected boolean validateUniqueEntity(Hole hole, Hole existingEntities)
	{
		return true;
	}

	/**
	 * Validates Hole entity to be saved:
	 * - Par is between 3 and 9 inclusive
	 *
	 * @param hole - hole to be saved to the db
	 *
	 * @return true if hole is valid, false otherwise.
	 */
	@Override
	protected Boolean validateEntityToSave(Hole hole)
	{
		return hole.par >= Hole.MIN_PAR && hole.par <= Hole.MAX_PAR;
	}
}
