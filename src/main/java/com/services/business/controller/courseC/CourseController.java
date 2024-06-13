package com.services.business.controller.courseC;

import com.services.business.common.util.MessageResponse;
import com.services.business.common.util.PageResponseDto;
import com.services.business.domain.course.dto.request.CourseRequest;
import com.services.business.domain.course.dto.response.CourseResponse;
import com.services.business.domain.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<PageResponseDto<CourseResponse>> getAllCourse(Pageable pageable){
        return ResponseEntity.ok(courseService.findAllCourse(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CourseResponse>> getAllCourseByNameOrDescription(@RequestParam("query") String keyword){
        return ResponseEntity.ok(courseService.findAllByCourseNameOrDescription(keyword));
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<MessageResponse> addNewOrUpdateCourse(@PathVariable String courseId, @Valid @RequestBody CourseRequest courseRequest){
        return ResponseEntity.ok(courseService.addNewCourse(courseId, courseRequest));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<MessageResponse> deleteCourse(@PathVariable String courseId){
        return ResponseEntity.ok(courseService.deleteCourseById(courseId));
    }
}
