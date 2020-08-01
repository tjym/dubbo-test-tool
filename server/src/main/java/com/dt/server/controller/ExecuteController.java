package com.dt.server.controller;

import com.alibaba.fastjson.JSON;
import com.dt.dto.CaseParamDTO;
import com.dt.dto.InvokeDTO;
import com.dt.dto.ResultDTO;
import com.dt.dto.ValueDTO;
import com.dt.server.service.impl.ExecuteServiceImpl;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/25
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
@RestController
@RequestMapping("dt/execute")
public class ExecuteController {
    @Autowired
    ExecuteServiceImpl executeService;

    @PostMapping("cmd")
    public ResultDTO<String> execute(
            @ApiParam(value = "ip") @RequestParam  String ip,
            @ApiParam(value = "port") @RequestParam int port,
            @ApiParam(value = "clazzName") @RequestParam String clazzName,
            @ApiParam(value = "methodName") @RequestParam String methodName,
            @ApiParam(value = "param") @RequestParam String param
    ){
        InvokeDTO dto =new InvokeDTO();
        dto.setIp(ip);
        dto.setPort(port);
        dto.setClazzName(clazzName);
        dto.setMethodName(methodName);
        dto.setValueList(JSON.parseArray(param, ValueDTO.class));
        return executeService.doExecute(dto);
    }

}
