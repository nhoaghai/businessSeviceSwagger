package com.services.business.domain.mentor.model;

import com.services.business.domain.course.model.Course;
import com.services.business.domain.member.model.User;
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
@Table(name = "mentor")
public class Mentor {
    @Id
    @Column(name = "user_id")
    private String mentorId;

    @Column(name = "degree")
    private String degree;

    @Column(name = "experience")
    private int experience;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;


    @OneToMany(mappedBy = "mentor")
    private List<Course> course;
}
