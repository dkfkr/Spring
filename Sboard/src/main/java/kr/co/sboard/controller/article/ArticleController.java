package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ArticleController {

    @Autowired
    private HttpServletRequest request;


    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/list")
    public String list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO pageResponseDTO = articleService.selectArticles(pageRequestDTO);

        model.addAttribute("pageResponse", pageResponseDTO);

        return "/article/list";
    }


    @GetMapping("/article/write")
    public String register(Model model, PageRequestDTO pageRequestDTO) {
        return "/article/write";
    }

    @PostMapping("/article/write")
    public String register(ArticleDTO dto) {

        String clientIP = request.getRemoteAddr();
        dto.setRegip(clientIP);

        articleService.insertArticle(dto);

        return "redirect:/article/list";
    }

    @GetMapping("/article/view")
    public String view(String no, Model model) {
        ArticleDTO article = articleService.selectArticle(no);
        model.addAttribute("article", article);
        return "/article/view";
    }


    @GetMapping("/article/modify")
    public String modify(String no, Model model){

        ArticleDTO article = articleService.selectArticle(no);
        model.addAttribute("article", article);
        return "/article/modify";

    }

    @PutMapping("/article/modify")
    public String modify() {
        return null;
    }



}
