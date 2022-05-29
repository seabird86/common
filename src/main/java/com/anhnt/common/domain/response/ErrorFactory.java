package com.anhnt.common.domain.response;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ErrorFactory {
    public final static class ApiGatewayError {
        public static final BiFunction<String, List, ErrorEntity> INVALID_SIGNATURE = (lang, args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "AGW00001", args, lang);
        public static final BiFunction<String, List, ErrorEntity> INTERNAL_SERVER_ERROR = (lang, args) -> new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "AGW99999", args, lang);
        public static final BiFunction<String, List, ErrorEntity> HEADER_REQUIRED = (lang, args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "AGW00002", args, lang);
    }
    public final static class CustomerError {
        public static final Function<List,ErrorEntity> INTERNAL_SERVER_ERROR = (args) -> new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "CUS99999", args);
    }

    public final static class ConfigurationError {
        public static final Function<List,ErrorEntity> UNAUTHORIZED = (args) -> new ErrorEntity(HttpStatus.UNAUTHORIZED, "CFG00001", args);
    }
}
