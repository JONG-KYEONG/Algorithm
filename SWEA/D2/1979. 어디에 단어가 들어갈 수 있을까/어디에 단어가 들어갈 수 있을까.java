import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase <= t; testcase++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int arr[][] = new int[n][n];
            int result = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int length = 0;
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1){
                        length++;
                    }
                    if(arr[i][j] == 0 || j == n - 1){
                        if(length == k){
                            result++;
                        }
                        length = 0;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                int length = 0;
                for(int j = 0; j < n; j++){
                    if(arr[j][i] == 1){
                        length++;
                    }
                    if(arr[j][i] == 0 || j == n - 1){
                        if(length == k){
                            result++;
                        }
                        length = 0;
                    }
                }
            }

            sb.append("#" + testcase + " " + result + "\n");

        }

        System.out.print(sb);
    }

}
