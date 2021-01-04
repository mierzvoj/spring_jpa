package pl.pjatk.project1.controller;

import org.modelmapper.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.project1.model.*;
import pl.pjatk.project1.service.*;

import java.util.*;
import java.util.stream.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private ModelMapper modelMapper;
    private ArticleService articleService;

    public ArticleController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;

    }

    @Bean
    @RequestMapping(value = "/article",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseEntity saveArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = convertToEntity(articleDTO);
        Article articleCreated = articleService.saveArticle(article);
        return ResponseEntity.ok(convertToDto(articleCreated));
    }

    @Bean
    @GetMapping("/select")
    public ResponseEntity<List<ArticleDTO>> selectAll() {
        return ResponseEntity.ok(articleService.findAll().stream()
                .map(this::convertToDto).collect(Collectors.toList()));
    }

    @Bean
    @GetMapping("/selectTotals")
    public ResponseEntity<List<ArticleDTO>> findArticlesTotals() {
        return ResponseEntity.ok(articleService.findArticlesTotal().stream()
                .map(this::convertToDto).collect(Collectors.toList()));
    }

    @PutMapping("/article/{id}")
    public void updateArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = convertToEntity(articleDTO);
        articleService.updateArticle(article);
    }

    private ArticleDTO convertToDto(Article article) {
        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        articleDTO.setArticleName(article.getArticleName());
        articleDTO.setArticlePrice(article.getArticlePrice());
        return articleDTO;
    }

    private Article convertToEntity(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);
        article.setArticleName(articleDTO.getArticleName());
        article.setArticlePrice(articleDTO.getArticlePrice());
        return article;
    }


//
//    @GetMapping
//    public ResponseEntity<List<Article>> findAll() {
//        return ResponseEntity.ok(articleService.findAll());
//    }
//
//    @GetMapping("/{id}")
//
//    public ResponseEntity<Optional<Article>> findById(@PathVariable Long id){
//
//        Optional<Article> byId = articleService.findById(id);
//
//        if(byId.isPresent()){
//
//            return ResponseEntity.ok(byId);
//
//        } else { return ResponseEntity.notFound().build();
//
//        }
//
//    }
////
//    @DeleteMapping("/{id}/")
//    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
//        articleService.deleteArticle(id);
//        return ResponseEntity.ok().build();
//    }
//


}