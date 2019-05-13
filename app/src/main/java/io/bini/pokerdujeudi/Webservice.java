package io.bini.pokerdujeudi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Webservice {
    @GET("/api/player")
    Call<List<Player>> getPlayers();
}
