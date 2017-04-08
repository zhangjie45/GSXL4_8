package com.example.gsxl4_8.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gsxl4_8.R;
import com.example.gsxl4_8.Utils.SharedPreferencesUtil;

public class SettingFragment extends Fragment {
    private EditText SettingIp;
    private Button btn_set_ip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        SettingIp = (EditText) view.findViewById(R.id.setting_ip);
        btn_set_ip = (Button) view.findViewById(R.id.btn_sure_ip);
        btn_set_ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtil sp = new SharedPreferencesUtil();
                if (SettingIp.getText().toString().length() == 0 && SettingIp.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "ip设置失败，请检查", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    sp.saveData(getActivity(), "ip", SettingIp.getText().toString());
                    Toast.makeText(getActivity(), "ip设置成功", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

}
