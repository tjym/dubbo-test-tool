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
public class CaseParamDTO implements Serializable {
    private static final long serialVersionUID = 6422080573053293860L;
    private String id;
    private String caseId;
    private String name;
    private String value;
    private Boolean enabled;
    private String type;
    private Integer sort;
    private Boolean add=false;
    private Date createTime;
}
