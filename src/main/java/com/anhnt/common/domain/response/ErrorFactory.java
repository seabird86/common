package com.anhnt.common.domain.response;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.http.HttpStatus;

public class ErrorFactory {
    public final static class ApiGatewayError {
        public static final BiFunction<String, List, ErrorEntity> INVALID_SIGNATURE = (lang, args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "AGW00001", args, lang);
        public static final BiFunction<String, List, ErrorEntity> INTERNAL_SERVER_ERROR = (lang, args) -> new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "AGW99999", args, lang);
        public static final BiFunction<String, List, ErrorEntity> HEADER_REQUIRED = (lang, args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "AGW00002", args, lang);
        public static final BiFunction<String, List, ErrorEntity> TOO_MANY_REQUESTS = (lang, args) -> new ErrorEntity(HttpStatus.TOO_MANY_REQUESTS, "AGW00003", args, lang);
    }
    public final static class CustomerError {
        public static final Function<List,ErrorEntity> INTERNAL_SERVER_ERROR = (args) -> new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "CUS99999", args);
        public static final Function<List,ErrorEntity> BALANCE_MUST_BE_POSITIVE = (args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "CUS00001", args);
        public static final Function<List,ErrorEntity> USERNAME_EXISTS = (args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "CUS00002", args);
    }

    public final static class PaymentError {
        public static final Function<List,ErrorEntity> INTERNAL_SERVER_ERROR = (args) -> new ErrorEntity(HttpStatus.INTERNAL_SERVER_ERROR, "PMT99999", args);
        public static final Function<List,ErrorEntity> INVALID_PAYEE = (args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "PMT00001", args);
        public static final Function<List,ErrorEntity> BALANCE_AMOUNT_MUST_GREATER_THAN = (args) -> new ErrorEntity(HttpStatus.BAD_REQUEST, "PMT00002", args);
    }

    public final static class ConfigurationError {
        public static final Function<List,ErrorEntity> UNAUTHORIZED = (args) -> new ErrorEntity(HttpStatus.UNAUTHORIZED, "CFG00001", args);
    }
}
