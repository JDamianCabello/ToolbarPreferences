package es.jdamiancabello.toolbarpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_preferences);
        //Se quere recoger el evento cuando se modifique el String
        onSharedPreferenceChanged(PreferenceManager.getDefaultSharedPreferences(getActivity()),getString(R.string.key_ringtone_notification));

        onSharedPreferenceChanged(PreferenceManager.getDefaultSharedPreferences(getActivity()),getString(R.string.key_psw));

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);

        if(key.equals(getString(R.string.key_ringtone_notification))){
            //Downcasting
            ListPreference listPreference = (ListPreference)preference;
            int prefIndex = listPreference.findIndexOfValue(sharedPreferences.getString(key,null));

            if(prefIndex >= 0)
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            else
                preference.setSummary(sharedPreferences.getString(key,null));
        }
    }

}
