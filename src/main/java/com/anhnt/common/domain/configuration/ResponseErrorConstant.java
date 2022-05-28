package com.anhnt.common.domain.configuration;

import com.anhnt.common.domain.response.ResponseError;
import org.springframework.http.HttpStatus;

public class ResponseErrorConstant {
    public static final ResponseError UNAUTHORIZED = new ResponseError("CFG00001", HttpStatus.UNAUTHORIZED.getReasonPhrase());
}
