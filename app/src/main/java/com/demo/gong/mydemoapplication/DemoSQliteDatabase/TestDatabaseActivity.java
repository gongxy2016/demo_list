package com.demo.gong.mydemoapplication.DemoSQliteDatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.GreenDaoActivity;
import com.demo.gong.mydemoapplication.R;

public class TestDatabaseActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDatabase;
    private Button btnGoGreenDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        sqLiteDatabase = TestSqliteDatabaseOpenHelper.getInstance(this).getWritableDatabase();

        if (sqLiteDatabase.isOpen()) {
            TestSQliteDatabaseUtil.update(sqLiteDatabase);
        }

        btnGoGreenDao = (Button)findViewById(R.id.btn_go_greendaodemo);
        btnGoGreenDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestDatabaseActivity.this, GreenDaoActivity.class));
            }
        });
    }
}
