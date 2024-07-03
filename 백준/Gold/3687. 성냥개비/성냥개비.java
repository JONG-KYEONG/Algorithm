import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static Long dp[] = new Long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2]=1L;
        dp[3]=7L;
        dp[4]=4L;
        dp[5]=2L;
        dp[6]=6L;
        dp[7]=8L;
        dp[8]=10L;

        String[] add = {"1","7","4","2","0","8"};

        for(int i=9;i<=100;i++) {
            for(int j=2;j<=7;j++) {
                String line = dp[i-j]+add[j-2];
                dp[i] = Math.min(Long.parseLong(line), dp[i]);
            }
        }

        for(int i = 0 ; i < n; i++){


            find(Integer.parseInt(br.readLine()));
        }
        System.out.println(sb);
    }

    public static void find(int n){
        String big;

        if(n % 2 ==0){
            String s = "";
            for(int i = 0 ; i < n/2; i++){
                s = s + "1";
            }
            big = s;
        }
        else{
            String s = "7";
            for(int i = 0 ; i < (n - 3)/2; i++){
                s = s + "1";
            }
            big = s;
        }
        sb.append(dp[n] + " " + big + "\n");
    }
}