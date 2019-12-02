package sample;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class AgentController {

    @FXML
    ArrayList<User> agentsArray = new ArrayList<User>();


    @FXML
    public void saveAgent() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("propertyFile.xml"));
        out.writeObject(agentsArray);
        out.close();
    }

    @FXML
    public void loadAgent() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("propertyFile.xml"));
        agentsArray = (ArrayList<User>) is.readObject();
        is.close();
    }



    public Property getAgentDetails(String id) {
        try {
            String id1 = (id);  //Test only
            for (User item : agentsArray) {
                if (item.getEmail() == id1) {
                }
            }
        } catch (Exception e) {
        }
        return null;
    }


}



