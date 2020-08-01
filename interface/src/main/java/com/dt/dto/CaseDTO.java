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
public class CaseDTO implements Serializable {
    private static final long serialVersionUID = 2047614741537961886L;
    private String id;
    private String name;
    private String methodId;
    private Date createTime;
}
