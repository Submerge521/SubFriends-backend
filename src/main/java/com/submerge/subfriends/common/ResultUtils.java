package com.submerge.subfriends.common;

/**
 * ClassName: ResultUtils
 * Package: com.submerge.SubFriends.common
 * Description: 返回工具类
 *
 * @Author Submerge--WangDong
 * @Create 2023-08-07 9:55
 * @Version 1.0
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data 响应数据
     * @param <T>  data泛型
     * @return 响应方法
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "OK");
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @return 响应方法
     */
    public static  BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode.getCode(),
               errorCode.getMessage(), errorCode.getDescription());
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @return 响应方法
     */
    public static  BaseResponse error(ErrorCode errorCode, String message,
                                            String description) {
        return new BaseResponse(errorCode.getCode(),
                errorCode.getMessage(), errorCode.getDescription());
    }

    /**
     * 失败
     * @param code
     * @param message
     * @param description
     * @return
     */
    public static  BaseResponse error(int code, String message,
                                            String description) {
        return new BaseResponse(code,null,message,description);
    }


    /**
     * 失败
     *
     * @param errorCode 错误码
     * @return 响应方法
     */
    public static BaseResponse error(ErrorCode errorCode,
                                            String description) {
        return new BaseResponse(errorCode.getCode(),null,
                errorCode.getMessage(), errorCode.getDescription());
    }
}
