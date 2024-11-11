import java.util.*;
import java.io.*;

public class Solution {

    static int arr[][];
    static boolean visited[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int testcase = 1; testcase <= 10; testcase++){
            arr = new int[16][16];
            visited = new boolean[16][16];
            br.readLine();
            int x = 0;
            int y = 0;

            for(int i = 0 ; i < 16; i++){
                String s = br.readLine();
                for(int j = 0 ; j < 16; j++){
                    arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                    if (arr[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }

            if(bfs(x,y)){
                sb.append("#" + testcase + " 1\n");
            }
            else {
                sb.append("#" + testcase + " 0\n");
            }

        }
        System.out.print(sb);
    }

    private static boolean bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < 16 && ny < 16){
                    if(arr[nx][ny] == 3){
                        return true;
                    }
                    if(arr[nx][ny] == 0 && !visited[nx][ny]){
                        q.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }

    static class Node{
        int x;
        int y;
        Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
