package com.services.business.controller.courseC;

import com.services.business.common.util.PageResponseDto;
import com.services.business.domain.course.dto.request.CategoryRequest;
import com.services.business.domain.course.dto.response.CategoryResponse;
import com.services.business.domain.course.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v3/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<PageResponseDto<CategoryResponse>> getAllCategories(Pageable pageable){
        return ResponseEntity.ok(categoryService.findAllCategory(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponse>> findCategoryByNameOrDescription(@RequestParam("query") String keyword){
        return ResponseEntity.ok(categoryService.getAllCategoryByNameOrDescription(keyword));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.findCategoryById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> addNewCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.ok(categoryService.addNewCategory(categoryRequest));
    }
}
