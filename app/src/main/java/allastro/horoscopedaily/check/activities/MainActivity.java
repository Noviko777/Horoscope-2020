package allastro.horoscopedaily.check.activities;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener {

    private ActivityMainBinding activityMainBinding;
    private Intent intent;

    public MainActivity() {
        super(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setBasicClickHandlers(new BasicClickHandlers());
        activityMainBinding.setClickHandlers(new MainActivityClickHandlers());


    }

    public Integer getResourceFromImage(Integer id) {
        switch (id) {
            case R.id.aries:
                return R.drawable.aries_sign_big;
            case R.id.taurus:
                return R.drawable.taurus_sign_big;
            case R.id.gemini:
                return R.drawable.gemini_sign_big;
            case R.id.cancer:
                return R.drawable.cancer_sign_big;
            case R.id.leo:
                return R.drawable.leo_sign_big;
            case R.id.virgio:
                return R.drawable.virgio_sign_big;
            case R.id.libra:
                return R.drawable.libra_sign_big;
            case R.id.scorpio:
                return R.drawable.scorpio_sign_big;
            case R.id.sagittarius:
                return R.drawable.sagittarius_sign_big;
            case R.id.capricorn:
                return R.drawable.capricorn_sign_big;
            case R.id.aquarius:
                return R.drawable.aquarius_sign_big;
            case R.id.pisces:
                return R.drawable.pisces_sign_big;
            default:
                return R.drawable.aries_sign_big;
        }
    }

    public String getNameFromImage(Integer id) {
        switch (id) {
            case R.id.aries:
                return "????????";
            case R.id.taurus:
                return "??????????";
            case R.id.gemini:
                return "????????????????";
            case R.id.cancer:
                return "??????";
            case R.id.leo:
                return "??????";
            case R.id.virgio:
                return "????????";
            case R.id.libra:
                return "????????";
            case R.id.scorpio:
                return "????????????????";
            case R.id.sagittarius:
                return "??????????????";
            case R.id.capricorn:
                return "??????????????";
            case R.id.aquarius:
                return "??????????????";
            case R.id.pisces:
                return "????????";
            default:
                return "????????";
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }


    public class MainActivityClickHandlers {

        public void zodiacClick(View view) {



            intent = new Intent(MainActivity.this, ZodiakActivity.class);

            intent.putExtra("imageRes", getResourceFromImage(view.getId()));
            intent.putExtra("name", getNameFromImage(view.getId()));
            intent.putExtra("id", view.getId());


            new SpinnerDatePickerDialogBuilder()
                    .context(MainActivity.this)
                    .callback(MainActivity.this)
                    .spinnerTheme(R.style.NumberPickerStyle)
                    .showTitle(true)
                    .showDaySpinner(true)
                    .defaultDate(2000, 0, 1)
                    .maxDate(2001, 0, 1)
                    .minDate(1945, 0, 1)
                    .build()
                    .show();
        }

    }
}
