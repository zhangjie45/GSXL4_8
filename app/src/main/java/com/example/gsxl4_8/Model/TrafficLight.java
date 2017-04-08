package com.example.gsxl4_8.Model;

/**
 * Created by 11094 on 2017/4/8.
 */

public class TrafficLight {
    private String crossing;
    private String redTime;
    private String greenTime;
    private String yellowTime;

    public TrafficLight() {
        super();
    }

    public TrafficLight(String crossing, String redTime, String greenTime, String yellowTime) {
        super();
        this.crossing = crossing;
        this.greenTime = greenTime;
        this.redTime = redTime;
        this.yellowTime = yellowTime;

    }

    public String getCrossing() {
        return crossing;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public String getRedTime() {
        return redTime;
    }

    public void setRedTime(String redTime) {
        this.redTime = redTime;
    }

    public String getGreenTime() {
        return greenTime;
    }

    public void setGreenTime(String greenTime) {
        this.greenTime = greenTime;
    }

    public String getYellowTime() {
        return yellowTime;
    }

    public void setYellowTime(String yellowTime) {
        this.yellowTime = yellowTime;
    }

    @Override
    public String toString() {
        return "TrafficLight[crossing='" + crossing + ", redTime='" + redTime +
                ", greenTime='" + greenTime + ", yellowTime='" + yellowTime + ']';
    }
}
