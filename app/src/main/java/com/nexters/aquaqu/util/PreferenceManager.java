package com.nexters.aquaqu.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This class is for use sharedPreferences to easy on evenywhere.
 * Implement singleton pattern. If you want add value.
 * You can modify sample code.
 * <p/>
 * Sampe code. (You will change all key(KEY,Key,key) to value name use before)
 * private static final String KEY = "key";
 * private String key = "";
 * <p/>
 * public void setKey(String key){
 * this.key = key;
 * mEditor.putString(KEY,key);
 * mEditor.commit();
 * }
 * <p/>
 * public String getKey(){
 * if(key.equals("")){
 * key = mPrefs.getString("KEY", "");
 * }
 * return key;
 * }
 * //background select
 * private static final String BGSELECT = "bgSelect";
 * private int bgSelect = 1;
 * <p/>
 * public void setBgSelect(int bgSelect){
 * this.bgSelect = bgSelect;
 * mEditor.putInt(BGSELECT, bgSelect);
 * mEditor.commit();
 * }
 * <p/>
 * public int getBgSelect(){
 * if(bgSelect == 1){
 * bgSelect = mPrefs.getInt(BGSELECT, 1);
 * }
 * return bgSelect;
 * }
 */

/*
*getpref
* PreferenceManager.getInstance().getPhonenum()
*
* setpref
* PreferenceManager.getInstance().setPphoneNum(phone);
*
 */

    /*
    *
     */


public class PreferenceManager {
    private static final String PREF_NAME = "aqua_prefs.xml";

    private static PreferenceManager instance;

    public static PreferenceManager getInstance(Context context) {
        if (instance == null) {
            instance = new PreferenceManager(context);
        }
        return instance;
    }

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private PreferenceManager(Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    //select star in setting activity
    private static final String SELECTEDSTAR = "SELECTEDSTAR";
    private int selected_star = 0;

    public void setSelectedstar(int key) {
        this.selected_star = key;
        clear(SELECTEDSTAR);
        mEditor.putInt(SELECTEDSTAR, key);
        mEditor.commit();
    }

    public int getSelectedstar() {
        if (selected_star == 0) {
            selected_star = mPrefs.getInt(SELECTEDSTAR, 0);
        }
        return selected_star;
    }


    //clear
    public void clear(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }

}
