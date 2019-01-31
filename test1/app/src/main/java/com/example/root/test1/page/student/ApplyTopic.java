package com.example.root.test1.page.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Spinner spinner;
    private TextView tvApplyShow;
    private String[] topicArray;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonSubmit, buttonReturn;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_apply_topic);

        //TODO 由于字符串数组中的后半部分null导致的程序崩溃问题，还有点击下拉框选择后对数据库的操作
        //从数据库读取数据
        ZhouDatabaseOpenHelper dbHelper = new ZhouDatabaseOpenHelper(this, "zhouDatabase.db", null, ZhouDatabaseOpenHelper.version);
        topicArray = dbHelper.getTopicAvali();
        Log.d("StringArray", "数据库查询数据"+topicArray);

        spinner      = (Spinner) findViewById(R.id.apply_spinner);
        tvApplyShow  = (TextView)findViewById(R.id.apply_show);
        buttonReturn = (Button)  findViewById(R.id.apply_button_return);
        buttonSubmit = (Button)  findViewById(R.id.apply_button_submit);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, topicArray);
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
            tvApplyShow.setText("所选课题是："+topicArray[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

}
