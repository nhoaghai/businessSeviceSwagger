package com.services.business.domain.course.repository;

import com.services.business.domain.course.model.Course;
import com.services.business.domain.mentor.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findAllByCourseNameContainingOrCourseDesContaining(String courseName, String courseDes);

    Course findByCourseId(String courseId);

    List<Course> findAllByMentorMentorId(String mentorId);

    Course findByMentorMentorIdAndCourseId(String mentorId, String courseId);
}
