package com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO;

import android.database.sqlite.SQLiteDatabase;

import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.dao.DaoSession;
import com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO.dao.PersonBeanDao;
import com.demo.gong.mydemoapplication.MyApplication;

import java.net.DatagramPacket;
import java.util.List;

/**
 * Created by TS_02 on 2018/12/6.
 */

public class SQLiteUtils {
    private static SQLiteUtils instance;
    private static PersonBeanDao personBeanDao;
    private static DaoSession daoSession;

    private SQLiteUtils(PersonBeanDao personBeanDao,DaoSession daoSession) {
        this.personBeanDao = personBeanDao;
        this.daoSession = daoSession;
    }

    public static SQLiteUtils getInstance(PersonBeanDao personBeanDao,DaoSession daoSession) {
        if (instance == null) {
            instance = new SQLiteUtils(personBeanDao,daoSession);
        }
        return instance;
    }

    //增
    public void insert(PersonBean personBean) {
        personBeanDao.insert(personBean);
    }

    //删
    public void delete(PersonBean personBean) {
        personBeanDao.delete(personBean);
    }

    //改
    public void update(PersonBean personBean) {
        personBeanDao.update(personBean);
    }

    //查询单个字段
    public PersonBean selectUnique() {
        personBeanDao.detachAll();//清楚缓存
        PersonBean pg = personBeanDao.queryBuilder().where(PersonBeanDao.Properties.Name.eq("pg")).unique();
        return pg;
    }

    //查询多个字段
    public List<PersonBean> selectList() {
        personBeanDao.detachAll();
        List<PersonBean> iphonePersons = personBeanDao.queryBuilder().where(PersonBeanDao.Properties.PhoneName.eq("iphone")).list();
        return iphonePersons;
    }

    //删除表中内容
    public void deleteAllContact() {
        personBeanDao.deleteAll();
    }

}
