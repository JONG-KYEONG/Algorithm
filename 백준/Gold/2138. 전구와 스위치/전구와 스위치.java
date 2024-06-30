import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int arr1 [], arr2[], answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        arr2 = new int[n];
        answer = new int[n];
        String st1 = br.readLine();
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(String.valueOf(st1.charAt(i)));
            arr1[i] = tmp;
            arr2[i] = tmp;
        }

        arr2[0] = 1 - arr2[0];
        arr2[1] = 1 - arr2[1];
        String st2 = br.readLine();
        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(String.valueOf(st2.charAt(i)));
        }

        int a = 0;
        int b = 1;
        for(int i = 0; i < n-1; i++){
            if(arr1[i] != answer[i]){
                arr1[i] = 1 - arr1[i];
                arr1[i + 1] =  1 - arr1[i + 1];
                if (i != n-2)
                    arr1[i+2] = 1-arr1[i+2];
                a++;
            }
        }
        for(int i = 0; i < n-1; i++){
            if(arr2[i] != answer[i]) {
                arr2[i] = 1 - arr2[i];
                arr2[i + 1] =  1 - arr2[i + 1];
                if (i != n-2)
                    arr2[i+2] = 1-arr2[i+2];
                b++;
            }
        }
        if(arr1[0] != answer[0] || arr1[1] != answer[1] || arr1[n-1] != answer[n-1]){
            a = Integer.MAX_VALUE;
        }
        if(arr2[0] != answer[0] || arr2[1] != answer[1] || arr2[n-1] != answer[n-1]){
            b = Integer.MAX_VALUE;
        }
        if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Math.min(a,b));
    }
}