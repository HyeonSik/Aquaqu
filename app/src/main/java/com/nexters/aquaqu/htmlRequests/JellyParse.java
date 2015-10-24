package com.nexters.aquaqu.htmlRequests;

import android.os.AsyncTask;
import android.util.Log;

import com.nexters.aquaqu.handler.JellyXMLHandler;
import com.nexters.aquaqu.helper.JellyHelper;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by YounDitt on 2015-10-24.
 */
public class JellyParse {

    public void main(){

        new JellyAsync().execute();
    }



    private ArrayList<JellyHelper> dataList;

    private class JellyAsync extends AsyncTask<Void, Void, Void> {


        JellyAsync(){

        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //------ Main parse section start ------//
                SAXParserFactory saxPF = SAXParserFactory.newInstance();
                SAXParser saxP = saxPF.newSAXParser();
                XMLReader xmlR = saxP.getXMLReader();
                URL url = new URL("http://openapi.nfrdi.re.kr/openapi/service/OceanProblemService/getOceanproblemInfoServiceJellyfishOccurrenceSpot?ServiceKey=hMHtzWl7qHvb9kRkjE6XbKxRsSzs05X8nPgokJs3M6bZ%2FUwglNjmQ13dztjJWir0DQotzSi81H1hq2%2FZ1iKxCA%3D%3D&numOfRows=3"); // URL of the XML
                JellyXMLHandler myJellyXMLHandler = new JellyXMLHandler();
                xmlR.setContentHandler(myJellyXMLHandler);
                xmlR.parse(new InputSource(url.openStream()));
                //------ Main parse section end ------//

                // load parsing data & View
                dataList = myJellyXMLHandler.getData();

//                Log.e("____data", dataList.toString() + "");

            } catch (Exception e) {
                System.out.println(e);
                Log.e("_______error",e.getMessage());
            }
            return null;
        }
    }

}
