package com.nexters.aquaqu.handler;

import android.util.Log;

import com.nexters.aquaqu.data.SampleData;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class DataHandler extends DefaultHandler {
    private String elementValue = null;
    private Boolean elementOn = false;
    private ArrayList<SampleData> dataList = new ArrayList<SampleData>();
    private SampleData data = null;

    public ArrayList<SampleData> getData() {
        return dataList;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementOn = true;
        if (localName.equals("CD")) {
            data = new SampleData();
        }
    }

    /**
     * This will be called when the tags of the XML end.
     **/
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        elementOn = false;

        if (localName.equalsIgnoreCase("title")) {
            data.setTitle(elementValue);
        } else if (localName.equalsIgnoreCase("artist")) {
            data.setArtist(elementValue);
        } else if (localName.equalsIgnoreCase("country")) {
            data.setCountry(elementValue);
        } else if (localName.equalsIgnoreCase("company")) {
            data.setCompany(elementValue);
        } else if (localName.equalsIgnoreCase("price")) {
            data.setPrice(Double.parseDouble(elementValue));
            Log.i("debuging", "price : " + data.getPrice());
        } else if (localName.equalsIgnoreCase("year")) {
            data.setYear(Integer.parseInt(elementValue));
            data.setPeriod(Integer.parseInt(elementValue));
        } else if (localName.equalsIgnoreCase("cd")) {
            dataList.add(data);
            data = null;
        }
    }

    /**
     * This is called to get the tags value
     **/
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (elementOn) {
            elementValue = new String(ch, start, length);
            elementOn = false;
        }
    }
}