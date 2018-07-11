package com.power.recyclingcompany.ui.home.recycler;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.ui.message.ChatPrivateActivity;
import com.power.recyclingcompany.utils.LogUtils;
import com.power.recyclingcompany.utils.PermissionUtils;
import com.power.recyclingcompany.utils.SPUtils;
import com.power.recyclingcompany.utils.ToastUtils;
import com.power.recyclingcompany.widget.BaseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-07-10 10:59:37
 * @description: 回收人员详情页
 */
public class RecyclerDetailActivity extends BaseActivity<RecyclerDetailContract, RecyclerDetailPresenter> {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.name_tv)
    TextView nameTv;
    @BindView(R.id.sex_tv)
    TextView sexTv;
    @BindView(R.id.age_tv)
    TextView ageTv;
    @BindView(R.id.leibie_tv)
    TextView leibieTv;
    @BindView(R.id.phone_tv)
    TextView phoneTv;
    @BindView(R.id.card_tv)
    TextView cardTv;
    @BindView(R.id.address_tv)
    TextView addressTv;
    @BindView(R.id.call_tv)
    TextView callTv;
    @BindView(R.id.chat_tv)
    TextView chatTv;
    @BindView(R.id.list_tv)
    TextView lietTv;
    @BindView(R.id.unbind_tv)
    TextView unbindTv;
    private BaseDialog mDialog;
    private BaseDialog.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("回收人员详情");
    }

    @Override
    protected RecyclerDetailPresenter createPresenter() {
        return new RecyclerDetailPresenter();
    }

    @OnClick({R.id.title_back_iv, R.id.call_tv, R.id.chat_tv, R.id.list_tv, R.id.unbind_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
                break;
            case R.id.call_tv:
                PermissionUtils.requestPermissions(this, Constant.REQUEST_CODE_CALLPHONE,
                        new String[]{Manifest.permission.CALL_PHONE},
                        new PermissionUtils.OnPermissionListener() {
                            @Override
                            public void onPermissionGranted() {
                                LogUtils.e("权限申请成功");
                                showCallDialog();
                            }

                            @Override
                            public void onPermissionDenied(String[] deniedPermissions) {
                                LogUtils.e("权限申请被拒绝");
                                ToastUtils.showShort("权限申请被拒绝");
                            }
                        });
                break;
            case R.id.chat_tv:
                //设置要发送出去的昵称
                SPUtils.getInstance().put(Constant.keys.USERNAME,"Power公司端");
                //设置要发送出去的头像
                SPUtils.getInstance().put(Constant.keys.FACE,"http://img4q.duitang.com/uploads/item/201506/13/20150613215049_xiHNV.jpeg");

                Intent intent = new Intent(this,ChatPrivateActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID,"test02");
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                startActivity(intent);
                break;
            case R.id.list_tv:
                startActivity(new Intent(this,RecyclerOrderActivity.class));
                break;
            case R.id.unbind_tv:
                showUnbindDialog();
                break;
        }
    }

    private void showUnbindDialog() {
        mBuilder = new BaseDialog.Builder(this);
        mDialog = mBuilder.setViewId(R.layout.dialog_order_del)
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
        mDialog.setCancelable(true);
        TextView contentTv = mDialog.getView(R.id.content_tv);
        TextView leftTv = mDialog.getView(R.id.left_tv);
        TextView rightTv = mDialog.getView(R.id.right_tv);
        contentTv.setText("您确定要解除合作吗？");
        leftTv.setText("取消");
        rightTv.setText("确认");
        mDialog.show();
        leftTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
        rightTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                finish();
            }
        });
    }

    private void showCallDialog() {
        mBuilder = new BaseDialog.Builder(this);
        mDialog = mBuilder.setViewId(R.layout.dialog_order_call)
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
        mDialog.setCancelable(true);
        mDialog.show();
        TextView contentTv = mDialog.getView(R.id.content_tv);

        mDialog.getView(R.id.cancle_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
        mDialog.getView(R.id.query_tv).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri data = Uri.parse("tel:" + "17611226688");
                intent.setData(data);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.onRequestPermissionsResult(this,requestCode, permissions,grantResults);
    }
}
