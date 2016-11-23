package ultrasupreem.aret;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String username = ((EditText) getView().findViewById(R.id.username_login)).getText().toString();
                String password = ((EditText) getView().findViewById(R.id.password_login)).getText().toString();

                ((MainActivity)getActivity()).setUser(checkDBForUser(username, password));

                if (((MainActivity)getActivity()).getUser().token) {
                    ((MainActivity) getActivity()).replaceFragments(TabFragment.class);
                } else {
                    Toast.makeText(getActivity(), "Username or password incorrect", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.signup_switch_button:
                ((MainActivity) getActivity()).replaceFragments(SignUpFragment.class);
                break;
        }
    }

    /*
    returns a User if it exists in the DB or null if not found
     */
    private User checkDBForUser(String username, String password) {
        //db stuff
        return null;//user not found
    }
}
