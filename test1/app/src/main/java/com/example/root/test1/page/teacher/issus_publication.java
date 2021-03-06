package com.example.root.test1.page.teacher;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.test1.R;
import com.example.root.test1.database.ZhouDatabaseOpenHelper;
import com.example.root.test1.page.project.Topic;

public class issus_publication extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSubmit, buttonReturn;
    private EditText issueName, issueCategory, issueTeacher,
            issueTechnologyNeed, issueStudentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_issus_publication);

        buttonSubmit = findViewById(R.id.issue_submit);
        buttonReturn = findViewById(R.id.release_button_return);

        issueName   = findViewById(R.id.issue_name);
        issueCategory = findViewById(R.id.issue_catagory);
        issueTechnologyNeed = findViewById(R.id.issue_need);
        issueStudentNumber  = findViewById(R.id.issue_student_need);
        issueTeacher = findViewById(R.id.issue_teacher);

        buttonSubmit.setOnClickListener(this);
        buttonReturn.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.issue_submit:
                Topic topic = new Topic();

                topic.topicName = issueName.getText().toString();
                topic.topicCategory = issueCategory.getText().toString();
                topic.topicTeacher = issueTeacher.getText().toString();
                topic.topicTechNeed = issueTechnologyNeed.getText().toString();
                topic.topicStudentNeed = Integer.valueOf(issueStudentNumber.getText().toString());

                ZhouDatabaseOpenHelper dbHelper = new ZhouDatabaseOpenHelper(this,
                        "zhouDatabase.db", null, ZhouDatabaseOpenHelper.version);
                dbHelper.addTopicIntoDB(topic);
                Toast.makeText(this, "项目发布成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.release_button_return:
                finish();
                break;
        }
    }
}
