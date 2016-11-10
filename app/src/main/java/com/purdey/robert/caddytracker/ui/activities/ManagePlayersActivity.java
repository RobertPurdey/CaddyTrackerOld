package com.purdey.robert.caddytracker.ui.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.ui.fragments.PlayerListFragment;
import com.purdey.robert.caddytracker.ui.helpers.ActivityHelper;

public class ManagePlayersActivity
	extends AppCompatActivity
	implements PlayerListFragment.OnFragmentInteractionListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_manage_players);

		// Setup Player List Fragment
		PlayerListFragment playerFragment = new PlayerListFragment();

		getSupportFragmentManager().beginTransaction()
			.add(R.id.mng_player_select_player_fragment, playerFragment)
			.commit();
	}

	@Override
	public void onFragmentInteraction(Uri uri)
	{

	}

	/**
	 * Start Add Players activity
	 *
	 * @param view - view calling the method
	 */
	public void onClickAddPlayer(View view)
	{
		ActivityHelper.startAddPlayerActivity(this);
	}
}
