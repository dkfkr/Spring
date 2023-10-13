package kr.co.sboard.repository;

import kr.co.sboard.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {

    Optional<ArticleEntity> findById(String no);

    public Page<ArticleEntity> findByParentAndCate(int parent, String cate, Pageable pageable);

}