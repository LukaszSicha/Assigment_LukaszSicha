package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PropertyAgentController {
    ArrayList<User> agents = new ArrayList<User>();

    public Property getAgentDetails(String id) {

        try {
            String id1 = id;  //Test only
            for (User item : agents) {
                if (item.getUsername() == id1) {
                }
            }
        } catch (Exception e) {
        }
        return null;

    }

    @FXML
    public void saveAgent() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("propertyFile.xml"));
        out.writeObject(agents);
        out.close();
    }

    @FXML
    public void loadAgent() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("propertyFile.xml"));
        agents = (ArrayList<User>) is.readObject();
        is.close();
    }


    @FXML
    public String listAgents() {
        int i = 0;
        String displayAgent = "All properties";
        for (User item : agents) {
            displayAgent += "\n" + (i++) + " : " + item;
        }
        return displayAgent;
    }



}
