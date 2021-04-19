package allastro.horoscopedaily.check.activities;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import allastro.horoscopedaily.check.HoroscopeUtil;
import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.adapters.MatchRecyclerAdapter;
import allastro.horoscopedaily.check.databinding.ActivityCharacteristicBinding;
import allastro.horoscopedaily.check.model.Match;

public class CharacteristicActivity extends BaseActivity {

    private ActivityCharacteristicBinding characteristicBinding;

    private RecyclerView recyclerView;
    private ArrayList<Match> matchArrayList = new ArrayList<>();
    private MatchRecyclerAdapter adapter;

    public CharacteristicActivity() {
        super(-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characteristic);

        characteristicBinding = DataBindingUtil.setContentView(this, R.layout.activity_characteristic);
        characteristicBinding.setBasicClickHandlers(new BasicClickHandlers());
        characteristicBinding.setTitle("Характеристика " + getIntent().getStringExtra("name"));
        characteristicBinding.setImageRes(getIntent().getIntExtra("imageRes", 0));


        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView = characteristicBinding.recyclerView;

        int id = getIntent().getIntExtra("id", 0);
        String name = getIntent().getStringExtra("name");
        matchArrayList.add(new Match(getDrawable(R.drawable.character_icon), "Характер", HoroscopeUtil.CHARACTERISTIC_OWNER[getCurrent(id)], "#C57F06"));
        matchArrayList.add(new Match(getDrawable(R.drawable.woman_icon), name + " девушка", HoroscopeUtil.CHARACTERISTIC_WOMAN[getCurrent(id)], "#FF006C"));
        matchArrayList.add(new Match(getDrawable(R.drawable.man_icon), name + " мужчина", HoroscopeUtil.CHARACTERISTIC_MAN[getCurrent(id)], "#0089FE"));
        matchArrayList.add(new Match(getDrawable(R.drawable.love_icon), "Любовь", HoroscopeUtil.CHARACTERISTIC_LOVE, "#FE000C"));
        matchArrayList.add(new Match(getDrawable(R.drawable.star_icon), "Здоровье", HoroscopeUtil.CHARACTERISTIC_HEALTH[getCurrent(id)], "#DBCD0C"));

        adapter = new MatchRecyclerAdapter(matchArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

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

}
