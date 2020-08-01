package com.dt.server.service.db;

import com.dt.dto.ServiceInfoDTO;
import com.dt.server.mapper.ServiceInfoMapper;
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
public class SvrInfoDBServiceImpl {
    @Autowired
    ServiceInfoMapper serviceInfoMapper;
    @Autowired
    MethodDBServiceImpl methodDBService;

    public boolean save(ServiceInfoDTO dto){
        if(dto.getId()==null){
            return insert(dto);
        }
        return update(dto);
    }

    public List<ServiceInfoDTO> list(){
        return serviceInfoMapper.list();
    }

    public boolean delete(String id){
        methodDBService.deleteBySvrId(id);
        return serviceInfoMapper.delete(id)>0;
    }


    private boolean insert(ServiceInfoDTO dto){
        dto.setId(UUID.randomUUID().toString());
        dto.setCreateTime(new Date());
        return serviceInfoMapper.insert(dto)>0;
    }

    private boolean update(ServiceInfoDTO dto){
        return serviceInfoMapper.update(dto)>0;
    }


}
