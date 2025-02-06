import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = {1, 1 ,1 ,0, 0, -1, -1, -1};
	static int dy[] = {1, 0, -1, 1, -1, 1, 0, -1};
	static int n, min, max, px, py, kCnt, result;
	static String arr[][];
	static int height[][];
	static TreeSet<Integer> heightSet = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        height = new int[n][n];
        kCnt = 0;
        result = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
                if(arr[i][j].equals("K")) kCnt++;
                if(arr[i][j].equals("P")) {
                    px = i;
                    py = j;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                heightSet.add(height[i][j]); // TreeSet 사용하여 자동 정렬
            }
        }

        Integer[] hArr = heightSet.toArray(new Integer[0]);
        int l = 0, r = 0;

        while (r < hArr.length) {
            min = hArr[l];
            max = hArr[r];

            if (isValid()) { // BFS로 체크
                result = Math.min(result, max - min);
                if (l < r) l++; // 🚨 l이 r보다 커지지 않도록 제한
                else
                	r++;
            } else {
                r++; // 최대 높이 증가
            }
        }

        System.out.println(result);
    }
    
    public static boolean isValid() {
        if (height[px][py] < min || height[px][py] > max) return false;
        
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        
        q.add(new Node(px, py));
        visited[px][py] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (visited[nx][ny] || height[nx][ny] > max || height[nx][ny] < min)
                        continue;

                    visited[nx][ny] = true;
                    if (arr[nx][ny].equals("K")) cnt++;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return cnt == kCnt;
    }

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
