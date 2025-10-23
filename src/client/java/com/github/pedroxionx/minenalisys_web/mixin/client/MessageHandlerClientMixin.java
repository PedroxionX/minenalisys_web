package com.github.pedroxionx.minenalisys_web.mixin.client;


import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.client.network.message.MessageTrustStatus;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.github.pedroxionx.minenalisys_web.Byp_minenalisys_web;
import com.github.pedroxionx.minenalisys_web.config.ConfigurableAPIConfig;
import com.github.pedroxionx.minenalisys_web.httpClient.PostClient;

@Mixin(MessageHandler.class)
public class MessageHandlerClientMixin{


    @Inject(method = "addToChatLog", at = @At("TAIL"))
    public void listen_addToChatLog(SignedMessage message, MessageType.Parameters params, com.mojang.authlib.GameProfile sender, MessageTrustStatus trustStatus,CallbackInfo info){
        
        String rawMessage = info.toString() + message.toString() + sender.toString();
        Pattern pattern = Pattern.compile("content=(.*?), timeStamp");
        Matcher matcher = pattern.matcher(rawMessage);
        
        if (matcher.find()) {
            String content = matcher.group(1);
            Byp_minenalisys_web.LOGGER.info(content);
            if (content.equals("@" + ConfigurableAPIConfig.getCommand())) {
            // Byp_minenalisys_web.LOGGER.info("Palabra correcta ingresada");
            PostClient.PostMessage(content);
        }
        }
        
    }


}