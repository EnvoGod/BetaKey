/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */
package org.hyplexmc.betakey.bungee;

import org.hyplexmc.betakey.BetaKey;
import org.hyplexmc.betakey.misc.IPlugin;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import java.io.File;

public class init extends Plugin implements IPlugin {

    private static init instance;
    private BetaKey betaKey;

    public static init getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        betaKey = new BetaKey(this);

        /*
         * commands
         */
        PluginManager pm = getProxy().getPluginManager();
        pm.registerCommand(this, new org.hyplexmc.betakey.bungee.commands.BetaKeyCommand());
        pm.registerListener(this, new org.hyplexmc.betakey.bungee.listener.Login());

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
        ProxyServer.getInstance().getConsole().sendMessage(new TextComponent(message));
    }
}
