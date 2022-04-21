/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */

package org.hyplexmc.betakey.database.sqlite;

import org.hyplexmc.betakey.BetaKey;
import org.hyplexmc.betakey.misc.Config;

import java.util.HashMap;

public class SQLite {

    private final BetaKey betaKey;

    public SQLite(BetaKey betaKey) {
        this.betaKey = betaKey;
    }

    public void init() {

        HashMap<String, Object> getMySQLCredentials = Config.getInstance().getMySQLCredentials();

        String url = "jdbc:sqlite:" + betaKey.getIPlugin().getFolder() + "/betakey.sqlite";

        try {
            // use JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        betaKey.getDbManager().connect(getMySQLCredentials, url);
    }

}
