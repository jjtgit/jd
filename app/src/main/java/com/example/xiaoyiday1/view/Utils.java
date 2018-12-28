package com.example.xiaoyiday1.view;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utils {
    public static String get(String s) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request =new Request.Builder().url(s).build();
        try {
            Response execute =okHttpClient.newCall(request).execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
