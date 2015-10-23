package com.nexters.aquaqu.helper;

/**
 * Created by HyunSik on 2015-10-24.
 */
public class OceanHelper {

    String tide; //조위

    String salt; //염분

    String a_temp; //기온

    String w_temp; //수온

    String press; //기압

    String wind; //풍속


    public OceanHelper() {

    }

    public String getTide() {
        return tide;
    }


    public void setTide(String tide) {
        this.tide = tide;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getA_temp() {
        return a_temp;
    }

    public void setA_temp(String a_temp) {
        this.a_temp = a_temp;
    }

    public String getW_temp() {
        return w_temp;
    }

    public void setW_temp(String w_temp) {
        this.w_temp = w_temp;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
