
import java.awt.print.Pageable;
import java.util.*;
import java.io.*;

public class Solution {
    static int n, l, result;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase <= tc; testcase++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            arr = new int[n][2];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            result = 0;

            get(0, 0,0);

            sb.append("#" + testcase + " " + result +"\n");
        }

        System.out.print(sb);
    }

    public static void get(int idx, int score, int cal) {
        if(cal <= l){
            result = Math.max(score, result);
        }
        else {
            return;
        }

        if(idx >= n){
            return;
        }

        get(idx+1, score + arr[idx][0], cal + arr[idx][1]);
        get(idx+1, score, cal);
    }
}
