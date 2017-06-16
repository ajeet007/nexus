package main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by 60923 on 16/06/2017.
 */
public class ArtifactHandler extends DefaultHandler {
    private ArrayList<Data> alData;
    private Data data;
    private Artifact artifact;
    private ArrayList<Artifact> alArtifact;
    private String reading;


    public ArtifactHandler(){
        super();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(qName.equals("searchNGResponse")){
            alData = new ArrayList<Data>();
        }
        else if(qName.equals("data")){
            data = new Data();
        }
       else if(qName.equals("artifact")){
            artifact = new Artifact();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equals("data")){
            data.setAlArtifact(alArtifact);
            alData.add(data);
            alArtifact = null;
        }
        else if(qName.equals("artifact")){
            if(alArtifact != null){
                alArtifact.add(artifact);
                artifact = null;
            }
        }
        else if(qName.equals("groupId")){
            artifact.setGroupId(reading);
        }
        else if(qName.equals("artifactId")){
            artifact.setArtifactId(reading);
        }
        else if(qName.equals("version")){
            artifact.setVersion(reading);
        }

    }
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        reading = new String(ch, start, length);
    }

    public ArrayList<Data> getAlData() {
        return alData;
    }


}
