package com.anhnt.common.domain.response;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseFactory {
    public static ResponseEntity success() {
        return success(new HashMap<>());
    }

    public static <T> ResponseEntity<BodyEntity<T>> success(T data) {
        return ResponseEntity.ok((BodyEntity<T>)BodyEntity.builder().data(data).build());
    }
}
