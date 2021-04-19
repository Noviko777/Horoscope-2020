package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivitySplashAdsBinding;

public class SplashAdsActivity extends AppCompatActivity {

    private ActivitySplashAdsBinding adsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ads);

        adsBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash_ads);
        adsBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putBoolean("ads", false).apply();
                Intent intent = new Intent(SplashAdsActivity.this, MagicBallActivity.class);
                startActivity(intent);
                Animatoo.animateFade(SplashAdsActivity.this);
                finish();
            }
        });

    }
}
