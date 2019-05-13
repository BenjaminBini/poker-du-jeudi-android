package io.bini.pokerdujeudi.services;

import java.util.List;

import io.bini.pokerdujeudi.models.Player;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Webservice {
    @GET("/api/player")
    Call<List<Player>> getPlayers();
}
