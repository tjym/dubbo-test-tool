package com.dt.service;

import com.dt.dto.DubboDTO;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
public interface DubboService {
    DubboDTO save(DubboDTO dubbo);

    Boolean delete(String dubboId);

    List<DubboDTO> list();
}
