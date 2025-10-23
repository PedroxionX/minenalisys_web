package com.github.pedroxionx.minenalisys_web.httpClient;

import org.eclipse.jetty.client.ContentResponse;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.http.HttpMethod;

import com.github.pedroxionx.minenalisys_web.Byp_minenalisys_web;

public class GetClient {
    public static HttpClient httpClient = new HttpClient();
	public static final String URLFASTAPI = "http://127.0.0.1:8000";
    public static final String MOD_ID = "byp_minenalisys_web";

    public static void GetAvailability(){
        Byp_minenalisys_web.LOGGER.info("Se intentara hacer conexion a " + URLFASTAPI + "mediante una peticion GET");
        try {
			httpClient.start();
            ContentResponse response = httpClient.newRequest(URLFASTAPI)
			.method(HttpMethod.GET)
			.agent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:17.0) Gecko/20100101 Firefox/17.0")
			.send();
            Byp_minenalisys_web.LOGGER.info("Peticion GET lograda");
            httpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
            Byp_minenalisys_web.LOGGER.info("Peticion GET no lograda");
		}
    }


}
