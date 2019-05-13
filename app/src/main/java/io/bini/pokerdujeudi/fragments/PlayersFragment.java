package io.bini.pokerdujeudi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.bini.pokerdujeudi.R;
import io.bini.pokerdujeudi.models.Player;
import io.bini.pokerdujeudi.viewadapters.PlayersViewAdapter;
import io.bini.pokerdujeudi.viewmodels.PlayerListViewModel;

public class PlayersFragment extends DialogFragment {

    private RecyclerView playersView;
    private RecyclerView.Adapter playersViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private PlayerListViewModel playerListViewModel = new PlayerListViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.players_fragment, container, false);
        playersView = fragmentView.findViewById(R.id.players_view);
        playersView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        playersView.setLayoutManager(layoutManager);

        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerListViewModel.getPlayers().observe(this, new Observer<List<Player>>() {
            @Override
            public void onChanged(List<Player> players) {
                playersViewAdapter = new PlayersViewAdapter(players);
                playersView.setAdapter(playersViewAdapter);
            }
        });
    }
}
