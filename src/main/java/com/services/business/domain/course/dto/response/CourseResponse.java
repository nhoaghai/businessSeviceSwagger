package com.services.business.domain.course.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String courseId;
    private String courseName;
    private String courseDes;
    private Integer duration;
    private String imageCourseUrl;
    private boolean isActive;
    private String courseTitle;
    private Long coursePrice;
    private int courseRate;
    private String categoryName;
    private String userId;
}
