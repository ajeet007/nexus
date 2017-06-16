package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by 60923 on 16/06/2017.
 */
public class GetRelease {
    public static void main(String[] args) throws Exception{

        try {

            URL url = new URL("http://itdev03.hph.com/nexus/service/local/lucene/search?g=hk.com.hit.ngen*&repositoryId=t9.hph.snapshots");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String xmlStr = new String();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                xmlStr +=output;
            }
           getTree(xmlStr);
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
    public static void getTree(String str) throws SAXException{
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();





        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}