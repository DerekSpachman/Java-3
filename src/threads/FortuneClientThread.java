/*
 * 
 * 
 * @author Derek Spachman
 */
package threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class FortuneClientThread extends Thread{
    
    private Socket client;
    private Scanner input; //fromClient
    private PrintWriter output; //toClient
    
    public FortuneClientThread(Socket client) {
        this.client = client;
        try {
            input = new Scanner(client.getInputStream());
            output = new PrintWriter(client.getOutputStream(), true);
            start();
        }
        catch(IOException e) { 
            System.out.println("Error in FortuneClientThread constructor.");
        }
    }
    
    @Override
    public void run() {
        String string = null;
        Fortune fortune = new Fortune();
        try {
            while(input.hasNextLine()) {
                string = input.nextLine();
                if(string.equals("today"))
                    output.println(fortune.getToday());
                else if(string.equals("future"))
                    output.println(fortune.getFuture());
            }
            input.close();
            output.close();
            client.close();
        }
        catch(IOException e) { System.out.println("Error in run."); }
    }
}
