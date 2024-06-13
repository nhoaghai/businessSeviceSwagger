package com.services.business.domain.lesson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.services.business.domain.course.model.Section;
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
@Table
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "content_link")
    private String contentLink;

    @Column(name = "lesson_title")
    private String lessonTitle;

    @OneToMany(mappedBy = "lesson")
    private List<Question> questions;

    @OneToMany(mappedBy = "lesson")
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    @JsonIgnore
    private Section section;

}
