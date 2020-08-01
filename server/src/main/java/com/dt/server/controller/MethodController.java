package com.dt.server.controller;

import com.dt.bdf.valid.Assert;
import com.dt.dto.MethodDTO;
import com.dt.dto.ResultDTO;
import com.dt.dto.ServiceInfoDTO;
import com.dt.server.common.constant.Constant;
import com.dt.server.common.util.ResultGenerator;
import com.dt.server.service.db.MethodDBServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/28
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
@RestController
@RequestMapping(("dt"))
public class MethodController {
    @Autowired
    MethodDBServiceImpl methodDBService;
    
    @PostMapping("method/save")
    @ApiOperation(value="保存方法信息")
    public ResultDTO<Boolean> save(
            @ApiParam(value = "id") @RequestParam(required = false) String id,
            @ApiParam(value = "name") @RequestParam String name,
            @ApiParam(value = "aliaName") @RequestParam String aliaName,
            @ApiParam(value = "svrId") @RequestParam String svrId){
        Assert.isBlank(name, Constant.MSG_ERROR_METHOD_NAME);
        Assert.isBlank(aliaName, Constant.MSG_ERROR_METHOD_ALIA_NAME);
        Assert.isBlank(svrId, Constant.MSG_ERROR_SERVICE_ID);
        MethodDTO dto=new MethodDTO();
        if(StringUtils.isNotBlank(id)){
            dto.setId(id);
        }
        dto.setName(name);
        dto.setAliaName(aliaName);
        dto.setSvrId(svrId);
        return ResultGenerator.genSuccessResult(methodDBService.save(dto));
    }


    @GetMapping("method/list")
    @ApiOperation(value="获取方法信息")
    public ResultDTO<List<MethodDTO>> list(
            @ApiParam(value = "svrId") @RequestParam String svrId){
        return ResultGenerator.genSuccessResult(methodDBService.list(svrId));
    }

    @PostMapping("method/delete")
    @ApiOperation(value="获取方法信息")
    public ResultDTO<Boolean> delete(
            @ApiParam(value = "id") @RequestParam String id){
        Assert.isBlank(id, Constant.MSG_ERROR_METHOD_ID);
        return ResultGenerator.genSuccessResult(methodDBService.delete(id));
    }
}
