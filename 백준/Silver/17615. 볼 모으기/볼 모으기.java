import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static String arr[];
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    String balls = br.readLine();
	    
	    int subCnt = 0;
		boolean sw = false;
		for(int i=0;i<n;i++) {
			if(sw && balls.charAt(i) == 'R') {
				subCnt++;
				continue;
			}
			
			if(balls.charAt(i) == 'B') sw = true;
		}
		min = Math.min(min, subCnt);
		
		subCnt = 0;
		sw = false;
		for(int i=0;i<n;i++) {
			if(sw && balls.charAt(i) == 'B') {
				subCnt++;
				continue;
			}
			
			if(balls.charAt(i) == 'R') sw = true;
		}
		min = Math.min(min, subCnt);
		
				
		subCnt = 0;
		sw = false;
		for(int i=n-1;i>=0;i--) {
			if(sw && balls.charAt(i) == 'B') {
				subCnt++;
				continue;
			}
			
			if(balls.charAt(i) == 'R') sw = true;
		}
		min = Math.min(min, subCnt);
	    
		subCnt = 0;
		sw = false;
		for(int i=n-1;i>=0;i--) {
			if(sw && balls.charAt(i) == 'R') {
				subCnt++;
				continue;
			}
			
			if(balls.charAt(i) == 'B') sw = true;
		}
		min = Math.min(min, subCnt);
	    
	    
	    
		System.out.println(min);
	}
	
}