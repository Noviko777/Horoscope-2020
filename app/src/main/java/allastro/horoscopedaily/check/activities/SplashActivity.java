package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Timer;
import java.util.TimerTask;

import allastro.horoscopedaily.check.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = null;
                        SharedPreferences sharedPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        if(sharedPreference.getBoolean("ads", true)) {
                            intent = new Intent(SplashActivity.this, SplashAdsActivity.class);
                            startActivity(intent);
                            Animatoo.animateSplit(SplashActivity.this);
                            finish();

                        } else {
                            intent = new Intent(SplashActivity.this, MagicBallActivity.class);
                            startActivity(intent);
                            Animatoo.animateFade(SplashActivity.this);
                            finish();
                        }

                    }
                });



            }
        }, 1500);

    }
}
