import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cursor;
	static int n;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb.append(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		cursor = sb.length();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String text = st.nextToken();
			
			if(text.equals("L")) {
				if(cursor > 0) {
					cursor--;
				}
				
			}
			else if(text.equals("D")) {
				if(cursor < sb.length()) {
					cursor++;
				}
			}
			else if(text.equals("B")) {
				if(cursor>0) {
					sb.deleteCharAt(cursor-1);
					cursor--;
				}
				
			}
			else{
				if(cursor == sb.length()) {
					sb.append(st.nextToken());
					cursor++;
				}
				else {
					sb.insert(cursor, st.nextToken());
					cursor++;
				}
				
			}
		}

		System.out.println(sb);
		
	}

}
