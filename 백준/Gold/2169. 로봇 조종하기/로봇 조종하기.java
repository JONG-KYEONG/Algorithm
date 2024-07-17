import java.util.*;
import java.io.*;

public class Main
{
    static int n, m;
    static int map [][];
    static int dp [][][];
    static int tmp [];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        dp = new int [n][m][3];
        tmp = new int [m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = -100000;
            }
        }

        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = map[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (j > 0)
                    dp[i][j][0] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + map[i][j];  //  왼쪽에서 오는 경우
                if (i > 0)
                    dp[i][j][1] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + map[i][j];
            }
            for(int j = m-2; j >=0;j--){
                dp[i][j][2] = Math.max(dp[i][j+1][2] , dp[i][j+1][1]) + map[i][j];
            }
        }



        System.out.println(Math.max(dp[n-1][m-1][0],dp[n-1][m-1][1]));
    }


}