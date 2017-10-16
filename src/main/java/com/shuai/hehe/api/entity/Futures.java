package com.shuai.hehe.api.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
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

    @Column(nullable = false)
    @NotNull
    @Size(min = 5)
    private String name;

    @Column(nullable = false)
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
