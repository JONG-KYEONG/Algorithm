import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int game[][] = new int [6][3];
    static int result;
    static boolean isValidMatchCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 0; tc < 4; tc++){
            st = new StringTokenizer(br.readLine());
            result = 0;
            isValidMatchCount = true;

            for(int i = 0; i < 6; i++){
                game[i][0] = Integer.parseInt(st.nextToken());
                game[i][1] = Integer.parseInt(st.nextToken());
                game[i][2] = Integer.parseInt(st.nextToken());

                if(game[i][0] + game[i][1] + game[i][2] != 5){
                    isValidMatchCount = false;
                }
            }

            if(isValidMatchCount){
                search(0, 1);
            }
            sb.append(result + " ");
        }

        System.out.println(sb);

    }

    static void search(int idx, int nxt) {
        if (result == 1) return; // 유효한 결과를 찾았을 경우 즉시 종료

        if (idx == 5) { // 마지막 국가까지 탐색 완료 시 유효한 결과
            result = 1;
            return;
        }

        int nextIdx = idx;
        int nextNxt = nxt + 1;
        if (nxt == 5) {
            nextIdx = idx + 1;
            nextNxt = idx + 2;
        }

        // idx 국가가 nxt 국가를 이긴 경우
        if (game[idx][0] > 0 && game[nxt][2] > 0) {
            game[idx][0]--;
            game[nxt][2]--;
            search(nextIdx, nextNxt);
            game[idx][0]++;
            game[nxt][2]++;
        }

        // idx 국가와 nxt 국가가 무승부인 경우
        if (game[idx][1] > 0 && game[nxt][1] > 0) {
            game[idx][1]--;
            game[nxt][1]--;
            search(nextIdx, nextNxt);
            game[idx][1]++;
            game[nxt][1]++;
        }

        // idx 국가가 nxt 국가에게 패배한 경우
        if (game[idx][2] > 0 && game[nxt][0] > 0) {
            game[idx][2]--;
            game[nxt][0]--;
            search(nextIdx, nextNxt);
            game[idx][2]++;
            game[nxt][0]++;
        }
    }

}