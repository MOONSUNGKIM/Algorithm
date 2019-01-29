import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a14948{ // 군대탈출하기 
	static class state implements Comparable<state> {
		int x, y, min,d,cnt, wp;
		state(int x, int y, int cnt,int min,int wp) {
			this.x=x;
			this.y=y;
			this.cnt = cnt;
			this.min = min;
			this.wp = wp;
		}		
		public int compareTo(state s) {
			if(this.min > s.min) return 1;
			else if(this.min == s.min) {				
				return 0;				
			}
			else return -1;
		}
		
	}
	
	static PriorityQueue<state> pq;
	static int n, m ,map[][],v[][][];
	static final int dx[] = {0,0,1,-1},dy[]= {1,-1,0,0};
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	v = new int[n][m][2];
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	pq = new PriorityQueue<>();
	pq.offer(new state(0,0,0,map[0][0],0)); // x,y,cnt,min,wp
	v[0][0][0] = 0;
	v[0][0][1] = 0;
	int ans = 0;
	while(!pq.isEmpty()) {
		state p = pq.poll();
		if(p.x == n-1 && p.y == m-1) {
			ans = p.min;
			break;
		}
		for(int i =0; i<4; i++) {
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			if(x>=0 && y>=0 && x<n && y<m) {
				
				//일반
				if(v[x][y][p.wp] ==0) {
					v[x][y][p.wp] = 1;
						int min = Math.max(p.min, map[x][y]); 
						pq.offer(new state(x,y,(p.cnt+1),min,p.wp));					
				}
				//무기사용 
				if(p.wp ==0) {
					int x2 = x+dx[i];
					int y2 = y+dy[i];
					if(x2>=0 && y2>=0 && x2<n && y2<m) {
						if(v[x2][y2][1]==0) {
							v[x2][y2][1] = 1;
							int min = Math.max(p.min,map[x2][y2]);
							pq.offer(new state(x2,y2,(p.cnt+1),min,1));
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

