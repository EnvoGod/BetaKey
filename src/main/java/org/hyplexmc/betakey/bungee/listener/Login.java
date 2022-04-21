/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */

package org.hyplexmc.betakey.bungee.listener;

import org.hyplexmc.betakey.database.querys.BetaPlayer;
import org.hyplexmc.betakey.misc.Config;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Login implements Listener {

    @EventHandler
    public void onLogin(LoginEvent e) {
        e.registerIntent(org.hyplexmc.betakey.bungee.init.getInstance());
        PendingConnection player = e.getConnection();
        BetaPlayer betaPlayer = new BetaPlayer(player.getUniqueId());

        if (!betaPlayer.isValid()) {
            //noinspection deprecation to support cross version
            e.setCancelReason(ChatColor.translateAlternateColorCodes('&', Config.getInstance().getKickMessage()));
            e.setCancelled(true);
            System.out.println("BetaKey DEBUG >> Not valid!");
        } else
            System.out.println("BetaKey DEBUG >> Valid!");

        e.completeIntent(org.hyplexmc.betakey.bungee.init.getInstance());

    }

}
