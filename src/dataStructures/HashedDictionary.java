/*
 * 
 */
package dataStructures;

public class HashedDictionary<T> {
    private MyArrayList list[];
    private static int length;
    
    HashedDictionary(){
        list = new MyArrayList[10];
        length = 50000;
    }
    
    /**
     * 
     * @param word
     * @return 
     */
    public static int hashCode(String word){
        int hash = word.hashCode();
        if(hash < 0)
            hash = -hash;
        if(hash >= length)
            hash %= length;
        return hash;
    }
    
    public void add(String word, String description){
        list[hashCode(word)].add(description);
    }
    
    /**
     * Finds and returns the word and all descriptions.
     * @param word is the word being searched.
     * @return a String of the word and all descriptions.
     */
    public String lookFor(String word){
        String toReturn = "";
        int hash = hashCode(word);
        if(list[hash] != null){
            toReturn += word;
            for (int i = 0; i < list[hash].getSize(); i++)
                toReturn += list[hash].get(i);
        }
        return toReturn;
    }
    
    
    public static void main(String[] args){
        HashedDictionary hd = new HashedDictionary();
        
        hd.add("hi", "test");
        hd.add("hi", "test1");
        
        
        System.out.println(hd.lookFor("hi"));
    }
    
}
