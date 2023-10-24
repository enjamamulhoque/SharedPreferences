package com.enjamamulhoque.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView settingsInfoView;
    Button goToSettingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsInfoView = findViewById(R.id.textView);
        goToSettingsBtn = findViewById(R.id.button);

        goToSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // NOTE: to get existing instance of SharedPreferences use the SAME name you have given when creating it and saving values
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", 0);

        // getting settings info from shared preferences
        // NOTE: use the same key name you have given when saving changes
        boolean switchValue = sharedPreferences.getBoolean("switch_key", false);
        String wiFiName = sharedPreferences.getString("wifi_key", "");
        String optionSelected = sharedPreferences.getString("list_key", "");

        String settingsInfoValues  = "Settings information \nSwitch Value: " + switchValue
                + "\nWi-FI name: " + wiFiName + "\nOption selected: " + optionSelected;

        settingsInfoView.setText(settingsInfoValues);
    }
}