package ultrasupreem.aret;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
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
        fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

        //setup drawer items (Navigation View)
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();

                if(menuItem.getItemId() == R.id.nav_item_account) {
                    //FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    //dfragmentTransaction.replace(R.id.containerView,new FRAGMENT2LOAD()).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_data) {
                    //FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    //dfragmentTransaction.replace(R.id.containerView,new FRAGMENT2LOAD()).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_saved) {
                    //FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    //dfragmentTransaction.replace(R.id.containerView,new FRAGMENT2LOAD()).commit();
                }
                if(menuItem.getItemId() == R.id.nav_item_settings) {
                    //FragmentTransaction dfragmentTransaction = fragmentManager.beginTransaction();
                    //dfragmentTransaction.replace(R.id.containerView,new FRAGMENT2LOAD()).commit();
                }
                return false;
            }
        });

        //drawer toggle
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
