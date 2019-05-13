package io.bini.pokerdujeudi.viewadapters;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.bini.pokerdujeudi.R;
import io.bini.pokerdujeudi.models.Player;

public class PlayersViewAdapter extends RecyclerView.Adapter<PlayersViewAdapter.PlayersViewHolder> {
    private List<Player> players;

    public static class PlayersViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout playersLayout;

        public PlayersViewHolder(ConstraintLayout cl) {
            super(cl);
            playersLayout = cl;
        }
    }

    public PlayersViewAdapter(List<Player> players) {
        this.players = players;
    }

    @Override
    public PlayersViewAdapter.PlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout playersLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.player_holder, parent, false);
        PlayersViewHolder vh = new PlayersViewHolder(playersLayout);
        return vh;
    }

    @Override
    public void onBindViewHolder(PlayersViewHolder holder, int position) {
        TextView playerTextView = holder.playersLayout.findViewById(R.id.player_name);
        playerTextView.setText(players.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        if (players != null) {
            return players.size();
        }
        return 0;
    }

}
