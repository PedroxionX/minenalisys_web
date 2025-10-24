package com.github.pedroxionx.minenalisys_web;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pedroxionx.minenalisys_web.config.ConfigurableAPIConfig;
import com.github.pedroxionx.minenalisys_web.dto.RawMessageDTO;
import com.github.pedroxionx.minenalisys_web.httpClient.PostClient;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class Byp_minenalisys_web implements ModInitializer {
	public static final String MOD_ID = "byp_minenalisys_web";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final PostClient postClient = new PostClient();
	public static final RawMessageDTO rawMessageDTO = new RawMessageDTO();

	// This code runs as soon as Minecraft is in a mod-load-ready state. However,
	// some things (like resources) may still be uninitialized. Proceed with mild
	// caution.
	@Override
	public void onInitialize() {

		// Web client
		//GetClient.GetAvailability();
		

		// Config
		AutoConfig.register(ConfigurableAPIConfig.class, GsonConfigSerializer::new);

	}
}