import java.util.*;
import java.io.*;

public class Main
{
    static int n, m, result;
    static int map [][];
    static boolean visited [][][];
    static int dx [] = {0,1,0,-1};
    static int dy [] = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        visited = new boolean [n][m][2];
        result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        visited[0][0][0] = true;
        bfs();

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node (0,0,1,false));
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == n-1 && node.y == m-1) {
                result = Math.min(result, node.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(nx == n-1 && ny == m-1) {
                        result = Math.min(result, node.cnt + 1);
                        return;
                    }
                    if(node.bre){
                        if (!visited[nx][ny][1]) {
                            if (map[nx][ny] == 0) {
                                visited[nx][ny][1] = true;
                                q.add(new Node(nx, ny, node.cnt + 1, node.bre));
                            }
                        }
                    }
                    else{
                        if (!visited[nx][ny][0]) {
                            if (map[nx][ny] == 0) {
                                visited[nx][ny][0] = true;
                                q.add(new Node(nx, ny, node.cnt + 1, node.bre));
                            }
                            else{
                                visited[nx][ny][1] = true;
                                q.add(new Node(nx, ny, node.cnt + 1, true));
                            }
                        }
                    }
                }
            }


        }

    }

    static class Node{
        int x;
        int y;
        int cnt;
        boolean bre;
        Node(int x, int y, int cnt, boolean bre){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.bre = bre;
        }
    }
}