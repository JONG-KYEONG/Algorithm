import java.io.*;
import java.util.*;

public class Main
{
    static char map [][];
    static boolean visited [][];
    static int r,c,k, total;
    static int dx [] = {-1, 0, 1, 0};
    static int dy [] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char [r][c];
        visited = new boolean [r][c];
        total = 0;

        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
            }
        }

        visited[r-1][0] = true;
        dfs(r-1, 0, 1);


        System.out.println(total);
    }

    public static void dfs(int x, int y, int cnt){
        if(cnt > k){
            return;
        }
        if(x == 0 && y == c-1){
            if(cnt == k){
                total++;
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c){
                if(!visited[nx][ny] && map[nx][ny]!='T'){
                    visited[nx][ny] = true;
                    dfs(nx,ny,cnt+1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}