package com.dt.bdf.valid;

import com.alibaba.fastjson.JSONObject;
import com.dt.bdf.exception.ParamErrorException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/4/10
 * @Modified:
 * @Description:
 * @Date:
 */
public class Assert {
    private Assert() {
        throw new IllegalStateException("Utility class");
    }

    public static void isBlank(Object data, String message) {
        if(data==null){
            throw new ParamErrorException(message);
        }
        if(data instanceof String){
            if(StringUtils.isBlank(data.toString())){
                throw new ParamErrorException(message);
            }
        }
        if(data instanceof List){
            if(((List)data).size()==0){
                throw new ParamErrorException(message);
            }
        }
    }

    public static void validJson(String data, String message) {
        isBlank(data,message);
        try {
            JSONObject.parseObject(data);
        } catch (Exception e) {
            throw new ParamErrorException(message);
        }
    }
}
