//package com.dt.server.service.factory;
//
//import com.dt.bdf.exception.BusinessException;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.config.MyPropsConfig;
//import com.dt.service.MethodService;
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
//public class MethodServiceFactory {
//    @Autowired
//    private List<MethodService> MethodServices;
//    @Autowired
//    private MyPropsConfig myPropsConfig;
//    private MethodService MethodService;
//
//    public MethodService produce(){
//        if(MethodService!=null){
//            return MethodService;
//        }
//        for (MethodService service : MethodServices) {
//            if(!service.getClass().isAnnotationPresent(Database.class)){
//                continue;
//            }
//            Database database = service.getClass().getAnnotation(Database.class);
//            if(myPropsConfig.getDatabase().equals(database.value())){
//                MethodService=service;
//                return MethodService;
//            }
//        }
//        throw new BusinessException(String.format("存储类型为[%s]的MethodService实现类不存在",myPropsConfig.getDatabase()));
//    }
//}
//
//
