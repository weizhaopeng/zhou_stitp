package com.example.root.test1.page.student;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.root.test1.R;
import com.example.root.test1.database.ZhouDatabaseOpenHelper;

public class ApplyTopic extends AppCompatActivity {
    Spinner spinner;
    private TextView applyShow;
    private String[] topicArray;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_apply_topic);

        //TODO 由于字符串数组中的后半部分null导致的程序崩溃问题，还有点击下拉框选择后对数据库的操作
        topicArray = new String[20];
        ZhouDatabaseOpenHelper dbHelper = new ZhouDatabaseOpenHelper(this, "zhouDatabase.db",
                null, ZhouDatabaseOpenHelper.version);
        dbHelper.getTopicAvali(topicArray);

        spinner   = findViewById(R.id.apply_spinner);
        applyShow = findViewById(R.id.apply_show);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, topicArray);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
        spinner.setVisibility(View.VISIBLE);
    }

    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            applyShow.setText("所选课题是："+topicArray[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }
}
