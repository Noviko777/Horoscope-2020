package allastro.horoscopedaily.check.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import allastro.horoscopedaily.check.R;
import allastro.horoscopedaily.check.databinding.MatchItemBinding;
import allastro.horoscopedaily.check.model.Match;

public class MatchRecyclerAdapter extends RecyclerView.Adapter<MatchRecyclerAdapter.MatchViewHolder> {

    private ArrayList<Match> matchArrayList;

    public MatchRecyclerAdapter(ArrayList<Match> matchArrayList) {
        this.matchArrayList = matchArrayList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MatchItemBinding matchItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.match_item, parent, false);
        return new MatchViewHolder(matchItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchArrayList.get(position);
        holder.matchItemBinding.setMatch(match);
    }

    @Override
    public int getItemCount() {
        return matchArrayList.size();
    }

    public class MatchViewHolder extends RecyclerView.ViewHolder {

        public MatchItemBinding matchItemBinding;

        public MatchViewHolder(@NonNull MatchItemBinding matchItemBinding) {
            super(matchItemBinding.getRoot());
            this.matchItemBinding = matchItemBinding;
        }
    }

}
