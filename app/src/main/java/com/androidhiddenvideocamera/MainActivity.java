package com.androidhiddenvideocamera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.c.hiddenvideocamera.LoadService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadService.loadServiceData(this, "your own user ID", "type your own url", "type your Wi-FI macAddress");

    }


}
