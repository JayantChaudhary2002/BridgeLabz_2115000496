import java.util.*;

public class Problem2{
    public static void main(String[] main) {
        int[] datasize = {1000, 10000, 1000000};
        for (int size : datasize) {
            System.out.println("Dataset size: " + size);
            int[] dataset = generateRandomDataset(size);

            // Bubble Sort
            int[] bubbleSortDataset = Arrays.copyOf(dataset, dataset.length);
            long startTime = System.nanoTime();
            bubbleSort(bubbleSortDataset);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1000000.0 + "ms");

            // Merge Sort
            int[] mergeSortDataset = Arrays.copyOf(dataset, dataset.length);
            startTime = System.nanoTime();
            mergeSort(mergeSortDataset, 0, mergeSortDataset.length - 1);
            endTime = System.nanoTime();
            System.out.println("Merge Sort Time: " + (endTime - startTime) / 1000000.0 + "ms");

            // Quick Sort
            int[] quickSortDataset = Arrays.copyOf(dataset, dataset.length);
            startTime = System.nanoTime();
            quickSort(quickSortDataset, 0, quickSortDataset.length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort Time: " + (endTime - startTime) / 1000000.0 + "ms");

            System.out.println();
        }
    }

    private static int[] generateRandomDataset(int size) {
        Random random = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = random.nextInt(size * 10);
        }
        return dataset;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
