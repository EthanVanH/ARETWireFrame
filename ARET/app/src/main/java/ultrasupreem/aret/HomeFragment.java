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
        //expandable boxes
        final TextView headerText = (TextView) rootView.findViewById(R.id.detail_description_content);
        headerText.setText("Lorem ipsum  (see more ...)");
        final TextView showAll = (TextView) rootView.findViewById(R.id.detail_read_all);
        headerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll.isShown()) {
                    showAll.setVisibility(View.GONE);
                    headerText.setText("Lorem ipsum  (see more ...)");
                } else {
                    showAll.setVisibility(View.VISIBLE);
                    headerText.setText("Lorem ipsum  (less ...)");
                }
            }
        });
        final TextView headerText2 = (TextView) rootView.findViewById(R.id.detail_description_content2);
        headerText2.setText("2016 ARET Tobacco Symposium  (see more ...)");
        final TextView showAll2 = (TextView) rootView.findViewById(R.id.detail_read_all2);
        headerText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll2.isShown()) {
                    showAll2.setVisibility(View.GONE);
                    headerText2.setText("2016 ARET Tobacco Symposium  (see more ...)");
                } else {
                    showAll2.setVisibility(View.VISIBLE);
                    headerText2.setText("2016 ARET Tobacco Symposium  (less ...)");
                }
            }
        });
        final TextView headerText3 = (TextView) rootView.findViewById(R.id.detail_description_content3);
        headerText3.setText("Extension  (see more ...)");
        final TextView showAll3 = (TextView) rootView.findViewById(R.id.detail_read_all3);
        headerText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll3.isShown()) {
                    showAll3.setVisibility(View.GONE);
                    headerText3.setText("Extension  (see more ...)");
                } else {
                    showAll3.setVisibility(View.VISIBLE);
                    headerText3.setText("Extension  (less ...)");
                }
            }
        });
        final TextView headerText4 = (TextView) rootView.findViewById(R.id.detail_description_content4);
        headerText4.setText("Research  (see more ...)");
        final TextView showAll4 = (TextView) rootView.findViewById(R.id.detail_read_all4);
        headerText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll4.isShown()) {
                    showAll4.setVisibility(View.GONE);
                    headerText4.setText("Research  (see more ...)");
                } else {
                    showAll4.setVisibility(View.VISIBLE);
                    headerText4.setText("Research  (less ...)");
                }
            }
        });
        final TextView headerText5 = (TextView) rootView.findViewById(R.id.detail_description_content5);
        headerText5.setText("Welcome to ARET  (see more ...)");
        final TextView showAll5 = (TextView) rootView.findViewById(R.id.detail_read_all5);
        headerText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showAll5.isShown()) {
                    showAll5.setVisibility(View.GONE);
                    headerText5.setText("Welcome to ARET  (see more ...)");
                } else {
                    showAll5.setVisibility(View.VISIBLE);
                    headerText5.setText("Welcome to ARET  (less ...)");
                }
            }
        });

        return rootView;
    }

}
