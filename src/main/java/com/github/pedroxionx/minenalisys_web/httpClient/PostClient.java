package com.github.pedroxionx.minenalisys_web.httpClient;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.pedroxionx.minenalisys_web.Byp_minenalisys_web;
import com.github.pedroxionx.minenalisys_web.config.ConfigurableAPIConfig;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostClient {

    public void PostMessage(String userMessage) {
        OkHttpClient client = new OkHttpClient();

        // Tipo MIME
        MediaType mediaType = MediaType.parse("application/json");

        // 🔹 JSON dinámico con el mensaje real
        String jsonBody = "{"
                + "\"messages\": ["
                + "{\"content\": \"You are a helpful assistant.\", \"role\": \"system\"},"
                + "{\"content\": \"" + userMessage + "\", \"role\": \"user\"}"
                + "],"
                + "\"model\": \"deepseek-chat\","
                + "\"frequency_penalty\": 0,"
                + "\"max_tokens\": 4096,"
                + "\"presence_penalty\": 0,"
                + "\"response_format\": {\"type\": \"text\"},"
                + "\"stop\": null,"
                + "\"stream\": false,"
                + "\"stream_options\": null,"
                + "\"temperature\": 1,"
                + "\"top_p\": 1,"
                + "\"tools\": null,"
                + "\"tool_choice\": \"none\","
                + "\"logprobs\": false,"
                + "\"top_logprobs\": null"
                + "}";

        RequestBody body = RequestBody.create(jsonBody, mediaType);

        Request request = new Request.Builder()
                .url(ConfigurableAPIConfig.getApiUrl()) // https://api.deepseek.com/chat/completions
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + ConfigurableAPIConfig.getApiKey())
                .build();

        try {
            Byp_minenalisys_web.LOGGER.info("🚀 Enviando solicitud POST a DeepSeek...");

            // Ejecutar la petición
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    Byp_minenalisys_web.LOGGER.error("❌ Error HTTP: " + response.code());
                }

                String responseBody = response.body().string(); // <-- leer correctamente el contenido
                Byp_minenalisys_web.LOGGER.info("✅ Respuesta DeepSeek (raw): " + responseBody);

                Pattern pattern = Pattern.compile("content=(.*?), timeStamp");
                Matcher matcher = pattern.matcher(responseBody);

                String content = matcher.group(1);

                Byp_minenalisys_web.LOGGER.info("✅ Respuesta DeepSeek: " + content);

                // {"id":"cad5dd38-c67a-46ac-be1d-3885dd9a3295","object":"chat.completion","created":1761290800,"model":"deepseek-chat","choices":[{"index":0,"message":{"role":"assistant","content":"¡Hola!
                // Estoy muy bien, gracias por preguntar. ¿Y tú, cómo estás? 😊 \nSi necesitas
                // ayuda con algo, estaré encantado de
                // asistirte."},"logprobs":null,"finish_reason":"stop"}],"usage":{"prompt_tokens":14,"completion_tokens":43,"total_tokens":57,"prompt_tokens_details":{"cached_tokens":0},"prompt_cache_hit_tokens":0,"prompt_cache_miss_tokens":14},"system_fingerprint":"fp_ffc7281d48_prod0820_fp8_kvcache"}
            }

        } catch (IOException e) {
            Byp_minenalisys_web.LOGGER.error("❌ Error al conectar con DeepSeek", e);
        }
    }

}
