package com.example.root.test1.page.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.root.test1.R;

public class AuditApply extends AppCompatActivity implements View.OnClickListener {
    private Button buttonReturn, buttonPass, buttonRefuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_audit_apply2);

        buttonReturn = findViewById(R.id.audit_return);
        buttonPass   = findViewById(R.id.audit_pass);
        buttonRefuse = findViewById(R.id.audit_refuse);

        buttonReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audit_return:
                finish();
                break;
            case R.id.audit_pass:

                break;
            case R.id.audit_refuse:
                    break;
        }
    }
}
