package pl.pjatk.project1.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.project1.model.*;
import pl.pjatk.project1.service.*;
import javax.persistence.*;
import java.math.*;
import java.util.*;

@RestController
@RequestMapping

public class ArticleController {
    @Autowired
    private ArticleService articleService;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;

    }


    @GetMapping
    public ResponseEntity<List<Article>> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping("/{id}")

    public ResponseEntity<Optional<Article>> findById(@PathVariable Long id){

        Optional<Article> byId = articleService.findById(id);

        if(byId.isPresent()){

            return ResponseEntity.ok(byId);

        } else { return ResponseEntity.notFound().build();

        }

    }


    @RequestMapping(value = "/article",
            produces = "application/json",
            method=RequestMethod.POST)
    public ResponseEntity saveArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.saveArticle(article));
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.updateArticle(article));
    }

    @GetMapping("/select")

    public ResponseEntity<List<ArticleDTO>> selectAll() {
        return ResponseEntity.ok(articleService.selectAll());

    }

}