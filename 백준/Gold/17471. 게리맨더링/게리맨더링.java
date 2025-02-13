import java.io.*;
import java.util.*;

class Main{
	static StringBuilder sb = new StringBuilder();
	static int n, max, total;
	static List<Integer> al[];
	static boolean sungu[];
	static int count[];
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		max = Integer.MAX_VALUE;
		total = 0;
		n = Integer.parseInt(br.readLine());
		count = new int [n+1];
		sungu = new boolean[n+1];
		al = new ArrayList[n+1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n ; i++) {
			al[i] = new ArrayList<>();
			count[i] = Integer.parseInt(st.nextToken());
			total += count[i];
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				al[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		dfs(1, 0);
		
			
		if(max == Integer.MAX_VALUE)
			max = -1;
		
		System.out.println(max);
		br.close();
	}
	
	static void dfs(int idx, int cnt) {
		if(cnt > 0) {
//			check(cnt);
		}
		
		if(idx > n) {
			check(cnt);
			return;
		}
		
		sungu[idx] = true;
		dfs(idx+1, cnt+1);
		sungu[idx] = false;
		dfs(idx+1, cnt);
	}
	
	static void check(int cnt) {
//		System.out.println();
//		for(int i = 1; i <= n; i++) {
//			if(sungu[i]) {
//				System.out.print(i + " ");
//			}
//		}
//		System.out.println("선거구 검증");
		for(int i = 1; i <= n; i++) {
			if(sungu[i]) {
				int ccnt = 0;
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				boolean visited[] = new boolean[n+1];
				while(!q.isEmpty()) {
					int idx = q.poll();
					
					if(visited[idx]) {
						continue;
					}
					
					visited[idx] = true;
//					System.out.print(idx + " ");
					ccnt++;
					
					for(Integer next : al[idx]) {
						if(sungu[next]) {
							q.add(next);							
						}
					}
				}
				if(cnt != ccnt)
					return;
				else
					break;
			}
		}
		
//		System.out.println("선거구 검증 완료");
//
//		System.out.println();
//
//		System.out.println();
		
		for(int i = 1 ; i <= n; i++) {
			if(!sungu[i]) {
				int ccnt = 0;
				int sum = 0;
				boolean visited[] = sungu.clone();
				
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				
				while(!q.isEmpty()) {
					int idx = q.poll();
					if(visited[idx]) {
						continue;
					}
					visited[idx] = true;
					ccnt++;
					sum += count[idx];
					
					for(Integer next : al[idx]) {
						q.add(next);
					}
				}
				
				if(ccnt + cnt == n) {  // 선거구 분할 성공
					max = Math.min(max, Math.abs((total - sum)-sum));
//					System.out.println("선거구 분할 완료 " + (sum));
//					for(int d = 1; d <= n; d++) {
//						if(sungu[d]) {
//							System.out.print(d + " ");
//						}
//					}
//					System.out.println();
					return;
				}
				else return;
			}
		}
	}
}