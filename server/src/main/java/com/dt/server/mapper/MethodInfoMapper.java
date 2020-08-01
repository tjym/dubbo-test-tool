package com.dt.server.mapper;

import com.dt.dto.MethodDTO;
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
public interface MethodInfoMapper {
    @Insert({"insert into dt_method(id,name,alia_name,svr_id,create_time)",
            "values(#{id,jdbcType=VARCHAR},",
            "#{name,jdbcType=VARCHAR},",
            "#{aliaName,jdbcType=VARCHAR},",
            "#{svrId,jdbcType=VARCHAR},",
            "#{createTime,jdbcType=TIMESTAMP})"})
    int insert(MethodDTO dto);

    @Update({"update dt_method",
            "set name=#{name,jdbcType=VARCHAR},",
            "alia_name=#{aliaName,jdbcType=VARCHAR},",
            "svr_id=#{svrId,jdbcType=VARCHAR}",
            "where id=#{id,jdbcType=VARCHAR}"})
    int update(MethodDTO dto);

    @Select({"select m.id,m.name,m.alia_name as aliaName,s.id as svrId,s.name as svrName,m.create_time as createTime ",
            "from dt_method m",
            "inner join dt_service s on s.id=m.svr_id",
            "where s.id=#{svrId,jdbcType=VARCHAR}",
            "order by m.create_time desc"
    })
    List<MethodDTO> list(String svrId);

    @Delete("delete from dt_method where id=#{id,jdbcType=VARCHAR}")
    int delete(String id);

    @Delete("delete from dt_method where svr_id=#{svrId,jdbcType=VARCHAR}")
    int deleteBySvrId(String svrId);

}
