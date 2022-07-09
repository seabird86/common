package com.anhnt.common.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Slf4j
public class ErrorEntity implements Cloneable{
    @JsonIgnore
    private HttpStatus status;
    private String code;
    private String message;

    public ErrorEntity(HttpStatus status, String code, List params){
        this(status, code, params, null);
    }

    public ErrorEntity(HttpStatus status, String code, List params, String lang){
        this.status = status;
        this.code = code;
        this.message = ConfigurationCache.messageMap.get(code).get(lang!=null? lang: (LocaleContextHolder.getLocale().getLanguage()==null)? Locale.ENGLISH.getLanguage():LocaleContextHolder.getLocale().getLanguage());
        if (params !=null ) this.message = this.message.formatted(params.toArray());
    }
    public ResponseEntity toResponseEntity(){
        BodyEntity body = new BodyEntity();
        body.setError(this);
                return ResponseEntity.status(status).body(body);
//        return ResponseEntity.status(status).body(BodyEntity.builder().error(this).build());
    }
}
