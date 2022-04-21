/*
 *  Developed by HyplexMC.
 *  Last modified 21.04.22.
 *  Copyright (c) 2022.
 */

package org.hyplexmc.betakey.misc;

import java.io.File;

public interface IPlugin {

    String getVersion();

    File getFolder();

    void sendMessageConsole(String message);

}
