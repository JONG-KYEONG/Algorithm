import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int testcase = 1; testcase <= tc; testcase++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int parking[] = new int[n];
            int car[] = new int [m+1];

            Queue<Integer> wait = new LinkedList<>();
            int isParking[] = new int[n];

            for(int i = 0; i < n; i++){
                parking[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 1; i <= m; i++){
                car[i] = Integer.parseInt(br.readLine());
            }

            int result = 0;

            for(int i = 0; i < 2 * m; i++){
                int p = Integer.parseInt(br.readLine());

                if(p > 0){
                    int tmp = -1;
                    for(int j = 0; j < n; j++){
                        if(isParking[j] == 0){
                            tmp = j;
                            break;
                        }
                    }

                    if(tmp == -1){
                        wait.add(p);
                    }
                    else {
                        isParking[tmp] = p;
                        result += (parking[tmp] * car[p]);
                    }
                }
                else {
                    int tmp = -1;
                    p = p * (-1);
                    for(int j = 0; j < n; j++){
                        if(isParking[j] == p){
                            isParking[j] = 0;
                            tmp = j;
                            break;
                        }
                    }

                    if(!wait.isEmpty()){
                        int idx = wait.poll();
                        isParking[tmp] = idx;
                        result += (parking[tmp] * car[idx]);
                    }
                }

            }

            sb.append("#" + testcase + " " + result +"\n");


        }

        System.out.print(sb);
    }
}
