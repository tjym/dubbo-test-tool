package com.dt.service;

import com.dt.dto.MethodDTO;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
public interface MethodService {
    MethodDTO save(MethodDTO method);

    Boolean delete(MethodDTO method);

    MethodDTO get(String methodId);

    List<MethodDTO> getClazzMethodList(String clazzId);
}
