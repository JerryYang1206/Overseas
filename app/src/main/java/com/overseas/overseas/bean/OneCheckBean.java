package com.overseas.overseas.bean;

/**
 * Created by Administrator on 2018/4/3.
 */

public class OneCheckBean {
    private boolean isChecked;
    private String name;
    private int id;

    public OneCheckBean(boolean isChecked, String name, int id) {
        this.isChecked = isChecked;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
