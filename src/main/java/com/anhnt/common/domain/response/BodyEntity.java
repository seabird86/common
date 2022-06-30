package com.anhnt.common.domain.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
//@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
//@NoArgsConstructor
public class BodyEntity<T> implements Serializable {
    public BodyEntity(){

    }
    private ErrorEntity error;
    private T data;
}

