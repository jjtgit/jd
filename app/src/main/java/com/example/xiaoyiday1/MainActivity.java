package com.example.xiaoyiday1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaoyiday1.bean.Result;
import com.example.xiaoyiday1.bean.User;
import com.example.xiaoyiday1.core.DataCall;
import com.example.xiaoyiday1.presentre.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DataCall<User>{

    private EditText mobile;
    private EditText password;
    private Button deng;
    private Button zc;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        deng = (Button) findViewById(R.id.deng);
        zc = (Button) findViewById(R.id.zc);
        deng.setOnClickListener(this);
        zc.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deng:
                String name = mobile.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                loginPresenter.add(name,pwd);
                break;
            case R.id.zc:

                break;
        }
    }

    @Override
    public void success(User data) {
        Toast.makeText(this,"成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void faile(Result result) {
        Toast.makeText(this,"失败",Toast.LENGTH_LONG).show();
    }


//    private void submit() {
//        // validate
//        String mobileString = mobile.getText().toString().trim();
//        if (TextUtils.isEmpty(mobileString)) {
//            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        String passwordString = password.getText().toString().trim();
//        if (TextUtils.isEmpty(passwordString)) {
//            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // TODO validate success, do something
//
//
//
//    }
}
