package com.example.gsxl4_8.UI;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.gsxl4_8.Fragment.HomeFragment;
import com.example.gsxl4_8.Fragment.MycarFragment;
import com.example.gsxl4_8.Fragment.MyroadFragment;
import com.example.gsxl4_8.Fragment.RoadEnvironmentFragment;
import com.example.gsxl4_8.Fragment.SettingFragment;
import com.example.gsxl4_8.R;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private static final String MY_CAR = "mycar";
    private static final String MY_ROAD = "myroad";
    private static final String ROAD_ENVIROMENT = "roadenvironment";
    private static final String SETTING = "setting";
    private static final String HOME = "home";
    RadioGroup Rg;
    private Fragment mycarFragment, myroadFragment, roadEnvironmentFragment, settingFragment, homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rg= (RadioGroup) findViewById(R.id.rg_bar);
        Rg.setOnCheckedChangeListener(this);
        FragmentInitView();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (id == R.id.tab_mar_car) {
            showFragment(MY_CAR);
        } else if (id == R.id.my_road_condition) {
            showFragment(MY_ROAD);
        } else if (id == R.id.road_environment) {
            showFragment(ROAD_ENVIROMENT);
        } else if (id == R.id.setting) {
            showFragment(SETTING);
        } else if (id == R.id.tab_home) {
            showFragment(HOME);
        }
    }
    private void showFragment(String tag) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (tag.equals("mycar")){
            transaction.replace(R.id.fg_container, mycarFragment).commit();
        }
        if (tag.equals("myroad")){
            transaction.replace(R.id.fg_container, myroadFragment).commit();
        }
        if (tag.equals("roadenvironment")){
            transaction.replace(R.id.fg_container, roadEnvironmentFragment).commit();
        }
        if (tag.equals("setting")){
            transaction.replace(R.id.fg_container, settingFragment).commit();
        }
        if (tag.equals("home")){
            transaction.replace(R.id.fg_container, homeFragment).commit();
        }
    }
    private void FragmentInitView(){
        mycarFragment=new MycarFragment();
        myroadFragment=new MyroadFragment();
        roadEnvironmentFragment=new RoadEnvironmentFragment();
        settingFragment=new SettingFragment();
        homeFragment=new HomeFragment();
        
    }
}
