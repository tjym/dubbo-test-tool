//package com.dt.server.service.factory;
//
//import com.dt.bdf.exception.BusinessException;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.config.MyPropsConfig;
//import com.dt.service.ClazzService;
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
//public class ClazzServiceFactory {
//    @Autowired
//    private List<ClazzService> ClazzServices;
//    @Autowired
//    private MyPropsConfig myPropsConfig;
//    private ClazzService ClazzService;
//
//    public ClazzService produce(){
//        if(ClazzService!=null){
//            return ClazzService;
//        }
//        for (ClazzService service : ClazzServices) {
//            if(!service.getClass().isAnnotationPresent(Database.class)){
//                continue;
//            }
//            Database database = service.getClass().getAnnotation(Database.class);
//            if(myPropsConfig.getDatabase().equals(database.value())){
//                ClazzService=service;
//                return ClazzService;
//            }
//        }
//        throw new BusinessException(String.format("存储类型为[%s]的ClazzService实现类不存在",myPropsConfig.getDatabase()));
//    }
//}
