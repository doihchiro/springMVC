package com.yeezy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;

    @Column(length = 2000)
    private String content;

    @Column(updatable = false)
    private String writer;

    @Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
    private Date indate;
    @Column(updatable = false, insertable = false, columnDefinition = "int default 0")
    private int count;
}
