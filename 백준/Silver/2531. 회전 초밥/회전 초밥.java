import java.util.*;
import java.io.*;

public class Main
{
    static int n, d, k, c;
    static int arr[], eating[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        eating = new int [d+1];



        System.out.println(check());
    }

    public static int check() {
        int max = 0;
        int current = 0;
        int r = k-1;

        for(int i = 0; i < k; i++){
            if(eating[arr[i]] ==0){
                current++;
                eating[arr[i]]++;
            }
            else{
                eating[arr[i]]++;
            }
        }
        if(eating[c] == 0){
            max = Math.max(max, current + 1);
        }
        else{
            max = Math.max(max, current);
        }

        for(int l = 0; l < n; l++){
            r = (r + 1) % n;
            if(arr[l] == arr[r]){
                continue;
            }
            else{
                if(eating[arr[l]] == 1){
                    current--;
                }
                if(eating[arr[r]] == 0){
                    current++;
                }

                eating[arr[l]]--;
                eating[arr[r]]++;

            }

            if(eating[c] == 0){
                max = Math.max(max, current + 1);
            }
            else{
                max = Math.max(max, current);
            }

        }


        return max;

    }
}