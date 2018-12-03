package com.example.root.test1.page.init;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.root.test1.R;

public class ads extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        Intent intent = new Intent(ads.this, MainActivity.class);
        startActivity(intent);
    }
}
