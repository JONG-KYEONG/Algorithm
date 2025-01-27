import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long[] temp = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long inversionCount = mergeSort(arr, temp, 0, n - 1);
        System.out.println(inversionCount);
    }

    static long mergeSort(long[] arr, long[] temp, int left, int right) {
        long inversionCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;
            inversionCount += mergeSort(arr, temp, left, mid);
            inversionCount += mergeSort(arr, temp, mid + 1, right);
            inversionCount += merge(arr, temp, left, mid, right);
        }

        return inversionCount;
    }

    static long merge(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inversionCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }

        return inversionCount;
    }
}
