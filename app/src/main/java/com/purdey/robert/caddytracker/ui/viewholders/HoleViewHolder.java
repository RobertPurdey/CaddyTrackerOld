package com.purdey.robert.caddytracker.ui.viewholders;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Robert on 11/10/2016.
 *
 * ViewHolder for row_item_hole
 */
public class HoleViewHolder implements IViewHolder
{
	/**
	 * Text View to hold pkey for hole
	 */
	public TextView tvPkey;

	/**
	 * Text View to hold hole number for hole
	 */
	public TextView tvNum;

	/**
	 * Text View to hold hole par
	 */
	public TextView tvPar;

	/**
	 * Button View to hold decrease button
	 */
	public Button decreaseBttn;

	/**
	 * Button View to hold increase button
	 */
	public Button increaseBttn;
}
