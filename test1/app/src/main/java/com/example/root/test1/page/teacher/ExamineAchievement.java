package com.example.root.test1.page.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.teacher, menu);//第二个参数指定的是我们将菜单选项添加到哪个菜单对象中
        return(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_teacher:
                Toast.makeText(this, "您点击了新建", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_delete_teacher:
                Toast.makeText(this, "您点击了删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_copy_teacher:
                Toast.makeText(this, "您点击了复制", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
