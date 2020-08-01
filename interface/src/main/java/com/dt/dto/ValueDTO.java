package com.dt.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/27
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
public class ValueDTO implements Serializable {
    private String value;
    private String type;
    private Integer sort;
}
