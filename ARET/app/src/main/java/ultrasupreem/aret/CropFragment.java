package ultrasupreem.aret;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;


import java.net.URLConnection;


public class CropFragment extends ListFragment implements AdapterView.OnItemClickListener {
    CropList cropList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.crop_layout, null);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getCropListfromDB();

        //this makes the list
        ArrayAdapter<Crop> arrayAdapter = new ArrayAdapter<Crop>(this.getActivity(), android.R.layout.simple_list_item_1, cropList.crops);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    private void getCropListfromDB() {
        cropList = new CropList();
        //db stuff
        try {
            String url = "http://polls.apiblueprint.org/crops/";

            URL object = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) object.openConnection();
            connection.setRequestMethod("GET");

            InputStream response = connection.getInputStream();
            cropList.parseCrops(response);

        }
        catch (IOException e){
            //OH LOOK THE DATABASE DOESNT EXIST FUCKING SURPRISE
            InputStream noResponse = null;
            cropList.parseCrops(noResponse);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //this changes the fragment to the 'crop info' one and sends 2 strings to be shown.
        Bundle bundle = new Bundle();
        bundle.putString("title", "Carrot");
        bundle.putString("body", "A long string of text that do not want to show all the time.A long string of text that do not want to show all the time.A long string of text that do not want to show all the time.A long string of text that do not want to show all the time.A long string of text that do not want to show all the time.");
        ((MainActivity) getActivity()).replaceFragments(CropInfoFragment.class, bundle);
    }
}
