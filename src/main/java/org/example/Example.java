package org.example;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Example {

    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";

    public static void main(String[] args) throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(new HttpUrl.Builder()
                        .scheme("https")
                        .host("httpbin.org")
                        .port(443)
                        .addPathSegment("get")
                        .build().url());
        if (HTTP_METHOD_GET.equals(args[0])) {
            requestBuilder.get();
        } else if (HTTP_METHOD_POST.equals(args[0])) {
            requestBuilder.post(new FormBody.Builder().build());
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Response response = client.newCall(requestBuilder.build()).execute();
        System.out.println(response.body().string());
    }
}
