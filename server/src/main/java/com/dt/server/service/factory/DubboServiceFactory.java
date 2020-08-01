//package com.dt.server.service.factory;
//
//import com.dt.bdf.exception.BusinessException;
//import com.dt.dto.DubboDTO;
//import com.dt.server.common.aop.Database;
//import com.dt.server.common.config.MyPropsConfig;
//import com.dt.service.DubboService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
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
//public class DubboServiceFactory {
//    @Autowired
//    private List<DubboService> dubboServices;
//    @Autowired
//    private MyPropsConfig myPropsConfig;
//    private DubboService dubboService;
//
//    public DubboService produce(){
//        if(dubboService!=null){
//            return dubboService;
//        }
//        for (DubboService service : dubboServices) {
//            if(!service.getClass().isAnnotationPresent(Database.class)){
//             continue;
//            }
//            Database database = service.getClass().getAnnotation(Database.class);
//            if(myPropsConfig.getDatabase().equals(database.value())){
//                dubboService=service;
//                return dubboService;
//            }
//        }
//        throw new BusinessException(String.format("存储类型为[%s]的DubboService实现类不存在",myPropsConfig.getDatabase()));
//    }
//}
