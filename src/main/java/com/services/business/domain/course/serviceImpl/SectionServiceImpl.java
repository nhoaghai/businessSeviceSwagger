package com.services.business.domain.course.serviceImpl;

import com.services.business.common.util.MessageResponse;
import com.services.business.domain.course.dto.response.SectionResponse;
import com.services.business.domain.course.exception.CourseException;
import com.services.business.domain.course.model.Section;
import com.services.business.domain.course.repository.SectionRepository;
import com.services.business.domain.course.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<SectionResponse> findAllSectionByCourseId(String courseId) {
        List<Section> sections = sectionRepository.findByCourseId(courseId);
        if (sections == null) {
            throw new CourseException("Could not find any Section in this course");
        } else {
            return sections.stream()
                    .map(section -> {
                        SectionResponse sectionResponse = modelMapper.map(section, SectionResponse.class);
                        sectionResponse.setCourseId(section.getCourse().getCourseId());
                        return sectionResponse;
                    }).toList();
        }
    }

    @Override
    public MessageResponse deleteAllSectionByCourseId(String courseId) {
        sectionRepository.deleteAllSectionByCourseId(courseId);
        return MessageResponse.builder()
                .message("Delete all section successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
