import java.util.*;
import java.io.*;

class Main {
    static int arr[][];
    static int n,m,oil;
    static Taxi taxi;
    static boolean can;
    static List<Destination> d = new ArrayList<>();

    static int dx[] = {-1,0,0,1};
    static int dy[] = {0,-1,1,0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());
        arr = new int [n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int tx = Integer.parseInt(st.nextToken());
        int ty = Integer.parseInt(st.nextToken());
        taxi = new Taxi(tx-1, ty-1, oil);

        for(int i = 2; i <= m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            arr[x-1][y-1] = i;
            d.add(new Destination(dx-1,dy-1));
        }
        
        can = true;
        
        for(int i = 0 ; i < m ; i++) {
        	if(!can) {
        		break;
        	}
        	int cus = findCus();
        	goDest(d.get(cus-2));
        }

        if(can) {
        	System.out.println(taxi.o);
        }
        else {
        	System.out.println("-1");
        }
    }
    
    public static int findCus() {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(taxi.x, taxi.y, 0));
    	int cx = Integer.MAX_VALUE;
    	int cy = Integer.MAX_VALUE;
    	int cdis = Integer.MAX_VALUE;
    	int ci = 0;
    	boolean visited[][] = new boolean[n][n];
    	visited[taxi.x][taxi.y] = true;
    	
    	if(arr[taxi.x][taxi.y] >= 2) {
    		int tmp = arr[taxi.x][taxi.y];
    		arr[taxi.x][taxi.y] = 0;
    		return tmp;
    	}
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		int x = node.x;
    		int y = node.y;
    		for(int i = 0; i < 4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
    				if(visited[nx][ny]) {
    					continue;
    				}
    				if(arr[nx][ny] >= 2) {
    					if(node.dis+1 < cdis) {
    						cx = nx;
    						cy = ny;
    						cdis = node.dis+1;
    						ci = arr[nx][ny];
    					}
    					else if(node.dis+1 == cdis) {
    						if(nx<cx) {
        						cx = nx;
        						cy = ny;
        						cdis = node.dis+1;
        						ci = arr[nx][ny];
    						}
    						else if(nx==cx) {
    							if(ny<cy) {
            						cx = nx;
            						cy = ny;
            						cdis = node.dis+1;
            						ci = arr[nx][ny];
    							}
    						}
    					}
    				}
    				else if(arr[nx][ny] == 0){
    					q.add(new Node(nx, ny, node.dis + 1));
    				}
    				visited[nx][ny] = true;
    			}
    		}
    	}
    	
    	taxi.x = cx;
    	taxi.y = cy;
    	taxi.o -= cdis;
    	if(taxi.o < 0) {
    		can = false;
    	}
    	if(cx == Integer.MAX_VALUE) {
    		System.out.println("-1");
    		System.exit(0);
    	}
    	arr[cx][cy] = 0;
    	return ci;
    }
    
    public static void goDest(Destination destination) {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(taxi.x, taxi.y, 0));
    	boolean visited[][] = new boolean[n][n];
    	visited[taxi.x][taxi.y] = true;
    	
//    	if(taxi.x == destination.x && taxi.y == destination.y) {
//    		return;
//    	}
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
			int x = node.x;
			int y = node.y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if(visited[nx][ny]) {
    					continue;
    				}
					if(nx == destination.x && ny == destination.y) {
						taxi.o -= (node.dis+1);
						taxi.x = nx;
						taxi.y = ny;
						
						if(taxi.o < 0) {
							can = false;
						}
						taxi.o += (node.dis+1)*2;
						return;
					}
					else if(arr[nx][ny] != 1){
						q.add(new Node(nx, ny, node.dis + 1));
					}
					visited[nx][ny] = true;
				}
			}
			
			
    	}
    	
    	System.out.println("-1");
		System.exit(0);
    }
    
    static class Node{
        int x, y, dis;
        Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    static class Destination{
        int x, y;
        Destination(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Taxi{
        int x;
        int y;
        int o;
        Taxi(int x, int y, int o){
            this.x = x;
            this.y = y;
            this.o = o;
        }
    }

}

