package allastro.horoscopedaily.check.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.adapters.MatchRecyclerAdapter;
import allastro.horoscopedaily.check.databinding.ActivityMatchResultBinding;
import allastro.horoscopedaily.check.model.Match;
import allastro.horoscopedaily.check.model.MatchResult;

import static allastro.horoscopedaily.check.HoroscopeUtil.FAMILIES;
import static allastro.horoscopedaily.check.HoroscopeUtil.FRIENDSHIPS;
import static allastro.horoscopedaily.check.HoroscopeUtil.LOVES;
import static allastro.horoscopedaily.check.HoroscopeUtil.SEXES;
import static allastro.horoscopedaily.check.HoroscopeUtil.WORKS;

public class MatchResultActivity extends BaseActivity {

    private ActivityMatchResultBinding matchResultBinding;

    private RecyclerView recyclerView;
    private ArrayList<Match> matchArrayList;
    private MatchRecyclerAdapter adapter;

    public MatchResultActivity() {
        super(-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);

        matchResultBinding = DataBindingUtil.setContentView(this, R.layout.activity_match_result);
        matchResultBinding.setBasicClickHandlers(new BasicClickHandlers());
        matchResultBinding.setLeftZodiakResource(getResourceFromImage(getIntent().getIntExtra("left", 0)));
        matchResultBinding.setRightZodiakResource(getResourceFromImage(getIntent().getIntExtra("right", 0)));
        matchResultBinding.setMatchResult(new MatchResult(getIntent().getStringExtra("firstZodiak"), getIntent().getStringExtra("secondZodiak"), "99%"));

        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView = matchResultBinding.recyclerView;

        matchArrayList = new ArrayList<>();

        matchArrayList.add(new Match(getDrawable(R.drawable.love_icon), "Любовь", LOVES[0], "#FF0012"));
        matchArrayList.add(new Match(getDrawable(R.drawable.sex_icon), "Секс", SEXES[0], "#D800FF"));
        matchArrayList.add(new Match(getDrawable(R.drawable.family_icon), "Семья и брак", FAMILIES[0], "#84FF00"));
        matchArrayList.add(new Match(getDrawable(R.drawable.friendship_icon), "Дружба", FRIENDSHIPS[0], "#FFEA00"));
        matchArrayList.add(new Match(getDrawable(R.drawable.briefcase_icon), "Работа", WORKS[0], "#00D8FF"));

        adapter = new MatchRecyclerAdapter(matchArrayList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


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
}
