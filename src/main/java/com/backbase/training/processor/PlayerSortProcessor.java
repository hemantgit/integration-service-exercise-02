package com.backbase.training.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by marcio on 02/08/16.
 */
public class PlayerSortProcessor implements Processor{

    final static Logger logger = LoggerFactory.getLogger(PlayerSortProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        Map body = exchange.getIn().getBody(Map.class);
        List players = (List) body.get("players");
        final String field = (String) exchange.getIn().getHeader("sort");

        if(field != null) {

            boolean coin = new Random().nextBoolean();
            if(coin) {
                throw new IllegalArgumentException(field + " is missing. Unable to sort the list of players");
            }

            Collections.sort(players, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Map m1 = (Map) o1;
                    Map m2 = (Map) o2;

                    Object v1 = m1.get(field);
                    Object v2 = m2.get(field);


                    return v1.toString().compareTo(v2.toString());
                }
            });
        }
        logger.debug("Players: " + players);
    }
}
