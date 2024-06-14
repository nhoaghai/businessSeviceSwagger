package com.services.business.controller.courseC;

import com.services.business.common.util.MessageResponse;
import com.services.business.domain.course.dto.response.SectionResponse;
import com.services.business.domain.course.serviceImpl.SectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v3/sections")
public class SectionController {
    private final SectionServiceImpl sectionService;

    @GetMapping("/{courseId}")
    public ResponseEntity<List<SectionResponse>> findAllSectionByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(sectionService.findAllSectionByCourseId(courseId));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<MessageResponse> deleteAllSectionByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(sectionService.deleteAllSectionByCourseId(courseId));
    }
}
