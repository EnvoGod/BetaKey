/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */

package org.hyplexmc.betakey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hyplexmc.betakey.database.DBManager;
import org.hyplexmc.betakey.misc.Config;
import org.hyplexmc.betakey.misc.IPlugin;
import org.hyplexmc.betakey.misc.Updater;
import lombok.Getter;

@Getter
public class BetaKey {

    public final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static BetaKey instance = null;
    private final DBManager dbManager;
    private final IPlugin iPlugin;

    public BetaKey(IPlugin iPlugin) {
        instance = this;
        this.iPlugin = iPlugin;

        /*
         * Updater
         */
        Updater updater = new Updater();

        iPlugin.sendMessageConsole(
            "&r &r &r" +
            "&r &r &r" +
            "&r &r &r" +
            "&r &r &r" +
            "&r &r &r" +
            "&5___  ___      ___    ___ ________  ___       _______      ___    ___ _____ ______   ________" +
            " &5|\\  \\|\\  \\    |\\  \\  /  /|\\   __  \\|\\  \\     |\\  ___ \\    |\\  \\  /  /|\\   _ \\  _   \\|\\   ____\\" +
            "&5\\ \\  \\\\\\  \\   \\ \\  \\/  / | \\  \\|\\  \\ \\  \\    \\ \\   __/|   \\ \\  \\/  / | \\  \\\\\\__\\ \\  \\ \\  \\___|" +
            " &5\\ \\   __  \\   \\ \\    / / \\ \\   ____\\ \\  \\    \\ \\  \\_|/__  \\ \\    / / \\ \\  \\\\|__| \\  \\ \\  \\" +
            "  &5\\ \\  \\ \\  \\   \\/  /  /   \\ \\  \\___|\\ \\  \\____\\ \\  \\_|\\ \\  /     \\/   \\ \\  \\    \\ \\  \\ \\  \\____" +
            "   &5\\ \\__\\ \\__\\__/  / /      \\ \\__\\    \\ \\_______\\ \\_______\\/  /\\   \\    \\ \\__\\    \\ \\__\\ \\_______\\" +
            "    &5\\|__|\\|__|\\___/ /        \\|__|     \\|_______|\\|_______/__/ /\\ __\\    \\|__|     \\|__|\\|_______|" +
            "             &5\\|___|/                                      |__|/ \\|__|" +
            "&r &r &r" +
            "&b________  _______  _________  ________  ___  __    _______       ___    ___" +
            "&b|\\   __  \\|\\  ___ \\|\\___   ___\\\\   __  \\|\\  \\|\\  \\ |\\  ___ \\     |\\  \\  /  /|" +
            "&b\\ \\  \\|\\ /\\ \\   __/\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\/  /|\\ \\   __/|    \\ \\  \\/  / / &r &8[&5&lBeta&b&lKey&r&8] &5Bungee&bCord + &5Spi&bgot" +
            " &b\\ \\   __  \\ \\  \\_|/__  \\ \\  \\ \\ \\   __  \\ \\   ___  \\ \\  \\_|/__   \\ \\    / / &r &8Running Version &c" + iPlugin.getVersion() + (updater.isNew() ? "§c* outdated" : "") + "§r\n" +
            "  &b\\ \\  \\|\\  \\ \\  \\_|\\ \\  \\ \\  \\ \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\   \\/  /  /  " +
            "   &b\\ \\_______\\ \\_______\\  \\ \\__\\ \\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\_______\\__/  / /    " +
            "    &b\\|_______|\\|_______|   \\|__|  \\|__|\\|__|\\|__| \\|__|\\|_______|\\___/ /     " +
            "                                                                &b\\|___|/" +
            "&r &r &r" +
            "&r &r &r" +
            "&r &r &r" +
            "&r &r &r" +
            "&r &r &r"
        );

        /*
         * config
         */
        Config.init(iPlugin.getFolder());

        /*
         * database Manager
         */
        dbManager = new DBManager(this);
        dbManager.connect();
    }
}
