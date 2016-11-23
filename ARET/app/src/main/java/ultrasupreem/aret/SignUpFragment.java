package ultrasupreem.aret;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUpFragment extends Fragment implements OnClickListener {
    private static final String url = "https://jhvisser.com/aret/users/?district=&crop=&first_name=&last_name=&limit=";

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
                String firstname = ((EditText) getView().findViewById(R.id.firstname_signup)).getText().toString();
                String lastname = ((EditText) getView().findViewById(R.id.lastname_signup)).getText().toString();
                String username = ((EditText) getView().findViewById(R.id.username_signup)).getText().toString();
                String password = ((EditText) getView().findViewById(R.id.password_signup)).getText().toString();
                String region = ((Spinner) getView().findViewById(R.id.region_spinner)).getSelectedItem().toString();

                if(firstname.isEmpty()) {
                    Toast.makeText(getActivity(), "First name is required", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(lastname.isEmpty()) {
                    Toast.makeText(getActivity(), "Last name is required", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(username.isEmpty()) {
                    Toast.makeText(getActivity(), "Email address is required", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(password.isEmpty()) {
                    Toast.makeText(getActivity(), "Password is required", Toast.LENGTH_SHORT).show();
                    break;
                }

                ((MainActivity) getActivity()).setUser(addUserToDB(firstname, lastname, username, password, region));


                if (((MainActivity)getActivity()).getUser().token) {
                    ((MainActivity) getActivity()).replaceFragments(TabFragment.class);
                } else {
                    Toast.makeText(getActivity(), "User already exists please login", Toast.LENGTH_LONG).show();
                }
                ((MainActivity) getActivity()).replaceFragments(TabFragment.class);
                break;
            case R.id.login_switch_button:
                ((MainActivity) getActivity()).replaceFragments(LoginFragment.class);
                break;
        }
    }


    /*
    returns null if user already exists in db or the new User that was added to the db
     */
    private User addUserToDB(String firstname, String lastname, String username, String password, String region) {
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //db stuff
        User temp = new User(firstname, lastname, username, password, region);
        try {
            URL object = new URL(url);


            HttpURLConnection connection = (HttpURLConnection) object.openConnection();
            String urlParameters = "district="+region+"&crop=shit"+"&first_name="+firstname+"&last_name="+lastname+"&limit=1";

            connection.setDoInput(true);
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = rd.readLine()) != null) {
                System.out.println(line);
                System.out.println('\r');
            }
            rd.close();

        }
        catch (Exception e){
            //OH LOOK THE DATABASE DOESNT EXIST FUCKING SURPRISE
        }
        return temp;
    }


}
