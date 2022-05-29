package com.anhnt.common.domain.apigateway.response;

import com.anhnt.common.domain.response.ErrorEntity;
import org.springframework.http.HttpStatus;

public class ErrorEntityConstant {
    public static final ErrorEntity INVALID_SIGNATURE = new ErrorEntity(HttpStatus.BAD_REQUEST, "AGW00001", "Invalid Signature");
    public static final ErrorEntity INTERNAL_SERVER_ERROR = new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "AGW99999", new StringBuilder(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).append(": ").append("%s").toString());
    public static final ErrorEntity HEADER_REQUIRED = new ErrorEntity(HttpStatus.BAD_REQUEST, "AGW00002", "Header [%s] is Required");
}
