package com.dt.service;

import com.dt.dto.ParamDTO;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/4
 * @Modified:
 * @Description:
 * @Date:
 */
public interface ParamService {
    ParamDTO save(ParamDTO param);

    Boolean delete(ParamDTO param);

    ParamDTO get(String paramId);

    List<ParamDTO> getMethodParamList(String methodId);
}
