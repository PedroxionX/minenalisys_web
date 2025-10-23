package com.github.pedroxionx.minenalisys_web.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "minenalisys_web")
public class ConfigurableAPIConfig implements ConfigData {
    public static String prefix = "prefix";
    public static String command = "chatgpt";
    public static String apiUrl = "https://api.tu-servidor.com/";
    public static String apiKey = "API_KEY_AQUI";
    // public boolean debugMode = false;

    public static String getCommand() {
        return command;
    }
    public static String getPrefix() {
        return prefix;
    }
    public static String getApiUrl() {
        return apiUrl;
    }
    public static String getApiKey() {
        return apiKey;
    }
    // public boolean isDebugMode() {
    //     return debugMode;
    // }
}
