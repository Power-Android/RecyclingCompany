package com.power.recyclingcompany.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.util.NetUtils;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.ui.MainActivity;
import com.power.recyclingcompany.utils.LogUtils;
import com.power.recyclingcompany.utils.RegexUtils;
import com.power.recyclingcompany.utils.SPUtils;
import com.power.recyclingcompany.utils.StringUtils;
import com.power.recyclingcompany.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date  2018-06-06 17:33:25
 * @description: 登录页面
 */
public class LoginActivity extends BaseActivity<LoginContract, LoginPresenter> implements LoginContract {

    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_rigist)
    TextView tvRigist;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        titleContentTv.setText("登录");
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @OnClick({R.id.tv_rigist, R.id.tv_forget, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_rigist:
                startActivity(new Intent(this,RigistActivity.class));
                break;
            case R.id.tv_forget:
                startActivity(new Intent(this,ForgetPwdActivity.class));
                break;
            case R.id.tv_login:
                String userName = etUser.getText().toString();
                String passWord = etPassword.getText().toString();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)){
                    ToastUtils.showShort("用户名或密码不能为空");
                    return;
                }
                mPresenter.login(userName,passWord);
                break;
        }
    }

    @Override
    public void loginSuccess() {
        SPUtils.getInstance(Constant.SHARED_NAME).put(Constant.keys.IS_LOGIN,true);
        //TODO 测试账户密码，记得修改
        EMClient.getInstance().login("test01","123",new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                LogUtils.e("登录聊天服务器成功！");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                LogUtils.e("登录聊天服务器失败！"+message);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        //注册一个监听连接状态的listener
        EMClient.getInstance().addConnectionListener(new MyConnectionListener());
    }

    //实现ConnectionListener接口
    private class MyConnectionListener implements EMConnectionListener {
        @Override
        public void onConnected() {
        }
        @Override
        public void onDisconnected(final int error) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(error == EMError.USER_REMOVED){
                        // 显示帐号已经被移除
                    }else if (error == EMError.USER_LOGIN_ANOTHER_DEVICE) {
                        // 显示帐号在其他设备登录
                    } else {
                        if (NetUtils.hasNetwork(LoginActivity.this)){
                            //连接不到聊天服务器
                        } else{
                            //当前网络不可用，请检查网络设置
                        }
                    }
                }
            });
        }
    }
}
