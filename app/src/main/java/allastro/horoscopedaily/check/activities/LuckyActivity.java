package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityLuckyBinding;
import allastro.horoscopedaily.check.model.Lucky;

public class LuckyActivity extends BaseActivity {

    private ActivityLuckyBinding luckyBinding;
    private Lucky lucky;


    public LuckyActivity() {
        super(-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        luckyBinding = DataBindingUtil.setContentView(this, R.layout.activity_lucky);
        luckyBinding.setBasicClickHandlers(new BasicClickHandlers());
        lucky = new Lucky();
        setRandomLucky();
        luckyBinding.setLucky(lucky);
        luckyBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomLucky();

            }
        });

    }

    private String getRandomColor() {
        switch (new Random().nextInt(12)) {
            case 0:
                return "белый";
            case 1:
                return "черный";
            case 2:
                return "оранжевый";
            case 3:
                return "красный";
            case 4:
                return "синий";
            case 5:
                return "зелёный";
            case 6:
                return "коричневый";
            case 7:
                return "фиолетовый";
            case 8:
                return "розовый";
            case 9:
                return "жёлтый";
            case 10:
                return "бирюзовый";
            default:
                return "голубой";
        }
    }

    private void setRandomLucky() {

        lucky.setNumb1(String.valueOf(new Random().nextInt(100)));
        lucky.setNumb2(String.valueOf(new Random().nextInt(100)));
        lucky.setNumb3(String.valueOf(new Random().nextInt(100)));
        lucky.setNumb4(String.valueOf(new Random().nextInt(100)));
        lucky.setNumb5(String.valueOf(new Random().nextInt(100)));
        String color = getRandomColor();
        luckyBinding.setAnswer("Ваше счастливое число: " + lucky.getNumb1() + "-" + lucky.getNumb2() + "-"
                + lucky.getNumb3() + "-" + lucky.getNumb4() + "-" + lucky.getNumb5()
                + "\nВаш счастливый цвет: " + color);
    }


}
