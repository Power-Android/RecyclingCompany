package com.power.recyclingcompany.ui;

import android.app.Activity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BasePresenter;
import com.power.recyclingcompany.bean.DataResponse;
import com.power.recyclingcompany.bean.User;
import com.power.recyclingcompany.callback.DialogCallback;

import java.util.Map;

/**
 * @author power
 * @date 2018/5/30 上午11:33
 * @description:
 */
public class MainPresenter extends BasePresenter<MainContract> {
    private Activity activity;

    public MainPresenter(){

    }

    public MainPresenter(Activity activity){
        this.activity = activity;
    }

//    /**
//     * @param map
//     */
//    public void login(final Map<String, String> map) {
//
//        OkGo.<DataResponse<User>>post(Constant.Urls.URL_LOGIN)
//                .tag(this)
//                .params("username", map.get("userName"))
//                .params("password", map.get("passWord"))
//                .execute(new DialogCallback<DataResponse<User>>(activity) {
//                    @Override
//                    public void onSuccess(Response<DataResponse<User>> response) {
//                        DataResponse<User> userDataResponse = response.body();
//                        if (userDataResponse.getErrorCode() == 200){
//                            User user = response.body().getData();
//                            getView().loginSuccess(user);
//                        }else {
//                            getView().loginFail(userDataResponse);
//                        }
//
//                    }
//                });
//    }

}
