package com.example.root.test1.page.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.root.test1.R;

public class ExamineAchievement extends AppCompatActivity implements View.OnClickListener {
    private Button buttonReturn, buttonPass, buttonRefuse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_examine_achievement);

        buttonReturn = findViewById(R.id.examine_submit_return);
        buttonPass   = findViewById(R.id.examine_button_pass);
        buttonRefuse = findViewById(R.id.examine_button_nopass);

        buttonReturn.setOnClickListener(this);
        buttonRefuse.setOnClickListener(this);
        buttonPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.examine_button_pass:

                break;

            case R.id.examine_submit_return:
                finish();
                break;
            case R.id.examine_button_nopass:
                break;
        }
    }
}
