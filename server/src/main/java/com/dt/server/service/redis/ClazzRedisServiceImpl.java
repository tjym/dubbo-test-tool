//package com.dt.server.service.redis;
//
//import com.alibaba.fastjson.JSON;
//import com.dt.dto.ClazzDTO;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.constant.Constant;
//import com.dt.service.ClazzService;
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
//public class ClazzRedisServiceImpl implements ClazzService {
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public ClazzDTO save(ClazzDTO clazz){
//        String key=String.format(Constant.CACHE_KEY_CLAZZ,clazz.getId());
//        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(clazz));
//        List<String> clazzIds = getDubboClazzIds(clazz.getDubboId());
//        if(!clazzIds.contains(clazz.getId())){
//            clazzIds.add(clazz.getId());
//            saveDubboClazzIds(clazz.getDubboId(),clazzIds);
//        }
//        return clazz;
//    }
//
//
//    @Override
//    public Boolean delete(ClazzDTO clazz){
//        String key=String.format(Constant.CACHE_KEY_CLAZZ,clazz.getId());
//        stringRedisTemplate.delete(key);
//        List<String> clazzIds = getDubboClazzIds(clazz.getDubboId());
//        if(clazzIds.contains(clazz.getId())){
//            clazzIds.remove(clazz.getId());
//            saveDubboClazzIds(clazz.getDubboId(),clazzIds);
//        }
//        return true;
//    }
//
//
//    @Override
//    public ClazzDTO get(String clazzId){
//        String key=String.format(Constant.CACHE_KEY_CLAZZ,clazzId);
//        String clazzInfo = stringRedisTemplate.opsForValue().get(key);
//        return JSON.parseObject(clazzInfo,ClazzDTO.class);
//    }
//
//    @Override
//    public List<ClazzDTO> getBubboClazzList(String dubboId){
//        return list(getDubboClazzIds(dubboId));
//    }
//
//
//
//    private Boolean saveDubboClazzIds(String dubboId,List<String> clazzIds){
//        String key=String.format(Constant.CACHE_KEY_DUBBO_CLAZZ_RELATION,dubboId);
//        stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(clazzIds));
//        return true;
//    }
//
//    private List<ClazzDTO> list(List<String> clazzIdList){
//        List<ClazzDTO> res = new ArrayList();
//        for (String clazzId : clazzIdList) {
//            String key=String.format(Constant.CACHE_KEY_CLAZZ,clazzId);
//            res.add(get(key));
//        }
//        return res;
//    }
//
//    private List<String> getDubboClazzIds(String dubboId) {
//        String key=String.format(Constant.CACHE_KEY_DUBBO_CLAZZ_RELATION,dubboId);
//        String clazzIdStr = stringRedisTemplate.opsForValue().get(key);
//        if(StringUtils.isBlank(clazzIdStr)){
//            return new ArrayList<String>();
//        }
//        List<String> res = JSON.parseArray(clazzIdStr,String.class);
//        if(res==null){
//            return new ArrayList<String>();
//        }
//        return res;
//    }
//}
