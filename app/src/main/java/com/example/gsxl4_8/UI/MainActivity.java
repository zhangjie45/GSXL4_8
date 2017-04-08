package com.example.gsxl4_8.UI;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.gsxl4_8.Fragment.HomeFragment;
import com.example.gsxl4_8.Fragment.MycarFragment;
import com.example.gsxl4_8.Fragment.MyroadFragment;
import com.example.gsxl4_8.Fragment.RoadEnvironmentFragment;
import com.example.gsxl4_8.Fragment.SettingFragment;
import com.example.gsxl4_8.R;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout framlayout;
    private RadioGroup radiogroup;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.add(R.id.fg_container, new HomeFragment()).commit();

    }

    //点击back键提示再按一次退出程序，双击back键时退出程序
    /*用来计算返回键的点击时间间隔*/
    private long exitTiem = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - exitTiem > 2000) {
                Toast.makeText(this, "再点击一次退出程序", Toast.LENGTH_SHORT).show();
                exitTiem = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initView() {
        radiogroup = (RadioGroup) findViewById(R.id.rg_bar);
        framlayout = (FrameLayout) findViewById(R.id.fg_container);
        radiogroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.tab_mar_car:
                getSupportFragmentManager().beginTransaction().replace(R.id.fg_container, new MycarFragment()).commit();
                break;
            case R.id.my_road_condition:
                getSupportFragmentManager().beginTransaction().replace(R.id.fg_container, new MyroadFragment()).commit();
                break;
            case R.id.tab_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fg_container, new HomeFragment()).commit();
                break;
            case R.id.road_environment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fg_container, new RoadEnvironmentFragment()).commit();
                break;
            case R.id.setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fg_container, new SettingFragment()).commit();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
