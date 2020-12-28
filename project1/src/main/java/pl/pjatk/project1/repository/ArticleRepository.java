package pl.pjatk.project1.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;
import pl.pjatk.project1.model.*;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
