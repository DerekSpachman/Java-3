/*
 * 
 * 
 * @author Derek Spachman
 */
package threads;

import java.util.ArrayList;
import java.util.Random;


public class Fortune {
    private ArrayList<String> today;
    private ArrayList<String> future;
    
    public Fortune() {
        today = new ArrayList<>();
        future = new ArrayList<>();
        today.add("A friend is near.");
        today.add("Expect a call.");
        today.add("Someone misses you.");
        future.add("Wealth awaits - if you desire it.");
        future.add("Climb the hill of effort for high grades.");
        future.add("The door to success is open to you.");
    }
    
    /**
     * @return a randomly selected message for today.
     */
    public String getToday() {
        Random gen = new Random();
        return today.get(gen.nextInt(today.size()));
    }
    
    /**
     * @return a randomly selected message for future.
     */
    public String getFuture() {
        Random gen = new Random();
        return future.get(gen.nextInt(future.size()));
    }
}
