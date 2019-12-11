package es.jdamiancabello.toolbarpreferences;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

public class AcountFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_preferences);
        initPreferenceUser();
    }

    private void initPreferenceUser() {
        EditTextPreference edpUser = getPreferenceManager().findPreference(getString(R.string.key_user));

        edpUser.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            @Override
            public void onBindEditText(@NonNull EditText editText) {
                editText.setSingleLine(true);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                //Esta línea debe ser la ultima para seleccionar tod0 el texto
                editText.selectAll();
            }
        });

        EditTextPreference edpPassword = getPreferenceManager().findPreference(getString(R.string.key_user));

        edpPassword.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            @Override
            public void onBindEditText(@NonNull EditText editText) {
                editText.setSingleLine(true);
                editText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                //Esta línea debe ser la ultima para seleccionar tod0 el texto
                editText.selectAll();
            }
        });

    }
}
