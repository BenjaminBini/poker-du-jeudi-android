package io.bini.pokerdujeudi;

import android.webkit.WebSettings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import lombok.val;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlayerRepository {
    private Webservice webservice;

    public PlayerRepository() {
        val retrofit = new Retrofit.Builder()
                .baseUrl("https://pokerdujeudi.bini.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webservice = retrofit.create(Webservice.class);
    }

    public LiveData<List<Player>> getPlayers() {
        final val data = new MutableLiveData<List<Player>>();
        webservice.getPlayers().enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
            }
        });
        return data;
    }
}
