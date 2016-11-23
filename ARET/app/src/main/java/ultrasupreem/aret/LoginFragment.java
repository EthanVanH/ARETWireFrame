package ultrasupreem.aret;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginFragment extends Fragment implements OnClickListener {
    private static final String url = "https://jhvisser.com/aret/users/";
    private String JSONTurd = "";

    public User user;

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

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            URL object = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) object.openConnection();
            connection.setRequestMethod("GET");

            //Connect to the database and pull a JSON String object which
            //literally could have been made in ten seconds
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                JSONTurd = JSONTurd + inputLine;
            in.close();
            System.out.println("printing json");
            System.out.println(JSONTurd);

            //Check if the username they typed exists. For some reason there aren't
            // passwords in the db so we can't check tht
            String searchString = "\"email\": " + "\"" + username +"\"";
            if(JSONTurd.contains(searchString))
            {
                //don't give a shit about parsing rn
                ((MainActivity)getActivity()).setUser(new User(null, username, null, null, null));
            }
            else
            {
                System.out.println("Fuck off");
                System.out.println(searchString);
            }



           // InputStream response = connection.getInputStream();
           // System.out.println("response is: " + connection.getInputStream());
            //Somehow parse the response but it should never get there as i dont have a database
            // This if statement must be changed from response != null
           /* if (response != null){
                User temp = new User();
                return temp;
            }*/
        }
        catch (Exception e){
            //OH LOOK THE DATABASE DOESNT EXIST FUCKING SURPRISE
        }
        return null;//user not found
    }
}
