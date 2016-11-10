package com.purdey.robert.caddytracker.services;

import android.util.Log;

import com.google.common.collect.Lists;
import com.orm.SugarRecord;
import com.purdey.robert.caddytracker.domain.entities.Course;

import java.util.Iterator;

/**
 * Created by Robert on 11/6/2016.
 *
 * Service to handle entities that inherit from SugarRecord
 *
 * @param <TEntity> entity being handled
 */
public abstract class EntityService<TEntity extends SugarRecord> implements IEntityService<TEntity>
{
	/**
	 * The class type of the generic TEntity that is specified
	 *
	 * @return class type set for the generic TEntity
	 */
	protected abstract Class<TEntity> getClassType();

	/**
	 * Validate the uniqueness of the entity before saving
	 *
	 * @param entity - entity being saved
	 * @param existingEntity - entity to validate uniqueness against
	 *
	 * @return true if unique entity, false otherwise.
	 */
	protected abstract boolean validateUniqueEntity(TEntity entity, TEntity existingEntity);

	/**
	 * Validates the entity before saving to the db.
	 *
	 * @param entity Entity to be saved
	 *
	 * @return true if entity is valid to save, false otherwise.
	 */
	protected abstract Boolean validateEntityToSave(TEntity entity);

	/**
	 * Whether to validate for uniqueness or not
	 *
	 * @return - true if validating is needed, false otherwise
	 */
	protected abstract boolean isValidateUniqueness();
	/**
	 * Saves entity to the database
	 *
	 * @param entity Entity to be saved
	 */
	public final Boolean save(TEntity entity)
	{
		Boolean isEntitySaved              = false;
		Iterator<TEntity> existingEntities = this.findAll();

		if (isValidEntityToSave(entity) && isUniqueEntity(entity, Lists.newArrayList(existingEntities) ) )
		{
			TEntity.save(entity);
			isEntitySaved = true;
		}

		return isEntitySaved;
	}

	/**
	 * Saves entities to the database
	 *
	 * @param entities Entities to be saved
	 */
	public final Boolean save(Iterable<TEntity> entities)
	{
		Boolean isEntitySaved = false;

		for (TEntity entity : entities)
		{
			isEntitySaved = this.save(entity);

			if (isEntitySaved == false)
			{
				break;
			}
		}

		return isEntitySaved;
	}

	/**
	 * Finds all types of the entity
	 *
	 * @return - all entities found.
	 */
	public final Iterator<TEntity> findAll()
	{
		return TEntity.findAll(getClassType() );
	}

	/**
	 * Validates entity being saved.
	 * Checks for null and inheriting class validation
	 *
	 * @param entity entity being validated
	 *
	 * @return true if entity is valid, false otherwise.
	 */
	protected final Boolean isValidEntityToSave(TEntity entity)
	{
		return entity != null && validateEntityToSave(entity);
	}

	/**
	 * Validates entity is unqiue.
	 *
	 * @param entity entity being validated
	 *
	 * @return true if entity is unique, false otherwise.
	 */
	protected final Boolean isUniqueEntity(TEntity entity, Iterable<TEntity> existingEntities)
	{
		boolean isUnqiue = true;

		if (isValidateUniqueness() )
		{
			for (TEntity existingEntity : existingEntities)
			{
				if (validateUniqueEntity(entity, existingEntity) == false)
				{
					isUnqiue = false;
					break;
				}
			}
		}

		return isUnqiue;
	}
}
