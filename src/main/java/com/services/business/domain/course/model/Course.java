package com.services.business.domain.course.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.services.business.domain.mentor.model.Mentor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_des")
    private String courseDes;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "image_course_url")
    private String imageCourseUrl;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_price")
    private Long coursePrice;

    @Column(name = "course_rate")
    private int courseRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonIgnoreProperties({"categoryName", "description"})
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnoreProperties({"degree","experience"})
    private Mentor mentor;

    @OneToMany(mappedBy = "course")
    private List<Section> section;
}
