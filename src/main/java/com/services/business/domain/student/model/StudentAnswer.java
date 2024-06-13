package com.services.business.domain.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.services.business.domain.lesson.model.Answer;
import com.services.business.domain.lesson.model.Question;
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
@Table(name = "student_answer")
public class StudentAnswer {
    @EmbeddedId
    private StudentAnswerId studentAnswerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "student_answer")
    private Answer studentAnswer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @MapsId("questionId")
    @JsonIgnore
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @MapsId("userId")
    @JsonIgnore
    private Student student;

}
