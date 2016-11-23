package ultrasupreem.aret;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataFragment extends Fragment implements OnClickListener {
    View view;

    // TODO: Rename and change types of parameters
    private long usedData;
    private long totalData;


    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data, container, false);

        // Inflate the layout for this fragment
        usedData = android.net.TrafficStats.getMobileRxBytes();
        totalData = android.net.TrafficStats.getTotalRxBytes();


        TextView usedDataText = (TextView)view.findViewById(R.id.usedData);
        usedDataText.setText(usedData + "");
        TextView totalDataText = (TextView)view.findViewById(R.id.totalData);
        totalDataText.setText(totalData + "");
        TextView outOfText = (TextView)view.findViewById(R.id.outOfData);

        outOfText.setText(totalData - usedData + " Remaining");

        if(usedData <= 0){
            usedDataText.setText("No data used");
        }
        if(totalData <=0){
            totalDataText.setText("No data available");
            outOfText.setText("");
        }




        return view;
    }


    @Override
    public void onClick(View view) {


    }
}

