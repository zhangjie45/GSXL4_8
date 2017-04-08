package com.example.gsxl4_8.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gsxl4_8.R;
import com.example.gsxl4_8.Utils.AppConfig;
import com.example.gsxl4_8.Utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;


/**
 * Created by 11094 on 2017/4/8.
 */

public class HomeFragment extends Fragment {
    private TextView et_road_environment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        road_enVironment();
        return view;
    }

    private void road_enVironment() {
        try {
            JSONObject obj = new JSONObject();
            obj.put("BusStationId", null);
            Timer timer = new Timer();

            new HttpUtils(getActivity(), null, new HttpUtils.CallBack() {
                @Override
                public void callBack(String jsonResult) {
                    String str = jsonResult;
                    Log.e("HttpUtils", jsonResult);
                    try {
                        JSONObject obj = new JSONObject(jsonResult);
                        String pm = obj.getString("pm2.5");
                        String co2 = obj.getString("co2");

                        String humidity = obj.getString("humidity");
                        String temperature = obj.getString("temperature");
                        et_road_environment.setText("pm2.5:" + pm + "sμg/m³," + "温度：" + temperature + "℃,湿度：" + humidity + "%,CO₂：" + co2 + "sμg/m³");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //     et_road_environment.setText(jsonResult);


                }
            }).execute(AppConfig.getUrlAllSence(getActivity()));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void initView(View view) {
        et_road_environment = (TextView) view.findViewById(R.id.et_road_environment);
    }


}
