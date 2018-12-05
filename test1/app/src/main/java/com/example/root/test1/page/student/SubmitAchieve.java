package com.example.root.test1.page.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.root.test1.R;

public class SubmitAchieve extends AppCompatActivity implements View.OnClickListener {
    Button buttonReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_achieve);

        buttonReturn = findViewById(R.id.submit_return);

        buttonReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_return:
                finish();
                break;
            case R.id.submit_button_submit:

                break;
        }
    }
}
