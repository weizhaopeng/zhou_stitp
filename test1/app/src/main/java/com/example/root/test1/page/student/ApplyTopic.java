package com.example.root.test1.page.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Spinner;

import com.example.root.test1.R;

public class ApplyTopic extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_apply_topic);

        spinner = findViewById(R.id.apply_spinner);
    }
}
