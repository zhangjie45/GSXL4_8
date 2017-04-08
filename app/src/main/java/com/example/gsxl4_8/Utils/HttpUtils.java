package com.example.gsxl4_8.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 11094 on 2017/4/8.
 */

public class HttpUtils extends AsyncTask<String, Integer, String> {
    private Context context;
    private JSONObject object;
    private CallBack callBack;

    public HttpUtils(Context context, JSONObject object, CallBack callBack) {
        this.context = context;
        this.object = object;
        this.callBack = callBack;
    }




    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        StringBuffer buffer = null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(3000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content_type", "application/json");
            connection.connect();
            if (object != null) {
                OutputStream out = connection.getOutputStream();
                writer = new PrintWriter(new OutputStreamWriter(out));
                writer.write(object.toString());
                writer.flush();
            }
            InputStream in = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
        if (connection != null) {
            connection.disconnect();
        }

        return buffer != null ? buffer.toString() : "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject object = new JSONObject(s);
            String result = object.getString("serverinfo");
            callBack.callBack(result);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public interface CallBack {
        void callBack(String jsonResult);
    }
}
