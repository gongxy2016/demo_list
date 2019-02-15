package com.demo.gong.mydemoapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
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

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
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
