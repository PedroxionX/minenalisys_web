package com.github.pedroxionx.minenalisys_web.dto;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.pedroxionx.minenalisys_web.Byp_minenalisys_web;
import com.github.pedroxionx.minenalisys_web.config.ConfigurableAPIConfig;

public class RawMessageDTO {
    public RawMessageDTO() {
    }

    public List<String> list;

    public void addToList(String rawMessage) {
        Pattern pattern = Pattern.compile("content=(.*?), timeStamp");
        Matcher matcher = pattern.matcher(rawMessage);
        String userMessage = "";

        if (matcher.find()) {
            String content = matcher.group(1);
            Byp_minenalisys_web.LOGGER.info("Mensaje capturado: " + content);

            String fullTrigger = ConfigurableAPIConfig.getPrefix() + ConfigurableAPIConfig.getCommand();

            // Detecta si empieza con el prefijo+comando, por ejemplo "@deepseek"
            if (content.startsWith(fullTrigger)) {
                Byp_minenalisys_web.LOGGER.info("✅ Prefijo y palabra correctos detectados");

                // Elimina el prefijo del mensaje para enviar solo el texto
                userMessage = content.substring(fullTrigger.length()).trim();
                Byp_minenalisys_web.rawMessageDTO.sendMessage(userMessage);

            }
        }

        list.add(userMessage);
    }

    public void sendMessage(String userMessage) {
        CompletableFuture.runAsync(() -> {
            try {
                Byp_minenalisys_web.postClient.PostMessage(userMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
