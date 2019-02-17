import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b16933 { //벽부수고 이동하기 3 
	// 4차원 시간초과 
	// 자기위치 대기 큐에넣는것 시간초과 
	// 그래서 밤되는거 기다리지말고 낮이라고 가정하에 지나가고 카운트 + 2해준다 
	static int n , m , k, map[][],v[][][];
	static class state implements Comparable<state> {
		int x, y, c,kc, dn;
		state ( int x, int y, int c,int kc, int dn){
			this.x=x;
			this.y=y;
			this.c= c;
			this.kc=kc;  
			this.dn=dn; 
		}
		public int compareTo(state o) {
			if(this.c> o.c) return 1;
			else if(this.c==o.c) return 0;
			else return -1;
		}
	}
	
	static PriorityQueue<state > pq;
	static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());

	map = new int[n+1][m+1];
	for(int i =1; i<=n; i++) {
		String str = bf.readLine();
		for(int j =1; j<=m; j++) {
			map[i][j] = str.charAt(j-1)-48;
		}
	}
	
	pq = new PriorityQueue<>();
	pq.offer(new state(1,1,1,0,0));
	
	v = new int[n+1][m+1][k+1]; 

	v[1][1][0] = 1;
	v[1][1][0] = 1;
	
	int ans = -1;
	
	while(!pq.isEmpty()) {
		state p = pq.poll();
		if(p.x ==n && p.y == m) {
			ans = p.c;
			break;
		}
		
		for(int i =0; i<4; i++) {
			int x = p.x+dx[i];
			int y=  p.y+dy[i];
			if(x>=1 && y>=1 && x<=n && y<=m) {
				
			 if(map[x][y] ==0) { // move 
				 if(v[x][y][p.kc] == 0 ) {
					 v[x][y][p.kc] = 1;
					 int dn = p.dn;
					 if(dn ==0) dn=1;
					 else if(dn == 1) dn = 0;
					 pq.offer(new state(x, y, (p.c+1), p.kc,dn ));
				 }
			 }else if(map[x][y] == 1) { //not move
				 if((p.dn) == 0){ // 낮일때만 부스는거 가능
					 if( (p.kc+1) <=k && v[x][y][(p.kc+1)] ==0) {
						 v[x][y][(p.kc+1)] = 1;
						 pq.offer(new state(x,y,(p.c+1),(p.kc+1),1));
					 }
				 }else { //밤 -> 낮이되기위해 하루 더 지나야하니 카운트 +2 
					 if((p.kc+1) <=k && v[x][y][(p.kc+1)]== 0) {
						 v[x][y][(p.kc+1)] =1;
						 pq.offer(new state(x,y,(p.c+2),(p.kc+1),1)); // 그대로 -> 낮밤낮 , 밤낮밤 으로 바뀜 
					 }
				 }
			 }
			}
		}
		
	}
	
	System.out.println(ans);
	bf.close();
	
}
 
}
