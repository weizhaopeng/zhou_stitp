package com.example.root.test1.page.teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        setContentView(R.layout.activity_teacher);
        Toast.makeText(teacher.this, "登录成功", Toast.LENGTH_SHORT).show();

        buttonIssuePublication = (Button)findViewById(R.id.button_release);
        buttonApplyExamine = (Button)findViewById(R.id.button_application_audit);
        buttonResultExamine    = (Button)findViewById(R.id.button_result_audit);

        buttonIssuePublication.setOnClickListener(this);
        buttonApplyExamine.setOnClickListener(this);
        buttonResultExamine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent toWhere;
        switch (v.getId()) {
            case R.id.button_release:
                toWhere = new Intent(teacher.this, issus_publication.class);
                startActivity(toWhere);
                break;
            case R.id.button_application_audit:
                toWhere = new Intent(teacher.this, AuditApply.class);
                startActivity(toWhere);
                break;
            case R.id.button_result_audit:
                toWhere = new Intent(teacher.this, ExamineAchievement.class);
                startActivity(toWhere);
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

