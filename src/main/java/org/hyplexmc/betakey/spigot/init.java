/*
 *  Developed by Luuuuuis.
 *  Last modified 23.04.21, 23:31.
 *  Copyright (c) 2021.
 */

package org.hyplexmc.betakey.spigot;

import org.hyplexmc.betakey.BetaKey;
import org.hyplexmc.betakey.database.querys.BetaPlayerInfo;
import org.hyplexmc.betakey.database.querys.KeyInfo;
import org.hyplexmc.betakey.misc.IPlugin;
import org.hyplexmc.betakey.spigot.misc.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class init extends JavaPlugin implements IPlugin {

    private BetaKey betaKey;

    @Override
    public void onEnable() {
        super.onEnable();

        betaKey = new BetaKey(this);

        /*
         * commands
         */
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new org.hyplexmc.betakey.spigot.listener.Login(), this);

        getCommand("betakey").setExecutor(new org.hyplexmc.betakey.spigot.commands.BetaKeyCommand());

        /*
        Available here: https://bstats.org/plugin/bungeecord/BetaKey/11124
        to disable these metrics change the bStats config and copy it into you template folder but please don't :C
         */
        Metrics metrics = new Metrics(this, 11125);
        metrics.addCustomChart(new Metrics.SingleLineChart("betaplayers_active", BetaPlayerInfo::count));
        metrics.addCustomChart(new Metrics.SingleLineChart("betakeys_active", KeyInfo::count));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        betaKey.getDbManager().close();
    }

    @Override
    public String getVersion() {
        return getDescription().getVersion();
    }

    @Override
    public File getFolder() {
        return getDataFolder();
    }

    @Override
    public void sendMessageConsole(String message) {
        getServer().getConsoleSender().sendMessage(message);
    }

}
