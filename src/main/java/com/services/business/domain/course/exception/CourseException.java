package com.services.business.domain.course.exception;

import com.services.business.common.exception.DomainException;

public class CourseException extends DomainException {
    public CourseException(String message) {
        super(message);
    }

    public CourseException(String message, Throwable cause) {
        super(message, cause);
    }
}
