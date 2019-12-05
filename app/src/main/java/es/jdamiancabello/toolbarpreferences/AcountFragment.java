package es.jdamiancabello.toolbarpreferences;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class AcountFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_preferences);
    }
}
