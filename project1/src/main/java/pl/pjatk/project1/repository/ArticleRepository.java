package pl.pjatk.project1.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;
import pl.pjatk.project1.model.*;

import java.math.*;
import java.util.*;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT id  FROM Article")
    public Optional<Article> selectId();
}
