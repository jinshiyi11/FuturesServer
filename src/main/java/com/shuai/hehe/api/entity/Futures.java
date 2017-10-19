package com.shuai.hehe.api.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 期货信息
 */
@Entity
@Table(
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"name"})
)
public class Futures {
    @Id
    @GeneratedValue
    private long id;

    //TODO:message,unique
    @Column(nullable = false,length = 32)
    @NotNull
    @Size(min = 5,message = "长度至少5个字符")
    private String name;

    @Column(nullable = false)
    @NotNull
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
