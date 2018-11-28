package com.demo.gong.mydemoapplication.DemoSQliteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gong_ on 2018/11/19.
 */

public class TestSqliteDatabaseOpenHelper extends SQLiteOpenHelper {

    private static TestSqliteDatabaseOpenHelper dbHelper;


    private TestSqliteDatabaseOpenHelper(Context context) {
        super(context,"test_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE my_test(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,age INTEGER,num TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 使用单例模式
     * */
    public static TestSqliteDatabaseOpenHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new TestSqliteDatabaseOpenHelper(context.getApplicationContext());
        }
        return dbHelper;
    }
}
