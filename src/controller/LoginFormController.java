package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginForm;
    public TextField txtUserName;

    public void logInOnAction(ActionEvent actionEvent) {
        try {
            if (txtUserName.getText().equalsIgnoreCase("Rashmiya")) {
                loadUI("Client1Form",txtUserName.getText());
                txtUserName.clear();
            } else if (txtUserName.getText().equalsIgnoreCase("Risni")) {
                loadUI("Client2Form",txtUserName.getText());
                txtUserName.clear();
            } else if (txtUserName.getText().equalsIgnoreCase("Fareena")) {
                loadUI("Client3Form",txtUserName.getText());
                txtUserName.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error Occur in LoginForm Controller");
        }
    }
    public void loadUI(String URL, String userName) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+URL+".fxml"))));
        stage.setTitle("Live Chat - "+userName.toUpperCase());
        stage.show();
    }
}
