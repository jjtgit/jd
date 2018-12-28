package com.example.xsxweek02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView plv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        plv = (PullToRefreshListView) findViewById(R.id.plv);
    }
}
