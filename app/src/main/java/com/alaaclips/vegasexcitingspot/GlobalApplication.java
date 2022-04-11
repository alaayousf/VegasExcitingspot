package com.alaaclips.vegasexcitingspot;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.onesignal.OSDeviceState;
import com.onesignal.OSSubscriptionObserver;
import com.onesignal.OSSubscriptionStateChanges;
import com.onesignal.OneSignal;

public class GlobalApplication extends Application {




    @Override
    public void onCreate() {
        super.onCreate();


        String appToken = "5i0ikg0pnaio";
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(this, appToken, environment);
        config.setLogLevel(LogLevel.WARN);


        Log.e("ALAA","is valde"+config.isValid());



        config.setOnEventTrackingSucceededListener(S->{
            Log.e("ALAA","EventTrackingSucceededListener");
        });


        config.setOnEventTrackingFailedListener(S->{
            Log.e("ALAA","setOnEventTrackingFailedListener");
        });

        config.setOnAttributionChangedListener(e->{
            Log.e("ALAA","setOnAttributionChangedListener");

        });

//        Adjust.addSessionCallbackParameter("sc_foo","sc_bar");
//        Adjust.addSessionCallbackParameter("sc_key","sc_value");
//
//
//        Adjust.addSessionPartnerParameter("sc_foo","sc_bar");
//        Adjust.addSessionPartnerParameter("sc_key","sc_value");




        config.setSendInBackground(true);



        Adjust.onCreate(config);

        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());



    }

    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }

        //...
    }
}


