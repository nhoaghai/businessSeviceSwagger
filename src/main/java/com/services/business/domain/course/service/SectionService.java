package com.services.business.domain.course.service;

import com.services.business.common.util.MessageResponse;
import com.services.business.domain.course.dto.response.SectionResponse;

import java.util.List;

public interface SectionService {
    List<SectionResponse> findAllSectionByCourseId(String courseId);

    MessageResponse deleteAllSectionByCourseId(String courseId);
}
