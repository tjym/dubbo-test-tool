package com.dt.dto;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class MenuNodeDTO extends MenuTreeDTO {
    private static final long serialVersionUID = -6985285048230917427L;

    private List<MenuNodeDTO> children = new ArrayList();
}
