package com.nexters.aquaqu.htmlRequests;

import net.htmlparser.jericho.Source;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * Created by HyunSik on 2015-10-24.
 */
public class TestParse {

    private Source source;

    public void getUrl(String url_txt) {

        try {
            URL url = new URL(url_txt);
            InputStream html = url.openStream();
            source = new Source(new InputStreamReader(html, "utf-8"));
            source.fullSequentialParse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
