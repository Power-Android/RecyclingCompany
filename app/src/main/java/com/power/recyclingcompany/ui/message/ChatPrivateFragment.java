package com.power.recyclingcompany.ui.message;

import android.os.Bundle;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.widget.chatrow.EaseCustomChatRowProvider;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.App;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.utils.LogUtils;
import com.power.recyclingcompany.utils.SPUtils;

/**
 * @author power
 * @date 2018/6/13 上午9:52
 * @description:
 */
public class ChatPrivateFragment extends EaseChatFragment implements EaseChatFragment.EaseChatFragmentHelper{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState, chatType != EaseConstant.CHATTYPE_CHATROOM);
    }

    @Override
    protected void setUpView() {
        setChatFragmentHelper(this);
        super.setUpView();
        //隐藏右边删除聊天记录按钮
        titleBar.setRightLayoutVisibility(View.GONE);
        titleBar.setLeftImageResource(R.drawable.title_back_iv);
    }

    /**
     * @param message
     * 设置消息的扩展属性  我们要把自己的信息和头像放到里边
     */
    @Override
    public void onSetMessageAttributes(EMMessage message) {
        //设置要发送扩展消息用户昵称
        message.setAttribute(Constant.keys.USERNAME, SPUtils.getInstance().getString(Constant.keys.USERNAME));
        LogUtils.e("发送出去的userName:" + SPUtils.getInstance().getString(Constant.keys.USERNAME));
        //设置要发送扩展消息用户头像
        message.setAttribute(Constant.keys.FACE, SPUtils.getInstance().getString(Constant.keys.FACE));
        LogUtils.e("发送出去的face:" + SPUtils.getInstance().getString(Constant.keys.FACE));
    }

    @Override
    public void onEnterToChatDetails() {

    }

    @Override
    public void onAvatarClick(String username) {

    }

    @Override
    public void onAvatarLongClick(String username) {

    }

    @Override
    public boolean onMessageBubbleClick(EMMessage message) {
        return false;
    }

    @Override
    public void onMessageBubbleLongClick(EMMessage message) {

    }

    @Override
    public boolean onExtendMenuItemClick(int itemId, View view) {
        return false;
    }

    @Override
    public EaseCustomChatRowProvider onSetCustomChatRowProvider() {
        return null;
    }
}
