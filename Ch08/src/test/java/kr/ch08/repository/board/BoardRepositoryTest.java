package kr.ch08.repository.board;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import kr.ch08.entity.board.ArticleEntity;
import kr.ch08.entity.board.CommentEntity;
import kr.ch08.entity.board.FileEntity;
import kr.ch08.entity.board.UserEntity;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired private ArticleRepository articleRepo;
	@Autowired private CommentRepository commentRepo;
	@Autowired private FileRepository fileRepo;
	@Autowired private UserRepository userRepo;
	
	
	@DisplayName("insertUser 테스트")
	public void insertUser() {
		
		UserEntity user = UserEntity.builder()
							.uid("A103")
							.name("김유신")
							.hp("010-1233-1233")
							.build();
		
		userRepo.save(user);
	}
	
	
	@DisplayName("insertArticle 테스트")
	public void insertArticle() {
		
		UserEntity user = UserEntity.builder().uid("A103").build();
		
		ArticleEntity article = ArticleEntity.builder()
									.content("ㅎㅇ")
									.title("ㅎㅇ")
									.user(user)
									.build();
		
		articleRepo.save(article);
	}

	
	@DisplayName("insertCommnet 테스트")
	public void insertCommnet() {
		
		ArticleEntity no = ArticleEntity.builder().no(3).build();
		
		UserEntity user = UserEntity.builder().uid("A101").build();
		
		CommentEntity comment = CommentEntity.builder()
									.content("bye")
									.article(no)
									.user(user)
									.build();
		
		commentRepo.save(comment);
		
	}
	

	
	@DisplayName("insertFile 테스트")
	public void insertFile() {
		ArticleEntity no = ArticleEntity.builder().no(5).build();
		FileEntity file = FileEntity.builder()
							.oName("테스트5.txt")
							.sName("fdsafsfa.txt")
							.article(no)
							.build();
		
		fileRepo.save(file);
	}
	
	/*
	 * 양방향으로 처리되는 엔티티 관계에서 다수의 SELECT를 수행하기 때문에
	 * 단일 SELECT 처리 후 종료되는 특징으로 접속이 종료됨 (no session)
	 * 따라서 그 다음 SELECT 실행에서 no session 에러발생
	 * 이럴경우에 @Transactional 선언으로 트랜잭션 처리를 해줘야됨
	 */
	@Transactional
	@DisplayName("selectArticles 테스트")
	public void selectArticles() {
		
		List<ArticleEntity> articles = articleRepo.findAll();
		System.out.println(articles);
		
		
		for(ArticleEntity article : articles) {
			System.out.println(article);
		}
		
	}
	
	@Test
	@Transactional
	@DisplayName("selectArticle 테스트")
	public void selectArticle() {
		
		Optional<ArticleEntity> result = articleRepo.findById(1);
		ArticleEntity article = result.orElseThrow();
		
		System.out.println(article);
		
	}
	
}
