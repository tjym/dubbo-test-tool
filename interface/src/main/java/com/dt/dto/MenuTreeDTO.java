package com.dt.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class MenuTreeDTO implements Serializable{
    private static final long serialVersionUID = 1487812008606077536L;
    private Integer uId;
    private Integer roleId;
    private Integer menuId;
    private Integer parentMenuId;
    private String menuName;
    private String menuUrl;
    private String menuStyle;
    private Integer menuLevel;
    private Integer menuLeft;
    private Integer menuRight;
    
    
}
