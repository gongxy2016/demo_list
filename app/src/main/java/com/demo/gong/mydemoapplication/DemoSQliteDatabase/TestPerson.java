package com.demo.gong.mydemoapplication.DemoSQliteDatabase;

/**
 * Created by gong_ on 2018/11/19.
 */

public class TestPerson {
    private String name;
    private int age;
    private String num;

    public TestPerson(String name, int age, String num) {
        this.name = name;
        this.age = age;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
