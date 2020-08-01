package com.dt.server.service.db;

import com.dt.dto.CaseDTO;
import com.dt.dto.CaseParamDTO;
import com.dt.server.mapper.CaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/29
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
@Service
public class CaseDBServiceImpl {
    @Autowired
    CaseMapper caseMapper;
    @Autowired
    CaseParamDBServiceImpl caseParamDBService;

    public Boolean save(CaseDTO dto, List<CaseParamDTO> params){
        String id="";
        if(dto.getId()==null){
            id = insert(dto);
        }else{
            id = update(dto);
        }
        if(params!=null && params.size()>0){
            caseParamDBService.saveBatch(id,params);
        }
        return true;
    }

    public List<CaseDTO> list(String methodId){
        return caseMapper.list(methodId);
    }

    public boolean delete(String id){
        caseParamDBService.deleteByCaseId(id);
        return caseMapper.delete(id)>0;
    }

    public boolean deleteByMethodId(String methodId){
        List<CaseDTO> list = list(methodId);
        if(list.size()==0){
            return true;
        }
        for (CaseDTO dto : list) {
            delete(dto.getId());
        }
        return true;
    }


    private String insert(CaseDTO dto){
        dto.setId(UUID.randomUUID().toString());
        dto.setCreateTime(new Date());
        caseMapper.insert(dto);
        return dto.getId();
    }

    private String update(CaseDTO dto){
        caseMapper.update(dto);
        return dto.getId();
    }

}
