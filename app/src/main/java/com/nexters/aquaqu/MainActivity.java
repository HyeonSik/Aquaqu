package com.nexters.aquaqu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.nexters.aquaqu.config.CConstant;
import com.nexters.aquaqu.helper.OceanHelper;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    private Source source;
    private int BBSlocate;
    OceanHelper helper = new OceanHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        //new GetHtml("http://sms.khoa.go.kr/koofs/kor/observation/obs_real_detail.asp?tsType=0&tsId=13&obsItem=ALL").execute();

    }


    private class GetHtml extends AsyncTask<String, String, Void> {

        String url;
        String BBS_SPAN_ITEM;

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


                Element BBS_DIV = (Element) source.getAllElements(HTMLElementName.DIV).get(31); //BBSlocate 번째 의 DIV 를 모두 가져온다.
                Element BBS_UL = (Element) BBS_DIV.getAllElements(HTMLElementName.UL).get(0); //ul 접속

                Element BBS_LI = (Element) BBS_UL.getAllElements(HTMLElementName.LI).get(0); //데이터가 있는 li에 접속
                Element element1 = (Element) BBS_LI.getAllElements(HTMLElementName.IMG).get(0);
                String BBS_LI_TITLE = element1.getAttributeValue("title");


                Element BBS_ITEM = (Element) BBS_UL.getAllElements(HTMLElementName.LI).get(2); //데이터가 있는 li에 접속
                Element BBS_SPAN = (Element) BBS_ITEM.getAllElements(HTMLElementName.SPAN).get(0);
                BBS_SPAN_ITEM = BBS_SPAN.getContent().toString();


                Element BBS_SPAN1 = (Element) BBS_ITEM.getAllElements(HTMLElementName.SPAN).get(1);
                String BBS_SAPN_ITEM1 = BBS_SPAN1.getContent().toString();

                helper.setW_temp(BBS_LI_TITLE + BBS_SPAN_ITEM.trim() + BBS_SAPN_ITEM1.trim());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            if (!helper.getW_temp().equals("")) {
                //textView.setText(helper.getW_temp());
            } else {
                Log.e("@@@@", "어허허허");
            }
            super.onPostExecute(aVoid);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
