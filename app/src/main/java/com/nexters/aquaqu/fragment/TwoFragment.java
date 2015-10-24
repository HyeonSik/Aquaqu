package com.nexters.aquaqu.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexters.aquaqu.R;
import com.nexters.aquaqu.helper.OceanHelper;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by HyunSik on 2015-10-25.
 */
public class TwoFragment extends Fragment {

    private Source source;
    OceanHelper helper = new OceanHelper();


    private static final String TAG = "TwoFragment";

    public static TwoFragment newInstance() {
        TwoFragment fragment = new TwoFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.l_activity_viewpager, container, false);
        rootView.setTag(TAG);

        return rootView;
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
}
