package com.dt.server.mapper;

import com.dt.dto.CaseParamDTO;
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
public interface CaseParamMapper {
    @Insert({"insert into dt_case_param(id,case_id,name,value,type,enabled,sort,create_time)",
            "values(#{id,jdbcType=VARCHAR},",
            "#{caseId,jdbcType=VARCHAR},",
            "#{name,jdbcType=VARCHAR},",
            "#{value,jdbcType=VARCHAR},",
            "#{type,jdbcType=VARCHAR},",
            "#{enabled,jdbcType=BOOLEAN},",
            "#{sort,jdbcType=INTEGER},",
            "#{createTime,jdbcType=TIMESTAMP})"})
    int insert(CaseParamDTO dto);

    @Update({"update dt_case_param",
            "set value=#{value,jdbcType=VARCHAR}",
            "where id=#{id,jdbcType=VARCHAR}"})
    int update(CaseParamDTO dto);

    @Select({"select id,case_id as caseId,name,value,type,enabled,sort,create_time as createTime",
            "from dt_case_param ",
            "where case_id=#{caseId,jdbcType=VARCHAR}",
            "order by sort asc"
    })
    List<CaseParamDTO> list(String caseId);

    @Delete("delete from dt_case_param where id=#{id,jdbcType=VARCHAR}")
    int delete(String id);

    @Delete("delete from dt_case_param where case_id=#{caseId,jdbcType=VARCHAR}")
    int deleteByCaseId(String caseId);
}
