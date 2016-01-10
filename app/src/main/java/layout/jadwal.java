package layout;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kucing.salim.R;
import com.example.kucing.salim.jadwalSholatAdapter;
import com.example.kucing.salim.modelListJadwalSolat;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link jadwal.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link jadwal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class jadwal extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView daftar;
    jadwalSholatAdapter adapter;
    public jadwal jawa = null;
    public ArrayList<modelListJadwalSolat> CustomListViewValuesArr = new ArrayList<modelListJadwalSolat>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public jadwal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment jadwal.
     */
    // TODO: Rename and change types and number of parameters
    public static jadwal newInstance(String param1, String param2) {
        jadwal fragment = new jadwal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public void setListData(){
        final modelListJadwalSolat subuh = new modelListJadwalSolat();
        //subuh
        subuh.setImage(R.drawable.night);
        subuh.setSolatna("Subuh");
        subuh.setWaktuna("4:03");
        CustomListViewValuesArr.add(subuh);
        //dzuhr
        final modelListJadwalSolat dzuhr = new modelListJadwalSolat();
        dzuhr.setImage(R.drawable.day);
        dzuhr.setSolatna("Dzuhr");
        dzuhr.setWaktuna("12:02");
        CustomListViewValuesArr.add(dzuhr);
        //ashar
        final modelListJadwalSolat ashar = new modelListJadwalSolat();
        ashar.setImage(R.drawable.day);
        ashar.setSolatna("Ashar");
        ashar.setWaktuna("15:03");
        CustomListViewValuesArr.add(ashar);
        //maghrib
        final modelListJadwalSolat maghr = new modelListJadwalSolat();
        maghr.setImage(R.drawable.night);
        maghr.setSolatna("Maghrib");
        maghr.setWaktuna("18:30");
        CustomListViewValuesArr.add(maghr);
        //isya
        final modelListJadwalSolat isya = new modelListJadwalSolat();
        isya.setImage(R.drawable.night);
        isya.setSolatna("Isya");
        isya.setWaktuna("19:04");
        CustomListViewValuesArr.add(isya);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        jawa = this;
        View v = inflater.inflate(R.layout.fragment_jadwal, container, false);;

        setListData();

        Resources res = getResources();
        daftar = (ListView)v.findViewById(R.id.Jaso);

        adapter = new jadwalSholatAdapter(this.getActivity(),CustomListViewValuesArr,res);
        daftar.setAdapter(adapter);

        return v;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
