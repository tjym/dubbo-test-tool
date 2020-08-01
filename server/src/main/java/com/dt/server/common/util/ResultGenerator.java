package com.dt.server.common.util;

import com.dt.dto.ResultDTO;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private ResultGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static ResultDTO genSuccessResult() {
        return new ResultDTO()
                .setCode(ResultDTO.ResultCode.SUCCESS.code())
                .setSuccess(true)
                .setMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> ResultDTO<T> genSuccessResult(T data) {
        return new ResultDTO<T>()
                .setCode(ResultDTO.ResultCode.SUCCESS.code())
                .setSuccess(true)
                .setMsg(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResultDTO genFailResult(String message) {
        return new ResultDTO()
                .setCode(ResultDTO.ResultCode.FAIL.code())
                .setMsg(message)
                .setSuccess(false);
    }

    public static ResultDTO genBusinessFailResult(String message) {
        return new ResultDTO()
                .setCode(ResultDTO.ResultCode.BUSINESS_FAIL.code())
                .setMsg(message)
                .setSuccess(false);
    }

    public static ResultDTO genInnerErrorResult(String message) {
        return new ResultDTO()
                .setCode(ResultDTO.ResultCode.INTERNAL_SERVER_ERROR.code())
                .setMsg(message)
                .setSuccess(false);
    }

    public static ResultDTO genParamErrorResult(String message) {
        return new ResultDTO()
                .setCode(ResultDTO.ResultCode.PARAM_FAIL.code())
                .setMsg(message)
                .setSuccess(false);
    }

    public static ResultDTO genUnKnowErrorResult(String message) {
        return new ResultDTO()
                .setCode(ResultDTO.ResultCode.UNKNOW_ERROR.code())
                .setMsg(message)
                .setSuccess(false);
    }

}
