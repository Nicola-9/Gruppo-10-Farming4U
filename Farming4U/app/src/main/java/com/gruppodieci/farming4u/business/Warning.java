package com.gruppodieci.farming4u.business;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Warning implements Serializable {
    public Warning(){
    }

    public Warning(String warning, boolean isSerious, String data){
        this.warning=warning;
        this.isSerious=isSerious;
        this.data=data;
    }

    public Warning(String warning, boolean isSerious){
        this.warning=warning;
        this.isSerious=isSerious;
        LocalDateTime data=LocalDateTime.now();
        String dataStr=""+data.getDayOfMonth()+" "+MonthConverter.getMonth(data.getMonthValue())+" "+data.getYear()+" "+data.getHour()+":"+data.getMinute();
        this.data=dataStr;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public boolean isSerious() {
        return isSerious;
    }

    public void setSerious(boolean serious) {
        isSerious = serious;
    }

    public int getSizeOfWarning() {
        return sizeOfWarning;
    }

    public void setSizeOfWarning(int sizeOfWarning) {
        this.sizeOfWarning = sizeOfWarning;
    }

    private int sizeOfWarning;
    private int yPosition;
    private int xPosition;
    private String data;
    private String warning;
    private boolean isSerious;
}
