package com.dt.server.service.db;

import com.dt.dto.ParamDTO;
import com.dt.server.mapper.ParamInfoMapper;
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
public class ParamDBServiceImpl {
    @Autowired
    ParamInfoMapper paramInfoMapper;

    public boolean save(ParamDTO dto){
        if(dto.getId()==null){
            return insert(dto);
        }
        return update(dto);
    }

    public List<ParamDTO> list(String methodId){
        return paramInfoMapper.list(methodId);
    }

    public boolean delete(String id){
        return paramInfoMapper.delete(id)>0;
    }

    public boolean deleteByMethodId(String methodId){
        return paramInfoMapper.deleteByMethodId(methodId)>0;
    }


    public int getNextSort(String methodId){
        Integer res = paramInfoMapper.getMaxSort(methodId);
        if(res==null){
            return 1;
        }
        return res+1;
    }


    private boolean insert(ParamDTO dto){
        dto.setId(UUID.randomUUID().toString());
        dto.setCreateTime(new Date());
        return paramInfoMapper.insert(dto)>0;
    }

    private boolean update(ParamDTO dto){
        return paramInfoMapper.update(dto)>0;
    }
    
    
}
