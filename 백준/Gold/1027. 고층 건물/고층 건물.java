import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int [] building;
    static int [] max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        building = new int [n+1];
        max = new int [n+1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++){
            building[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans, Count(i));
        }


        System.out.println(ans);
    }
    public static int Count(int idx) {
        int cnt = 0;
        double tmp = 0;
//        System.out.println();
//        System.out.println(idx + "번");

        for(int i = idx-1; i > 0; i--){
            double s = (double)(building[idx] - building[i]) / (idx - i);
            if (i == idx-1 || tmp > s) {
                cnt++;
                tmp = s;
//                System.out.println(i);
            }
        }

        for(int i = idx+1; i <= n; i++){
            double s = (double)(building[i] - building[idx]) / (i - idx);
            if (i == idx+1 || tmp < s) {
                cnt++;
                tmp = s;
//                System.out.println(i);
            }
        }

        return cnt;
    }

}