package ultrasupreem.aret;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginFragment extends Fragment implements OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_layout, null);

        Button login = (Button) root.findViewById(R.id.login_button);
        login.setOnClickListener(this);

        Button signupSwtich = (Button) root.findViewById(R.id.signup_switch_button);
        signupSwtich.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                ((MainActivity) getActivity()).replaceFragments(TabFragment.class);
                break;
            case R.id.signup_switch_button:
                ((MainActivity) getActivity()).replaceFragments(SignUpFragment.class);
                break;
        }
    }
}
