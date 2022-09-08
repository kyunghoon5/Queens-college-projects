public class WordNode {
    protected Word data;
    protected WordNode next;
   
    /**
     * Instantiates the WordNode object for use.
     * @Param word
     */
    public WordNode (Word word) {
        data = word;
        next = null;
        
    }
}