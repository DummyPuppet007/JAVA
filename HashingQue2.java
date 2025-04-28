// Question: Given two arrays, find the union of the two arrays.
import java.util.*;

public class HashingQue2 {
    public static int UnionOfArrays(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++){
            set.add(arr2[i]);
        }

        //System.out.println("Union of two arrays: " + set);
        return set.size();
    }

    public static int IntersectionOfArrays(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int j = 0; j < arr2.length; j++){
            if(set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        System.out.println("Union array size : "+ UnionOfArrays(arr1, arr2));
        System.out.println("Intersection array size : "+ IntersectionOfArrays(arr1, arr2));
    }  
}

