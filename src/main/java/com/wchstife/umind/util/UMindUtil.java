package com.wchstife.umind.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.List;

public class UMindUtil {
    public static String RESULT_KEY = "result";

    public static String DATA_KEY = "data";

    public static String ERR_KEY = "err";

    public static String SUCCESS = "success";

    public static String FAIL = "fail";

    public static String ERR_EMPTY_RESULT = "没有查询到任何结果！";

    public static String ERR_PARAM_CANNOT_RESOLVE = "参数无法解析！";

    public static String ERR_BEAN_TO_JSON = "JSON转换出错！";

    public static String ERR_HIBERNATE = "数据操作异常！";

    public static String ERR_INSERT_EXIST = "添加失败，数据已存在，无法重复添加!";

    /**
     * 增删改查都包括
     */
    public static String ERR_OPERATE_NOT_EXIST = "操作失败，数据不存在！";

    public static String ERR_NO_RIGHT = "您没有权限操作相关数据！";

    /**
     * 获取一个基础的成功响应JSON
     * @return
     */
    public static JSONObject getSuccessResponseJo(){
        JSONObject jo = new JSONObject();
        jo.put(RESULT_KEY, SUCCESS);
        jo.put(ERR_KEY, "");

        return jo;
    }

    /**
     * 获取一个基础的成功响应JSON
     * @return
     */
    public static JSONObject getSuccessResponseJoWithData(Object data){
        JSONObject jo = new JSONObject();
        try {
            jo.put(RESULT_KEY, SUCCESS);
            if((data instanceof  JSONObject) || (data instanceof JSONArray)){
                jo.put(DATA_KEY, data);
            }else if(data instanceof List){
                jo.put(DATA_KEY, UMindJSONUtil.listToJson((List)data));
            }else if(data instanceof String){
                JSONObject sdata = new JSONObject();
                sdata.put("msg", data);
                jo.put(DATA_KEY, sdata);
            }else{
                jo.put(DATA_KEY, UMindJSONUtil.beanToJson(data));
            }

            jo.put(ERR_KEY, "");
        } catch (IOException e) {
            jo.put(RESULT_KEY, FAIL);
            jo.put(DATA_KEY, "");
            jo.put(ERR_KEY, "JSON转换出错！");
            e.printStackTrace();
        }

        return jo;
    }

    /**
     * 获取一个基础的失败响应JSON
     * @return
     */
    public static JSONObject getFailResponseJo(){
        JSONObject jo = new JSONObject();
        jo.put(RESULT_KEY, FAIL);
        jo.put(DATA_KEY, "");

        return jo;
    }

    /**
     * 获取一个带errmsg的响应JSON
     * @return
     */
    public static JSONObject getFailResponseJoWithErrMsg(String errMsg){
        JSONObject jo = new JSONObject();
        jo.put(RESULT_KEY, FAIL);
        jo.put(DATA_KEY, "");
        jo.put(ERR_KEY, errMsg);

        return jo;
    }

    /**
     * 获取一个ERR_EMPTY_RESULT响应JSON
     * @return
     */
    public static JSONObject getFailResponseJoErrEmptyResult(){

        return getFailResponseJoWithErrMsg(ERR_EMPTY_RESULT);
    }

    /**
     * 获取一个ERR_JSON_TO_BEAN响应JSON
     * @return
     */
    public static JSONObject getFailResponseJoErrParamCannotResolve(){

        return getFailResponseJoWithErrMsg(ERR_PARAM_CANNOT_RESOLVE);
    }

    /**
     * 获取一个ERR_BEAN_TO_JSON响应JSON
     * @return
     */
    public static JSONObject getFailResponseJoErrBeanToJSON(){

        return getFailResponseJoWithErrMsg(ERR_BEAN_TO_JSON);
    }

    /**
     * 获取一个ERR_HIBERNATE响应JSON
     * @return
     */
    public static JSONObject getFailResponseJoErrHibernate(){

        return getFailResponseJoWithErrMsg(ERR_HIBERNATE);
    }

    /**
     * 获取一个ERR_NO_RIGHT响应JSON
     * 获取不存在的实体
     * @return
     */
    public static JSONObject getFailResponseJoErrNoRight(){

        return getFailResponseJoWithErrMsg(ERR_NO_RIGHT);
    }

    /**
     * 获取一个ERR_INSERT_EXIST响应JSON
     * 插入已存在实体
     * @return
     */
    public static JSONObject getFailResponseJoErrInsertExist(){

        return getFailResponseJoWithErrMsg(ERR_INSERT_EXIST);
    }

    /**
     * 获取一个ERR_OPERATE_NOT_EXIST响应JSON
     * 操作不存在实体
     * @return
     */
    public static JSONObject getFailResponseJoErrOperateNotExist(){

        return getFailResponseJoWithErrMsg(ERR_OPERATE_NOT_EXIST);
    }
}
