package daffodilfestivalva.org.daffodilfestival2016;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private FragmentTransaction fragTransaction;
    private FragmentManager fragManager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBar = getSupportActionBar();
        navList = (ListView) findViewById(R.id.navList);

        ArrayList<String> navArray = new ArrayList<>(); //menu items
        navArray.add("Home");
        navArray.add("About Us");
        navArray.add("Vendors");
        navArray.add("Schedule of Events");
        navArray.add("Map");
        navArray.add("Transportation Information");
        navArray.add("Sponsors");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBar.setDisplayHomeAsUpEnabled(true); // Back button on the action bar when drawer is open
        actionBar.setDisplayShowHomeEnabled(true); // hamburger button when drawer is closed
        fragManager = getSupportFragmentManager();
        fragTransaction = fragManager.beginTransaction();

        loadFrag(0); //The default fragment is the home
    }

    private void loadFrag(int i)
    {
        navList.setItemChecked(i, true);
        if(i == 0)
        {
            actionBar.setTitle("Welcome to the 2016 Daffodil Festival");
            fragTransaction = fragManager.beginTransaction();
            HomeFragment home = new HomeFragment();
            fragTransaction.replace(R.id.fragmentholder,home);
            fragTransaction.commit();
        }
        else if(i == 1)
        {
            actionBar.setTitle("About Us");
            fragTransaction = fragManager.beginTransaction();
            AboutUs aboutUs = new AboutUs();
            fragTransaction.replace(R.id.fragmentholder,aboutUs);
            fragTransaction.commit();
        }
        else if(i == 2)
        {
            actionBar.setTitle("Vendors");
            fragTransaction = fragManager.beginTransaction();
            Vendors vendors = new Vendors();
            fragTransaction.replace(R.id.fragmentholder,vendors);
            fragTransaction.commit();
        }
        else if(i == 3)
        {
            actionBar.setTitle("Schedule");
            fragTransaction = fragManager.beginTransaction();
            Schedule schedule = new Schedule();
            fragTransaction.replace(R.id.fragmentholder,schedule);
            fragTransaction.commit();
        }
        else if(i == 4)
        {
            actionBar.setTitle("Map");
            fragTransaction = fragManager.beginTransaction();
            Map map = new Map();
            fragTransaction.replace(R.id.fragmentholder,map);
            fragTransaction.commit();
        }
        else if(i == 5)
        {
            actionBar.setTitle("Transportation Information");
            fragTransaction = fragManager.beginTransaction();
            Transportation transport = new Transportation();
            fragTransaction.replace(R.id.fragmentholder,transport);
            fragTransaction.commit();
        }
        else if(i == 6)
        {
            actionBar.setTitle("Sponsors");
            fragTransaction = fragManager.beginTransaction();
            Sponsors sponsors = new Sponsors();
            fragTransaction.replace(R.id.fragmentholder,sponsors);
            fragTransaction.commit();
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeFragment/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
            return true;
        else if(id == android.R.id.home)
        {
            if(drawerLayout.isDrawerOpen(navList))
                drawerLayout.closeDrawer(navList); //if drawer is open, close it
            else
                drawerLayout.openDrawer(navList); //if drawer is closed, open it
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadFrag(position); // load the correct fragment
        drawerLayout.closeDrawer(navList);
    }
}
