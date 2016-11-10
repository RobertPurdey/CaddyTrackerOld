package com.purdey.robert.caddytracker.services;

import com.orm.SugarRecord;
import java.util.Iterator;

/**
 * Created by Robert on 11/8/2016.
 */

/**
 * Created by Robert on 11/8/2016.
 * Specification for entity service (CRUD and query)
 *
 * @param <TEntity> - Entity to perform CRUD or query on
 */
public interface IEntityService<TEntity extends SugarRecord>
{
	Boolean save(TEntity entity);
	Boolean save(Iterable<TEntity> entity);
	Iterator<TEntity> findAll();
}
