package com.example.swachh_bharat;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;

/**
 * Created by praveena on 12/6/15.
 */
public class SwatchBharathApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SwatchBharath", "OnCreate of the application");
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "JhuZ4VjXGVrbXQMmukuEslLCygeQPuzjaLbBIURw", "RHLIlS3FDsauiAaqGccm2XCAyNFZlWjTwQEMULYJ");

    }


}
