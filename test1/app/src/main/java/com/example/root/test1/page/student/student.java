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
        Intent toWhere;

        switch (v.getId()) {
            case R.id.student_apply:
                toWhere = new Intent(student.this, ApplyTopic.class);
                startActivity(toWhere);
                break;
            case R.id.student_submit:
                toWhere = new Intent(student.this, SubmitAchieve.class);
                startActivity(toWhere);
                break;
        }
    }
}
