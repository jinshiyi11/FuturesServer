package com.shuai.hehe.api.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 期货信息
 */
public class Futures {
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
