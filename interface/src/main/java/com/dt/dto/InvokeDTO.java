package com.dt.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/25
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
public class InvokeDTO implements Serializable {
    private static final long serialVersionUID = 4072448871907322307L;
    private String ip;
    private int port;

    private String clazzName;
    private String methodName;

    private List<ValueDTO> valueList;



}
