/*
 * 
 * 
 * @author Derek Spachman
 */
package ThreadedChat;

import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class ChatReadThread extends Thread{
    private Socket client;
    private HashMap map;
    
    public ChatReadThread(Socket client) {
        this.client = client;
        this.start();
    }
    
    
    public void setMap(HashMap map) { this.map = map; }
    
    
    @Override
    public void run() {
        
    }
}
