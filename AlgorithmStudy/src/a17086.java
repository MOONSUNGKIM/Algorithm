import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class a17086 { // 아기상어 2 
	static int n , m ,map[][],v[][],cnt,ans;
	static final int dx[] ={ 0,0,1,-1,1,1,-1,-1}, dy[] = {1,-1,0,0,1,-1,1,-1};
	static class state{
		int x, y, c;
		state(int x, int y, int c){
			this.x=x;
			this.y=y;
			this.c=c;
		}
		
	}
	static Queue<state> q;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	
	for (int i = 0; i < n; i++) {
		st = new StringTokenizer(bf.readLine());
		for (int j = 0; j < m; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				cnt = 0;
				func(i, j);
				ans = Math.max(ans, cnt);
			}
		}
	}
	
	System.out.println(ans);
	bf.close();
	
 }
 
 static void func(int a, int b) {
	 v = new int[n][m];
	 q = new LinkedList<>();
	 q.offer(new state(a,b,0));
	 v[a][b] = 1;
	 while(!q.isEmpty()) {
		 state p = q.poll();
		 if(p.c != 0 && map[p.x][p.y] == 1) {
			 cnt = (p.c);
			 break;
		 }
		 for(int i =0; i<8; i++) {
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			if(x>=0 && y>=0 && x<n && y<m){
				if(v[x][y] == 0){
					v[x][y] = 1;
					q.offer(new state(x,y,p.c+1));
				}
			}
		 }
	 }
	 
 }
 
}
