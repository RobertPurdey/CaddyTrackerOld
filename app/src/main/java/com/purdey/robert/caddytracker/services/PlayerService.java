package com.purdey.robert.caddytracker.services;

import com.purdey.robert.caddytracker.domain.entities.Course;
import com.purdey.robert.caddytracker.utilities.types.Strings;
import com.purdey.robert.caddytracker.domain.entities.Player;

/**
 * Created by Robert on 11/6/2016.
 *
 * Service to handle player entities
 */
public class PlayerService extends EntityService<Player>
{
	/**
	 * Default constructor
	 */
	public PlayerService()
	{
	}

	/**
	 * Validates player name to be unique
	 *
	 * @param player - player being validated
	 * @param existingEntity - entity to validate uniqueness against
	 *
	 * @return true if player's name is unique, false otherwise
	 */
	@Override
	protected boolean validateUniqueEntity(Player player, Player existingEntity)
	{
		return existingEntity.name.equals(player.name) == false;
	}

	@Override
	protected boolean isValidateUniqueness()
	{
		return true;
	}

	/**
	 * Gets Player type
	 *
	 * @return type of Player
	 */
	@Override
	protected Class<Player> getClassType()
	{
		return Player.class;
	}

	/**
	 * Validates player entity to be saved:
	 * - name must be between 1 and 16 characters.
	 *
	 * @param player - player to be saved to the db
	 *
	 * @return true if player name is valid, false otherwise.
	 */
	@Override
	protected Boolean validateEntityToSave(Player player)
	{
		return Strings.isEmptyOrNull(player.name) == false
		    && player.name.length() >= Player.MIN_PLAYER_NAME
			&& player.name.length() <= Player.MAX_PLAYER_NAME;
	}
}
