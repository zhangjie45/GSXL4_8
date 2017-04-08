package com.example.gsxl4_8.Utils;

import android.content.Context;

/**
 * Created by 11094 on 2017/4/8.
 */

public class AppConfig {

    public static String getUrlAllSence(Context context) {
        return "http://" + SharedPreferencesUtil.getData(context, "ip", "String").toString() + ":8080/transportservice/type/jason/action/GetAllSense.do";
    }


}
