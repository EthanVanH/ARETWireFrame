package ultrasupreem.aret;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CropInfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.crop_info_layout,null);

        String title = getArguments().getString("title");
        TextView tvTitle = (TextView) root.findViewById(R.id.crop_title);
        tvTitle.setText(title);

        String body = getArguments().getString("body");
        TextView tvBody = (TextView) root.findViewById(R.id.crop_body);
        tvBody.setText(body);
        return root;
    }
}
