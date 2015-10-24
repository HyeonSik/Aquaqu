package com.nexters.aquaqu.util;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by HyunSik on 2015-10-24.
 */
public class GetLocation {

    static public class MyThread extends Thread {
        private DefaultHttpClient client = new DefaultHttpClient();
        String url2;
        String result;

        public MyThread(Object parameter) {
            url2 = (String) parameter;
        }

        public String getResult() {
            return result;
        }

        public void run() {

            HttpGet getRequest = new HttpGet(url2);

            try {
                HttpResponse getResponse = client.execute(getRequest);
                final int statusCode = getResponse.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
                    Log.e("", "Error " + statusCode + " for URL " + url2);
                }
                HttpEntity getResponseEntity = getResponse.getEntity();

                if (getResponseEntity != null) {
                    result = EntityUtils.toString(getResponseEntity);
                }
            } catch (IOException e) {
                getRequest.abort();
                Log.e("", "Error for URL " + url2, e);
            }

        }
    }


    public static final String GOOGLE_GEOCODER = "http:⁄⁄maps.googleapis.com⁄maps⁄api⁄geocode⁄json?latlng=";

    public static String getAddressFromGPSData(double lat, double longi) {

        String request = GOOGLE_GEOCODER + lat + "," + longi + "&sensor=true" + "&language=" + Locale.getDefault().getLanguage();

        String response;

        MyThread downloadThread = new MyThread(request);
        downloadThread.start();

        try {
            downloadThread.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


        response = downloadThread.getResult();
        String formattedAddress = "";
        if (response != null) {
            Log.d("GeoCoder", response);
            try {
                JSONObject parentObject = new JSONObject(response);
                JSONArray arrayOfAddressResults = parentObject.getJSONArray("results");
                JSONObject addressItem = arrayOfAddressResults.getJSONObject(0);
                formattedAddress = addressItem.getString("formatted_address");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Log.e("GeoCoder", response);
        return formattedAddress;
    }
}
