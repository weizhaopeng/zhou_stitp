package com.example.root.test1.page.init;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.root.test1.database.ZhouDatabaseOpenHelper;
import com.example.root.test1.R;
import com.example.root.test1.page.student.Yangxiaohan;
import com.example.root.test1.page.student.student;
import com.example.root.test1.page.teacher.teacher;

public class MainActivity extends Activity implements View.OnClickListener {
    Button buttonLoad, buttonRegister;
    RadioGroup rg;
    private EditText et1, et2;
    private RadioButton rb1, rb2;
    private boolean isStudent = true;
    private ZhouDatabaseOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //直接创建数据库
        dbHelper = new ZhouDatabaseOpenHelper(this, "zhouDatabase.db", null, ZhouDatabaseOpenHelper.version);
        dbHelper.getWritableDatabase();

        //找到控件的对象id
        buttonLoad     = (Button)findViewById(R.id.button_load);
        buttonRegister = (Button)findViewById(R.id.button_register);
        et1            = (EditText)findViewById(R.id.et_username);
        et2            = (EditText)findViewById(R.id.et_passwd);
        rg             = findViewById(R.id.radio_group_registrar);
        rb1            = findViewById(R.id.radio_button_teacher);
        rb2            = findViewById(R.id.radio_button_student);

        //按钮监听器
        buttonRegister.setOnClickListener(this);
        buttonLoad.setOnClickListener(this);
        rg.setOnCheckedChangeListener(new RadioGroupListener());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_load:
                String usernameTemp = et1.getText().toString();
                String passwdTemp   = et2.getText().toString();
                int isStudentTemp   = (isStudent? 1: 0);
                Intent intentTo;

                switch (dbHelper.userLogin(usernameTemp, passwdTemp, isStudentTemp)) {
                    case 0:
                        if (usernameTemp.equals("yangxiaohan") || usernameTemp.equals("杨晓涵")) {
                            intentTo = new Intent(MainActivity.this, Yangxiaohan.class);
                            //startActivity(intentTo);
                        }
                        else {
                            if (isStudent) {
                                //TODO 学生进入自己的界面需要显示自己的课题和个人信息
                                intentTo = new Intent(MainActivity.this, student.class);
                                //startActivity(intentTo);
                            } else {
                                //TODO 老师进入自己的界面需要显示自己的课题和个人信息
                                intentTo = new Intent(MainActivity.this, teacher.class);
                                //startActivity(intentTo);
                            }
                        }
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(intentTo);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "密码错误！请确认！", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case  R.id.button_register:
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
                break;

                default:
                    break;
        }
        //Intent intent = new Intent(MainActivity.this, teacher.class);
        //startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_register:
                Intent toRegister = new Intent(MainActivity.this, register.class);
                startActivity(toRegister);
                break;

            case R.id.item_main_unload:
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == rb1.getId())
                isStudent = false;
            else if (checkedId == rb2.getId())
                isStudent = true;
        }
    }
}
