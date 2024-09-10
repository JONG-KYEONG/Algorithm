import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int box[][][];
    static int m, n, h, unRipe;
    static int dx[] = {-1, 0, 1, 0, 0, 0};
    static int dy[] = {0, 1, 0, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};
//    static PriorityQueue<BoxCood> q = new PriorityQueue<>((o1, o2) -> o1.days - o2.days);
    static Queue<BoxCood> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        unRipe = 0;

        box = new int [h][n][m];

        for(int i = 0 ; i < h; i++){
            for(int j = 0 ; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1)
                        q.add(new BoxCood(k,j,i,0));
                    else if(box[i][j][k] == 0)
                        unRipe++;
                }
            }
        }

        System.out.println(boxBfs());

    }
    public static int boxBfs(){
        int cnt = 0;
        int day = 0;
        while (!q.isEmpty()){
            BoxCood boxCood = q.poll();
            day = boxCood.days;
            for(int i = 0; i < 6; i++){
                int nx = boxCood.x + dx[i];
                int ny = boxCood.y + dy[i];
                int nz = boxCood.z + dz[i];
                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny <n && nz < h){
                    if(box[nz][ny][nx] == 0){
                        box[nz][ny][nx] = 1;
                        q.add(new BoxCood(nx, ny, nz, boxCood.days + 1));
                        cnt++;
                    }
                }
            }
        }
        if(cnt == unRipe)
            return day;
        else
            return -1;

    }
    static class BoxCood{
        int x;
        int y;
        int z;
        int days;
        BoxCood(int x, int y, int z, int days){
            this.x = x;
            this.y = y;
            this.z = z;
            this.days = days;
        }
    }
}
