package com.example.root.test1.page.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.root.test1.R;

public class student extends Activity implements View.OnClickListener {
    private Button apply, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Toast.makeText(student.this, "登录成功", Toast.LENGTH_SHORT).show();

        apply = findViewById(R.id.student_apply);
        submit= findViewById(R.id.student_submit);

        apply.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.student_apply:
                Intent toApply = new Intent(student.this, ApplyTopic.class);
                startActivity(toApply);
                break;
            case R.id.student_submit:
                break;
        }
    }
}
