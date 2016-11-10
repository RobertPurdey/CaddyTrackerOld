package com.purdey.robert.caddytracker.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.common.collect.Lists;
import com.purdey.robert.caddytracker.R;
import com.purdey.robert.caddytracker.domain.entities.Course;
import com.purdey.robert.caddytracker.services.CourseService;
import com.purdey.robert.caddytracker.services.IEntityService;
import com.purdey.robert.caddytracker.ui.adapters.CourseArrayAdapter;
import com.purdey.robert.caddytracker.ui.adapters.EntityArrayAdapter;
import com.purdey.robert.caddytracker.ui.viewholders.CourseViewHolder;
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
public class CourseListFragment extends EntityListFragment<Course>
{
	/**
	 * Service used to access player entities
	 */
	private static final IEntityService<Course> courseService = new CourseService();

	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	private OnFragmentInteractionListener mListener;

	public CourseListFragment()
	{
		// Required empty public constructor
	}

	@Override
	protected ArrayList<Course> getEntities()
	{
		return Lists.newArrayList(courseService.findAll() );
	}

	@Override
	protected int getFragmentID()
	{
		return R.layout.fragment_course_list;
	}

	@Override
	protected int getFragmentListID()
	{
		return R.id.select_course_list_view;
	}

	@Override
	protected EntityArrayAdapter<Course, CourseViewHolder> getEntityAdapter(ArrayList<Course> entities)
	{
		return new CourseArrayAdapter(getActivity(), entities);
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment SelectPlayerFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static CourseListFragment newInstance(String param1, String param2)
	{
		CourseListFragment fragment = new CourseListFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (getArguments() != null)
		{
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri)
	{
		if (mListener != null)
		{
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		if (context instanceof CourseListFragment.OnFragmentInteractionListener)
		{
			mListener = (CourseListFragment.OnFragmentInteractionListener) context;
		} else
		{
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener
	{
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}
