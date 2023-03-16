package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.navigationdrawer.databinding.ActivityMainBinding;
import com.example.navigationdrawer.databinding.AppBarMainBinding;
import com.example.navigationdrawer.databinding.ContentMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding b ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setSupportActionBar(b.toolbar.toolBar);

        b.navView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, b.drawerLayout, b.toolbar.toolBar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        b.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
            b.navView.setCheckedItem(R.id.drawer_message);
        }

    }

    @Override
    public void onBackPressed() {
        if (b.drawerLayout.isDrawerOpen(GravityCompat.START)){
            b.drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.drawer_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                break;
            case R.id.drawer_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatFragment()).commit();
                break;
            case R.id.drawer_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                break;
            case R.id.drawer_communicate_share:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                break;
            case R.id.drawer_communicate_send:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SendFragment()).commit();
                break;
            }
            b.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}