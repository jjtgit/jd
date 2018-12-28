package com.example.xiaoyiday1.presentre;

import android.os.Handler;
import android.os.Message;

import com.example.xiaoyiday1.MainActivity;
import com.example.xiaoyiday1.bean.Result;
import com.example.xiaoyiday1.core.DataCall;
import com.example.xiaoyiday1.modern.LoginModel;

public class LoginPresenter {

    DataCall dataCall;
    public LoginPresenter(DataCall dataCall) {
        this.dataCall=dataCall;
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Result result = (Result) msg.obj;
            if (result.getCode()==0){
                dataCall.success(result.getData());
            }else {
                dataCall.faile(result);
            }
        }
    };


    public void add(final String name, final String pwd) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Result getlogin = LoginModel.getlogin(name, pwd);
                Message message = handler.obtainMessage();
                message.obj=getlogin;
                handler.sendMessage(message);
            }
        }).start();
    }
}
