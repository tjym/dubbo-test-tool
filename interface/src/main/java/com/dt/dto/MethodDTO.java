package com.dt.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
public class MethodDTO implements Serializable {
    private static final long serialVersionUID = -8042406290755712025L;
    private String id;
    private String name;
    private String aliaName;
    private String svrId;
    private String svrName;
    private Date createTime;
    private List<ParamDTO> params;

}
