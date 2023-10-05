package kr.ch08.entity.board;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
/* 
 * @ToString에서 exclude 속성을 통한 무한참조() 에러를 방지
 * toSting() 메서드에서 양방향 참조를 모두 처리하면 무한순환 참조가 발생
 * 어느 한 쪽만 참조할 수 있게 exclude를 해줘야됨
 */
@ToString(exclude = "article")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BoardComment")
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cno;
	private String content;
	
	@CreationTimestamp
	private LocalDateTime rdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "witer")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent")
	private ArticleEntity article;
	
}
