package com.services.business.domain.course.service;

import com.services.business.common.util.PageResponseDto;
import com.services.business.domain.course.dto.request.CategoryRequest;
import com.services.business.domain.course.dto.response.CategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    PageResponseDto<CategoryResponse> findAllCategory(Pageable pageable);

    List<CategoryResponse> getAllCategoryByNameOrDescription(String keyword);

    CategoryResponse findCategoryById(Long id);

    CategoryResponse addNewCategory(CategoryRequest categoryRequest);

}
