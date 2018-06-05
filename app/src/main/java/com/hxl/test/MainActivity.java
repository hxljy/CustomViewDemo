package com.hxl.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hxl.test.activity.Main2Activity;
import com.hxl.test.activity.Main3Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, Main3Activity.class));
                break;
        }
    }
}
