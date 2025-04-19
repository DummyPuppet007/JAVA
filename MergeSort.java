import java.util.*;

public class MergeSort {
    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] < arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0,j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void devide(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        devide(arr, si, mid);
        devide(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        devide(arr, 0, n - 1);
        System.out.print("Sorted array : ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
