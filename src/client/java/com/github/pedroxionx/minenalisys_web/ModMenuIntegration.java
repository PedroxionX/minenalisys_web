package com.github.pedroxionx.minenalisys_web;

import com.github.pedroxionx.minenalisys_web.config.ConfigurableAPIConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(ConfigurableAPIConfig.class, parent).get();
    }
}
