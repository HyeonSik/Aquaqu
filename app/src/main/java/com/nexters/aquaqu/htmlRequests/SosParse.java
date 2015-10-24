package com.nexters.aquaqu.htmlRequests;

import android.os.AsyncTask;
import android.util.Log;

import com.nexters.aquaqu.handler.SosXMLHandler;
import com.nexters.aquaqu.helper.SosHelper;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Created by YounDitt on 2015-10-24.
 */
public class SosParse {

    public void main() {

        new SosAsync().execute();
    }

    private ArrayList<SosHelper> dataList;

    private class SosAsync extends AsyncTask<Void, Void, Void> {

        SosAsync() {

        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                //------ Main parse section start ------//
                SAXParserFactory saxPF = SAXParserFactory.newInstance();
                SAXParser saxP = saxPF.newSAXParser();
                XMLReader xmlR = saxP.getXMLReader();
                URL url = new URL("http://api.data.go.kr/openapi/0a8ba413-10d4-47ba-8f19-b0035dc3ab8c?serviceKey=hMHtzWl7qHvb9kRkjE6XbKxRsSzs05X8nPgokJs3M6bZ%2FUwglNjmQ13dztjJWir0DQotzSi81H1hq2%2FZ1iKxCA%3D%3D"); // URL of the XML
                SosXMLHandler mySosXMLHandler = new SosXMLHandler();
                xmlR.setContentHandler(mySosXMLHandler);
                xmlR.parse(new InputSource(url.openStream()));
                //------ Main parse section end ------//

                // load parsing data & View
                dataList = mySosXMLHandler.getData();

                Log.e("____data", dataList.toString() + "");
            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }
    }
}