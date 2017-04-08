package com.example.gsxl4_8.Model;

/**
 * Created by 11094 on 2017/4/8.
 */

public class RoadEnvi {

    private int id;
    private String time;
    private String pm;
    private String light;
    private String humidity;
    private String tememperature;
    private String co2;

    public RoadEnvi() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTememperature() {
        return tememperature;
    }

    public void setTememperature(String tememperature) {
        this.tememperature = tememperature;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    @Override
    public String toString() {
        return "RoadEnvi[id=" + id +", time='" + time  +", pm='" + pm  +
                ", light='" + light  +", humidity='" + humidity +
                ", tememperature='" + tememperature  +", co2='" + co2  +']';
    }
}
