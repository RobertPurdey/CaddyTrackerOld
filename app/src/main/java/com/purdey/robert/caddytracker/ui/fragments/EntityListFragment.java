package com.purdey.robert.caddytracker.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.orm.SugarRecord;
import com.purdey.robert.caddytracker.ui.adapters.EntityArrayAdapter;
import com.purdey.robert.caddytracker.ui.viewholders.IViewHolder;

import java.util.ArrayList;

/**
 * Created by Robert on 11/9/2016.
 *
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayerListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public abstract class EntityListFragment<TEntity extends SugarRecord> extends Fragment
{
	public EntityListFragment()
	{
		// Required empty public constructor
	}

	/**
	 * Entities to display in list fragment
	 */
	protected abstract ArrayList<TEntity> getEntities();

	/**
	 * Gets the ID of the fragment
	 *
	 * @return - ID of fragment being used
	 */
	protected abstract int getFragmentID();

	/**
	 * Gets the ID of the list in the fragment being used
	 *
	 * @return - ID of the list in the fragment
	 */
	protected abstract int getFragmentListID();

	/**
	 * Get entity adapter being used
	 *
	 * @param entities - entities to set using array adapter
	 * @param <?> - view holder for the adapter
	 *
	 * @return - entity adapter to move data from model to fragment
	 */
	protected abstract EntityArrayAdapter<TEntity, ? extends IViewHolder>
		getEntityAdapter(ArrayList<TEntity> entities);

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		View entityListView = inflater.inflate(this.getFragmentID(), container, false);

		// Get array of entities
		ArrayList<TEntity> entitiesFound = this.getEntities();

		// Find the list view and set adapter
		ListView listView = (ListView) entityListView.findViewById(this.getFragmentListID() );

		// Set entity adapter for the list view
		listView.setAdapter(this.getEntityAdapter(entitiesFound) );

		return entityListView;
	}
}
