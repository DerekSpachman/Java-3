/*
 * 
 * 
 * @author Derek Spachman
 */
package ThreadedChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost", 5678);
            Scanner input = new Scanner(server.getInputStream());
            PrintWriter output = new PrintWriter(server.getOutputStream(), true);
            
            Scanner scan = new Scanner(System.in);
            String user = "";
            do {
                user = scan.nextLine();
                output.println(user);
            }while(!user.equals("quit"));
        }
        catch(IOException e) { System.out.println("Error in client."); }
    }
}