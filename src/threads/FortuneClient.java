/*
 * 
 * 
 * @author Derek Spachman
 */
package threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FortuneClient {
    
    public static void main(String[] args) {
        try {
            String s = "";
            Socket server = new Socket("localhost", 5678); /////////////////////////////
            System.out.println("Connected to server: "+server.getInetAddress());
            Scanner user = new Scanner(System.in);
            Scanner input = new Scanner(server.getInputStream()); //fromServer
            PrintWriter output = new PrintWriter(server.getOutputStream(), true); //toServer
            System.out.println("Enter \"today\" or \"future\" to recieve a "
                    + "fortune from the expected or \"quit\" to quit.");
            
            s = user.nextLine();
            output.println(s);
            System.out.println("Your fortune is: "+input.nextLine());
            
            input.close();
            output.close();
            server.close();
        }
        catch(IOException e) { System.out.println("Error in FortuneClient"); }
    }
    
}
