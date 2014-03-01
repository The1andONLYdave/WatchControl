package com.dlka.watcheverremote;



import java.util.List;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.dlka.watcheveremote.R;


/**
 * The sample control preference activity handles the preferences for the sample
 * control extension.
 */
public class MyPreferenceActivity extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        return dialog;
    }

}
