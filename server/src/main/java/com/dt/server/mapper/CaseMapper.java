package com.dt.server.mapper;

import com.dt.dto.CaseDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/29
 * @Modified:
 * @Description:
 * @Date:
 */
@Mapper
public interface CaseMapper {
    @Insert({"insert into dt_case(id,method_id,name,create_time)",
            "values(#{id,jdbcType=VARCHAR},",
            "#{methodId,jdbcType=VARCHAR},",
            "#{name,jdbcType=VARCHAR},",
            "#{createTime,jdbcType=TIMESTAMP})"})
    int insert(CaseDTO dto);

    @Update({"update dt_case",
            "set name=#{name,jdbcType=VARCHAR} where id=#{id,jdbcType=VARCHAR}"})
    int update(CaseDTO dto);

    @Select({"select id,method_id as methodId,name,create_time as createTime",
            "from dt_case ",
            "where method_id=#{methodId,jdbcType=VARCHAR}",
            "order by create_time desc"
    })
    List<CaseDTO> list(String methodId);

    @Delete("delete from dt_case where id=#{id,jdbcType=VARCHAR}")
    int delete(String id);

    @Delete("delete from dt_case where method_id=#{methodId,jdbcType=VARCHAR}")
    int deleteByMethodId(String methodId);
}
