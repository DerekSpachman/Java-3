/*
 * This dictonary adds words and their descriptions to an array. Words hash 
 * code is found then stored in the array based on that hash code. If another
 * word is stored there (a collision), then the word and it's description will
 * be placed in the next available index. One may also look for a word and see
 * the word formatted with all it's descriptions.
 */
package dataStructures;

public class HashedDictionary<T> {
    private Node array[];
    private static int length;
    
    HashedDictionary(){
        length = 50000;
        array = new Node[length];
        
    }
    
    /**
     * Finds and returns the given hash code of a given word.
     * @param word is the word to find the hash code of.
     * @return hash code of the given word.
     */
    public static int hashCode(String word){
        int hash = word.hashCode();
        if(hash < 0)
            hash = -hash;
        if(hash >= length)
            hash %= length;
        return hash;
    }
    
    /**
     * Adds a given word and description to the dictionary.
     * @param word
     * @param description
     */
    public void add(String word, String description){
        int hash = hashCode(word);
        //if no entry add word and description
        if(array[hash] == null)
            array[hash] = new Node(word, new Node(description, null));
        //if word in array is the same as given word, add description
        else if(word.equals(array[hash].getData())) {
            Node node = array[hash]; //starts at the word
            while(node.getLink() != null) //traverse the linked list
                node = node.getLink();
            node.setLink(new Node(description, null)); //add new description
        }
        //if word in array is not same as given word
        else {
            //if word does not exist in array
            if(lookFor(word).equals("")){
                while(array[hash] != null)
                    hash++;
                array[hash] = new Node(word, new Node(description, null));
            }
            //if word does exist in array
            else {
                for (int i = hash+1; i != hash;) {
                    //if not empty and words are same, format 
                    if(array[i] != null && array[i].getData().equals(word)) {
                        hash = i;
                        break;
                    }
                    //traversal through the array
                    if(i == length-1)
                        i = 0;
                    else
                        i++;
                }
                
                Node node = array[hash]; //starts at the word
                while(node.getLink() != null) //traverse the linked list
                    node = node.getLink();
                node.setLink(new Node(description, null));//add new description
            }
        }
    }
    
    /**
     * Finds and returns the word and all descriptions.
     * @param word is the word being searched.
     * @return a String of the word and all descriptions.
     */
    public String lookFor(String word){
        String toReturn = "";
        int hash = hashCode(word);
        //if hash slot is not empty and words are the same, format dictionary
        if(array[hash] != null && word.equals(array[hash].getData())){
            Node node = array[hash];
            toReturn += node.getData()+"\n";
            node = node.getLink();
            while(node != null) {
                toReturn += "\t* "+node.getData()+"\n";
                node = node.getLink();
            }
        }
        //word in array and given word are not same
        else {
            //traverse array until found or until every slot was checked
            for (int i = hash+1; i != hash;) {
                //if not empty and words are same, format dictionary
                if(array[i] != null && array[i].getData().equals(word)){
                    Node node = array[i];
                    toReturn += node.getData()+"\n";
                    node = node.getLink();
                    while(node != null) {
                        toReturn += "\t* "+node.getData()+"\n";
                        node = node.getLink();
                    }
                    return toReturn;
                }
                //traversal through the array
                if(i == length-1)
                    i = 0;
                else
                    i++;
            }
        }
        return toReturn;
    }
    
    
    public static void main(String[] args) {
        HashedDictionary hd = new HashedDictionary();
        
        hd.add("word", "description 1");
        hd.add("word", "description 2");
        System.out.println(hd.lookFor("word"));
        
        //when two words have the same hash value: 2236
        hd.add("FB", "hash value of 2236");
        hd.add("FB", "FB 2");
        hd.add("Ea", "hash value of 2236");
        hd.add("Ea", "Ea 2");
        hd.add("Ea", "Ea 3");
        System.out.println(hd.lookFor("FB"));
        System.out.println(hd.lookFor("Ea"));
    }
}
