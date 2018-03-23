package fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.example.niejingwei.bigbang.R;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.zip.Inflater;

/**
 * Created by niejingwei on 2018/3/19.
 */

public class TaskFragment extends Fragment {
    Bundle bundle;
    MapView mapView;
    AMap aMap;
    AMapLocationClient aMapLocationClient;
    AMapLocationClientOption aMapLocationClientOption;
    AMapLocation curLocation;
    boolean isTheFirstFlushMap=true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_task,container,false);
        mapView=view.findViewById(R.id.taskmap);
        aMap=mapView.getMap();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle=savedInstanceState;
    }

    @Override
    public void onStart() {
        super.onStart();
        aMapLocationClient=new AMapLocationClient(getContext());
        aMapLocationClientOption=new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setInterval(3000);
        AMapLocationListener aMapLocationListener=new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                curLocation=aMapLocation;
                if(isTheFirstFlushMap)
                {
                    flushMap(aMapLocation);
                }

            }
        };
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClient.setLocationListener(aMapLocationListener);
        aMapLocationClient.startLocation();

        MyLocationStyle myLocationStyle=new MyLocationStyle();
        myLocationStyle.showMyLocation(true);
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);
        mapView.onCreate(bundle);


    }
    private void flushMap(AMapLocation loc){
        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLng(new LatLng(loc.getLatitude(),loc.getLongitude()));//先维度后经度
        aMap.moveCamera(cameraUpdate);
    }
}
