package com.tianff.jsondemo.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Dog {

    private int id;

    private String name;

    /**
     * annotation for filed-name doesn't match json-field
     */
    @JSONField(name = "dogSlogan")
    private String slogan;

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

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
