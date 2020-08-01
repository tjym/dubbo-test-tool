//package com.dt.server.service.redis;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.dt.dto.DubboDTO;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.constant.Constant;
//import com.dt.service.DubboService;
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisKeyValueTemplate;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
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
//public class DubboRedisServiceImpl implements DubboService {
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//
//    @Override
//    public DubboDTO save(DubboDTO dubbo){
//        if(StringUtils.isBlank(dubbo.getId())){
//            dubbo.setId(UUID.randomUUID().toString());
//            String key=String.format(Constant.CACHE_KEY_DUBBO_ID);
//            String dubboIdStr = stringRedisTemplate.opsForValue().get(key);
//            List<String> dubboIdList = new ArrayList<String>();
//            if(StringUtils.isNotBlank(dubboIdStr)){
//                dubboIdList = JSON.parseArray(dubboIdStr,String.class);
//            }
//            dubboIdList.add(dubbo.getId());
//            stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(dubboIdList));
//        }
//        String key=String.format(Constant.CACHE_KEY_DUBBO,dubbo.getId());
//        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(dubbo));
//        return dubbo;
//    }
//
//    @Override
//    public Boolean delete(String dubboId){
//        String key=String.format(Constant.CACHE_KEY_DUBBO,dubboId);
//        stringRedisTemplate.delete(key);
//
//        key=String.format(Constant.CACHE_KEY_DUBBO_ID);
//        String dubboIdStr = stringRedisTemplate.opsForValue().get(key);
//        List<String> dubboIds = JSON.parseArray(dubboIdStr,String.class);
//        dubboIds.remove(dubboId);
//        stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(dubboIds));
//        return true;
//    }
//
//
//    @Override
//    public List<DubboDTO> list(){
//        List<DubboDTO> res = new ArrayList<DubboDTO>();
//        String key=String.format(Constant.CACHE_KEY_DUBBO_ID);
//        String dubboIdStr = stringRedisTemplate.opsForValue().get(key);
//        if(StringUtils.isBlank(dubboIdStr)){
//            return res;
//        }
//        List<String> dubboIds = JSON.parseArray(dubboIdStr,String.class);
//        for (String dubboId : dubboIds) {
//            DubboDTO dubbo = get(dubboId);
//            if(dubbo==null){
//                continue;
//            }
//            res.add(dubbo);
//        }
//        return res;
//    }
//
//
//    private DubboDTO get(String dubboId){
//        String key=String.format(Constant.CACHE_KEY_DUBBO,dubboId);
//        String dubboInfo = stringRedisTemplate.opsForValue().get(key);
//        return JSON.parseObject(dubboInfo,DubboDTO.class);
//    }
//
//
//}
