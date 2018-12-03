package com.example.root.test1.page.init;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
        dbHelper = new ZhouDatabaseOpenHelper(this, "zhouDatabase.db", null, 2);
        dbHelper.getWritableDatabase();
        //找到空间的id
        buttonLoad     = findViewById(R.id.button_load);
        buttonRegister = findViewById(R.id.button_register);
        et1    = findViewById(R.id.et_username);
        et2    = findViewById(R.id.et_passwd);
        rg  = findViewById(R.id.radio_group_registrar);
        rb1 = findViewById(R.id.radio_button_teacher);
        rb2 = findViewById(R.id.radio_button_student);
        //按钮监听器
        buttonRegister.setOnClickListener(this);
        buttonLoad.setOnClickListener(this);
        rg.setOnCheckedChangeListener(new RadioGroupListener());
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button_load:
                SQLiteDatabase SQLiteDB = dbHelper.getReadableDatabase();
                String usernameTemp = et1.getText().toString();
                String passwdTemp   = et2.getText().toString();
                int isStudentTemp   = (isStudent? 1: 0);
                Cursor cursor;
                Intent intentTo;

                cursor = SQLiteDB.rawQuery("select passwd from users t where t.username = ? and t.is_student = ?",
                        new String[]{usernameTemp, String.valueOf(isStudentTemp)});
                if (cursor.moveToFirst()) {
                    String passwdReturn = cursor.getString(cursor.getColumnIndex("passwd"));
                    if (passwdTemp.equals(passwdReturn)) {
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
                        startActivity(intentTo);
                    }
                    else
                        Toast.makeText(MainActivity.this, "登录失败：密码错误", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
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
