package com.anhnt.common.domain.configuration.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Message{
    private String code;
    private String message;
    private String messageFr;

    public Map<String,String> toMessageMap(){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("en",message);
        map.put("fr", messageFr);
        return map;
    }
}
