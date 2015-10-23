package com.nexters.aquaqu.data;

/**
 * Created by YounDitt on 2015-10-24.
 */
public class SampleData {
    private static int mPeriod;
    private String mTitle;
    private String mArtist;
    private String mCountry;
    private String mCompany;
    private double mPrice;
    private int mYear;

    public void setPeriod(int period) {
        if (period < 1980) {
            this.mPeriod = 7;
        } else if (period < 1990) {
            this.mPeriod = 8;
        } else if (period < 2000) {
            this.mPeriod = 9;
        }
    }

    public int getperiod() {
        return mPeriod;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setCountry(String country) {
        this.mCountry = country;
    }

    public String getcountry() {
        return mCountry;
    }

    public void setCompany(String company) {
        this.mCompany = company;
    }

    public String getCompany() {
        return mCompany;
    }

    public void setPrice(double price) {
        this.mPrice = price;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setYear(int year) {
        this.mYear = year;
    }

    public int getYear() {
        return mYear;
    }
}
