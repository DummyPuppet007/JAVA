import java.util.*;

public class HashingMap {
    public static void main(String[] args) {
        //create a hash map
        HashMap<String, Integer> map = new HashMap<>();

        //add elements to the map
        //(case 1: ket exists(value update) || case 2: key not exists(new key-value pair))
        map.put("India", 120);
        map.put("USA", 300);
        map.put("China", 140);
        map.put("Russia", 200);
        map.put("India", 130); 

        System.out.println("Map: " + map);

        //Search for an element
        if(map.containsKey("India")){
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }

        System.out.println("Value of India: " + map.get("India")); //key exist
        System.out.println("Value of Indonesia: " + map.get("Indonesia")); //key not exist

        //Iterate through the map
        for(Map.Entry<String, Integer> element : map.entrySet()){
            System.out.println("Key: " + element.getKey() + ", Value: " + element.getValue());
        }                                                                           

        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        //Remove an element
        map.remove("India");
        System.out.println("Map after removing India: " + map);                                                                                                                                     
    }
}
