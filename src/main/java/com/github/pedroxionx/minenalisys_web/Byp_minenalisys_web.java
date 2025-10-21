package com.github.pedroxionx.minenalisys_web;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pedroxionx.minenalisys_web.client.GetClient;

public class Byp_minenalisys_web implements ModInitializer {
	public static final String MOD_ID = "byp_minenalisys_web";

	
	// This logger is used to write text to the console and the log file. It is considered best practice to use your mod id as the logger's name. That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// This code runs as soon as Minecraft is in a mod-load-ready state. However, some things (like resources) may still be uninitialized.  Proceed with mild caution.
	@Override
	public void onInitialize() {

		// Web App
		GetClient.GetAvailability();
		
	}
}