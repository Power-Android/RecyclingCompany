package com.power.recyclingcompany.ui.home.driver;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.power.recyclingcompany.R;
import com.power.recyclingcompany.app.Constant;
import com.power.recyclingcompany.base.BaseActivity;
import com.power.recyclingcompany.bean.LatLngBean;
import com.power.recyclingcompany.utils.LogUtils;
import com.power.recyclingcompany.utils.PermissionUtils;
import com.power.recyclingcompany.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author power
 * @date 2018-06-19 11:03:13
 * @description: 司机人员分布页面
 */
public class DriverFBActivity extends BaseActivity<DriverFBContract, DriverFBPresenter>
        implements DriverFBContract, AMapLocationListener {

    @BindView(R.id.title_back_iv)
    ImageView titleBackIv;
    @BindView(R.id.title_content_tv)
    TextView titleContentTv;
    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.dingwei_iv)
    ImageView dingweiIv;
    @BindView(R.id.jia_iv)
    ImageView jiaIv;
    @BindView(R.id.jian_iv)
    ImageView jianIv;
    private AMap aMap;
    private MyLocationStyle myLocationStyle;
    //声明mlocationClient对象
    private AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    private AMapLocationClientOption mLocationOption = null;
    private LatLng latLng;

    @Override
    protected DriverFBPresenter createPresenter() {
        return new DriverFBPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_fb);
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    private void initView(final Bundle savedInstanceState) {
        titleBackIv.setVisibility(View.VISIBLE);
        titleContentTv.setText("司机人员分布");

        PermissionUtils.requestPermissions(this, Constant.REQUEST_CODE_LOCATION,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION},
                new PermissionUtils.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        LogUtils.e("权限申请成功");
                        initMap(savedInstanceState);
                    }

                    @Override
                    public void onPermissionDenied(String[] deniedPermissions) {
                        LogUtils.e("权限申请被拒绝");
                        ToastUtils.showShort("权限申请被拒绝");
                    }
                });
    }

    private void initMap(Bundle savedInstanceState) {
        //创建地图
        mapView.onCreate(savedInstanceState);
        //显示地图
        if (aMap == null) aMap = mapView.getMap();
        //隐藏缩放按钮
        aMap.getUiSettings().setZoomControlsEnabled(false);

        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW);//连续定位、且将视角移动到地图中心点，定位蓝点跟随设备移动。（1秒1次定位）
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.moveCamera(CameraUpdateFactory.zoomTo(16));

//        //更改定位图标
//        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.driver_map_location_iv));
//        //设置不显示范围圆圈
//        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
//        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色

        mlocationClient = new AMapLocationClient(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
        //marker标记
        initMarker();
    }

    private void initMarker() {
        mPresenter.requestData();
    }

    @Override
    public void dataSuccess(List<LatLngBean> latLngBeanList) {
        for (int i = 0; i < latLngBeanList.size(); i++) {
            final LatLngBean latLngBean = latLngBeanList.get(i);
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(new LatLng(latLngBean.getLatitude(), latLngBean.getLongitude()))
                    .title(i + "")
                    .draggable(false);//设置Marker可拖动
            View view = LayoutInflater.from(this).inflate(R.layout.view_driver, null);
            markerOption.icon(BitmapDescriptorFactory.fromView(view));
            aMap.addMarker(markerOption);
        }
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                LogUtils.i("定位结果回调：" + "\n" +
                        "定位来源：" + aMapLocation.getLocationType() + "\n" +
                        "纬度：" + aMapLocation.getLatitude() + "\n" +
                        "经度：" + aMapLocation.getLongitude() + "\n" +
                        "城市信息:" + aMapLocation.getCity() + "\n" +
                        "定位时间：" + df.format(date));
                latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                LogUtils.i(latLng.toString());
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @OnClick({R.id.title_back_iv,R.id.dingwei_iv, R.id.jia_iv, R.id.jian_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_iv:
                finish();
            case R.id.dingwei_iv://点击定位
                if (latLng != null) aMap.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
                break;
            case R.id.jia_iv://放大地图
                if (aMap.getCameraPosition().zoom <= aMap.getMaxZoomLevel()) aMap.moveCamera(CameraUpdateFactory.zoomIn());
                break;
            case R.id.jian_iv://缩小地图
                if (aMap.getCameraPosition().zoom >= aMap.getMinZoomLevel()) aMap.moveCamera(CameraUpdateFactory.zoomOut());
                break;
        }
    }
}
