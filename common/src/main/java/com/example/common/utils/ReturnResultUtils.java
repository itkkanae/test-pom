package com.example.common.utils;

@SuppressWarnings("unused")
public class ReturnResultUtils {

    private static final int SUCCESS = 0;

    private static final String SUCCESS_MSG = "SUCCESS";

    /***
     * 成功 不带数据
     * @return 返回状态码与状态信息
     */
    public static <T> ReturnResult<T> returnSuccess() {
        ReturnResult<T> returnResult = new ReturnResult<>();
        returnResult.setCode(SUCCESS);
        returnResult.setMessage(SUCCESS_MSG);
        return returnResult;
    }

    /***
     * 成功 带数据
     * @return 返回状态码, 状态信息与数据
     */
    public static <T> ReturnResult<T> returnSuccess(T data) {
        ReturnResult<T> returnResult = new ReturnResult<>();
        returnResult.setCode(SUCCESS);
        returnResult.setMessage(SUCCESS_MSG);
        returnResult.setData(data);
        return returnResult;
    }

    /***
     * 失败
     * @return 返回状态码与状态信息
     */
    public static <T> ReturnResult<T> returnFail(Integer code, String message) {
        ReturnResult<T> returnResult = new ReturnResult<>();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        return returnResult;
    }

}
