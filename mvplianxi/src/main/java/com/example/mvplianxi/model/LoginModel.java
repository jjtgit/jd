package com.example.mvplianxi.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.mvplianxi.api.UserApi;
import com.example.mvplianxi.entity.UserEntity;
import com.example.mvplianxi.net.RequestCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements IloginModel{
    Handler handler=new Handler();
    @Override
    public void login(HashMap<String, String> params, final RequestCallback callback) {
        //okhttp网络框架管理
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)//读取超时
                .connectTimeout(5,TimeUnit.SECONDS)//连接超时
                .writeTimeout(5,TimeUnit.SECONDS)//写入超时
                .build();

        //对请求体，构建数据的过程，建造者模式
        FormBody.Builder formBody=new FormBody.Builder();
        for (Map.Entry<String,String> p:params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }

        //创建请求信息
       final Request request=new Request.Builder().url(UserApi.USER_LOGIN).post(formBody.build()).build();
        //创建请求执行对象
        Call call = okHttpClient.newCall(request);
        //异步和同步请求
        call.enqueue(new Callback() {
            //失败
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络可能不稳定，请稍后再试");
                        }
                    });

                }

            }

            //成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();//返回的数据，json串
                int code = response.code();
                if (!TextUtils.isEmpty(result)) {
                    paserResult(result, callback, code);
                }


            }
        });
    }
    private void paserResult(String result,  final RequestCallback callback, final int code) {
        final UserEntity userEntity = new Gson().fromJson(result, UserEntity.class);
        if (callback != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
//                    if (200 == code) {
                    callback.success(userEntity);
//                    } else {
//                        callback.successMsg(userEntity.msg);
//                    }
                }
            });

        }
    }
}
