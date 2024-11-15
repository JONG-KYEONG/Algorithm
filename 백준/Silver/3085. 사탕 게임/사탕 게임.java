import java.util.*;
import java.io.*;

public class Main {
    static char arr[][];
    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        result = 0;
        arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                char tmp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = tmp;
                check();
                arr[i][j+1] = arr[i][j];
                arr[i][j] = tmp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                char tmp = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = tmp;
                check();
                arr[j+1][i] = arr[j][i];
                arr[j][i] = tmp;
            }
        }

        System.out.print(result);
    }

    public static void check(){
        for(int i = 0; i < n; i++){
            int idx = 1;
            int idx2 = 1;
            char ch = 'A';
            char ch2 = 'A';
            for(int j = 0; j < n; j++){
                if(arr[i][j] != ch){
                    result = Math.max(idx, result);
                    ch = arr[i][j];
                    idx = 1;
                }
                else{
                    idx++;
                }

                if(arr[j][i] != ch2){
                    result = Math.max(idx2, result);
                    ch2 = arr[j][i];
                    idx2 = 1;
                }
                else{
                    idx2++;
                }
            }
            result = Math.max(idx, result);
            result = Math.max(idx2, result);
        }
    }
}
