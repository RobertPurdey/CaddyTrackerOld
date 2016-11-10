package com.purdey.robert.caddytracker.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Player;
import com.purdey.robert.caddytracker.services.IEntityService;
import com.purdey.robert.caddytracker.services.PlayerService;
import com.purdey.robert.caddytracker.ui.helpers.ActivityHelper;
import com.purdey.robert.caddytracker.utilities.types.Strings;

public class AddPlayerActivity extends AppCompatActivity
{
	private static final IEntityService<Player> playerService = new PlayerService();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_player);
	}

	/**
	 * Adds player to the db.
	 *
	 * If successful, the ManagePlayersActivity is started. Otherwise, user errors are shown.
	 *
	 * @param view - view calling the method
	 */
	public void addPlayer(View view)
	{
		Player player_to_add = new Player();
		EditText playerName  = (EditText) findViewById(R.id.etxt_player_name);
		player_to_add.name   = ( (EditText) findViewById(R.id.etxt_player_name) ).getText().toString();

		if (Strings.isEmptyOrNull(player_to_add.name) || player_to_add.name.length() > Player.MAX_PLAYER_NAME )
		{
			playerName.setError("Player name must be between 1-16 characters inclusive.");
		}
		else if (playerService.save(player_to_add) )
		{
			// successful message set
			ActivityHelper.startManagePlayersActivity(this);
		}
		else
		{
			playerName.setError("Player name must be unique.");
		}
	}
}
