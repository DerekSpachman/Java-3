/*
 * 
 * 
 * @author Derek Spachman
 */

package ThreadedChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ChatServer {
    public static void main(String[] args) {
        Socket client;
        HashMap map = new HashMap();
        try(ServerSocket server = new ServerSocket(5678)) {
            while(true) {
                client = server.accept();
                //map.put(client.getInetAddress(), new ChatClientThread(client));
                //map.get(client.getInetAddress())
                System.out.println("client accepted");
            }
        }
        catch(IOException e) { System.out.println("Error in ChatServer."); }
    }
}