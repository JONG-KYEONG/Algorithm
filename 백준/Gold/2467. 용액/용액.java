import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int arr [] = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;
        int l = 0;
        int r = 0;
        while(true){
            if(left >= right)
                break;
            int tmp = arr[left] + arr[right];
            if(Math.abs(tmp) <= Math.abs(result)){
                l = arr[left];
                r = arr[right];
                result = tmp;
            }

            if(Math.abs(arr[left]) < Math.abs(arr[right]))
                right--;
            else
                left++;
        }

        System.out.println(l + " " + r);
    }
}
