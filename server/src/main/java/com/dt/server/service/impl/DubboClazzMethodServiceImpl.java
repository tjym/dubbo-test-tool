//package com.dt.server.service.impl;
//
//import com.dt.dto.*;
//import com.dt.server.common.util.ResultGenerator;
//import com.dt.server.service.factory.ClazzServiceFactory;
//import com.dt.server.service.factory.DubboServiceFactory;
//import com.dt.server.service.factory.MethodServiceFactory;
//import com.dt.server.service.factory.ParamServiceFactory;
//import com.dt.service.ClazzService;
//import com.dt.service.DubboService;
//import com.dt.service.MethodService;
//import com.dt.service.ParamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.annotation.PostConstruct;
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
//public class DubboClazzMethodServiceImpl {
//    @Autowired
//    private DubboServiceFactory dubboServiceFactory;
//    @Autowired
//    private ClazzServiceFactory clazzServiceFactory;
//    @Autowired
//    private MethodServiceFactory methodServiceFactory;
//    @Autowired
//    private ParamServiceFactory paramServiceFactory;
//
//
//
//    private DubboService dubboService;
//    private ClazzService clazzService;
//    private MethodService methodService;
//    private ParamService paramService;
//    @PostConstruct
//    public void init(){
//        dubboService = dubboServiceFactory.produce();
//        clazzService = clazzServiceFactory.produce();
//        methodService = methodServiceFactory.produce();
//        paramService = paramServiceFactory.produce();
//    }
//
//
//
//    public ResultDTO<DubboDTO> saveDubbo(DubboDTO dubbo){
//        DubboDTO res = dubboService.save(dubbo);
//        return ResultGenerator.genSuccessResult(res);
//    }
//
//    public ResultDTO<Boolean> deleteDubbo(String dubboId){
//        return ResultGenerator.genSuccessResult(dubboService.delete(dubboId));
//    }
//
//    public ResultDTO<List<DubboDTO>> getDubboList(){
//        return ResultGenerator.genSuccessResult(dubboService.list());
//    }
//
//    public ResultDTO<ClazzDTO> saveClazz(ClazzDTO clazz){
//        if(StringUtils.isBlank(clazz.getId())){
//            clazz.setId(UUID.randomUUID().toString());
//        }
//        ClazzDTO res = clazzService.save(clazz);
//        return ResultGenerator.genSuccessResult(res);
//    }
//
//    public ResultDTO<Boolean> deleteClazz(ClazzDTO clazz){
//        return ResultGenerator.genSuccessResult(clazzService.delete(clazz));
//    }
//
//    public ResultDTO<List<ClazzDTO>> getDubboClazzList(String dubboId){
//        return ResultGenerator.genSuccessResult(clazzService.getBubboClazzList(dubboId));
//    }
//
//    public ResultDTO<MethodDTO> saveMethod(MethodDTO method){
//        if(StringUtils.isBlank(method.getId())){
//            method.setId(UUID.randomUUID().toString());
//        }
//        MethodDTO res = methodService.save(method);
//        return ResultGenerator.genSuccessResult(res);
//    }
//
//    public ResultDTO<Boolean> deleteMethod(MethodDTO method){
//        return ResultGenerator.genSuccessResult(methodService.delete(method));
//    }
//
//    public ResultDTO<List<MethodDTO>> getClazzMethodList(String clazzId){
//        return ResultGenerator.genSuccessResult(methodService.getClazzMethodList(clazzId));
//    }
//
//    public ResultDTO<ParamDTO> saveParam(ParamDTO param){
//        if(StringUtils.isBlank(param.getId())){
//            param.setId(UUID.randomUUID().toString());
//        }
//        ParamDTO res = paramService.save(param);
//        return ResultGenerator.genSuccessResult(res);
//    }
//
//    public ResultDTO<Boolean> deleteParam(ParamDTO method){
//        return ResultGenerator.genSuccessResult(paramService.delete(method));
//    }
//
//    public ResultDTO<List<ParamDTO>> getMethodParamList(String clazzId){
//        return ResultGenerator.genSuccessResult(paramService.getMethodParamList(clazzId));
//    }
//}
