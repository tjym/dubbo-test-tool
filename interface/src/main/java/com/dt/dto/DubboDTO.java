package com.dt.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
public class DubboDTO implements Serializable {
    private static final long serialVersionUID = 6226408529916871970L;
    private String id;
    private String name;
    private String host;
    private String port;

}
