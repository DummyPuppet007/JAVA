public class TRIE {
    static class Node{
        Node children[];
        boolean eow;

        Node(){
            children = new Node[26];
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    
    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }

            if(i == word.length() - 1){
                curr.children[index].eow = true;
            }

            curr = curr.children[index];            
        }
    }

    public static boolean search(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            int index = ch - 'a';
            Node node = curr.children[index];
            if(node == null){
                return false;
            }

            if(i == word.length() - 1 && node.eow == false){
                return false;
            }

            curr = curr.children[index];
        }
        return true;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i = 1; i <= key.length(); i++){
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);
            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            Node node = curr.children[index];
            if(node == null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    public static int countUniqueSubstrings(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null){
                count += countUniqueSubstrings(root.children[i]);
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        /* 
        // INSERT & SEARCH
        String words[] = {"the", "a", "there", "any",  "their"};
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        System.out.println(search("their"));
        System.out.println(search("thor")); 
        System.out.println(search("an")); 
        */

        /*
        // Word Break Problem
        String words[] = {"i", "like", "sam", "samsung",  "mobile"};
        String key = "ilikesamsung";

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        if(wordBreak(key)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        */

        /* 
        // Starts With
        String words[] = {"app", "apple", "mango", "man", "woman"};
        String prefix = "apple";

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        if(startsWith(prefix)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        */

        /* 
        // Count of unique substrings
        String str = "ababa";
        for(int i =0; i < str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println("Count of unique substrings: " + countUniqueSubstrings(root));
        */

        /* 
        // Longest Word in Dictionary
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        
        longestWord(root, new StringBuilder(""));
        System.out.print("Longest word with all prefix : ");
        System.out.println(ans);
        */
    }
}
