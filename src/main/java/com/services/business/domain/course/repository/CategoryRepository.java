package com.services.business.domain.course.repository;

import com.services.business.domain.course.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByCategoryNameContainingOrDescriptionContaining(String categoryName, String categoryDescription);

    Category findByCategoryId(Long id);
}
