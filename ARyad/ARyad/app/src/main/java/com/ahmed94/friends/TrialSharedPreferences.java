package com.ahmed94.friends;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TrialSharedPreferences {

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private final long ONE_DAY = 24 * 60 * 60 * 1000;
//    private final long ONE_DAY = 10;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public TrialSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("TRIAL", context.MODE_PRIVATE);
    }

    public void controlTrial(TrialCallback trialCallback) {
        String installDate = sharedPreferences.getString("InstallDate", null);
        if (installDate == null) {
            Log.d("TrialSharedPreferences", "controlTrial: FIRST RUN :: START TRIAL DATE WILL BE REGISTERED NOW");

            editor = sharedPreferences.edit();
            Date now = new Date();
            String dateString = formatter.format(now);
            editor.putString("InstallDate", dateString);
            editor.apply();
            trialCallback.onActive();

        } else {
            Date before = null;
            try {
                before = formatter.parse(installDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date now = new Date();
            long diff = now.getTime() - Objects.requireNonNull(before).getTime();
            long days = diff / ONE_DAY;
            if (days > 30) { // More than 30 days?
                // Expired !!!
                trialCallback.onTrialEnd();
                Log.d("TrialSharedPreferences", "controlTrial: TRIAL VERSION END");
            }
        }
    }
}
