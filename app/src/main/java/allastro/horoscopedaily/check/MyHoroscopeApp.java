package allastro.horoscopedaily.check;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Timer;
import java.util.TimerTask;

public class MyHoroscopeApp extends Application {

    public static int counter = 30;

    private static MyHoroscopeApp mInstance;

    public static Context getContext() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        String appToken = "6k913bt0vgxs";
        String environment = AdjustConfig.ENVIRONMENT_PRODUCTION;
        AdjustConfig config = new AdjustConfig(this, appToken, environment);
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


    }


}
