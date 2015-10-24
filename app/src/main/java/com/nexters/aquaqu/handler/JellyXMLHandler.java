package com.nexters.aquaqu.handler;

import com.nexters.aquaqu.helper.JellyHelper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class JellyXMLHandler extends DefaultHandler {
    private String elementValue = null;
    private Boolean elementOn = false;
    private ArrayList<JellyHelper> dataList = new ArrayList<JellyHelper>();
    private JellyHelper data = null;

    public ArrayList<JellyHelper> getData() {
        return dataList;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementOn = true;
        if (localName.equals("item")) {
            data = new JellyHelper();
        }
    }

    /**
     * This will be called when the tags of the XML end.
     **/
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        elementOn = false;

        if (localName.equalsIgnoreCase("jel_1")) {
            data.setName1(elementValue);
        } else if (localName.equalsIgnoreCase("jel_1Desc")) {
            data.setDesc1(elementValue);
        } else if (localName.equalsIgnoreCase("jel_2")) {
            data.setName2(elementValue);
        } else if (localName.equalsIgnoreCase("jel_2Desc")) {
            data.setDesc2(elementValue);
        } else if (localName.equalsIgnoreCase("jel_3")) {
            data.setName3(elementValue);
        } else if (localName.equalsIgnoreCase("jel_3Desc")) {
            data.setDesc3(elementValue);
        } else if (localName.equalsIgnoreCase("jel_4")) {
            data.setName4(elementValue);
        } else if (localName.equalsIgnoreCase("jel_4Desc")) {
            data.setDesc4(elementValue);
        } else if (localName.equalsIgnoreCase("jel_5")) {
            data.setName5(elementValue);
        } else if (localName.equalsIgnoreCase("jel_5Desc")) {
            data.setDesc5(elementValue);
        } else if (localName.equalsIgnoreCase("newsPerEnd")) {
            data.setNewsPerEnd(elementValue);

        } else if (localName.equalsIgnoreCase("newsPerSta")) {
            data.setNewsPerSta(elementValue);
        } else if (localName.equalsIgnoreCase("newsSeq")) {
            data.setNewsSeq(elementValue);
        } else if (localName.equalsIgnoreCase("item")) {
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