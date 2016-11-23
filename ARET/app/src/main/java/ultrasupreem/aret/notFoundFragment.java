package ultrasupreem.aret;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class notFoundFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.not_found_layout, null);

        Button back = (Button) root.findViewById(R.id.back_404_button);
        back.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.back_404_button:
                ((MainActivity) getActivity()).replaceFragments(TabFragment.class);
                break;
        }
    }
}
