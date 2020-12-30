package pl.pjatk.project1.model;

import org.springframework.stereotype.*;

import javax.persistence.*;
import java.awt.print.*;
import java.math.*;

@Component
public class ArticleDTO {
    private Long id;
    private String articleName;
    private BigDecimal articlePrice;


    public ArticleDTO(Long id, String articleName, BigDecimal articlePrice) {
        this.id = id;
        this.articleName = articleName;
        this.articlePrice = articlePrice;
    }

    public ArticleDTO(String articleName, BigDecimal articlePrice) {
        this.id = id;
        this.articleName = articleName;
        this.articlePrice = articlePrice;
    }

    public ArticleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public BigDecimal getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(BigDecimal articlePrice) {
        this.articlePrice = articlePrice;
    }

//    public ArticleDTO mapArticleToArticleDTO(ArticleDTO articleDTO, Article article) {
//        ArticleDTO article1 = new ArticleDTO();
//
//        if (article.getArticleName() != null) {
//            article1.setArticleName(article.getArticleName());
//        }
//        if (article.getArticlePrice() != null) {
//            article1.setArticlePrice(article.getArticlePrice());
//        }
//        return article1;
//    }

    static ArticleDTO from (Article article) {
        return new ArticleDTO(article.getArticleName(), article.getArticlePrice());
    }
}
