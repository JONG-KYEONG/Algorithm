import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, r, result;
	static boolean [] visited;  // 진실을 말해야하는 파티장 기록
	static List<Integer> arr[];  // 참석한 사람 번호 저장
	static HashSet<Integer> liar = new HashSet<>();

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = 0;
		
		visited = new boolean[m];
		arr = new List[m];
		Queue<Integer> q = new LinkedList<>(); 
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		for(int i = 0; i < r; i++) {
			int x = Integer.parseInt(st.nextToken());
			q.add(x);
			liar.add(x);
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
			for(int j = 0; j < x; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			for(int i = 0; i < m; i++) {
				if(!visited[i]) {
					if(arr[i].contains(t)) {
						for(Integer ch : arr[i]) {
							if(!liar.contains(ch)) {
								liar.add(ch);
								q.add(ch);
							}
						}
						visited[i] = true;
					}
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			if(!visited[i]) {
				result++;
			}
		}

		System.out.println(result);
	    
    }
	
}