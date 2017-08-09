package com.decobim.model.prrepareForAssert;

/**
 * Created by Administrator on 2017/8/9.
 */
public class ResultCode {
        public static final String ERROR_COMMON= "40000" ;           //常规错误
        public static final String ERROR_INVALID= "40010" ;          //验证不通过
        public static final String ERROR_NOT_FOUND = "40011";        //资源找不到
        public static final String ERROR_OPERATION_FAILURE= "40012"; //操作失败
        public static final String ERROR_INVALID_PARAMTER = "40013"; //参数（格式、范围）验证失败
        public static final String ERROR_CONFLICT_MOBILE = "40015";
        public static final String ERROR_DUPLICATED_INSTANCE = "40016"; //对象已经存在了
        public static final String ERROR_UNKNOWN = "40999" ;            //目前未知错误
}
