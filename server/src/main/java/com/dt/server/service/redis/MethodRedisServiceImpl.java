//package com.dt.server.service.redis;
//
//import com.alibaba.fastjson.JSON;
//import com.dt.dto.MethodDTO;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.constant.Constant;
//import com.dt.service.MethodService;
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
// * @Date: 2020/7/3
// * @Modified:
// * @Description:
// * @Date:
// */
//@Service
//@Database("redis")
//public class MethodRedisServiceImpl implements MethodService {
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public MethodDTO save(MethodDTO method){
//        String key=String.format(Constant.CACHE_KEY_METHOD,method.getId());
//        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(method));
//        List<String> methodIds = getClazzMethodIds(method.getClazzId());
//        if(!methodIds.contains(method.getId())){
//            methodIds.add(method.getId());
//            saveClazzMethodIds(method.getClazzId(),methodIds);
//        }
//        return method;
//    }
//
//    @Override
//    public Boolean delete(MethodDTO method){
//        String key=String.format(Constant.CACHE_KEY_METHOD,method.getId());
//        stringRedisTemplate.delete(key);
//        List<String> methodIds = getClazzMethodIds(method.getClazzId());
//        if(methodIds.contains(method.getId())){
//            methodIds.remove(method.getId());
//            saveClazzMethodIds(method.getClazzId(),methodIds);
//        }
//        return true;
//    }
//
//    @Override
//    public MethodDTO get(String methodId){
//        String key=String.format(Constant.CACHE_KEY_METHOD,methodId);
//        String method = stringRedisTemplate.opsForValue().get(key);
//        return JSON.parseObject(method,MethodDTO.class);
//    }
//
//    @Override
//    public List<MethodDTO> getClazzMethodList(String clazzId){
//        return list(getClazzMethodIds(clazzId));
//    }
//
//    private Boolean saveClazzMethodIds(String clazzId,List<String> methodIds){
//        String key=String.format(Constant.CACHE_KEY_CLAZZ_METHOD_RELATION,clazzId);
//        stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(methodIds));
//        return true;
//    }
//
//    private List<MethodDTO> list(List<String> methodIdList){
//        List<MethodDTO> res = new ArrayList();
//        for (String methodId : methodIdList) {
//            String key=String.format(Constant.CACHE_KEY_METHOD,methodId);
//            res.add(get(key));
//        }
//        return res;
//    }
//
//    private List<String> getClazzMethodIds(String clazzId){
//        String key=String.format(Constant.CACHE_KEY_CLAZZ_METHOD_RELATION,clazzId);
//        String methodIdStr = stringRedisTemplate.opsForValue().get(key);
//        if(StringUtils.isBlank(methodIdStr)){
//            return new ArrayList<String>();
//        }
//        List<String> res = JSON.parseArray(methodIdStr,String.class);
//        return res;
//    }
//
//}
