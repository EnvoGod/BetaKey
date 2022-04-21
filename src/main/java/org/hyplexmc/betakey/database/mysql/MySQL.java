/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */

package org.hyplexmc.betakey.database.mysql;

import org.hyplexmc.betakey.BetaKey;
import org.hyplexmc.betakey.misc.Config;

import java.util.HashMap;

public class MySQL {

    private final BetaKey betaKey;

    public MySQL(BetaKey betaKey) {
        this.betaKey = betaKey;
    }

    public void init() {

        HashMap<String, Object> getMySQLCredentials = Config.getInstance().getMySQLCredentials();

        String url = "jdbc:mysql://" + getMySQLCredentials.get("Host").toString() + ":" + ((Double) getMySQLCredentials.get("Port")).intValue() + "/"
                + getMySQLCredentials.get("database").toString() + "?autoReconnect=true&useUnicode=yes&allowMultiQueries=true";

        betaKey.getDbManager().connect(getMySQLCredentials, url);
    }

}
