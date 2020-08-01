package com.dt.server.service.db;

import com.dt.dto.CaseParamDTO;
import com.dt.server.mapper.CaseParamMapper;
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
public class CaseParamDBServiceImpl {

    @Autowired
    CaseParamMapper caseParamMapper;


    public boolean saveBatch(String caseId,List<CaseParamDTO> params){
        if(params==null || params.size()==0)return true;
        for (CaseParamDTO param : params) {
            param.setCaseId(caseId);
            if(param.getAdd()){
                insert(param);
            }else{
                update(param);
            }
        }
        return true;
    }

    public List<CaseParamDTO> list(String caseId){
        return caseParamMapper.list(caseId);
    }

    public boolean delete(String id){
        return caseParamMapper.delete(id)>0;
    }

    public boolean deleteByCaseId(String caseId){
        return caseParamMapper.deleteByCaseId(caseId)>0;
    }


    private boolean insert(CaseParamDTO dto){
        dto.setId(UUID.randomUUID().toString());
        dto.setCreateTime(new Date());
        return caseParamMapper.insert(dto)>0;
    }

    private boolean update(CaseParamDTO dto){
        return caseParamMapper.update(dto)>0;
    }


}
