package org.projectSoap.repositories;

import org.projectSoap.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("select c from CategoryEntity c where c.title =?1")
    Optional<CategoryEntity> findByTitle(String title);
}
