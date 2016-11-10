package com.purdey.robert.caddytracker.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Player;
import com.purdey.robert.caddytracker.ui.viewholders.PlayerViewHolder;

import java.util.ArrayList;

/**
 * Created by Robert on 11/6/2016.
 *
 * Adapter to display Player info
 */
public class PlayerArrayAdapter extends EntityArrayAdapter<Player, PlayerViewHolder>
{
	public PlayerArrayAdapter(Context context, ArrayList<Player> players)
	{
		super(context, players);
	}

	@Override
	protected int getLayoutID()
	{
		return R.layout.row_item_player;
	}

	@Override
	protected PlayerViewHolder setupViewHolder(View convertView)
	{
		PlayerViewHolder playerVwHolder = new PlayerViewHolder();

		playerVwHolder.tvPkey = (TextView) convertView.findViewById(R.id.txtv_player_pkey);
		playerVwHolder.tvName = (TextView) convertView.findViewById(R.id.txtv_player_name);

		return playerVwHolder;
	}

	@Override
	protected void setupRowLayout(final PlayerViewHolder viewHolder, final Player player)
	{
		// Populate the data into the template view using the data object
		viewHolder.tvPkey.setText(player.getId().toString() );
		viewHolder.tvName.setText(player.name);
	}
}
