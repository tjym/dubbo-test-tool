//package com.dt.server.service.redis;
//
//import com.alibaba.fastjson.JSON;
//import com.dt.dto.ParamDTO;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.constant.Constant;
//import com.dt.service.ParamService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: mingyang5
// * @Description:
// * @Date: 2020/7/4
// * @Modified:
// * @Description:
// * @Date:
// */
//@Service
//@Database("redis")
//public class ParamRedisServiceImpl implements ParamService {
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public ParamDTO save(ParamDTO param){
//        String key=String.format(Constant.CACHE_KEY_PARAM,param.getId());
//        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(param));
//        List<String> paramIds = getMethodParamIds(param.getMethodId());
//        if(!paramIds.contains(param.getId())){
//            paramIds.add(param.getId());
//            saveMethodParamIds(param.getMethodId(),paramIds);
//        }
//        return param;
//    }
//
//    @Override
//    public Boolean delete(ParamDTO param){
//        String key=String.format(Constant.CACHE_KEY_PARAM,param.getId());
//        stringRedisTemplate.delete(key);
//        List<String> methodIds = getMethodParamIds(param.getMethodId());
//        if(methodIds.contains(param.getId())){
//            methodIds.remove(param.getId());
//            saveMethodParamIds(param.getMethodId(),methodIds);
//        }
//        return true;
//    }
//
//    @Override
//    public ParamDTO get(String paramId){
//        String key=String.format(Constant.CACHE_KEY_PARAM,paramId);
//        String param = stringRedisTemplate.opsForValue().get(key);
//        return JSON.parseObject(param,ParamDTO.class);
//    }
//
//    @Override
//    public List<ParamDTO> getMethodParamList(String methodId){
//        return list(getMethodParamIds(methodId));
//    }
//
//    private Boolean saveMethodParamIds(String methodId, List<String> methodIds){
//        String key=String.format(Constant.CACHE_KEY_METHOD_PARAM_RELATION,methodId);
//        stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(methodIds));
//        return true;
//    }
//
//    private List<ParamDTO> list(List<String> methodIdList){
//        List<ParamDTO> res = new ArrayList();
//        for (String paramId : methodIdList) {
//            String key=String.format(Constant.CACHE_KEY_PARAM,paramId);
//            res.add(get(key));
//        }
//        return res;
//    }
//
//    private List<String> getMethodParamIds(String methodId){
//        String key=String.format(Constant.CACHE_KEY_METHOD_PARAM_RELATION,methodId);
//        String paramIdStr = stringRedisTemplate.opsForValue().get(key);
//        if(StringUtils.isBlank(paramIdStr)){
//            return new ArrayList<String>();
//        }
//        return JSON.parseArray(paramIdStr,String.class);
//    }
//}
