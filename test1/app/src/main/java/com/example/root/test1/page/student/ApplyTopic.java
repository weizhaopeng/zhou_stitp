package com.example.root.test1.page.student;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.root.test1.R;
import com.example.root.test1.database.ZhouDatabaseOpenHelper;

public class ApplyTopic extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    private TextView applyShow;
    private String[] topicArray;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonSubmit, buttonReturn;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_apply_topic);

        //TODO 由于字符串数组中的后半部分null导致的程序崩溃问题，还有点击下拉框选择后对数据库的操作
        topicArray = new String[]{"基于可见光通信的博物馆语音播报系统",
                "关联成像优化算法模块研究", "基于BCube的网络的分布式深度学习优化",
                "基于大数据的网络虚拟化技术", "基于神经网络的图像处理算法"};
        /*
        ZhouDatabaseOpenHelper dbHelper = new ZhouDatabaseOpenHelper(this, "zhouDatabase.db",
                null, ZhouDatabaseOpenHelper.version);
        dbHelper.getTopicAvali(topicArray);
            */
        spinner   = findViewById(R.id.apply_spinner);
        applyShow = findViewById(R.id.apply_show);
        buttonReturn = findViewById(R.id.apply_button_return);
        buttonSubmit = findViewById(R.id.apply_button_submit);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, topicArray);
        spinner.setAdapter(adapter);

        buttonReturn.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
        spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.apply_button_return:
                finish();
                break;
            case R.id.apply_button_submit:
                //TODO 学生申请做课题的代码，操作数据库
                break;
        }
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
