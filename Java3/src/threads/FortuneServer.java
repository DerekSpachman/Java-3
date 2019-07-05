/*
 * 
 * 
 * @author Derek Spachman
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class FortuneServer {
    
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(5678)) { 
            while(true) {
                Socket client = server.accept();
                new FortuneClientThread(client);
            }
        }
        catch(IOException e) { System.out.println("Error in FortuneServer"); }
    }
    
}
