package com.github.pedroxionx.minenalisys_web.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.github.pedroxionx.minenalisys_web.Byp_minenalisys_web;

import net.minecraft.server.MinecraftServer;


@Mixin(MinecraftServer.class)
public class ExampleMixin{
	// private static final String MOD_ID = "byp_minenalisys_web";
	// private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()
		Byp_minenalisys_web.LOGGER.info("El jugador acaba de cargar un mundo locochon");
		// return true;
	}
}