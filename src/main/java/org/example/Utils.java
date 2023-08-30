package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Utils {
    private static final CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(
                    RequestConfig.custom()
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build()
            )
            .build();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Cats> getCatsInfo(String uri) {
        try (CloseableHttpResponse response = httpClient.execute(new HttpGet(uri))) {
            return mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
