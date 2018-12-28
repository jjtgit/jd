package com.example.xiaoyiday1.modern;

import com.example.xiaoyiday1.bean.Result;
import com.example.xiaoyiday1.bean.User;
import com.example.xiaoyiday1.view.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class LoginModel {

    public static Result getlogin(String name, String pwd){
        String ss=Utils.get("http://120.27.23.105/user/login?mobile="+name+"&password="+pwd);
        Gson gson = new Gson();
        Type type = new TypeToken<Result<User>>() {}.getType();
        Result result = gson.fromJson(ss, type);
        return result;
    }
}
