import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 10;

        for(int testcase = 1; testcase <= tc; testcase++){
            int n = Integer.parseInt(br.readLine());

            int arr[] = new int [100];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for(int i = 0; i < n; i++){
                if(arr[99] - arr[0] <= 1){
                    break;
                }
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }

            int result = arr[99] - arr[0];

            sb.append("#" + testcase + " " + result +"\n");
        }

        System.out.print(sb);
    }
}
