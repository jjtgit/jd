package com.example.xiaoyiday1.core;

import com.example.xiaoyiday1.bean.Result;
import com.example.xiaoyiday1.bean.User;

public interface DataCall<T> {
    void success(T data);

    void faile(Result result);
}
