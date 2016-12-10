package com.example.admin.exodia2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private boolean viewIsAtHome;
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        displayView(R.id.content_frame);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (!viewIsAtHome) { //if the current view is not the News fragment
            displayView(R.id.content_frame); //display the News fragment
            //Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            final Toast toast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 500);
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
            {
                finish();}
            mBackPressed = System.currentTimeMillis();//If view is in Home fragment, exit application
        }else {
            //Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            final Toast toast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 500);
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
            {
                finish();}
            mBackPressed = System.currentTimeMillis();//If view is in Home fragment, exit application

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            displayView(R.id.nav_home);
        } else if (id == R.id.nav_events) {
            displayView(R.id.nav_events);
        } else if (id == R.id.nav_schedule) {

        } else if (id == R.id.nav_favorite) {

        } else if (id == R.id.nav_directions) {
            startActivity(new Intent(MainActivity.this,Map_activity.class));
            return true;
        } else if (id == R.id.nav_register) {

        } else if (id == R.id.nav_app_credits) {

        } else if (id == R.id.nav_contact_us) {
            displayView(R.id.nav_contact_us);
        } else if (id == R.id.nav_sponsors) {
            displayView(R.id.nav_sponsors);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void displayView(int viewId) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {

            case R.id.nav_contact_us:
                fragment = new ContactUs();
                viewIsAtHome = true;
                title  = "Contacts";

                break;
            case R.id.nav_events:
                fragment = new EventsFragment();
                viewIsAtHome = true;
                title = "Events";
                break;
            case R.id.nav_home:
                fragment = new Home();
                viewIsAtHome= true;
                title = "Exodia";
                break;
            case R.id.nav_sponsors:
                fragment = new Sponsors();
                viewIsAtHome =true;
                title = "Sponsors";
                break;
            case R.id.nav_directions:
                fragment = new MapFrag();
                viewIsAtHome =true;
                title = "Campus Map";
                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
