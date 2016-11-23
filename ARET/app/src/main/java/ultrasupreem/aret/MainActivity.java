package ultrasupreem.aret;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    User user = new User();

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drawerLayout setup
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //navigationView setup
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        //inflate first fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new LoginFragment()).commit();

        //setup drawer items (Navigation View)
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();

                if(menuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    dfragmentTransaction.replace(R.id.containerView,new TabFragment()).addToBackStack(null).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_account) {
                    //FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    //dfragmentTransaction.replace(R.id.containerView,new FRAGMENT2LOAD()).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_data) {
                    //FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    //dfragmentTransaction.replace(R.id.containerView,new DataFragment()).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_saved) {
                    FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    dfragmentTransaction.replace(R.id.containerView,new CropFragment()).addToBackStack(null).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_settings) {
                    FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    dfragmentTransaction.replace(R.id.containerView,new notFoundFragment()).addToBackStack(null).commit();
                }
                return false;
            }
        });

    }

    public void replaceFragments(Class fragmentClass, Bundle bundle) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerView, fragment)
                .addToBackStack(null).commit();
    }

    public void replaceFragments(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerView, fragment)
                .addToBackStack(null).commit();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        if (u==null) {
            return;
        } else {
            user = u;
        }
    }
}
