package com.demo.gong.mydemoapplication.DemoSQliteDatabase;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gong_ on 2018/11/21.
 */

public class TestSQliteDatabaseUtil {


    public static void insert(SQLiteDatabase db) {
        db.execSQL("insert into my_test(name,age,num) values ('gxy',18,'1')");
    }

    public static void update(SQLiteDatabase db) {
        db.execSQL("update my_test set age = 17 where name = 'gxy'");
    }
}
