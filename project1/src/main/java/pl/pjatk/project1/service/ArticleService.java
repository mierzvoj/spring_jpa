package pl.pjatk.project1.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import pl.pjatk.project1.model.*;
import pl.pjatk.project1.repository.*;

import java.util.*;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {

        this.articleRepository = articleRepository;
    }


    public List<Article> findArticlesTotal() {
        return articleRepository.findArticlesTotal();

    }
    public Article saveArticle(Article article) {
        articleRepository.save(article);
        return article;
    }
    public List<Article> findAll(){
       return articleRepository.findAll();
    }
//
    public Article updateArticle(Article article) {
        articleRepository.save(article);
        return article;
    }
//
//    public Optional <Article> findById(Long id){
//        return articleRepository.findById(id);
//    }
//
//    public void deleteArticle(Long id){
//        articleRepository.deleteById(id);
//    }
//

//

}


