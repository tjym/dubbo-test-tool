package com.dt.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/28
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
public class ServiceInfoDTO implements Serializable {
    private static final long serialVersionUID = 2616933960651779700L;
    private String id;
    private String name;
    private String host;
    private int port;
    private String service;
    private Date createTime;

}
