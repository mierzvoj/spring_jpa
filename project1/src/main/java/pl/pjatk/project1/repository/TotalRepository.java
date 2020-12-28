package pl.pjatk.project1.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import pl.pjatk.project1.model.*;

import java.math.*;
import java.util.*;

@Repository
public interface TotalRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT SUM(articlePrice) FROM Article")
    BigInteger selectTotals();
}
