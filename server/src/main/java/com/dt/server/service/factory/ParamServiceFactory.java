//package com.dt.server.service.factory;
//
//import com.dt.bdf.exception.BusinessException;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.config.MyPropsConfig;
//import com.dt.service.MethodService;
//import com.dt.service.ParamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
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
//public class ParamServiceFactory {
//    @Autowired
//    private List<ParamService> paramServices;
//    @Autowired
//    private MyPropsConfig myPropsConfig;
//    private ParamService paramService;
//
//    public ParamService produce(){
//        if(paramService!=null){
//            return paramService;
//        }
//        for (ParamService service : paramServices) {
//            if(!service.getClass().isAnnotationPresent(Database.class)){
//                continue;
//            }
//            Database database = service.getClass().getAnnotation(Database.class);
//            if(myPropsConfig.getDatabase().equals(database.value())){
//                paramService=service;
//                return paramService;
//            }
//        }
//        throw new BusinessException(String.format("存储类型为[%s]的ParamService实现类不存在",myPropsConfig.getDatabase()));
//    }
//}
