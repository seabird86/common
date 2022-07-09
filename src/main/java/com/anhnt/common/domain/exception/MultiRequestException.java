package com.anhnt.common.domain.exception;

import com.anhnt.common.domain.response.ErrorEntity;
import lombok.Getter;

@Getter
public class MultiRequestException extends AbstractException {
    public MultiRequestException(ErrorEntity error){
        super(error);
    }
}
