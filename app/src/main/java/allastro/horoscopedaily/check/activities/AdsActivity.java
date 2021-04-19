package allastro.horoscopedaily.check.activities;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityAdsBinding;

public class AdsActivity extends BaseActivity {

    private ActivityAdsBinding adsBinding;

    public AdsActivity() {
        super(5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        adsBinding = DataBindingUtil.setContentView(this, R.layout.activity_ads);
        adsBinding.setBasicClickHandlers(new BasicClickHandlers());
        adsBinding.setClickHandlers(new AdsClickHandlers());

    }

    public class AdsClickHandlers {

        public void adsClick(View view) {
            Toast.makeText(AdsActivity.this, "Server is not available, try again later", Toast.LENGTH_SHORT).show();
        }

    }

}
