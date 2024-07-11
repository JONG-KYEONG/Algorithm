import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int arr[];
    static int dp[];
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    arr = new int [n+1];
	    dp = new int [n+1];
	    Arrays.fill(dp, 1);
	    
	    for(int i = 1; i < n+1; i++){
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	    
	    for(int i = 1; i < n+1; i++){
	        for(int j = 1; j < i; j++){
	            if(arr[i] > arr[j]){
	                dp[i] = Math.max(dp[i], dp[j]+1);
	            }
	        }
	    }
	    
	   int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }
	    
		System.out.println(n-maxLength);
	}
	
}