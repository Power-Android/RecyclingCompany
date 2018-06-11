package com.power.recyclingcompany.bean;

import java.io.Serializable;

/**
 * @author power
 * @date 2018/5/30 上午12:50
 * @description: response基类
 */
public class DataResponse<T> implements Serializable {
    public int errorCode;
    public String errorMsg;
    public T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
