package com.test.config;

import java.util.HashMap;
import java.util.Map;

public class WebMessages extends Messages {

    private Map<String,String> errorMap = new HashMap<String,String>(){{
        put("Invalid_Error_Message", "Enter your error message here");
    }};

    public String getMessage(String key){
        return errorMap.get(key);
    }
}
