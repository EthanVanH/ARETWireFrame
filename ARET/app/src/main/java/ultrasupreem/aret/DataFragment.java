package ultrasupreem.aret;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;



public class DataFragment extends Fragment implements OnClickListener {

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("bytes recvd", "" + android.net.TrafficStats.getMobileRxBytes());
        Log.e("Total", "Bytes received" + android.net.TrafficStats.getTotalRxBytes());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }


    @Override
    public void onClick(View view) {


    }
}

