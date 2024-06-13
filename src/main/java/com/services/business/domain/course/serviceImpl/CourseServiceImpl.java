package com.services.business.domain.course.serviceImpl;

import com.services.business.common.util.MessageResponse;
import com.services.business.common.util.PageResponseDto;
import com.services.business.domain.course.dto.request.CourseRequest;
import com.services.business.domain.course.dto.response.CourseResponse;
import com.services.business.domain.course.exception.CourseException;
import com.services.business.domain.course.model.Course;
import com.services.business.domain.course.repository.CategoryRepository;
import com.services.business.domain.course.repository.CourseRepository;
import com.services.business.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public PageResponseDto<CourseResponse> findAllCourse(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);
        List<CourseResponse> data = page.getContent().stream()
                .map(course -> {
                    CourseResponse response = modelMapper.map(course, CourseResponse.class);
                    response.setCategoryName(course.getCategory().getCategoryName());
                    return response;
                })
                .toList();

        PageResponseDto<CourseResponse> pageResponseDto = new PageResponseDto<>();
        pageResponseDto.setData(data);
        pageResponseDto.setTotalPage(page.getTotalPages());
        pageResponseDto.setPageNumber(page.getNumber());
        pageResponseDto.setSize(page.getSize());
        pageResponseDto.setSort(page.getSort().toString());
        return pageResponseDto;
    }

    @Override
    public List<CourseResponse> findAllByCourseNameOrDescription(String keyword) {
        List<Course> courses = courseRepository.findAllByCourseNameContainingOrCourseDesContaining(keyword,keyword);
        if (courses.isEmpty()){
            throw new CourseException("Not found course with name or description");
        }else {
            return courses.stream()
                    .map(course -> {
                        CourseResponse response = modelMapper.map(course, CourseResponse.class);
                        response.setCategoryName(course.getCategory().getCategoryName());
                        return response;
                    })
                    .collect(Collectors.toList());
        }
    }

    @Override
    public CourseResponse findCourseById(String courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course == null){
            throw new CourseException("Could not found course with Id");
        }else {
            CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
            courseResponse.setCategoryName(course.getCategory().getCategoryName());
            return courseResponse;
        }
    }

    @Override
    public MessageResponse addNewCourse(String courseId,CourseRequest courseRequest) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course == null){
            //add new
            courseRepository.save(modelMapper.map(courseRequest, Course.class));
        }else {
            //update
            course.setCourseDes(courseRequest.getCourseDes());
            course.setCourseName(courseRequest.getCourseName());
            course.setCoursePrice(courseRequest.getCoursePrice());
            course.setCourseRate(courseRequest.getCourseRate());
            course.setCourseTitle(courseRequest.getCourseTitle());
            course.setDuration(courseRequest.getDuration());
            course.setImageCourseUrl(courseRequest.getImageCourseUrl());
            course.setActive(courseRequest.isActive());
            courseRepository.save(course);
        }
        return MessageResponse.builder()
                .message("Successfully!")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public MessageResponse deleteCourseById(String courseId) {
        courseRepository.deleteById(courseId);
        return MessageResponse.builder()
                .message("Delete course successfully!")
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
