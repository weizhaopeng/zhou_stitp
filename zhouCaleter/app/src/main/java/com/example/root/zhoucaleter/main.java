package com.example.root.zhoucaleter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class main extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonBefore, buttonAfter, buttonReturn, buttonNew;

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        //创建数据库
        ZhouDatebase dbHelper = new ZhouDatebase(this, "calender", null, ZhouDatebase.version);

        buttonBefore = findViewById(R.id.main_button_before);
        buttonAfter  = findViewById(R.id.main_button_after);
        buttonReturn = findViewById(R.id.main_button_return);
        buttonNew    = findViewById(R.id.main_button_new);

        buttonBefore.setOnClickListener(this);
        buttonAfter.setOnClickListener(this);
        buttonReturn.setOnClickListener(this);
        buttonNew.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_button_return:
                finish();
                break;
            case R.id.main_button_new:
                Intent toNew = new Intent(main.this, New.class);
                startActivity(toNew);
                break;
            case R.id.main_button_before:
                //TODO 通过切换按钮触发，从数据库中查询并且显示在前端
                Matter[] arrayMatter = new Matter[12];
                ZhouDatebase zhouDBHelper = new ZhouDatebase(this, "calender", null, ZhouDatebase.version);


                break;
            case R.id.main_button_after:
                //TODO 通过切换按钮触发，从数据库中查询并且显示在前端

                break;
        }
    }

    public void showAllEvent(Matter[] arrayMatter, int length) {

    }
}
