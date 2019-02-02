package com.jiwoolee.android_back.Network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLdocuActivity extends AppCompatActivity {

    TextView text54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmldocu);

        text54 = (TextView)findViewById(R.id.textView54);
    }

    public void btn_xml(View view){
        NetworkThread thread = new NetworkThread();
        thread.start();
    }

    class NetworkThread extends Thread{
        @Override
        public void run() {
            try{
                String site = "http://192.168.193.77:8090/XmlServer/xml.jsp";
                URL url = new URL(site);
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();

                //DOM 방식으로 xml분석 파서 객체 생성
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(is);

                Element root = doc.getDocumentElement();                 //최상위 태그 가져옴 ==<data>
                NodeList item_list = root.getElementsByTagName("item");  //<item> 태그 리스트 얻어옴

                text54.setText("");

                //<item>태그 객체 수 만큼 반복
                for(int i=0; i<item_list.getLength(); i++){
                    Element item_tag = (Element) item_list.item(i);
                    NodeList data1_list = item_tag.getElementsByTagName("data1"); //<item>태그 안의 태그를 읽어옴
                    NodeList data2_list = item_tag.getElementsByTagName("data2");
                    NodeList data3_list = item_tag.getElementsByTagName("data3");

                    Element data1_tag = (Element)data1_list.item(0); //0번째 태그 객체 얻어옴
                    Element data2_tag = (Element)data2_list.item(0);
                    Element data3_tag = (Element)data3_list.item(0);

                    final String data1 = data1_tag.getTextContent();
                    final String data2 = data2_tag.getTextContent();
                    final String data3 = data3_tag.getTextContent();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text54.append("data1 : "+data1+"\n");
                            text54.append("data2 : "+data2+"\n");
                            text54.append("data3 : "+data3+"\n\n");
                        }
                    });
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
