import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
 
                if (i == j) { 
                    arr[i][j] = 1;
                }
            }
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }            
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        boolean can = true;
        for(int i = 1; i < m; i++){
            int t = Integer.parseInt(st.nextToken());
            
            if(arr[s][t] == 0){
                can = false;
                break;
            }
        }
        
        if(can)
            System.out.println("YES");
        else
            System.out.println("NO");
	}
}