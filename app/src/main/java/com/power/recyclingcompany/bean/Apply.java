package com.power.recyclingcompany.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * @author power
 * @date 2018/6/15 上午10:00
 * @description:
 */
public class Apply implements Serializable{
    public static final int ALREADY = 1;
    public static final int NOT = 2;
    private int itemType;

    public Apply(int itemType) {
        this.itemType = itemType;
    }

    public int getItemType() {
        return itemType;
    }
}
