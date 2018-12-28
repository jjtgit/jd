package com.example.mvplianxi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplianxi.R;
import com.example.mvplianxi.entity.UserEntity;
import com.example.mvplianxi.presenter.RegisterPresenter;
import com.example.mvplianxi.view.IloginView;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements IloginView {

    private EditText name;
    private EditText pass;
    private Button querd;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initData();
    }

    private void initData() {
        presenter = new RegisterPresenter(this);
    }
    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        querd=(Button)findViewById(R.id.querd);
        querd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namea = name.getText().toString();
                String passa = pass.getText().toString();
                HashMap<String,String> params=new HashMap<>();
                params.put("namea",namea);
                params.put("passa",passa);
                if (presenter!=null){
                    presenter.login(params);
                }
            }
        });
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
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
