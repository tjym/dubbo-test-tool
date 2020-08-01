package com.dt.server.service.db;

import com.dt.dto.MethodDTO;
import com.dt.server.mapper.MethodInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/28
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
@Service
public class MethodDBServiceImpl {
    @Autowired
    MethodInfoMapper methodInfoMapper;
    @Autowired
    ParamDBServiceImpl paramDBService;
    @Autowired
    CaseDBServiceImpl caseDBService;

    public boolean save(MethodDTO dto){
        if(dto.getId()==null){
            return insert(dto);
        }
        return update(dto);
    }

    public List<MethodDTO> list(String svrId){
        List<MethodDTO> methodList = methodInfoMapper.list(svrId);
        for (MethodDTO method : methodList) {
            method.setParams(paramDBService.list(method.getId()));
        }
        return methodList;
    }

    public boolean delete(String id){
        paramDBService.deleteByMethodId(id);
        caseDBService.deleteByMethodId(id);
        return methodInfoMapper.delete(id)>0;
    }

    public boolean deleteBySvrId(String svrId){
        List<MethodDTO> list = list(svrId);
        if(list.size()==0){
            return true;
        }
        for (MethodDTO method : list) {
            delete(method.getId());
        }
        return true;
    }

    private boolean insert(MethodDTO dto){
        dto.setId(UUID.randomUUID().toString());
        dto.setCreateTime(new Date());
        return methodInfoMapper.insert(dto)>0;
    }

    private boolean update(MethodDTO dto){
        return methodInfoMapper.update(dto)>0;
    }
}
