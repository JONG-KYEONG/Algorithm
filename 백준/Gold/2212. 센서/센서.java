import java.io.*;
import java.util.*;

public class Main
{
    static int n, k;
    static int arr[];
    static int length[];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    k = Integer.parseInt(br.readLine());
	    arr = new int [n];
	    length = new int [n-1];
	    int result = 0;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i = 0; i <n; i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	        if(i != 0){
	            length[i-1] = arr[i] - arr[i-1];
	        }
	    }
	    
	    Arrays.sort(arr);
	    
	    for(int i = 1; i <n; i++){
	       length[i-1] = arr[i] - arr[i-1];
	   }
	   
	   Arrays.sort(length);
	   
	   for(int i = 0; i < n - k; i++){
	       result = result + length[i];
	   }
	    
		System.out.println(result);
	}
}