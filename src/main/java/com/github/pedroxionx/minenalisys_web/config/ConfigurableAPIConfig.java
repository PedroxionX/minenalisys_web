package com.github.pedroxionx.minenalisys_web.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "minenalisys_web")
public class ConfigurableAPIConfig implements ConfigData {
    public static String prefix = "@";
    public static String command = "deepseek";
    public static String apiUrl = "https://api.deepseek.com/chat/completions";
    public static String apiKey = "sk-f6665fcb3b1542059f8b137f808f1ceb";
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
