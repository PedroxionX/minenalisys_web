package com.github.pedroxionx.minenalisys_web.dto;

import com.github.pedroxionx.minenalisys_web.httpClient.PostClient;

public final class rawMessageDTO {
    

    public static void postRawMessage(String string){
        PostClient.PostMessage(string);
    }



}
