package com.power.recyclingcompany.bean;

/**
 * Created by Administrator on 2017/11/23.
 */

public class EventBean {
    private String str_msg;
    private int int_msg;

    public EventBean(String msg) {
        this.str_msg = msg;
    }

    public EventBean(int msg) {
        this.int_msg = msg;
    }

    public String getMsg() {
        return str_msg;
    }

    public void setMsg(String msg) {
        this.str_msg = msg;
    }

    public int getInt_msg() {
        return int_msg;
    }

    public void setInt_msg(int int_msg) {
        this.int_msg = int_msg;
    }
}
