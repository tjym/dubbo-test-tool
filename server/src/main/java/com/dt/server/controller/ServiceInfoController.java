package com.dt.server.controller;

import com.dt.bdf.valid.Assert;
import com.dt.dto.DubboDTO;
import com.dt.dto.ResultDTO;
import com.dt.dto.ServiceInfoDTO;
import com.dt.server.common.constant.Constant;
import com.dt.server.common.util.ResultGenerator;
import com.dt.server.service.db.SvrInfoDBServiceImpl;
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
public class ServiceInfoController {

    @Autowired
    SvrInfoDBServiceImpl svrInfoDBService;

    @PostMapping("svr/save")
    @ApiOperation(value="保存服务信息")
    public ResultDTO<Boolean> save(
            @ApiParam(value = "id") @RequestParam(required = false) String id,
            @ApiParam(value = "name") @RequestParam String name,
            @ApiParam(value = "host") @RequestParam String host,
            @ApiParam(value = "port") @RequestParam Integer port,
            @ApiParam(value = "service") @RequestParam String service){
        Assert.isBlank(name, Constant.MSG_ERROR_SERVICE_NAME);
        Assert.isBlank(host, Constant.MSG_ERROR_SERVICE_HOST);
        Assert.isBlank(port, Constant.MSG_ERROR_SERVICE_PORT);
        Assert.isBlank(service, Constant.MSG_ERROR_SERVICE);
        ServiceInfoDTO dto=new ServiceInfoDTO();
        if(StringUtils.isNotBlank(id)){
            dto.setId(id);
        }
        dto.setName(name);
        dto.setHost(host);
        dto.setPort(port);
        dto.setService(service);
        return ResultGenerator.genSuccessResult(svrInfoDBService.save(dto));
    }


    @GetMapping("svr/list")
    @ApiOperation(value="获取服务信息")
    public ResultDTO<List<ServiceInfoDTO>> list(){
        return ResultGenerator.genSuccessResult(svrInfoDBService.list());
    }

    @PostMapping("svr/delete")
    @ApiOperation(value="获取服务信息")
    public ResultDTO<Boolean> delete(
            @ApiParam(value = "id") @RequestParam String id){
        Assert.isBlank(id, Constant.MSG_ERROR_SERVICE_ID);
        return ResultGenerator.genSuccessResult(svrInfoDBService.delete(id));
    }
}
