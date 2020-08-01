package com.dt.bdf.exception;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/4/10
 * @Modified:
 * @Description:
 * @Date:
 */
public class ParamErrorException extends RuntimeException {

    public ParamErrorException(String msg) {
        super(msg);
    }

    public ParamErrorException(String msg, Throwable e) {
        super(msg, e);
    }

}

