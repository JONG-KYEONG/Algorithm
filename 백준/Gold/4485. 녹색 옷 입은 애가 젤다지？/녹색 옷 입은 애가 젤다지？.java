import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int dp [][];
    static int arr [][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 1;
        while (true){
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            dp = new int[n][n];
            arr = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    int tmp = Integer.parseInt(st.nextToken());
                    arr[i][j] = tmp;
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = arr[0][0];

            sb.append("Problem " + cnt + ": " + dijk() +"\n");
            cnt++;
        }

        System.out.println(sb);
    }


    static public int dijk() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0,arr[0][0]));
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            if(x == n - 1 && y == n -1){
                return node.money;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(dp[nx][ny] > dp[x][y] + arr[nx][ny]){
                        dp[nx][ny] = dp[x][y] + arr[nx][ny];
                        q.add(new Node(nx, ny, dp[nx][ny]));
                    }
                }
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int money;
        Node(int x, int y, int money){
            this.x = x;
            this.y = y;
            this.money = money;
        }
        @Override
        public int compareTo(Node o1) {
            return this.money - o1.money;
        }
    }
}
