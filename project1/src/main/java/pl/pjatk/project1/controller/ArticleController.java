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

    @PostMapping
    public ResponseEntity saveArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.saveArticle(article));
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article){
        return ResponseEntity.ok(articleService.updateArticle(article));
    }

    @GetMapping("/getTotalPrices")
    public ResponseEntity<BigInteger> getTotalPrices() {
        return ResponseEntity.ok(articleService.totalArticlePrices());
    }
}