import java.lang.reflect.Array;
import java.util.*;

public class HashMapCode {
    static class HashMap<K, V>{  //generic type <K, V>
        private class Node{
            K key;
            V value;

            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n -nodes
        private int N; // N - buckets
        private LinkedList<Node>[] buckets;

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){ // 0 to N-1
            int bucketIdx = key.hashCode();
            return Math.abs(bucketIdx) % N;
        }

        private int searchInLL(K key, int bucketIdx){
            LinkedList<Node> ll = buckets[bucketIdx];
            for(int i = 0; i < ll.size(); i++){
                
                if(ll.get(i).key == key){
                    return i; 
                }
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[2 * N];

            for(int i = 0; i < 2 * N; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value); 
                }
            }
        }

        public void put(K key, V value){
            int bucketIdx = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIdx);

            if(dataIndex == -1){
                //key not found
                Node node = new Node(key, value);
                buckets[bucketIdx].add(node);
                n++;
            } else {
                //key found
                Node node = buckets[bucketIdx].get(dataIndex);
                node.value = value;
            }

            double lambda = (double)n / N;
            if(lambda > 2.0){
                //rehash
                rehash();
            }
        }

        public V get(K key){
            int bucketIdx = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIdx);

            if(dataIndex == -1){
                return null; //key not found
            } else {
                Node node = buckets[bucketIdx].get(dataIndex);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bucketIdx = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIdx);
            
            if(dataIndex == -1){
                return false; //key not found
            } else {
                return true; //key found
            }
        }

        public V remove(K key){
            int bucketIdx = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIdx);

            if(dataIndex == -1){
                return null; //key not found
            } else {
                Node node = buckets[bucketIdx].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < N; i++){ //bucketIdx
                LinkedList<Node> ll = buckets[i];
                for(int j = 0; j < ll.size(); j++){ //dataIndex
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("USA", 300);
        map.put("China", 140);
        map.put("Russia", 200);
        map.put("India", 130); 

        ArrayList<String> keys = map.keySet();
        // for(String key : keys){
        //     System.out.println("Key: " + key + ", Value: " + map.get(key));
        // }
        for(int i = 0; i < keys.size(); i++){
            String key = keys.get(i);
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}

// reason behind create a empty linked list in each bucket because intially in array
// at every index we have null value
// so we need to create a linked list at every index
// so that we can add elements in the linked list