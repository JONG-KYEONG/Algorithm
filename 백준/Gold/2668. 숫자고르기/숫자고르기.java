import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int arr[];
    static boolean have[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        have = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++){
            have[arr[i]] = true;
        }

        while(true){
            boolean isChange = false;
            boolean tmp [] = new boolean[n+1];
            for(int i = 1; i <= n; i++){
                if(have[i]){
                    tmp[arr[i]] = true;
                }
            }
            for(int i = 1; i <= n; i++){
                if(have[i] != tmp[i])
                    isChange = true;
            }
            have = tmp.clone();
            if(!isChange)
                break;
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++){
             if(have[i])
                 cnt++;
        }
        System.out.println(cnt);
        for(int i = 1; i <= n; i++){
            if(have[i])
                System.out.println(i);
        }
    }
}