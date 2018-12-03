package com.example.root.test1.page.student;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.test1.*;
import com.example.root.test1.R;
import com.example.root.test1.page.init.MainActivity;

public class Yangxiaohan extends Activity implements View.OnClickListener {
    private EditText et;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_yangxiaohan);

        Toast.makeText(Yangxiaohan.this, "国务院热烈欢迎魏朝鹏的女朋友杨晓涵参加大创项目", Toast.LENGTH_SHORT).show();
        et = findViewById(R.id.yangxiaohan_like);
        submit = findViewById(R.id.yangxiaohan_submit);

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yangxiaohan_submit:
                if (et.getText().toString().equals("喜欢")) {
                    Toast.makeText(Yangxiaohan.this, "我也喜欢你，老婆", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if (et.getText().toString().equals("不喜欢")) {
                    Toast.makeText(Yangxiaohan.this,"不存在的，重新选择", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(Yangxiaohan.this, "你在瞎写啥，回去重新选", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
