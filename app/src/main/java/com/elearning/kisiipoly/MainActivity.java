package com.elearning.kisii_national_polytechnic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
  private DrawerLayout drawerLayout;
  private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

// ========================add menu icon on top using actinbartoggle==========================
        drawerLayout= findViewById(R.id.drawer_layout);

        NavigationView navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classMainHome()).commit();
            navigationView.setCheckedItem(R.id.nav_mainhome);

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_mainhome:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classMainHome()).commit();
                break;

            case R.id.menu_eResources:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classEresource()).commit();
                break;

            case R.id.menu_competency:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classCompetency()).commit();
                break;

            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classHome()).commit();
                break;

            case R.id.menu_artisan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classArtisan()).commit();
                break;

            case R.id.menu_certificate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classCertificate()).commit();
                break;

            case R.id.menu_diploma:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classDiploma()).commit();
                break;

            case R.id.menu_hdiploma:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classHdiploma()).commit();
                break;

            case R.id.menu_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Welcome to Kisiipoly e-Learning.Access all services Mobile App.";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Kisiipoly e-Learning");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

            case R.id.menu_faq:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new classFaq()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //===========when menu is preesed back==============
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
//        to make transparent background when menu pressed, create new style if the API level is 21>
    }
}
