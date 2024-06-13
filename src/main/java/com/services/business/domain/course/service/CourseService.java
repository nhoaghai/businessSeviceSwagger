package com.services.business.domain.course.service;

import com.services.business.common.util.MessageResponse;
import com.services.business.common.util.PageResponseDto;
import com.services.business.domain.course.dto.request.CourseRequest;
import com.services.business.domain.course.dto.response.CourseResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    PageResponseDto<CourseResponse> findAllCourse(Pageable pageable);

    List<CourseResponse> findAllByCourseNameOrDescription(String keyword);

    CourseResponse findCourseById(String courseId);

    MessageResponse addNewCourse(String courseId, CourseRequest courseRequest);

    MessageResponse deleteCourseById(String courseId);

}
