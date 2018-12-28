package com.example.mvplianxi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplianxi.R;
import com.example.mvplianxi.entity.UserEntity;
import com.example.mvplianxi.presenter.LoginPresenter;
import com.example.mvplianxi.view.IloginView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements IloginView {

    private EditText mobile;
    private EditText password;
    private Button deng;
    private Button zc;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initView() {
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        zc = (Button) findViewById(R.id.zc);
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    /**git
     * 初始化数据
     */
    private void initData() {
        presenter = new LoginPresenter(this);
    }
    /**
     * 点击，登录
     * @param view
     */
    public void login(View view) {
        String name = mobile.getText().toString();
        String pwd = password.getText().toString();
        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",name);
        params.put("password",pwd);

        if (presenter!=null){
            presenter.login(params);
        }

    }


    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.getMsg()+"",Toast.LENGTH_SHORT).show();
        if (userEntity.getMsg().equals("登录成功")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
