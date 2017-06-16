package main;

/**
 * Created by 60923 on 16/06/2017.
 */
public class myCall {
    public static void main(String[] args) {

        for(Data data : XMLManager.getAlData()){
            System.out.println("------------------------");
            for(Artifact i :data.getAlArtifact()){
                System.out.println(i.getGroupId());
                System.out.println(i.getArtifactId());
                System.out.println(i.getVersion());
            }
        }
    }
}
