package pl.pjatk.project1.repository;
import java.awt.print.*;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;
import pl.pjatk.project1.model.*;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT Article  FROM  Article article WHERE article.id = :id")
    List<Article> findArticlesById(@Param("id") Long id);

    @Query("SELECT SUM(article.articlePrice)  FROM  Article article ")
    List<Article> findArticlesTotal();

}
