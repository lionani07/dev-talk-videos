package com.github.lionani07.appvideos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "videos")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String url;
}
