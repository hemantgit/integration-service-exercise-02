package com.backbase.training.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcio on 09/08/16.
 */
public class Players {

    private List<Player> players;

    public Players() {
        setPlayers(new ArrayList<Player>());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
