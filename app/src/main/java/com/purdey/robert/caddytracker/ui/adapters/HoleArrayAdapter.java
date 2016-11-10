package com.purdey.robert.caddytracker.ui.adapters;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Hole;
import com.purdey.robert.caddytracker.ui.viewholders.HoleViewHolder;

import java.util.ArrayList;

/**
 * Created by Robert on 11/6/2016.
 *
 * Adapter to display Hole info
 */
public class HoleArrayAdapter extends EntityArrayAdapter<Hole, HoleViewHolder>
{
	public HoleArrayAdapter(Context context, ArrayList<Hole> holes)
	{
		super(context, holes);
	}

	@Override
	protected int getLayoutID()
	{
		return R.layout.row_item_hole;
	}

	@Override
	protected HoleViewHolder setupViewHolder(View convertView)
	{
		HoleViewHolder holeVwHolder = new HoleViewHolder();

		holeVwHolder.tvPkey       = (TextView) convertView.findViewById(R.id.txtv_hole_pkey);
		holeVwHolder.tvNum        = (TextView) convertView.findViewById(R.id.txtv_hole_number);
		holeVwHolder.tvPar        = (TextView) convertView.findViewById(R.id.txtv_hole_par);
		holeVwHolder.decreaseBttn = (Button) convertView.findViewById(R.id.bttn_decrease_hole_par);
		holeVwHolder.increaseBttn = (Button) convertView.findViewById(R.id.bttn_increase_hole_par);

		return holeVwHolder;
	}

	@Override
	protected void setupRowLayout(final HoleViewHolder viewHolder, final Hole hole)
	{
		// Populate the data into the template view using the data object
		if (hole.getId() != null)
		{
			viewHolder.tvPkey.setText(hole.getId().toString());
		}

		viewHolder.tvNum.setText(Integer.toString(hole.holeNumber) );
		viewHolder.tvPar.setText(Integer.toString(hole.par) );

		// Setup decrease button on click listener
		viewHolder.decreaseBttn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				hole.decreasePar();
				viewHolder.tvPar.setText(Integer.toString(hole.par) );
			}
		});

		// Setup increase button on click listener
		viewHolder.increaseBttn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				hole.increasePar();
				viewHolder.tvPar.setText(Integer.toString(hole.par) );
			}
		});
	}
}
