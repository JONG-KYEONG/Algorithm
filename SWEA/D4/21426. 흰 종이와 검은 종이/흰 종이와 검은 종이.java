import java.util.*;
import java.io.*;

class Solution {
	static int t;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2= Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4= Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int x5 = Integer.parseInt(st.nextToken());
			int y5 = Integer.parseInt(st.nextToken());
			int x6 = Integer.parseInt(st.nextToken());
			int y6 = Integer.parseInt(st.nextToken());
			
			if(i==2) {
				y2=y2;
			}
			
			if(x1 >= x3 && x2 <= x4 && y1 >= y3 && y2 <= y4) { // 첫번째가 아예 덮을 때
				sb.append("NO"+ "\n");
				continue;
			}
			
			if(y1 >= y3 && y2 <= y4) { // 좌우 덮
				
				if(x1 >= x3 && x4 <= x2 && x4 >= x1) {
					x1 = x4;
				}
				else if(x3 <= x2 && x3 >= x1 && x4 >= x2) {
					x2 = x3;
				}
				
			}
			else if(x1 >= x3 && x2 <= x4) {
				
				if(y1 >= y3 && y4 <= y2 && y4 >= y1) {
					y1 = y4;
				}
				else if(y3 <= y2 && y3 >= y1 && y4 >= y2) {
					y2 = y3;
				}
				
			}
			
			
			
			if(x1 >= x5 && x2 <= x6 && y1 >= y5 && y2 <= y6) { // 두번째가 아예 덮을 때
				sb.append("NO"+ "\n");
				continue;
			}
			sb.append("YES" + "\n");
			
		}
		
		System.out.print(sb);
	}

}
