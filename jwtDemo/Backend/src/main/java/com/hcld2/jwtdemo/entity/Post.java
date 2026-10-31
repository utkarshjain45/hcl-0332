package com.hcld2.jwtdemo.entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String content;

    @Column(nullable = false)
    private String author;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Post(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.author = name;
    }
}
