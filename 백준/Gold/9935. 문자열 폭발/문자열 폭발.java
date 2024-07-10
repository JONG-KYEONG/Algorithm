import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		int l = bomb.length();
		
		Stack <Character> s = new Stack<>();
		
        for(int i = 0 ; i < str.length(); i++){
		    s.push(str.charAt(i));
		    if(s.size() >= l){
		        boolean isSame = true;
		            
		        for(int j = 0 ; j < l; j++){
		            if(s.get(s.size() - l + j) != bomb.charAt(j)){
	                    isSame = false;
	                    break;
	                }
	            }
	            if(isSame){
	                for(int j = 0 ; j < l; j++){
	                    s.pop();
	                }
	            }
	        }
		}
                   
		StringBuilder sb = new StringBuilder();
		for(Character c : s){
		    sb.append(c);
		}

		System.out.println(sb.length()==0? "FRULA" : sb.toString());
	}
}