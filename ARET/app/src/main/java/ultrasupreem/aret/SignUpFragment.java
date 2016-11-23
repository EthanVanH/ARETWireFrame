package ultrasupreem.aret;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SignUpFragment extends Fragment implements OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.signup_layout, null);

        String[] regions = {"Dedza", "Dowa", "Kasungu", "Lilongwe", "Mchinji", "Nkhotakota", "Ntcheu",
                "Ntchisi", "Salima", "Chitipa", "Karonga", "Likoma", "Mzimba", "Nkhata Bay", "Rumphi",
                "Balaka", "Blantyre", "Chikwawa", "Chiradzulu", "Machinga", "Mangochi", "Mulanje",
                "Mwanza", "Neno", "Nsanje", "Thyolo", "Phalombe", "Zomba",};
        Spinner spinner = (Spinner) root.findViewById(R.id.region_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, regions);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

        Button signup = (Button) root.findViewById(R.id.signup_button);
        signup.setOnClickListener(this);

        Button loginSwtich = (Button) root.findViewById(R.id.login_switch_button);
        loginSwtich.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.signup_button:
                ((MainActivity) getActivity()).replaceFragments(TabFragment.class);
                break;
            case R.id.login_switch_button:
                ((MainActivity) getActivity()).replaceFragments(LoginFragment.class);
                break;
        }
    }
}
