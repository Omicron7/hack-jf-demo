package com.example.brian.jesusfilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.brian.jesusfilm.deeplink.GodToolsDeepLink;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchGodTools(View v) {
        GodToolsDeepLink gtdl = new GodToolsDeepLink.Builder().build();
        Intent intent = new Intent(Intent.ACTION_VIEW, gtdl.deeplink());
        startActivity(intent);
    }
}
