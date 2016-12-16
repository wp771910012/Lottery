package com.im.lottery.utils;
import com.im.lottery.resp.Response;
/**
 * created by jqli on 2016/7/21
 */
public class ResponseUtil {
	public static final String SUCCESS="1";
    public static final String UNKNOWN="9999";
    public static final String LACK_PARAM="0001";
    public static final String PARAM_NOT_ALLOW="0002";
    public static final String VERIFY_ALREADY_NOT_VALIDATE="0003";
    public static final String EXCEED_MAX_COUNT="0004";
    public static final String VERIFY_NOT_MATCH="-15";
    public static final String RIGHT_NOT_ALLOW="0007";
    public static final String SIGN_ERROR="-2";
    public static final String OPERATE_NOT_ALLOW="0008";
    public static final String USER_ALREADY_EXIST="0100";
    public static final String USER_ALREADY_LOCK="0102";
    public static final String LOGINNAME_PASSWORD_ERROR="-1";
    public static final String USER_NOT_EXIST="0106";
    public static final String USER_WAITING_AUDIT="0107";
    public static final String SERIALNUMBER_NOT_ALLOW="0108";
    public static final String ACCESS_TOKEN_OUT_OF_DATE="0109";
    public static final String ACCOUNT_NOT_ENOUGH="0200";
    public static final String NOT_FOUND = "0404";
    
    /**
     * 创建成功响应
     * @return
     */
    public static Response createSuccessResponseResult(){
    	Response result = new Response();
    	result.setResultCode(SUCCESS);
    	result.setResultMessage("成功");
    	return result;
    }
    
    /**
     * 创建成功响应
     * @return
     */
    public static Response createSuccessResponseResult(String msg){
    	Response result = new Response();
    	result.setResultCode(SUCCESS);
    	result.setResultMessage(msg);
    	return result;
    }
    
    /**
     * 创建缺少参数响应
     * @return
     */
    public static Response createLackParamResult(String msg){
    	Response result = new Response();
    	result.setResultCode(LACK_PARAM);
    	result.setResultMessage(msg);
    	return result;
    }
    
    /**
     * 创建用户已存在响应
     * @return
     */
    public static Response createUserAlreadyExistResult(String msg){
        Response result=new Response();
        result.setResultCode(USER_ALREADY_EXIST);
        result.setResultMessage(msg);
        return result;
    }
    
    /**
     * 创建用户不存在错误响应
     * @return
     */
    public static Response createUSERNOTEXISTResult(String msg){
        Response result=new Response();
        result.setResultCode(USER_NOT_EXIST);
        result.setResultMessage(msg);
        return result;
    }
    
    /**
     * 创建未知错误响应
     * @return
     */
    public static Response createUnknownResult(){
        Response result=new Response();
        result.setResultCode(UNKNOWN);
        return result;
    }
    
    /**
     * 创建错误信息的未知错误响应
     * @param msg
     * @return
     */
    public static Response createUnknownResult(String msg){
        Response result=new Response();
        result.setResultCode(UNKNOWN);
        result.setResultMessage(msg);
        return result;
    }
    
    /**
     * 创建签名错误响应
     * @return
     */
    public static Response createSignErrorResult(){
        Response result=new Response();
        result.setResultCode(SIGN_ERROR);
        result.setResultMessage("签名错误");
        return result;
    }
    
    /**
     * 创建权限不足的错误响应
     * @param msg
     * @return
     */
    public static Response createRightNotAllowResult(String msg){
    	Response result = new Response();
    	result.setResultCode(RIGHT_NOT_ALLOW);
    	result.setResultMessage(msg);
    	return result;
    }
    
    /**
     * 创建资源不存在的错误响应
     * @param msg
     * @return
     */
    public static Response createNotFoundResult(String msg){
    	Response result = new Response();
    	result.setResultCode(NOT_FOUND);
    	result.setResultMessage(msg);
    	return result;
    }
    
    /**
     * 创建参数不允许响应
     * @return
     */
    public static Response createParamNotAllowResult(String msg){
    	Response result = new Response();
    	result.setResultCode(PARAM_NOT_ALLOW);
    	result.setResultMessage(msg);
    	return result;
    }
    
}
