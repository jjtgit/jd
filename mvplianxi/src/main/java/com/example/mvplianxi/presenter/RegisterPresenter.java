package com.example.mvplianxi.presenter;

import com.example.mvplianxi.entity.UserEntity;
import com.example.mvplianxi.model.RegisterModel;
import com.example.mvplianxi.net.RequestCallback;
import com.example.mvplianxi.utils.ValidatorUtil;
import com.example.mvplianxi.view.IloginView;

import java.util.HashMap;

public class RegisterPresenter {
    private RegisterModel registerModel;
    private IloginView iloginView;
    public RegisterPresenter(IloginView iloginView){
        this.registerModel=new RegisterModel();
        this.iloginView=iloginView;
    }
    public void login(HashMap<String,String> params){
        String mobile = params.get("namea");
        if (!ValidatorUtil.isMobile(mobile)){
            if (iloginView!=null){
                iloginView.mobileError("请输入合法手机号");
            }
            return;//返回
        }
        if (registerModel!=null){
            registerModel.login(params, new RequestCallback() {
                @Override
                public void failure(String msg) {
                    if (iloginView!=null)
                        iloginView.failure(msg);
                }

                @Override
                public void successMsg(String msg) {
                    if (iloginView!=null)
                        iloginView.successMsg(msg);

                }

                @Override
                public void success(UserEntity userEntity) {
                    if (iloginView!=null)
                        iloginView.success(userEntity);
                }
            });
        }
    }
}
