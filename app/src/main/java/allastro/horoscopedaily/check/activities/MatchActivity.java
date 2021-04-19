package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityMatchBinding;
import allastro.horoscopedaily.check.viewmodel.MatchViewModel;

public class MatchActivity extends BaseActivity {

    private ActivityMatchBinding activityMatchBinding;
    private MatchViewModel matchViewModel;

    public MatchActivity() {
        super(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        activityMatchBinding = DataBindingUtil.setContentView(this, R.layout.activity_match);
        activityMatchBinding.setBasicClickHandlers(new BasicClickHandlers());
        activityMatchBinding.setClickHandlers(new MatchClickHandlers());

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);


    }

    public Integer getResourceFromImage(Integer id) {
        switch (id) {
            case R.id.aries:
                return R.drawable.aries_sign_for_match;
            case R.id.taurus:
                return R.drawable.taurus_sign_for_match;
            case R.id.gemini:
                return R.drawable.gemini_sign_for_match;
            case R.id.cancer:
                return R.drawable.cancer_sign_for_match;
            case R.id.leo:
                return R.drawable.leo_sign_for_match;
            case R.id.virgio:
                return R.drawable.virgio_sign_for_match;
            case R.id.libra:
                return R.drawable.libra_sign_for_match;
            case R.id.scorpio:
                return R.drawable.scorpio_sign_for_match;
            case R.id.sagittarius:
                return R.drawable.sagittarius_sign_for_match;
            case R.id.capricorn:
                return R.drawable.capricorn_sign_for_match;
            case R.id.aquarius:
                return R.drawable.aquarius_sign_for_match;
            case R.id.pisces:
                return R.drawable.pisces_sign_for_match;
            default:
                return R.drawable.aries_sign_for_match;
        }
    }

    public String getNameFromImage(Integer id) {
        switch (id) {
            case R.id.aries:
                return "Овен";
            case R.id.taurus:
                return "Телец";
            case R.id.gemini:
                return "Близнецы";
            case R.id.cancer:
                return "Рак";
            case R.id.leo:
                return "Лев";
            case R.id.virgio:
                return "Дева";
            case R.id.libra:
                return "Весы";
            case R.id.scorpio:
                return "Скорпион";
            case R.id.sagittarius:
                return "Стрелец";
            case R.id.capricorn:
                return "Козерог";
            case R.id.aquarius:
                return "Водолей";
            case R.id.pisces:
                return "Рыбы";
            default:
                return "Овен";
        }
    }

    public class MatchClickHandlers {

        public void zodiacClick(View view) {
            if(!matchViewModel.isFirstPerson()) {
                matchViewModel.setFirstPerson(true);
                ((ImageView)findViewById(R.id.leftZodiak)).setImageResource(getResourceFromImage(view.getId()));
                matchViewModel.setLeftId(view.getId());
                matchViewModel.setFirstZodiak(getNameFromImage(view.getId()));
            } else if(!matchViewModel.isSecondPerson()) {
                matchViewModel.setSecondPerson(true);
                ((ImageView)findViewById(R.id.rightZodiak)).setImageResource(getResourceFromImage(view.getId()));
                matchViewModel.setRightId(view.getId());
                matchViewModel.setSecondZodiak(getNameFromImage(view.getId()));
                Intent intent = new Intent(MatchActivity.this, MatchResultActivity.class);
                intent.putExtra("left", matchViewModel.getLeftId());
                intent.putExtra("right", matchViewModel.getRightId());
                intent.putExtra("firstZodiak", matchViewModel.getFirstZodiak());
                intent.putExtra("secondZodiak", matchViewModel.getSecondZodiak());
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }



        }

    }

}
