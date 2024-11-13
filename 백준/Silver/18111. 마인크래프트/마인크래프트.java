import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = 0;
        int arr[][] = new int [n][m];

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Integer.min(arr[i][j], min);
                max = Integer.max(arr[i][j], max);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;

        for(int d = min; d <= max; d++){
            int totalTime = 0;
            int remove = 0;
            int add = b;
            for(int i = 0 ; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] < d){
                        int dis = d - arr[i][j];
                        totalTime += dis;
                        remove += dis;
                    }
                    else if(arr[i][j] > d){
                        int dis = arr[i][j] - d;
                        totalTime += (dis * 2);
                        add += dis;
                    }
                }
            }
            if(remove <= add){
                if(totalTime <= time){
                    time = totalTime;
                    height = d;
                }
            }
        }

        System.out.print(time + " " + height);
    }

}
