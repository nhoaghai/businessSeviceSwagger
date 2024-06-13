package com.services.business.domain.course.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    @NotNull
    private String courseId;

    @NotNull
    private String courseName;

    @NotNull
    private String courseDes;

    @NotNull
    private Integer duration;

    private String imageCourseUrl;

    private boolean isActive;

    @NotNull
    private String courseTitle;

    @NotNull
    private Long coursePrice;

    private Integer courseRate;

    private Long categoryId;

    @NotNull
    private String userId;
}
