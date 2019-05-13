package io.bini.pokerdujeudi.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.bini.pokerdujeudi.models.Player;
import io.bini.pokerdujeudi.repositories.PlayerRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

public class PlayerListViewModel extends ViewModel {
    @Getter
    @Setter
    private LiveData<List<Player>> players;

    public PlayerListViewModel() {
        val playerRepository = new PlayerRepository();
        players = playerRepository.getPlayers();
    }
}
