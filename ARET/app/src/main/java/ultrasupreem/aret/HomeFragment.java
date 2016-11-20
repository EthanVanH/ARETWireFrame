package ultrasupreem.aret;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_layout,null);

        final TextView headerText = (TextView) rootView.findViewById(R.id.detail_description_content);
        headerText.setText("Header  (see more ...)");
        final TextView showAll = (TextView) rootView.findViewById(R.id.detail_read_all);
        headerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll.isShown()) {
                    showAll.setVisibility(View.GONE);
                    headerText.setText("Header  (see more ...)");
                } else {
                    showAll.setVisibility(View.VISIBLE);
                    headerText.setText("Header  (less ...)");
                }
            }
        });
        final TextView headerText2 = (TextView) rootView.findViewById(R.id.detail_description_content2);
        headerText2.setText("Header  (see more ...)");
        final TextView showAll2 = (TextView) rootView.findViewById(R.id.detail_read_all2);
        headerText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll2.isShown()) {
                    showAll2.setVisibility(View.GONE);
                    headerText2.setText("Header  (see more ...)");
                } else {
                    showAll2.setVisibility(View.VISIBLE);
                    headerText2.setText("Header  (less ...)");
                }
            }
        });

        return rootView;
    }

}
