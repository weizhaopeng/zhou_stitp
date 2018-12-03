package com.example.root.test1.page.student;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.root.test1.R;

public class student extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Toast.makeText(student.this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
