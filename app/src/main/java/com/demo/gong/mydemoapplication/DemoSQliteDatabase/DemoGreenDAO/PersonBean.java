package com.demo.gong.mydemoapplication.DemoSQliteDatabase.DemoGreenDAO;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by TS_02 on 2018/12/6.
 */
@Entity
public class PersonBean {
    @Id(autoincrement = true)
    private Long id;
    //姓名
    public String name = "";
    //电话
    public String phone = "";
    //联系人id
    public String contactsId = "";
    //手机名
    public String phoneName = "";
    public String getPhoneName() {
        return this.phoneName;
    }
    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }
    public String getContactsId() {
        return this.contactsId;
    }
    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1069965546)
    public PersonBean(Long id, String name, String phone, String contactsId,
            String phoneName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.contactsId = contactsId;
        this.phoneName = phoneName;
    }
    @Generated(hash = 836535228)
    public PersonBean() {
    }

}
