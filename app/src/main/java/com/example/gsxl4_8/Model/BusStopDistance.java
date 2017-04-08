package com.example.gsxl4_8.Model;

/**
 * Created by 11094 on 2017/4/8.
 */

public class BusStopDistance {
    private int stopNum;
    private String busid;
    private String distance;

    public BusStopDistance() {
        super();
    }

    public BusStopDistance(int stopNum, String busid, String distance) {
        super();
        this.stopNum = stopNum;
        this.busid = busid;
        this.distance = distance;


    }

    public int getStopNum() {
        return stopNum;
    }

    public void setStopNum(int stopNum) {
        this.stopNum = stopNum;
    }

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "BusStopDistance[stopNum=" + stopNum +", busid='" + busid +
                ", distance='" + distance +']';
    }
}
