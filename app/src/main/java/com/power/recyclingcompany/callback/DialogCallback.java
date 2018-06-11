package com.power.recyclingcompany.callback;

import android.app.Activity;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.request.base.Request;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.widget.BaseDialog;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：对于网络请求是否需要弹出进度对话框
 * 修订历史：
 * ================================================
 */
public abstract class DialogCallback<T> extends JsonCallback<T> {

    private Class<T> clazz;
    private Type type;
    private Activity activity;
    private BaseDialog mDialog;
    private BaseDialog.Builder mBuilder;


    private void initDialog(Activity activity) {
        mBuilder = new BaseDialog.Builder(activity);
        mDialog = mBuilder.setViewId(R.layout.layout_loading)
                //设置dialogpadding
                .setPaddingdp(0, 0, 0, 0)
                //设置显示位置
                .setGravity(Gravity.CENTER)
                //设置动画
                .setAnimation(R.style.nomal_aniamtion)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(false)
                //设置监听事件
                .builder();

    }

    public DialogCallback(Activity activity) {
        super();
        this.activity=activity;
        initDialog(activity);
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.setCancelable(false);
            mDialog.show();
        }
        // 主要用于在所有请求之前添加公共的请求头或请求参数
        // 例如登录授权的 token
        // 使用的设备信息
        // 可以随意添加,也可以什么都不传
        // 还可以在这里对所有的参数进行加密，均在这里实现
        /*request.headers("header1", "HeaderValue1")//
                .params("params1", "ParamsValue1")//
                .params("token", "3215sdf13ad1f65asd4f3ads1f");*/
    }

    @Override
    public T convertResponse(Response response) throws Throwable {
//        ResponseBody body = response.body();
//        if (body == null) return null;
//
//        T data = null;
//        Gson gson = new Gson();
//        JsonReader jsonReader = new JsonReader(body.charStream());
//        if (type != null) data = gson.fromJson(jsonReader,type);
//        if (clazz != null) data = gson.fromJson(jsonReader,clazz);
//        return data;
        if (type == null) {
            if (clazz == null) {
                Type genType = getClass().getGenericSuperclass();
                type = ((ParameterizedType) genType).getActualTypeArguments()[0];
            } else {
                JsonConvert<T> convert = new JsonConvert<>(clazz);
                return convert.convertResponse(response);
            }
        }

        JsonConvert<T> convert = new JsonConvert<>(type);
        return convert.convertResponse(response);
    }

    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }
}