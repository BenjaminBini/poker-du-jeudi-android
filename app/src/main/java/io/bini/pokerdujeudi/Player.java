package io.bini.pokerdujeudi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Player {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    public Player(String firstName, String lastName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
        if (lastName != "null") {
            this.lastName = lastName;
        }
    }

    public Player(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        String fullName = firstName;
        if (lastName != null && lastName.length() > 0) {
            fullName += " " + lastName;
        }
        return fullName;
    }

    public static List<Player> fromJsonString(String jsonString) {
        List<Player> players = new ArrayList<>();
        try {
            JSONArray playersJsonArray =  new JSONArray(jsonString);
            for (int i = 0; i < playersJsonArray.length(); i++) {
                JSONObject playerJson = playersJsonArray.getJSONObject(i);
                Player player = new Player(playerJson.getString("firstName"), playerJson.getString("lastName"));
                players.add(player);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return players;
    }
}
