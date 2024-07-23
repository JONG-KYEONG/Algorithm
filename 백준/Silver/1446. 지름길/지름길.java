import java.util.*;
import java.io.*;

public class Main
{
    static int n, d;
    static int arr [][];
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int [n][3];
        min = d;

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }




        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
            }
        });

        dfs(0,0,0);

        System.out.println(min);
    }

    public static void dfs(int now, int idx ,int cnt){
        if(idx >= n){
            cnt += (d - now);
            min = Math.min(min, cnt);
            return;
        }

        if(now <= arr[idx][0]){
            if(arr[idx][1] <= d)
                dfs(arr[idx][1] , idx + 1, cnt + arr[idx][0] - now + arr[idx][2]);
        }
        dfs(now, idx+1, cnt);
    }


}