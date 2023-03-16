package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.navigationdrawer.databinding.ActivityMainBinding;
import com.example.navigationdrawer.databinding.AppBarMainBinding;
import com.example.navigationdrawer.databinding.ContentMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b ;
    AppBarMainBinding c;
    ContentMainBinding d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setSupportActionBar(b.toolbar.toolBar);

      
    }
}