import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int map [][] = new int[20][20];

    static int dx[] = {0, 1, -1, 1};
    static int dy[] = {1, 1, 1, 0};

public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("Test5.txt"));
        //---------여기에 코드를 작성하세요.---------------//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < 20; i++) {
            for(int j = 1; j < 20; j++) {
                int target = map[i][j];
                int cnt = 1;

                if(target!=0) {
                    for(int d = 0; d < 4; d++) {
                    	cnt = 1;
                        int cx = i - dx[d];
                        int cy = j - dy[d];

                        if(cx >= 1 && cy >= 1 && cx <= 19 && cy <= 19) {
                            if(map[cx][cy] == target) {
                                continue;
                            }
                        }

                        while(true) {
                            int nx = i + dx[d]*cnt;
                            int ny = j + dy[d]*cnt;

                            if(nx >= 1 && ny >= 1 && nx <= 19 && ny <= 19) {
                                if(target == map[nx][ny]) {
                                    cnt++;
//                                	if(i == 15 && j == 14) {
//                                		System.out.println(nx + " " + ny + " " + d + "방향으로 " + cnt);
//                                	}
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                        
                        
                        if(cnt == 5) {
                            System.out.println(target);
                            System.out.print(i + " " + j);
                            return;
                        }
                    }

                    
                }

            }
        }

    System.out.println(0);
}
}