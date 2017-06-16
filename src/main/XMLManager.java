package main;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 60923 on 16/06/2017.
 */

public final class XMLManager {

    public static ArrayList<Data> getAlData(){
        ArrayList<Data> alData = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File("D:\\search.xml");
            ArtifactHandler artifactHandler = new ArtifactHandler();
            parser.parse(file, artifactHandler);
            alData = artifactHandler.getAlData();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return alData;
    }

}