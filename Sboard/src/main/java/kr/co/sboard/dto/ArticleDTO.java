package kr.co.sboard.dto;

import jakarta.persistence.*;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO {

    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private MultipartFile fname;
    private int file;
    private int hit;
    private String writer;
    private String regip;
    private LocalDateTime rdate;

    public ArticleEntity toEntity(){
        return ArticleEntity.builder()
                .no(no)
                .parent(parent)
                .comment(comment)
                .cate(cate)
                .title(title)
                .content(content)
                .file(file)
                .hit(hit)
                .writer(writer)
                .regip(regip)
                .rdate(rdate)
                .build();
    }
}
