package kr.co.sboard.entity;

import jakarta.persistence.*;
import jakarta.servlet.annotation.HttpConstraint;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Article")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private int hit;
    private String writer;
    private String regip;

    @CreationTimestamp
    private LocalDateTime rdate;

    @OneToOne
    @JoinColumn(name = "no")
    private FileEntity fileEntity;

    public ArticleDTO toDTO(){
        return ArticleDTO.builder()
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
