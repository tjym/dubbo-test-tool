package com.dt.server.common.constant;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
public class Constant {

    public final static  String MSG_DATA_EXIST="该数据已存在";
    public final static  String MSG_ERROR_SERVICE_ID ="服务Id不能为空";
    public final static  String MSG_ERROR_SERVICE_NAME ="服务名称不能为空";
    public final static  String MSG_ERROR_SERVICE_HOST ="服务地址不能为空";
    public final static  String MSG_ERROR_SERVICE_PORT ="服务端口不能为空";
    public final static  String MSG_ERROR_SERVICE="服务不能为空";

    public final static  String MSG_ERROR_METHOD_ID="方法Id不能为空";
    public final static  String MSG_ERROR_METHOD_NAME="方法名称不能为空";
    public final static  String MSG_ERROR_METHOD_ALIA_NAME="方法别名不能为空";

    public final static  String MSG_ERROR_PARAM_ID="参数Id不能为空";
    public final static  String MSG_ERROR_PARAM_NAME="参数名称不能为空";
    public final static  String MSG_ERROR_PARAM_DESC="参数描述不能为空";
    public final static  String MSG_ERROR_PARAM_TYPE="参数类型不能为空";
    public final static  String MSG_ERROR_PARAM_SORT="参数排序不能为空";

    public final static  String MSG_ERROR_CASE_ID="用例Id能为空";
    public final static  String MSG_ERROR_CASE_NAME="用例名称不能为空";


    public final static String END_KEY_DUBBO= "dubbo>";
    public final static String PROPERTY_LINE_SEPARATOR= "line.separator";


    //dubbo信息缓存key
    public final static  String CACHE_KEY_DUBBO_ID="DUBBO:DUBBO_ID_LIST";
    //dubbo信息缓存key
    public final static  String CACHE_KEY_DUBBO="DUBBO:%s";
    //dubbo-clazz关联信息缓存key
    public final static  String CACHE_KEY_DUBBO_CLAZZ_RELATION="DUBBO:RELATION_CLZAA_DUBBO_%s";
    //clazz信息缓存key
    public final static  String CACHE_KEY_CLAZZ="CLAZZ:%s";
    //clazz-method关联信息缓存key
    public final static  String CACHE_KEY_CLAZZ_METHOD_RELATION="CLAZZ:RELATION_METHOD_CLAZZ_%s";
    //method信息缓存key
    public final static  String CACHE_KEY_METHOD="METHOD:%s";
    //method-param关联信息缓存key
    public final static  String CACHE_KEY_METHOD_PARAM_RELATION="METHOD:RELATION_PARAM_METHOD_%s";
    //param信息缓存key
    public final static  String CACHE_KEY_PARAM="PARAM:%s";


    public static final String STATIC_PATH = "templates/pages/v1/";
}
