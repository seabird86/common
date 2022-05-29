package com.anhnt.common.domain.exception;

import com.anhnt.common.domain.response.ErrorEntity;
import lombok.Getter;

@Getter
public class AbstractException extends RuntimeException {
    private ErrorEntity error;

    public AbstractException(ErrorEntity error){
        super(error.getMessage());
        this.error = error;
    }
}
