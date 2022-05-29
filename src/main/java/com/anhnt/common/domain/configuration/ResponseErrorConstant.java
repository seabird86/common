package com.anhnt.common.domain.configuration;

import com.anhnt.common.domain.response.ErrorEntity;
import org.springframework.http.HttpStatus;

public class ResponseErrorConstant {
    public static final ErrorEntity UNAUTHORIZED = new ErrorEntity(HttpStatus.UNAUTHORIZED, "CFG00001", HttpStatus.UNAUTHORIZED.getReasonPhrase());
}
