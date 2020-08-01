package com.dt.server.controller;

import com.dt.bdf.valid.Assert;
import com.dt.dto.ParamDTO;
import com.dt.dto.ResultDTO;
import com.dt.server.common.constant.Constant;
import com.dt.server.common.util.ResultGenerator;
import com.dt.server.service.db.ParamDBServiceImpl;
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
public class ParamController {
    @Autowired
    ParamDBServiceImpl paramDBService;

    @PostMapping("param/save")
    @ApiOperation(value="保存方法信息")
    public ResultDTO<Boolean> save(
            @ApiParam(value = "id") @RequestParam(required = false) String id,
            @ApiParam(value = "name") @RequestParam String name,
            @ApiParam(value = "description") @RequestParam String description,
            @ApiParam(value = "type") @RequestParam String type,
            @ApiParam(value = "sort") @RequestParam Integer sort,
            @ApiParam(value = "methodId") @RequestParam String methodId){
        Assert.isBlank(name, Constant.MSG_ERROR_PARAM_NAME);
        Assert.isBlank(description, Constant.MSG_ERROR_PARAM_DESC);
        Assert.isBlank(type, Constant.MSG_ERROR_PARAM_TYPE);
        Assert.isBlank(methodId, Constant.MSG_ERROR_METHOD_ID);
        Assert.isBlank(sort, Constant.MSG_ERROR_PARAM_SORT);
        ParamDTO dto=new ParamDTO();
        if(StringUtils.isNotBlank(id)){
            dto.setId(id);
        }
        dto.setName(name);
        dto.setDescription(description);
        dto.setType(type);
        dto.setSort(sort);
        dto.setMethodId(methodId);
        return ResultGenerator.genSuccessResult(paramDBService.save(dto));
    }


    @GetMapping("param/list")
    @ApiOperation(value="获取方法信息")
    public ResultDTO<List<ParamDTO>> list(
            @ApiParam(value = "methodId") @RequestParam String methodId){
        return ResultGenerator.genSuccessResult(paramDBService.list(methodId));
    }

    @PostMapping("param/delete")
    @ApiOperation(value="获取方法信息")
    public ResultDTO<Boolean> delete(
            @ApiParam(value = "id") @RequestParam String id){
        Assert.isBlank(id, Constant.MSG_ERROR_PARAM_ID);
        return ResultGenerator.genSuccessResult(paramDBService.delete(id));
    }

    @GetMapping("param/sort/next")
    @ApiOperation(value="获取下一个序号")
    public ResultDTO<Integer> getNextSort(
            @ApiParam(value = "methodId") @RequestParam String methodId){
        Assert.isBlank(methodId, Constant.MSG_ERROR_METHOD_ID);
        return ResultGenerator.genSuccessResult(paramDBService.getNextSort(methodId));
    }

}
