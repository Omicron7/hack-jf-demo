package com.example.brian.jesusfilm;

import android.content.Intent;
import android.provider.Settings.Secure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.brian.jesusfilm.deeplink.GodToolsDeepLink;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchGodTools(View v) {
        String deviceId = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID);
        GodToolsDeepLink gtdl = new GodToolsDeepLink.Builder(deviceId).build();
        Log.d("JesusFilm", gtdl.deeplink().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, gtdl.deeplink());
        startActivity(intent);
    }
}
