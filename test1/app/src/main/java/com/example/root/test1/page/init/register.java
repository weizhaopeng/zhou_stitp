package com.example.root.test1.page.init;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.root.test1.R;
import com.example.root.test1.database.ZhouDatabaseOpenHelper;
import com.example.root.test1.page.user.User;

public class register extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSubmit, buttonReturn;
    private ZhouDatabaseOpenHelper dbHelper;
    private EditText username, passwd, passwdAgain, realName,
            telephoneNum, qqNum, number, note, projectId;
    private RadioGroup rgUserType;
    private RadioButton rbTeacher, rbStudent;
    private boolean isMale, isStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        buttonSubmit = findViewById(R.id.submit_register);
        buttonReturn = findViewById(R.id.return_register);
        //查找编辑栏id
        username   = findViewById(R.id.register_username);
        passwd     = findViewById(R.id.register_passwd);
        passwdAgain  = findViewById(R.id.register_passwd_again);
        realName   = findViewById(R.id.register_name_real);
        telephoneNum = findViewById(R.id.register_telephone_number);
        qqNum      = findViewById(R.id.register_qq_number);
        rgUserType = findViewById(R.id.register_user_type);
        rbTeacher  = findViewById(R.id.register_teacher);
        rbStudent  = findViewById(R.id.register_student);

        buttonReturn.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);
        rgUserType.setOnCheckedChangeListener(new RadioGroupListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.return_register:
                finish();
                break;
            case R.id.submit_register:
                User user     = new User();
                String passwdAgainTemp;

                user.username = username.getText().toString();
                user.passwd   = passwd.getText().toString();
                user.qqNumber = qqNum.getText().toString();
                user.realName = realName.getText().toString();
                user.telephoneNumber = telephoneNum.getText().toString();
                user.isStudent = isStudent;
                passwdAgainTemp   = passwdAgain.getText().toString();

                if (!passwdAgainTemp.equals(user.passwd)) {
                    Toast.makeText(register.this, "密码前后不一致！请确认！", Toast.LENGTH_SHORT).show();
                    break;
                }

                dbHelper = new ZhouDatabaseOpenHelper(this, "zhouDatabase.db", null, ZhouDatabaseOpenHelper.version);
                //判断是否用户存在
                if (dbHelper.userExisted(user.username, (isStudent? 1 : 0))) {
                    Toast.makeText(register.this, "用户名已存在！", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    dbHelper.addUserIntoDB(user);
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                }
        }
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup rg, int checkedId) {
            if (checkedId == rbTeacher.getId()) {
                isStudent = false;
            }
            else if (checkedId == rbStudent.getId()) {
                isStudent = true;
            }
        }
    }
}

