package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

import allastro.horoscopedaily.check.HoroscopeUtil;
import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityCookieBinding;
import allastro.horoscopedaily.check.viewmodel.CookieViewModel;

public class CookieActivity extends BaseActivity {

    private ActivityCookieBinding activityCookieBinding;
    private CookieViewModel viewModel;

    public CookieActivity() {
        super(4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

        activityCookieBinding = DataBindingUtil.setContentView(this, R.layout.activity_cookie);
        activityCookieBinding.setBasicClickHandlers(new BasicClickHandlers());
        activityCookieBinding.setCookieClickHandlers(new ActivityCookieClickHandlers());

        viewModel = new ViewModelProvider(this).get(CookieViewModel.class);

        viewModel.getAnswerVisibility().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                activityCookieBinding.setAnswerVisibility(aBoolean);
            }
        });
        viewModel.getAnswer().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                activityCookieBinding.setAnswer(s);
            }
        });



    }

    public class ActivityCookieClickHandlers {

        public void cookieClick(View view) {
            if(!viewModel.getAnswerVisibility().getValue()) {
                viewModel.setAnswerVisibility(true);
                viewModel.setAnswer(HoroscopeUtil.COOKIES[new Random().nextInt(HoroscopeUtil.COOKIES.length)]);
            }

        }

    }

}
