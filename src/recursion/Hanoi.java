/*
 * A simple game that has three pegs and a number of disks. move all the disks
 * to another peg in the decending order to win. A larger disk may not be 
 * placed on top of a smaller disk.
 * 
 * @author Derek Spachman (2019)
 */
package recursion;

import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
        private int disks; //number of disks
        private Stack peg1;
        private Stack peg2;
        private Stack peg3;
        
        public Hanoi(int size) {
            disks = size;
            peg1 = new Stack();
            peg2 = new Stack();
            peg3 = new Stack();
            for (int i = disks-1; i >= 0; i--)
                peg1.push(i);
        }
        
        
        public String play(Hanoi hanoi) {
            if(gameOver())
                return this.toString();
            //change object
            return this.toString()+"\n\n"+play(hanoi);
            
        }
        
        
        //move method
        public void move() {
            if(peg1.peek() != null) {
                
            }
        }
        
        
        private boolean validMove() {
            //if()
                
            return false;
        }
        
        
        private boolean gameOver() { 
            int p1, p2, p3;
            p1 = p2 = p3 = 0;
            
            for(Iterator itr = peg1.iterator(); itr.hasNext(); itr.next())
                p1++;
            if(p1 == disks)
                return true;
            
            for(Iterator itr = peg2.iterator(); itr.hasNext(); itr.next())
                p2++;
            if(p2 == disks)
                return true;
            
            for(Iterator itr = peg3.iterator(); itr.hasNext(); itr.next())
                p3++;
            if(p3 == disks)
                return true;
            
            return false;
        }
        
        /**
         * @return the formatted board.
         */
        @Override
        public String toString() {
            Iterator itr1 = peg1.iterator();
            Iterator itr2 = peg2.iterator();
            Iterator itr3 = peg3.iterator();
            
            String toReturn ="peg1\tpeg2\tpeg3\n-------------------------\n";
            while(itr1.hasNext() || itr2.hasNext() || itr3.hasNext()) {
                if(itr1.hasNext())
                    toReturn += itr1.next()+"\t";
                else
                    toReturn += " \t";
                if(itr2.hasNext())
                    toReturn += itr2.next()+"\t";
                else
                    toReturn += " \t";
                if(itr3.hasNext())
                    toReturn += itr3.next();
                toReturn += "\n";
            }
            
            return toReturn;
        }
        
    }
