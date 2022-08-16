import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static DataOutputStream dataOutputStream1;
    static DataInputStream dataInputStream1;

    static DataOutputStream dataOutputStream2;
    static DataInputStream dataInputStream2;

    static DataOutputStream dataOutputStream3;
    static DataInputStream dataInputStream3;
    /*private static int PORT = 9500;*/

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
//                    Create a serverSocket
                    ServerSocket serverSocket = new ServerSocket(9000);
                    System.out.println("Server Connected - 1");
//                     Waiting for Accept Client
                    Socket accept = serverSocket.accept();
                    System.out.println("First Client has connected successfully !");

                    dataOutputStream1 = new DataOutputStream(accept.getOutputStream());
                    dataInputStream1 = new DataInputStream(accept.getInputStream());

                    while (accept.isConnected()){
                        // read the messages
                        String message = dataInputStream1.readUTF();

                        dataOutputStream2.writeUTF("Rashmiya : " + message);
                        dataOutputStream3.writeUTF("Rashmiya : " + message);
                    }
                    if (!accept.isConnected()){
                        System.out.println("Client 1 has left the chat ");

                        dataOutputStream2.writeUTF("Rashmiya Left the Chat");
                        dataOutputStream3.writeUTF("Rashmiya Left the Chat");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Error Occur in Server for first Client");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
//      Create a serverSocket
                    ServerSocket serverSocket = new ServerSocket(9001);
                    System.out.println("Server Connected - 2");
//                     Waiting for Accept Client
                    Socket accept = serverSocket.accept();
                    System.out.println("Second Client has connected successfully !");

                    dataOutputStream2 = new DataOutputStream(accept.getOutputStream());
                    dataInputStream2 = new DataInputStream(accept.getInputStream());

                    while (accept.isConnected()){
                        // read the messages
                        String message = dataInputStream2.readUTF();

                        dataOutputStream1.writeUTF("Risni : " + message);
                        dataOutputStream3.writeUTF("Risni : " + message);
                    }
                    if (!accept.isConnected()){
                        System.out.println("Client 2 has left the chat ");

                        dataOutputStream1.writeUTF("Risni Left the Chat");
                        dataOutputStream3.writeUTF("Risni Left the Chat");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Error Occur in Server for second Client");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
//      Create a serverSocket
                    ServerSocket serverSocket = new ServerSocket(9002);
                    System.out.println("Server Connected - 3");
//                     Waiting for Accept Client
                    Socket accept = serverSocket.accept();
                    System.out.println("Third Client has connected successfully !");

                    dataOutputStream3 = new DataOutputStream(accept.getOutputStream());
                    dataInputStream3 = new DataInputStream(accept.getInputStream());

                    while (accept.isConnected()){
                        // read the messages
                        String message = dataInputStream3.readUTF();

                        dataOutputStream1.writeUTF("Fareena : " + message);
                        dataOutputStream2.writeUTF("Fareena : " + message);
                    }
                    if (!accept.isConnected()){
                        System.out.println("Client 3 has left the chat ");

                        dataOutputStream1.writeUTF("Fareena Left the Chat");
                        dataOutputStream2.writeUTF("Fareena Left the Chat");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Error Occur in Server for third Client");
                }
            }
        }).start();
    }
}
