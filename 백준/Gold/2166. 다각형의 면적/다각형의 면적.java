import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static double arr[][];
    static double s1, s2, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new double[n][2];
        result = 0.0;
        s1 = 0.0;
        s2 = 0.0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        
        for (int i = 0; i < n-1; i++) {
            s1 += (arr[i][0]*arr[i+1][1]);
            s2 += (arr[i][1]*arr[i+1][0]);
        }
        
        s1 += arr[n-1][0]*arr[0][1];
        s2 += arr[n-1][1]*arr[0][0];
        
        result = Math.abs(s1-s2)/2;

        System.out.printf("%.1f%n", result);
    }
}
