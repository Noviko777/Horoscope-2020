package allastro.horoscopedaily.check.activities;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityMagicBallBinding;
import allastro.horoscopedaily.check.viewmodel.MagicBallViewModel;


public class MagicBallActivity extends BaseActivity {

    private ActivityMagicBallBinding activityMagicBallBinding;
    private MagicBallViewModel viewModel;

    public MagicBallActivity() {
        super(3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_ball);

        activityMagicBallBinding = DataBindingUtil.setContentView(this, R.layout.activity_magic_ball);
        activityMagicBallBinding.setBasicClickHandlers(new BasicClickHandlers());
        activityMagicBallBinding.setMagicBallClickHandlers(new ActivityMagicBallClickHandlers());

        viewModel = new ViewModelProvider(this).get(MagicBallViewModel.class);
        viewModel.getAnswerVisibility().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                activityMagicBallBinding.setAnswerVisibility(aBoolean);
            }
        });
        viewModel.getAnswer().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                activityMagicBallBinding.setAnswer(s);
            }
        });
    }

    public class ActivityMagicBallClickHandlers {

        public void answerClick(View view) {
            if(!viewModel.getAnswerVisibility().getValue()) {
                viewModel.setAnswer(new Random().nextBoolean() ? "Да!" : "Нет!");
                viewModel.setAnswerVisibility(true);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                viewModel.setAnswerVisibility(false);
                            }
                        });

                    }
                }, 1000);
            }


        }

    }

}
