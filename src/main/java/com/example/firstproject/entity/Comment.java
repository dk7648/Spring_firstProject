package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id // 대표키 지정
    @GeneratedValue(strategy= GenerationType.IDENTITY) // DB가 자동으로 1씩 증가
    private Long id;
    @ManyToOne // Comment 엔티티와 Article 엔티티를 다대일 관계로 설정
    @JoinColumn(name="article_id") // 외래키 생성, Article엔티티의 기본키(id)와 매핑
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        //예외 발생
        if(dto.getId() != null)
            throw new IllegalArgumentException("댓글 생설 실패! 댓글의 id가 없어야 합니다.");
        if(dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("댓글 생설 실패! 게시글의 id가 잘못됐습니다.");
        // 엔티티 생성 및 반환
        return new Comment(dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody());

    }
}
