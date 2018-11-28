package com.demo.gong.mydemoapplication.DemoSQliteDatabase;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.gong.mydemoapplication.R;

public class TestDatabaseActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        sqLiteDatabase = TestSqliteDatabaseOpenHelper.getInstance(this).getWritableDatabase();

        if (sqLiteDatabase.isOpen()) {
            TestSQliteDatabaseUtil.update(sqLiteDatabase);
        }
    }
}
