import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b16433 { // 주디와 당근농장 
	static int n ,r,c,v[][];
	static class state implements Comparable<state>{
		int x,y,che,cnt;
		state(int x, int y,int che, int cnt){
			this.x=x;
			this.y=y;
			this.che = che;
			this.cnt = cnt;
		}
		public int compareTo(state s){
			if(this.cnt > s.cnt) return 1;
			else if(this.cnt == s.cnt) return 0;
			else return -1;
		}
	}
	static PriorityQueue<state> pq;
	static final int dx[] = {0,0,1,-1},dy[] = { 1,-1,0,0 };
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	r = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	v = new int[n+1][n+1];
	v[r][c] = 2;
	pq = new PriorityQueue<>();
	pq.offer(new state(r,c,0,0));
	while(!pq.isEmpty()){
		state p = pq.poll();
		for(int i =0; i<4; i++){
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			if(x>=1 && y>=1 && x<=n && y<=n) {
				if(v[x][y] == 0) {
					int che = p.che;
					if(che == 0) {
						v[x][y] = 1;
						che = 1;
					}
                    else if(che==1) {
                    	v[x][y] = 2;
                    	che = 0;
                    }
					
					pq.offer(new state(x,y,che,p.cnt+1));
				}
			}
		}
	}
	StringBuilder sb = new StringBuilder();
	for(int i =1; i <= n; i++){
		for(int j =1; j<=n; j++){
			if(v[i][j] == 1){
				sb.append(".");
			}else if(v[i][j] ==2){
				sb.append("v");
			}
		}
		sb.append("\n");
	}
	System.out.println(sb.toString());
	bf.close();
 }
}
