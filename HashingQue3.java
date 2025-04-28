// Question: Given a list of tickets, where each ticket is represented as a pair of strings (source, destination),
// find the itinerary that starts from the source and visits all the destinations exactly once.
// The itinerary should be printed in the order of the tickets.
import java.util.*;

public class HashingQue3 {
    public static String start(HashMap <String, String> ticket){
        HashMap<String, String> reverseMap = new HashMap<>();
        for(String key : ticket.keySet()){
            reverseMap.put(ticket.get(key), key);
        }

        String start = "";
        for(String key : ticket.keySet()){
            if(!reverseMap.containsKey(key)){
                start = key;
                break;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        HashMap<String, String> ticket = new HashMap<>();
        ticket.put("Chennai", "Bengaluru");
        ticket.put("Mumbai", "Delhi");
        ticket.put("Goa", "Chennai");
        ticket.put("Delhi", "Goa");

        String start = start(ticket);
        while(ticket.containsKey(start)){
            System.out.print(start + " -> ");
            start = ticket.get(start);
        }
        System.out.println(start);
    }
}
