package com.example.root.test1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.root.test1.page.project.Topic;
import com.example.root.test1.page.user.User;

//数据库创建表语句常量
public class ZhouDatabaseOpenHelper extends SQLiteOpenHelper {
    //静态变量指代数据库版本
    public static int version = 6;

    private static final String CREATE_TABLE_USERS=
            "create table users ("
                    +"user_id          integer primary key autoincrement, "
                    +"username         text not null, "
                    +"passwd           text not null, "
                    +"real_name        text not null, "
                    +"is_male          integer default 1, "
                    +"number           text, "
                    +"telephone_number text, "
                    +"qq_num           text, "
                    +"is_student       integer, "
                    +"delete_state     integer, "
                    +"delete_time      date, "
                    +"note             text,"
                    +"project_num      integer);";

    private static final String CREATE_TABLE_TOPIC =
            "create table topic ("
                    +"topic_id                integer primary key autoincrement, "
                    +"topic_name              text not null, "
                    +"topic_guidence_name     text not null, "
                    +"topic_category          text ,"
                    +"topic_technology_need   text, "
                    +"topic_students_need     text, "
                    +"topic_guidence_id       integer, "
                    +"topic_researcher1       integer, "
                    +"topic_researcher2       integer, "
                    +"topic_researcher3       integer, "
                    +"topic_researchers_other integer,"
                    +"topic_researchers_state integer default 0, "
                    +"topic_state             integer default 0, "
                    +"topic_is_full           integer default 0, "
                    +"topic_delete_state      integer,"
                    +"topic_delete_date       date);";
    private Context zhouContext;

    public ZhouDatabaseOpenHelper(Context contextCreate, String dbName, SQLiteDatabase.CursorFactory cf, int version) {
        super(contextCreate, dbName, cf, version);
        zhouContext = contextCreate;
    }

    @Override
    public void onCreate(SQLiteDatabase SQLiteDB) {
        SQLiteDB.execSQL(CREATE_TABLE_USERS);
        SQLiteDB.execSQL(CREATE_TABLE_TOPIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDB, int version, int newVerision) {
        SQLiteDB.execSQL("drop table if exists users");
        SQLiteDB.execSQL("drop table if exists topic");
        onCreate(SQLiteDB);
    }

    public void addUserIntoDB(User u) {
        SQLiteDatabase SQLiteDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", u.username);
        cv.put("passwd", u.passwd);
        cv.put("telephone_number", u.telephoneNumber);
        cv.put("qq_num", u.qqNumber);
        cv.put("real_name", u.realName);

        if (u.isStudent)
            cv.put("is_student", 1);
        else
            cv.put("is_student", 0);
        SQLiteDB.insert("users", null, cv);
        cv.clear();
    }

    public void addTopicIntoDB(Topic t) {
        SQLiteDatabase sqliteDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("topic_name", t.topicName);
        cv.put("topic_guidence_name", t.topicTeacher);
        cv.put("topic_category", t.topicCategory);
        cv.put("topic_technology_need", t.topicTechNeed);
        cv.put("topic_students_need", t.topicStudentNeed);
        //cv.put("topic_researcher1", t.topicResearcher[0]);
        //cv.put("topic_researcher2", t.topicResearcher[1]);
        //cv.put("topic_researcher3", t.topicResearcher[2]);
        //cv.put("topic_researchers_state", t.topicResearcherState.toString());

        sqliteDB.insert("topic", null, cv);
        cv.clear();
    }

    //TODO 将用户登录操作形成方法放入该类中:返回值0：正确，1,：用户名不存在， 2：密码错误
    public int userLogin(String username, String passwd, int isStudent) {
        Cursor cursor;
        SQLiteDatabase SQLiteDB = this.getReadableDatabase();

        cursor = SQLiteDB.rawQuery("select username from users t where t.username = ? and t.passwd = ? and t.is_student = ?",
                new String[]{username, passwd, String.valueOf(isStudent)});
        if (cursor.moveToFirst()) {
           return 0;
        }
        else {
            cursor = SQLiteDB.rawQuery("select username from users t where t.username = ?", new String[] {username});
            if (cursor.moveToFirst()) {
                cursor.close();
                return 2;
            }
            //Toast.makeText(MainActivity.class, "密码错误！请确认！", Toast.LENGTH_SHORT).show();
            else {
                cursor.close();
                return 1;
            }
            //Toast.makeText(MainActivity.class, "用户名不存在！", Toast.LENGTH_SHORT).show();
        }
    }

    //获取可做的课题名称字符串数组
    public String[] getTopicAvali() {
        Cursor cursor;
        int    line;

        SQLiteDatabase sqliteDB = this.getReadableDatabase();
        cursor = sqliteDB.rawQuery("select topic_name from topic t where t.topic_is_full = ? and t.topic_state = ?", new String[] {"0", "0"});
        line = cursor.getCount();

        String[] returnString = new String[line];
        for (int i = 0; cursor.moveToNext() && i < line; i++)
            returnString[i] = new String(cursor.getString(cursor.getColumnIndex("topic_name")));
        Log.d("StringArray", "从数据库中读取到的数据"+returnString[0]);

        cursor.close();
        return(returnString);
    }

    public boolean userExisted(String username, int isstudent) {
        Cursor cursor;
        SQLiteDatabase sqliteDB = this.getReadableDatabase();
        cursor = ((SQLiteDatabase)sqliteDB).rawQuery("select username from users t where t.username = ? and t.is_student = ?",
                new String[]{username, String.valueOf(isstudent)});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        else {
            cursor.close();
            return false;
        }
    }
}

