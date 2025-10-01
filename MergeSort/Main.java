import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
        }

        long start, end;

        // Normal Merge Sort
        start = System.currentTimeMillis();
        MergeSort.mergeSort(arr1, 0, arr1.length - 1);
        end = System.currentTimeMillis();
        System.out.println("\nNormal Merge Sort Time: " + (end - start) + " ms");

        // Multithreaded Merge Sort
        start = System.currentTimeMillis();
        MergeSortThread.mergeSort(arr2, 0, arr2.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Multithreaded Merge Sort Time: " + (end - start) + " ms");

        // Print sorted result
        System.out.println("\nSorted Array (Normal Merge Sort):");
        printArray(arr1);

        sc.close();
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
