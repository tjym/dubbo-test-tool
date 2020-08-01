package com.dt.server.controller;

import com.alibaba.fastjson.JSON;
import com.dt.bdf.valid.Assert;
import com.dt.dto.CaseDTO;
import com.dt.dto.CaseParamDTO;
import com.dt.dto.ResultDTO;
import com.dt.server.common.constant.Constant;
import com.dt.server.common.util.ResultGenerator;
import com.dt.server.service.db.CaseDBServiceImpl;
import com.dt.server.service.db.CaseParamDBServiceImpl;
import io.swagger.annotations.Api;
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
 * @Date: 2020/7/29
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
@RestController
@RequestMapping(("dt"))
public class CaseController {
    @Autowired
    CaseDBServiceImpl caseDBService;
    @Autowired
    CaseParamDBServiceImpl caseParamDBService;

    @PostMapping("case/save")
    @ApiOperation(value="保存用例信息")
    public ResultDTO<Boolean> save(
            @ApiParam(value = "id") @RequestParam(required = false) String id,
            @ApiParam(value = "methodId") @RequestParam String methodId,
            @ApiParam(value = "name") @RequestParam String name,
            @ApiParam(value = "params")  @RequestParam String params){
        Assert.isBlank(methodId, Constant.MSG_ERROR_METHOD_ID);
        Assert.isBlank(name, Constant.MSG_ERROR_CASE_NAME);
        CaseDTO dto=new CaseDTO();
        if(StringUtils.isNotBlank(id)){
            dto.setId(id);
        }
        dto.setMethodId(methodId);
        dto.setName(name);
        List<CaseParamDTO> paramList = JSON.parseArray(params,CaseParamDTO.class);
        return ResultGenerator.genSuccessResult(caseDBService.save(dto,paramList));
    }


    @GetMapping("case/list")
    @ApiOperation(value="获取用例信息")
    public ResultDTO<List<CaseDTO>> list(
            @ApiParam(value = "methodId") @RequestParam String methodId){
        return ResultGenerator.genSuccessResult(caseDBService.list(methodId));
    }

    @PostMapping("case/delete")
    @ApiOperation(value="获取用例信息")
    public ResultDTO<Boolean> delete(
            @ApiParam(value = "id") @RequestParam String id){
        Assert.isBlank(id, Constant.MSG_ERROR_PARAM_ID);
        return ResultGenerator.genSuccessResult(caseDBService.delete(id));
    }


    @GetMapping("case/param/list")
    @ApiOperation(value="获取用例参数信息")
    public ResultDTO<List<CaseParamDTO>> listParam(
            @ApiParam(value = "caseId") @RequestParam String caseId){
        return ResultGenerator.genSuccessResult(caseParamDBService.list(caseId));
    }

    @PostMapping("case/param/delete")
    @ApiOperation(value="获取用例参数信息")
    public ResultDTO<Boolean> deleteParam(
            @ApiParam(value = "id") @RequestParam String id){
        Assert.isBlank(id, Constant.MSG_ERROR_PARAM_ID);
        return ResultGenerator.genSuccessResult(caseParamDBService.delete(id));
    }
}
