package pl.pjatk.project1.model;

import org.springframework.stereotype.*;

import javax.persistence.*;
import java.math.*;

@Service
@Entity

public class Article {

    @Id
    @GeneratedValue

    private Long id;
    private String articleName;
    private BigDecimal articlePrice;


    public Article(Long id, String articleName, BigDecimal articlePrice) {
        this.id = id;
        this.articleName = articleName;
        this.articlePrice = articlePrice;
    }

    public Article(String articleName, BigDecimal articlePrice) {
        this.id = id;
        this.articleName = articleName;
        this.articlePrice = articlePrice;
    }

    public Article() {
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

}
