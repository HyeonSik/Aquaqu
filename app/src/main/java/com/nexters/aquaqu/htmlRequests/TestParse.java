package com.nexters.aquaqu.htmlRequests;

import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;

import com.nexters.aquaqu.helper.OceanHelper;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


/**
 * Created by HyunSik on 2015-10-24.
 */
public class TestParse {

    private Source source;
    private int BBSlocate;

    public void getUrl(String url) {

        try {
            new GetHtml(url).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class GetHtml extends AsyncTask<String, String, Void> {

        String url;

        GetHtml(String url) {
            this.url = url;
        }

        @Override
        protected Void doInBackground(String... strings) {

            try {
                Log.e("@@@", "들어옴!");
                URL URL = new URL(url);
                InputStream html = URL.openStream();
                source = new Source(new InputStreamReader(html, "utf-8"));
                source.fullSequentialParse();

                OceanHelper helper = new OceanHelper();

                Element BBS_DIV = (Element) source.getAllElements(HTMLElementName.DIV).get(34); //BBSlocate 번째 의 DIV 를 모두 가져온다.
                Element BBS_UL = (Element) BBS_DIV.getAllElements(HTMLElementName.UL).get(0); //ul 접속

                Element BBS_LI = (Element) BBS_UL.getAllElements(HTMLElementName.LI).get(0); //데이터가 있는 li에 접속
                Element element1 = (Element) BBS_LI.getAllElements(HTMLElementName.IMG).get(0);
                String BBS_LI_TITLE = element1.getAttributeValue("title");


                Element BBS_ITEM = (Element) BBS_UL.getAllElements(HTMLElementName.LI).get(2); //데이터가 있는 li에 접속
                Element BBS_SPAN = (Element) BBS_ITEM.getAllElements(HTMLElementName.SPAN).get(0);
                String BBS_SPAN_ITEM = BBS_SPAN.getContent().toString();

                helper.setW_temp(BBS_SPAN_ITEM);

                Element BBS_SPAN1 = (Element) BBS_ITEM.getAllElements(HTMLElementName.SPAN).get(1);
                String BBS_SAPN_ITEM1 = BBS_SPAN1.getContent().toString();


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }


    private static void displaySegments(List<? extends Segment> segments) {
        for (Segment segment : segments) {
            Log.e("@@@@", "-------------------------------------------------------------------------------");
            Log.e("@@@@", segment.toString());
        }
        Log.e("@@@@", "*****************************************************************");
    }
}
