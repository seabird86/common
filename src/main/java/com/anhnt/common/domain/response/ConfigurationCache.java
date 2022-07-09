package com.anhnt.common.domain.response;

import com.anhnt.common.domain.configuration.response.Message;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConfigurationCache {

    public static ConcurrentHashMap<String, Map<String,String>> messageMap = new ConcurrentHashMap<>();

    public static void cache(List<Message> messages){
        ConfigurationCache.messageMap.putAll(messages.stream().collect(Collectors.toMap(Message::getCode, Message::toMessageMap)));
    }

}
