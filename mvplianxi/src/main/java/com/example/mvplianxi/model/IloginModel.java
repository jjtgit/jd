package com.example.mvplianxi.model;

import com.example.mvplianxi.net.RequestCallback;

import java.util.HashMap;

public interface IloginModel {
    void login(HashMap<String,String> params,RequestCallback requestCallback);
}
