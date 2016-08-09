package com.backbase.training.processor;

import com.backbase.training.to.Player;
import com.backbase.training.to.Players;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by marcio on 02/08/16.
 */
public class PlayerSortProcessor implements Processor{

    final static Logger logger = LoggerFactory.getLogger(PlayerSortProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        Players body = exchange.getIn().getBody(Players.class);
        List<Player> players = body.getPlayers();
        final String field = (String) exchange.getIn().getHeader("sort");

        if("username".equals(field)) {
            Collections.sort(players, (Player p1, Player p2) -> {
                return p1.getUsername().compareTo(p2.getUsername());
            });
        }

        logger.debug("Players: " + players);
    }
}
