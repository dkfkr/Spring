package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.entity.FileEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final FileRepository fileRepository;

    public void insertArticle(ArticleDTO dto) {
        // 글 등록
        ArticleEntity savedEntity = articleRepository.save(dto.toEntity());

        FileDTO fileDTO = fileUpload(dto);

        if (fileDTO != null) {
            // 파일 등록
            fileDTO.setAno(savedEntity.getNo());
            fileRepository.save(fileDTO.toEntity());

            // file 필드 1 증가
            savedEntity.setFile(savedEntity.getFile() + 1);
            articleRepository.save(savedEntity);
        }
    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto) {

        MultipartFile mf = dto.getFname();

        if(!mf.isEmpty()) {
            //파일 첨부 시
            String path = new File(filePath).getAbsolutePath();

            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString() + ext;

            try {

                mf.transferTo(new File(path, sName));

            } catch (IOException e) {

                log.error(e.getMessage());

            }

            return FileDTO.builder().ofile(oName).sfile(sName).build();

        }

        return null;

    }

    public Page<ArticleDTO> selectArticle(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "no");

        Page<ArticleEntity> articleEntities = articleRepository.findByParent(0, pageable);

        Page<ArticleDTO> articles = articleEntities.map(ArticleEntity::toDTO);

        return articles;
    }

    public ArticleDTO selectArticle(String no) {
        Optional<ArticleEntity> articleEntityOptional = articleRepository.findById(no);
        ArticleEntity articleEntity = articleEntityOptional.get();
        return articleEntity.toDTO();
    }

}
