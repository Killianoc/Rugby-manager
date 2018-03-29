package com.rugby.manager.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Killian on 29/03/2018.
 */
@Data
public class Team implements LoadableEntity {

    private String teamName;
    private List<Player> players;

    public void addPlayer(Player player) {
        if (null != players) {
            players.add(player);
        } else {
            players = new ArrayList<>();
            players.add(player);
        }
    }

}
