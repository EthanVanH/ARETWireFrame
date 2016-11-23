package ultrasupreem.aret;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class CropFragment extends ListFragment implements AdapterView.OnItemClickListener {
    CropList cropList;
    ArrayAdapter cropArray;
    ArrayAdapter cropDescriptionArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.crop_layout, null);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       if(!getCropListfromDB())
       {
           makeSomeBullshitCropList();
       }
       else
       {
           //this makes the lis
           ArrayAdapter<Crop> arrayAdapter = new ArrayAdapter<Crop>(this.getActivity(), android.R.layout.simple_list_item_1, cropList.crops);
           setListAdapter(arrayAdapter);
       }

        getListView().setOnItemClickListener(this);
    }

    /**
     * This method is called if the fucking database doesn't do shit
     */
    public void makeSomeBullshitCropList()
    {
        cropArray = ArrayAdapter.createFromResource(getActivity(), R.array.Crops, android.R.layout.simple_list_item_1);
        setListAdapter(cropArray);
        getListView().setOnItemClickListener(this);
    }

    /**
     *
     * @return true or false depending on if the fucking database does shit
     */
    private boolean getCropListfromDB() {
        cropList = new CropList();
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //db stuff
        try {
            String url = "http://polls.apiblueprint.org/crops/";

            URL object = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) object.openConnection();
            connection.setRequestMethod("GET");

            InputStream response = connection.getInputStream();
            cropList.parseCrops(response);

        }
        catch (Exception e){
            //OH LOOK THE DATABASE DOESNT EXIST FUCKING SURPRISE
            InputStream noResponse = null;
            cropList.parseCrops(noResponse);
            return false;
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        //this changes the fragment to the 'crop info' one and sends 2 strings to be shown.
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("title", cropArray.getItem(position).toString());
        cropDescriptionArray = ArrayAdapter.createFromResource(getActivity(), R.array.CropDescriptions, android.R.layout.simple_list_item_1);
        setListAdapter(cropDescriptionArray);
        bundle.putString("body", cropDescriptionArray.getItem(position).toString());
        ((MainActivity) getActivity()).replaceFragments(CropInfoFragment.class, bundle);
    }
}
