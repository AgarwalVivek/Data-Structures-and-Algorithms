import java.util.HashMap;

class SolutionTree {

    TrieNode root;
    /** Initialize your data structure here. */
    class TrieNode{
        HashMap<Character, TrieNode> children;
        String prefix;
        boolean isWord;
        public TrieNode(String prefix){
            this.prefix = prefix;
            isWord = false;
            children = new HashMap<>();
        }
        
    }
    
    public SolutionTree() {
        root = new TrieNode("");
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         insert(word, root);
    }
    private void insert(String word, TrieNode x){
        //temporary node for traversing trie keeping root intact
        TrieNode cur  = root;

        char c;
        TrieNode child = null;
        for(int i = 0; i < word.length(); i++){
            c = word.charAt(i);
           
            child = cur.children.get(c);
            if(child == null){
                //fresh entry we need to insert this node and also entry into childfren hashmap
              cur.children.put(c, new TrieNode(word.substring(0, i+1)));
            } 
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root);
    }
    private boolean search(String word,TrieNode x){
        TrieNode cur = root;
        TrieNode child;
        char c;
        for(int i = 0; i < word.length(); i++){
            c = word.charAt(i);
            child = cur.children.get(c);
            //if no entry in map return false
            if(child == null)
                return false;
            cur = child;
        }
        return cur.isWord == true;
    }
    
    public boolean delete(String s) {
    		return delete(s, 0, root);
    		
    			
    }
    private boolean delete(String s, int index, TrieNode root) {
		// TODO Auto-generated method stub
    	if(index == s.length()) {
    		if(!root.isWord)
    			return false;
    		root.isWord = false;
    		return root.children.size() == 0;
    	}
    	char ch = s.charAt(index);
    	TrieNode cur  = root.children.get(ch);
    	if(cur == null)
    		return false;
    	boolean shouldDelete = delete(s, index+1, cur);
    	if(shouldDelete) {
    		root.children.remove(ch);
    		return root.children.size() == 0;
    		
    	}
		return false;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       return startsWith(prefix, root);
    }
    private boolean startsWith(String prefix, TrieNode x){
        //trvaerse till the node first
        char c;
        TrieNode cur  = root;
        TrieNode child;
        for(int i = 0; i < prefix.length(); i++){
            c = prefix.charAt(i);
            child = cur.children.get(c);
            if(child == null)
                return false;
            cur = child;
        }
        AutoFullComplete(cur);
        return cur != null;
    }
    private void AutoFullComplete(TrieNode cur){
        if(cur != null){
            if(cur.isWord == true)
                System.out.println(cur.prefix);
        }
        
        
        for(Character c: cur.children.keySet()){
            TrieNode n = cur.children.get(c);
            AutoFullComplete(n);
            
        }
    }
    public static void main(String []args) {
    		SolutionTree obj = new SolutionTree();
    		obj.insert("abcdef");
    		//System.out.println(obj.search("abc"));
    		System.out.println(obj.startsWith("a"));
    		System.out.println(obj.delete("abcdef"));
    		
    }

}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
