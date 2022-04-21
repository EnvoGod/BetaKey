/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */

package org.hyplexmc.betakey.misc;

import com.google.gson.JsonObject;
import org.hyplexmc.betakey.BetaKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Updater {

    private String tag_name;
    //private String browser_download_url;

    public Updater() {
        try {
            JsonObject jsonObject = BetaKey.GSON.fromJson(readJSONFromURL(), JsonObject.class);
            this.tag_name = jsonObject.get("tag_name").getAsString();
            //browser_download_url = jsonObject.get("assets").getAsJsonArray().get(0).getAsJsonObject().get("browser_download_url").getAsString();

            if (isNew())
                report();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void report() {
        BetaKey.instance.getIPlugin().sendMessageConsole(
                "&5  _    _             _           __  __  _____\n" +
                        "&5 | |  | |           | |         |  \\/  |/ ____|\n" +
                        "&5 | |__| |_   _ _ __ | | _____  _| \\  / | |     \n" +
                        "&5 |  __  | | | | '_ \\| |/ _ \\ \\/ / |\\/| | |     \n" +
                        "&5 | |  | | |_| | |_) | |  __/>  <| |  | | |____ \n" +
                        "&5 |_|  |_|\\__, | .__/|_|\\___/_/\\_\\_|  |_|\\_____|\n" +
                        "&5          __/ | |                              \n" +
                        "&5         |___/|_|                              \n" +
                        "&5   _____ _         __  __ \n" +
                        "&5  / ____| |       / _|/ _|\n" +
                        "&5 | (___ | |_ __ _| |_| |_ \n" +
                        "&5  \\___ \\| __/ _` |  _|  _|\n" +
                        "&5  ____) | || (_| | | | |  \n" +
                        "&5 |_____/ \\__\\__,_|_| |_|  \n" +
                        "&5   _____ _           _   \n" +
                        "&5  / ____| |         | |  \n" +
                        "&5 | |    | |__   __ _| |_ \n" +
                        "&5 | |    | '_ \\ / _` | __|\n" +
                        "&5 | |____| | | | (_| | |_ \n" +
                        "&5  \\_____|_| |_|\\__,_|\\__|\n" +
                        "&r &r &r\n" +
                        "&r &r &r\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        "&8[&4&lError&8] &b>>> &5Outdated configuration file. You DO NOT have &4V1 or an error has occured" + " &5Message EnvoGod and tell him to fix the plugin!\n" +
                        " &4______ _____  _____   ____  _____" +
                        "&4|  ____|  __ \\|  __ \\ / __ \\|  __ \\" +
                        "&4| |__  | |__) | |__) | |  | | |__) |" +
                        "&4|  __| |  _  /|  _  /| |  | |  _  /" +
                        "&4| |____| | \\ \\| | \\ \\| |__| | | \\ \\ " +
                        "&4|______|_|  \\_\\_|  \\_\\\\____/|_|  \\_\\" +
                        "&r &r &r");
    }

    private String readJSONFromURL() throws IOException {
        URL url = new URL("https://api.github.com/repos/Jackmoss2003/BetaKey/releases/latest");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            connection.disconnect();

            return content.toString();
        }
    }

//    private void download() {
//        try (InputStream in = new URL(browser_download_url).openStream()) {
//            Files.copy(in, Paths.get(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }

    public boolean isNew() {
        return !tag_name.equals(BetaKey.instance.getIPlugin().getVersion());
    }
}
