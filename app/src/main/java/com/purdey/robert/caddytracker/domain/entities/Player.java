package com.purdey.robert.caddytracker.domain.entities;

import com.orm.SugarRecord;

/**
 * Created by Robert Purdey on 11/6/2016.
 *
 * Represents a golfer
 */
public class Player extends SugarRecord
{
	public static final int MIN_PLAYER_NAME = 1;
	public static final int MAX_PLAYER_NAME = 16;

	/**
	 * name of the player
	 */
	public String name;

	/**
	 * Default constructor required by Sugar ORM
	 */
	public Player()
	{
	}

	/**
	 * Sets player properties
	 *
	 * @param name name of the player
	 */
	public Player(String name)
	{
		this.name = name;
	}

}
