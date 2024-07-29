import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static int arr[];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    arr = new int [n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < n; i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    ArrayList <Integer> answer = new ArrayList<>();
	    
	    for(int i = n - 1; i >= 0; i--){
	        answer.add(arr[i],i+1);
	    }
	    
	    for(Integer number : answer){
	        System.out.print(number + " ");
	    }
	    
	    
	
	}
}