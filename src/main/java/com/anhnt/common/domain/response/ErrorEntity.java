package com.anhnt.common.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class ErrorEntity implements Cloneable{
    @JsonIgnore
    private HttpStatus status;
    private String code;
    private String message;

    public ErrorEntity withParams(Object ...params){
        return new ErrorEntity(status, code, message.formatted(params));
    }

    public ResponseEntity toResponseEntity(){
        return ResponseEntity.status(status).body(BodyEntity.builder().error(this).build());
    }
}
