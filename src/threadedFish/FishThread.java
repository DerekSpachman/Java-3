/*
 * 
 */
package threadedFish;


public class FishThread extends Thread {
    private static int fishId = 0;
    
    public FishThread() {
        
    }
    
    @Override
    public void run() {
        FishGUI fish;
        fish = new FishGUI(200, 300);
        
    }
}
