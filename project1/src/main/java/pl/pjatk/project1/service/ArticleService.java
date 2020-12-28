package pl.pjatk.project1.service;

import org.springframework.stereotype.*;
import pl.pjatk.project1.model.*;
import pl.pjatk.project1.repository.*;

import java.math.*;
import java.util.*;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;
    private TotalRepository totalRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAll(){
       return articleRepository.findAll();
    }



    public Optional <Article> findById(Long id){
        return articleRepository.findById(id);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    public Article saveArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    public Article updateArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    public BigInteger totalArticlePrices() {
        return totalRepository.selectTotals();

    }



}


