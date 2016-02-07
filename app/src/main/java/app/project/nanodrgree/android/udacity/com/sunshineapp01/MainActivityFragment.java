package app.project.nanodrgree.android.udacity.com.sunshineapp01;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_main, container, false);

        R.layout.fragment_main
        ArrayList<String> forcastArrayList=new ArrayList<String>();
        forcastArrayList.add("Today - Sunny - 88/63");
        forcastArrayList.add("Tomorrow - Foggy - 70/46");
        forcastArrayList.add("Weds - Cloudy - 72/63");
        forcastArrayList.add("Thurs - Rainy - 64/51");
        forcastArrayList.add("Fri - Foggy - 70/46");
        forcastArrayList.add("Sat - Sunny - 76/68");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.listView_forcast,R.id.list_item_forcast_textView,forcastArrayList);

        return rootView;
    }
}
