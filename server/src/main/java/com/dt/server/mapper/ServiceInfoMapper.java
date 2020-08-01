package com.dt.server.mapper;

import com.dt.dto.ServiceInfoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/28
 * @Modified:
 * @Description:
 * @Date:
 */
@Mapper
public interface ServiceInfoMapper {
    @Insert({"insert into dt_service(id,name,host,port,service,create_time)",
            "values(#{id,jdbcType=VARCHAR},",
            "#{name,jdbcType=VARCHAR},",
            "#{host,jdbcType=VARCHAR},",
            "#{port,jdbcType=INTEGER},",
            "#{service,jdbcType=VARCHAR},",
            "#{createTime,jdbcType=TIMESTAMP})"})
    int insert(ServiceInfoDTO dto);

    @Update({"update dt_service",
            "set name=#{name,jdbcType=VARCHAR},",
            "host=#{host,jdbcType=VARCHAR},",
            "port=#{port,jdbcType=INTEGER},",
            "service=#{service,jdbcType=VARCHAR}",
            "where id=#{id,jdbcType=VARCHAR}"})
    int update(ServiceInfoDTO dto);

    @Select("select id,name,host,port,service,create_time as createTime from dt_service order by create_time desc")
    List<ServiceInfoDTO> list();

    @Delete("delete from dt_service where id=#{id,jdbcType=VARCHAR}")
    int delete(String id);

}
