package com.example.rutuja.image_circle;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.example.rutuja.image_circle.ScrollVeiwVertical.OnHorizontalFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScrollVeiwVertical#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScrollVeiwVertical extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private LinearLayout mLinearLayout;

    Button mButton;
    TextView mTextVeiw;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHorizontalFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScrollVeiwVertical.
     */
    // TODO: Rename and change types and number of parameters
    public static ScrollVeiwVertical newInstance(String param1, String param2) {
        ScrollVeiwVertical fragment = new ScrollVeiwVertical();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ScrollVeiwVertical() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View veiw = inflater.inflate(R.layout.fragment_scroll_veiw_vertical, container, false);

        mLinearLayout = (LinearLayout)veiw.findViewById(R.id.verticalcontainer);

        mTextVeiw=(TextView)veiw.findViewById(R.id.verticalTopText);
        mButton=(Button)veiw.findViewById(R.id.fragmentButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.activityTitleChanged("Scroll Veiw New");
                mTextVeiw.setTextColor(Color.BLUE);

            }
        });

        return veiw;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnHorizontalFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnHorizontalFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        public  void activityTitleChanged(String newtitle);
    }

   /* public interface OnHorizontalFragmentInteractionListner{
        public void OnHorizontalFragmentInteraction(Uri uri);
        public  void activityTitleChanged(String newtitle);
    }*/
}
