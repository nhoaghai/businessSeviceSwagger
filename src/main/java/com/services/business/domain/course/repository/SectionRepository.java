package com.services.business.domain.course.repository;

import com.services.business.domain.course.model.Section;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query("select s from Section s where s.course.courseId = ?1")
    List<Section> findByCourseId(String courseId);

    @Modifying
    @Transactional
    @Query("delete from Section as s where s.course.courseId =:courseId")
    void deleteAllSectionByCourseId(@Param("courseId") String courseId);
}
