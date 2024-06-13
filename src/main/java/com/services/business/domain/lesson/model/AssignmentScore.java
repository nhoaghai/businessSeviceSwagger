package com.services.business.domain.lesson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.services.business.domain.student.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment_score")
public class AssignmentScore {

    @EmbeddedId
    private AssignmentScoreId assignmentScoreId;

    @Column(name = "score")
    private double score;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    @MapsId("lessonId")
    @JsonIgnore
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @MapsId("userId")
    @JsonIgnore
    private Student student;

}
