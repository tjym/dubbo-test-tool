package com.dt.server.mapper;

import com.dt.dto.ParamDTO;
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
public interface ParamInfoMapper {
    @Insert({"insert into dt_param(id,name,description,type,sort,method_id,create_time)",
            "values(#{id,jdbcType=VARCHAR},",
            "#{name,jdbcType=VARCHAR},",
            "#{description,jdbcType=VARCHAR},",
            "#{type,jdbcType=VARCHAR},",
            "#{sort,jdbcType=INTEGER},",
            "#{methodId,jdbcType=VARCHAR},",
            "#{createTime,jdbcType=TIMESTAMP})"})
    int insert(ParamDTO dto);

    @Update({"update dt_param",
            "set name=#{name,jdbcType=VARCHAR},",
            "description=#{description,jdbcType=VARCHAR},",
            "type=#{type,jdbcType=VARCHAR},",
            "sort=#{sort,jdbcType=INTEGER},",
            "method_id=#{methodId,jdbcType=VARCHAR}",
            "where id=#{id,jdbcType=VARCHAR}"})
    int update(ParamDTO dto);

    @Select({"select p.id,p.name,p.description,p.type,p.sort,m.id as methodId,m.name as methodName,p.create_time as createTime ",
            "from dt_param p",
            "inner join dt_method m on m.id=p.method_id",
            "where m.id=#{methodId,jdbcType=VARCHAR}",
            "order by p.sort asc"
    })
    List<ParamDTO> list(String methodId);

    @Delete("delete from dt_param where id=#{id,jdbcType=VARCHAR}")
    int delete(String id);

    @Delete("delete from dt_param where method_id=#{methodId,jdbcType=VARCHAR}")
    int deleteByMethodId(String methodId);


    @Select({"select max(sort)",
            "from dt_param p",
            "where method_id=#{methodId,jdbcType=VARCHAR}"
    })
    Integer getMaxSort(String methodId);
}
