package com.enjamamulhoque.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);



        findPreference("notifications").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {

                Toast.makeText(getActivity(), "Switch: " + newValue, Toast.LENGTH_SHORT).show();

                // creating SharedPreferences instance with a name
                // NOTE: name can be ANY string you want, but use the SAME name when retrieving the values
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPrefs", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // NOTE: here you can give ANY string as a key name, but use the SAME key name when retrieving the value
                // IMPORTANT: DON'T use its key as key name here
                editor.putBoolean("switch_key", Boolean.parseBoolean(newValue.toString()));
                editor.apply();

                return true;
            }
        });


        findPreference("wifi").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {

                Toast.makeText(getActivity(), "Wi-Fi: " + newValue, Toast.LENGTH_SHORT).show();

                // creating SharedPreferences instance with a name
                // NOTE: name can be ANY string you want, but use the SAME name when retrieving the values
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPrefs", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // NOTE: here you can give ANY string as a key name, but use the SAME key name when retrieving the value
                // IMPORTANT: DON'T use its key as key name here
                editor.putString("wifi_key", newValue.toString());
                editor.apply();

                return true;
            }
        });

        findPreference("list").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {

                Toast.makeText(getActivity(), "Option selected: " + newValue, Toast.LENGTH_SHORT).show();

                // creating SharedPreferences instance with a name
                // NOTE: name can be ANY string you want, but use the SAME name when retrieving the values
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPrefs", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // NOTE: here you can give ANY string as a key name, but use the SAME key name when retrieving the value
                // IMPORTANT: DON'T use its key as key name here
                editor.putString("list_key", newValue.toString());
                editor.apply();

                return true;
            }
        });


        findPreference("feedback").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(@NonNull Preference preference) {

                Toast.makeText(getActivity(), "Clicked: " + preference.getKey(), Toast.LENGTH_SHORT).show();


                return true;
            }
        });
    }
}