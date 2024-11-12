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

            int arr[] = new int[n];

            for(int i = 0 ; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i] += Integer.parseInt(st.nextToken()) * 35;
                arr[i] += Integer.parseInt(st.nextToken()) * 45;
                arr[i] += Integer.parseInt(st.nextToken()) * 20;
            }

            int count = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] > arr[k-1]){
                    count++;
                }
            }

            String result = "";
            int dis = n / 10;

            if(count/dis <= 0){
                result = "A+";
            }
            else if(count/dis <= 1){
                result = "A0";
            }
            else if(count/dis <= 2){
                result = "A-";
            }
            else if(count/dis <= 3){
                result = "B+";
            }
            else if(count/dis <= 4){
                result = "B0";
            }
            else if(count/dis <= 5){
                result = "B-";
            }
            else if(count/dis <= 6){
                result = "C+";
            }
            else if(count/dis <= 7){
                result = "C0";
            }
            else if(count/dis <= 8){
                result = "C-";
            }
            else if(count/dis <= 9){
                result = "D0";
            }

            sb.append("#" + testcase + " " + result + "\n");


        }

        System.out.print(sb);
    }

}
