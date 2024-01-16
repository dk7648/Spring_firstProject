package com.example.firstproject.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor //기본 생성자 추가 어노테이션
@ToString
@Entity
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if(article.title != null)
            this.title = article.title;
        if(article.content != null)
            this.content = article.content;
    }
}
