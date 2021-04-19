package allastro.horoscopedaily.check.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Timer;
import java.util.TimerTask;

import allastro.horoscopedaily.check.AdsUtil;
import allastro.horoscopedaily.check.MyHoroscopeApp;

public class BaseActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private Timer timer = new Timer();

    private int num;

    public BaseActivity(int num) {
        this.num = num;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobileAds.initialize(MyHoroscopeApp.getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(MyHoroscopeApp.getContext());
        mInterstitialAd.setAdUnitId(AdsUtil.INTERSTITIAL);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        showInterstitalAds();
    }

    private void showInterstitalAds() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(MyHoroscopeApp.counter > 0) {
                            MyHoroscopeApp.counter--;
                        }
                        else {
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                                Log.d("MYADS", "Show ads");
                            } else {
                                Log.d("MYADS", "The interstitial wasn't loaded yet.");
                            }
                            cancel();
                        }
                    }
                });


            }
        }, 1000, 1000);

    }

    @Override
    protected void onStop() {
        timer.cancel();
        super.onStop();
    }

    public class BasicClickHandlers {

        public void starClick(View view) {
            if(num != 1) {
                if(MyHoroscopeApp.counter <= 0) {
                    MyHoroscopeApp.counter = 30;
                    showInterstitalAds();
                }
                Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                startActivity(intent);
                Animatoo.animateFade(BaseActivity.this);
                finish();
            }

        }

        public void matchClick(View view) {
            if(num != 2) {
                if(MyHoroscopeApp.counter <= 0) {
                    MyHoroscopeApp.counter = 30;
                    showInterstitalAds();
                }
                Intent intent = new Intent(BaseActivity.this, MatchActivity.class);
                startActivity(intent);
                Animatoo.animateFade(BaseActivity.this);
                finish();
            }

        }

        public void magicBallClick(View view) {
            if(num != 3) {
                if(MyHoroscopeApp.counter <= 0) {
                    MyHoroscopeApp.counter = 30;
                    showInterstitalAds();
                }
                Intent intent = new Intent(BaseActivity.this, MagicBallActivity.class);
                startActivity(intent);
                Animatoo.animateFade(BaseActivity.this);
                finish();
            }

        }

        public void cookieClick(View view) {
            if(num != 4) {
                if(MyHoroscopeApp.counter <= 0) {
                    MyHoroscopeApp.counter = 30;
                    showInterstitalAds();
                }
                Intent intent = new Intent(BaseActivity.this, CookieActivity.class);
                startActivity(intent);
                Animatoo.animateFade(BaseActivity.this);
                finish();
            }

        }

        public void handClick(View view) {
            if(num != 5) {
                if(MyHoroscopeApp.counter <= 0) {
                    MyHoroscopeApp.counter = 30;
                    showInterstitalAds();
                }
                Intent intent = new Intent(BaseActivity.this, AdsActivity.class);
                startActivity(intent);
                Animatoo.animateFade(BaseActivity.this);
                finish();
            }

        }

    }

}
