package com.dt.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
public class ParamDTO implements Serializable {
    private static final long serialVersionUID = -1090618276607450549L;

    private String id;
    private String methodId;
    private String methodName;
    private String name;
    private String description;
    private String type;
    private Integer sort;
    private Date createTime;
}
