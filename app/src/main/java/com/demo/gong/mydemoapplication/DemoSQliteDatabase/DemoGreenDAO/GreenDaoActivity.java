package com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.dao.DaoSession;
import com.demo.gong.mydemoapplication.MyApplication;
import com.demo.gong.mydemoapplication.R;

public class GreenDaoActivity extends AppCompatActivity {

    private SQLiteUtils sqLiteUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        MyApplication mApplication = MyApplication.getInstance();
        DaoSession daoSession = mApplication.getDaoSession();
        sqLiteUtils = SQLiteUtils.getInstance(daoSession.getPersonBeanDao(),mApplication.getDaoSession());
        sqLiteUtils.insert(new PersonBean( 1L,"lf","131648","001","iphone"));
        sqLiteUtils.insert(new PersonBean(2L,"pg","131649","002","iphone"));
        sqLiteUtils.insert(new PersonBean(3L,"nm","131650","003","oppo"));
        sqLiteUtils.delete(new PersonBean(3L,"nm","131650","003","oppo"));
    }
}
