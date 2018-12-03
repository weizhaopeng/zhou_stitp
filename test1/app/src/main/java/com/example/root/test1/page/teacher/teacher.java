package com.example.root.test1.page.teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.root.test1.R;

public class teacher extends Activity implements View.OnClickListener {
    private Button buttonIssuePublication, buttonApplyExamine, buttonResultExamine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_teacher);
        Toast.makeText(teacher.this, "登录成功", Toast.LENGTH_SHORT).show();

        buttonIssuePublication = findViewById(R.id.button_release);
        buttonApplyExamine = findViewById(R.id.button_application_audit);
        buttonResultExamine    = findViewById(R.id.button_result_audit);

        buttonIssuePublication.setOnClickListener(this);
        buttonApplyExamine.setOnClickListener(this);
        buttonResultExamine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_release:
                Intent toRelaease = new Intent(teacher.this, issus_publication.class);
                startActivity(toRelaease);
                break;
            case R.id.button_application_audit:

                break;
            case R.id.button_result_audit:

                break;
                default:

                    break;
        }
    }
}

