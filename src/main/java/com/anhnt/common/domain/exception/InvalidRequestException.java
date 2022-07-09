package com.anhnt.common.domain.exception;

import com.anhnt.common.domain.response.ErrorEntity;
import lombok.Getter;

@Getter
public class InvalidRequestException extends AbstractException {
    public InvalidRequestException(ErrorEntity error){
        super(error);
    }
}
