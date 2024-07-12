import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char map[][];
    static boolean visited[][];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r + 1][c + 1];
        visited = new boolean[r + 1][c + 1];

        for (int i = 1; i < r + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < c + 1; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }

        result = 1;
        visited[1][1] = true;
        dfs(1,1,String.valueOf(map[1][1]), 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, String str, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && nx <= r && ny > 0 && ny <= c) {
                if (!visited[nx][ny]&&!str.contains(String.valueOf(map[nx][ny]))) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, str + map[nx][ny], cnt + 1);
                    visited[nx][ny] = false;
                } else {
                    result = Math.max(result, cnt);
                }
            }
        }
    }
}