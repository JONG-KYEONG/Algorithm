import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static int map [][];
    static int fire [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        fire = new int[r][c];

        Queue<Node> q = new LinkedList<>();
        Queue<Node> sq = new LinkedList<>();

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                String tmp = String.valueOf(s.charAt(j));
                if(tmp.equals("J")){
                    map[i][j] = 1;
                    sq.add(new Node(i, j, 1));
                }
                if(tmp.equals("#")){
                    map[i][j] = -1;
                    fire[i][j] = -1;
                }
                if(tmp.equals("F")){
                    fire[i][j] = 1;
                    q.add(new Node(i,j,1));
                }
            }
        }

        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (fire[nx][ny]==0) {
                        fire[nx][ny] = node.cnt+1;
                        q.add(new Node(nx, ny, node.cnt+1));
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        while(!sq.isEmpty()){
            Node node = sq.poll();

            for(int k = 0; k < 4; k++){
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if(nx >= 0 && nx < r && ny >=0 && ny < c){
                    if((fire[nx][ny] == 0 || node.cnt + 1 < fire[nx][ny]) && map[nx][ny] == 0){
                        map[nx][ny] = node.cnt+1;
                        sq.add(new Node(nx, ny, node.cnt + 1));
                    }
                }
                else{
                    min = Math.min(min, node.cnt);
                }
            }

        }
        if(min == Integer.MAX_VALUE)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(min);
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
