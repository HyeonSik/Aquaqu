package com.nexters.aquaqu.handler;

import com.nexters.aquaqu.helper.SosHelper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class SosXMLHandler extends DefaultHandler {
    private String elementValue = null;
    private Boolean elementOn = false;
    private ArrayList<SosHelper> dataList = new ArrayList<SosHelper>();
    private SosHelper data = null;

    public ArrayList<SosHelper> getData() {
        return dataList;
    }

    int i;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementOn = true;
        //com.google.gson.internal.LinkedTreeMap
        if (localName.equals("com.google.gson.internal.LinkedTreeMap")) {
            data = new SosHelper();
            i = 0;
        }
    }

    /**
     * This will be called when the tags of the XML end.
     **/
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        elementOn = false;


        if (localName.equalsIgnoreCase("string")) {

            if (i == 0) {
                data.setSos_what(elementValue);
                i++;
            } else if (i == 1) {
                data.setSos_what_desc(elementValue);
                i++;
            } else if (i == 2) {
                data.setSos_where(elementValue);
                i++;
            } else if (i == 3) {
                data.setSos_where_desc(elementValue);
                i++;
            } else if (i == 4) {
                data.setSos_what(elementValue);
                i++;
            } else if (i == 5) {
                data.setSos_what_desc(elementValue);
                i++;
            } else if (i == 6) {
                data.setSos_howMany(elementValue);
                i++;
            } else if (i == 7) {
                data.setSos_howMany_desc(elementValue);
                i++;
            } else if (i == 8) {
                data.setSos_die(elementValue);
                i++;
            } else if (i == 9) {
                data.setSos_die_desc(elementValue);
                i++;
            } else if (i == 10) {
                data.setSos_alive(elementValue);
                i++;
            } else if (i == 11) {
                data.setSos_alive_desc(elementValue);
                i++;
            } else if (i == 12) {
                data.setSos_cap(elementValue);
                i++;
            } else if (i == 13) {
                data.setSos_cap_desc(elementValue);
                i++;
            } else if (i == 14) {
                data.setSos_id(elementValue);
                i++;
            } else if (i == 15) {
                data.setSos_id_desc(elementValue);
                i++;
            } else if (i == 16) {
                data.setSos_miss(elementValue);
                i++;
            } else if (i == 17) {
                data.setSos_miss_desc(elementValue);
                i++;
            } else if (localName.equalsIgnoreCase("com.google.gson.internal.LinkedTreeMap")) {
                dataList.add(data);
                data = null;
            }
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