package com.anhnt.common.domain.customer.response;

import com.anhnt.common.domain.response.ErrorEntity;
import org.springframework.http.HttpStatus;

public class ErrorEntityConstant {
    public static final ErrorEntity INTERNAL_SERVER_ERROR = new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "CUS99999", new StringBuilder(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).append(": ").append("%s").toString());
}
