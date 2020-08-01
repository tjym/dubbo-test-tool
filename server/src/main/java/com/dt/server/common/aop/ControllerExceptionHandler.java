package com.dt.server.common.aop;

import com.dt.bdf.exception.BusinessException;
import com.dt.bdf.exception.ParamErrorException;
import com.dt.dto.ResultDTO;
import com.dt.server.common.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2019/10/8
 *
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
@ControllerAdvice(basePackages = "com.dt.server.controller")
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDTO errorHandler(HttpServletRequest req, Exception throwable) {
        log.error("[{}]接口执行报错",req.getRequestURI(),throwable);
        if(throwable instanceof ParamErrorException){
            return ResultGenerator.genParamErrorResult(throwable.getMessage());
        }if(throwable instanceof BusinessException){
            return ResultGenerator.genBusinessFailResult(throwable.getMessage());
        }else{
            return ResultGenerator.genFailResult(throwable.getMessage());
        }
    }
}