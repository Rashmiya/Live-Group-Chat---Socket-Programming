package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2FormController {
    public AnchorPane Client2;
    public TextField txtTypeMessage;
    public Label lblLabelForName;
    public TextArea txtTextArea;

    final int PORT = 9001;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String receiveMessageFromClient = "";

    public void initialize(){
        new Thread(() -> {
            try {
                socket = new Socket("localhost", PORT);

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                while (!receiveMessageFromClient.equals("exit")) {
                    receiveMessageFromClient = dataInputStream.readUTF();
                    txtTextArea.appendText(receiveMessageFromClient + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Something went Wrong in Client 2");
            }
        }).start();
    }
    public void sendMsgOnAction(ActionEvent actionEvent) throws IOException {
        String messageToSend = txtTypeMessage.getText().trim();

        dataOutputStream.writeUTF(messageToSend);
        dataOutputStream.flush();
        txtTextArea.appendText("You : " + messageToSend + "\n");
        txtTypeMessage.clear();
    }
}
