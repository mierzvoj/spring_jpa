package pl.pjatk.project1.service;

import org.springframework.stereotype.*;
import pl.pjatk.project1.model.*;

@Service
public class ArticleMapper {
    public Article mapArticleDtoToArticle(Article article, ArticleDTO articleDTO) {
        Article article1 = new Article();

        if (articleDTO.getArticleName() != null) {
            article1.setArticleName(articleDTO.getArticleName());
        }
        if (articleDTO.getArticlePrice() != null) {
            article1.setArticlePrice(articleDTO.getArticlePrice());
        }
        return article1;
    }
}
