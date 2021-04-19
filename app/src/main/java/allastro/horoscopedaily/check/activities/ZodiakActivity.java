package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import allastro.horoscopedaily.check.HoroscopeUtil;
import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.ActivityZodiakBinding;
import allastro.horoscopedaily.check.model.Horoscope;
import allastro.horoscopedaily.check.viewmodel.ZodiakViewModel;

public class ZodiakActivity extends BaseActivity {

    private ActivityZodiakBinding zodiakBinding;
    private ZodiakViewModel viewModel;
    private Horoscope horoscope;
    private ScrollView scrollView;

    public ZodiakActivity() {
        super(-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiak);

        zodiakBinding = DataBindingUtil.setContentView(this, R.layout.activity_zodiak);
        zodiakBinding.setBasicClickHandlers(new BasicClickHandlers());
        zodiakBinding.setZodiakClickHandlers(new ZodiakClickHanlders());
        viewModel = new ViewModelProvider(this).get(ZodiakViewModel.class);
        viewModel.getHoroscopeChooser().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                zodiakBinding.setHoroscopeChooser(integer);
            }
        });

        horoscope = new Horoscope("Сегодня", HoroscopeUtil.TODAY[getCurrent(getIntent().getIntExtra("id", 0))]);
        zodiakBinding.setHoroscope(horoscope);
        zodiakBinding.setImageRes(getIntent().getIntExtra("imageRes", 0));
        zodiakBinding.setZodiakName(getIntent().getStringExtra("name"));
        scrollView = zodiakBinding.scrollView;
    }

    public int getCurrent(Integer id) {
        switch (id) {
            case R.id.aries:
                return HoroscopeUtil.ARIES;
            case R.id.taurus:
                return HoroscopeUtil.TAURUS;
            case R.id.gemini:
                return HoroscopeUtil.GEMINI;
            case R.id.cancer:
                return HoroscopeUtil.CANCER;
            case R.id.leo:
                return HoroscopeUtil.LEO;
            case R.id.virgio:
                return HoroscopeUtil.VIRGO;
            case R.id.libra:
                return HoroscopeUtil.LIBRA;
            case R.id.scorpio:
                return HoroscopeUtil.SCORPIO;
            case R.id.sagittarius:
                return HoroscopeUtil.SAGITTARIUS;
            case R.id.capricorn:
                return HoroscopeUtil.CAPRICORN;
            case R.id.aquarius:
                return HoroscopeUtil.AQUARIUS;
            case R.id.pisces:
                return HoroscopeUtil.PISCES;
            default:
                return HoroscopeUtil.ARIES;
        }
    }

    public class ZodiakClickHanlders {

        public void horoscopeChoose(View view) {

            switch (view.getTag().toString()) {
                case "0":
                    viewModel.setHoroscopeChooser(0);
                    horoscope.setName("Сегодня");
                    horoscope.setDescription(HoroscopeUtil.TODAY[getCurrent(getIntent().getIntExtra("id", 0))]);
                    break;
                case "1":
                    viewModel.setHoroscopeChooser(1);
                    horoscope.setName("Завтра");
                    horoscope.setDescription(HoroscopeUtil.HOROSCOPES[1]);
                    break;
                case "2":
                    viewModel.setHoroscopeChooser(2);
                    horoscope.setName("Неделя");
                    horoscope.setDescription(HoroscopeUtil.HOROSCOPES[2]);
                    break;
                case "3":
                    viewModel.setHoroscopeChooser(3);
                    horoscope.setName("Месяц");
                    horoscope.setDescription(HoroscopeUtil.HOROSCOPES[3]);
                    break;
                case "4":
                    viewModel.setHoroscopeChooser(4);
                    horoscope.setName("Год 2020");
                    horoscope.setDescription(HoroscopeUtil.HOROSCOPES[4]);
                    break;

            }
            scrollView.fullScroll(ScrollView.FOCUS_UP);
        }

        public void luckyClick(View view) {
            Intent intent = new Intent(ZodiakActivity.this, LuckyActivity.class);
            startActivity(intent);
            Animatoo.animateFade(ZodiakActivity.this);
            finish();
        }

        public void characteristicClick(View view) {
            Intent intent = new Intent(ZodiakActivity.this, CharacteristicActivity.class);
            intent.putExtra("imageRes", getIntent().getIntExtra("imageRes", 0));
            intent.putExtra("name", getIntent().getStringExtra("name"));
            intent.putExtra("id", getIntent().getIntExtra("id", 0));

            startActivity(intent);
            Animatoo.animateFade(ZodiakActivity.this);
            finish();
        }

    }

}
