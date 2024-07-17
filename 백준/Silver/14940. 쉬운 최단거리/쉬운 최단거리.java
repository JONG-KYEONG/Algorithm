import java.util.*;
import java.io.*;

public class Main
{
    static int n, m, x, y;
    static int map[][];
    static int result[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        result = new int [n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(result[i],-1);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 0)
                    result[i][j] = 0;
                else if(tmp == 2){
                    result[i][j] = 0;
                    x = i;
                    y = j;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));
        while(!q.isEmpty()){
            Node nd = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = nd.x + dx[i];
                int ny = nd.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(result[nx][ny] == -1){
                        result[nx][ny] = nd.cnt + 1;
                        q.add(new Node(nx,ny,nd.cnt+1));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}