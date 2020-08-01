package com.dt.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.dt.aop.RetryOnFailure;
import com.dt.dto.InvokeDTO;
import com.dt.dto.ResultDTO;
import com.dt.dto.ValueDTO;
import com.dt.server.common.config.MyPropsConfig;
import com.dt.server.common.constant.Constant;
import com.dt.server.common.util.ResultGenerator;
import com.dt.server.helper.TelnetHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ExecuteServiceImpl {
    @Autowired
    MyPropsConfig config;

    @RetryOnFailure
    public ResultDTO<String> doExecute(InvokeDTO invoke){
        TelnetClient client = null;
        try {
            String command = getCommand(invoke.getClazzName(),invoke.getMethodName(),invoke.getValueList());
            client = TelnetHelper.initClient(invoke.getIp(),invoke.getPort(),config.getTimeout());
            String ret = TelnetHelper.execute(client,command, Constant.END_KEY_DUBBO);
            //截取有效数据
            String lineSeparator = System.getProperty(Constant.PROPERTY_LINE_SEPARATOR, "\n");
            if (StringUtils.isNotEmpty(ret)) {
                ret = ret.split(lineSeparator)[0];
            }
            return ResultGenerator.genSuccessResult(ret);
        } catch (Exception e) {
            log.error("telnet执行失败", e);
            return ResultGenerator.genInnerErrorResult(e.getMessage());

        } finally {
            try {
                if (null != client) {
                    client.disconnect();
                }
            } catch (Exception e) {
                log.error("关闭telnet连接失败.[ip="+invoke.getIp()+",port="+invoke.getPort()+"]",e);
            }
        }
    }

    private String getCommand(String serviceName, String methodName, List<ValueDTO> valueList) {
        StringBuilder paramStr = new StringBuilder();
        for (ValueDTO value : valueList) {
            paramStr.append(JSON.toJSONString(value.getValue()));
            paramStr.append(",");
        }
        return String.format("invoke %s.%s(%s)", serviceName, methodName, paramStr);
    }
}
