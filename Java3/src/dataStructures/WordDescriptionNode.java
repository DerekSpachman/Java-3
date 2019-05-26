/*
 * 
 */
package dataStructures;


public class WordDescriptionNode {
    private String word;
    private String description;
    
    WordDescriptionNode(String w, String d){ word = w; description = d; }

    public String getWord() { return word; }
    public String getDescription() { return description; }

    public void setWord(String word) { this.word = word; }
    public void setDescription(String d) { this.description = d; }
}
