package com.demo.gong.mydemoapplication.DemoSQliteDatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.GreenDaoActivity;
import com.demo.gong.mydemoapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

public class TestDatabaseActivity extends BaseActivity {

    @BindView(R.id.btn_go_greendaodemo)
    Button btnGoGreenDao;

    private SQLiteDatabase sqLiteDatabase;

    @OnClick(R.id.btn_go_greendaodemo)
    public void onViewClick(View view) {
        startActivity(new Intent(TestDatabaseActivity.this, GreenDaoActivity.class));
    }

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
