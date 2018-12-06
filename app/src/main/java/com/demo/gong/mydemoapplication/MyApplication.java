package com.demo.gong.mydemoapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.dao.DaoMaster;
import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.dao.DaoSession;

/**
 * Created by TS_02 on 2018/12/6.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private DaoMaster.DevOpenHelper mDaoHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据库(DemoGreenDAO)
        initDatabase();
    }

    /**
     * 初始化数据库
     */
    private void initDatabase() {
        mDaoHelper = new DaoMaster.DevOpenHelper(this,"person",null);
        db = mDaoHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }
}
