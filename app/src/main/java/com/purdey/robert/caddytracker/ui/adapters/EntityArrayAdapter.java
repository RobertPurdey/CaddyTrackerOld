package com.purdey.robert.caddytracker.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.orm.SugarRecord;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Player;
import com.purdey.robert.caddytracker.ui.viewholders.IViewHolder;

import java.util.ArrayList;

/**
 * Created by Robert on 11/9/2016.
 *
 * Adapter to display Player info in row_player_item.xml
 */
public abstract class EntityArrayAdapter<TEntity extends SugarRecord, TViewHolder extends IViewHolder>
	extends ArrayAdapter<TEntity>
{
	public EntityArrayAdapter(Context context, ArrayList<TEntity> entities)
	{
		super(context, 0, entities);
	}

	/**
	 * Layout ID used for the row item
	 *
	 * @return - Layout ID used for the row item
	 */
	protected abstract int getLayoutID();

	/**
	 * Set values for the row item being used.
	 *
	 * @param viewHolder - viewHolder for the row item
	 * @param entity      - entity to set row item for
	 */
	protected abstract void setupRowLayout(TViewHolder viewHolder, final TEntity entity);

	/**
	 * Setup a view holder to hold views of the list item
	 *
	 * @param convertView
	 *
	 * @return - the setup view holder
	 */
	protected abstract TViewHolder setupViewHolder(View convertView);

	/**
	 * Setup view
	 *
	 * @param position    - position of entity
	 * @param convertView - view being setup
	 * @param parent      - convertView parent
	 * @return - completed view to render on screen
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		TViewHolder viewHolder;

		// Check if an existing view is being reused, otherwise inflate the view
		if (convertView == null)
		{
			convertView = LayoutInflater.from(getContext()).inflate(this.getLayoutID(), parent, false);

			// Setup view holder
			viewHolder = setupViewHolder(convertView);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder = (TViewHolder) convertView.getTag();
		}
		// Get the data item for this position
		TEntity entity = getItem(position);

		this.setupRowLayout(viewHolder, entity);

		// Return the completed view to render on screen
		return convertView;
	}
}
