package com.dt.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
@Accessors(chain = true)
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = 8084437819492983645L;

    private int code;
    private boolean success;
    private String msg;
    private T data;

    public static enum ResultCode {
        SUCCESS(0),
        //失败
        FAIL(9001),
        //业务失败
        BUSINESS_FAIL(9002),
        //参数失败
        PARAM_FAIL(9003),
        //内部错误
        INTERNAL_SERVER_ERROR(9005),
        //位置错误
        UNKNOW_ERROR(9999);

        private final int code;

        private ResultCode(int code) {
            this.code = code;
        }

        public int code() {
            return this.code;
        }
    }


}
