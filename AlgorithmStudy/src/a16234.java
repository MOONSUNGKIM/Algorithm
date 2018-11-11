import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class a16234 { // 인구이동 (Samsung DS 1)
	static int N , L , R, map[][],v[][] , totalman;
	static class state {
		int x, y;
		state(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static Queue<state> q,temp;
	static final int dx[] = {0,0,1,-1},dy[]= {1,-1,0,0};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	N = Integer.parseInt(st.nextToken());
	L = Integer.parseInt(st.nextToken());
	R = Integer.parseInt(st.nextToken());
	map = new int[N][N];
	
	for(int i =0; i<N; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j=0; j<N; j++) {
			map[i][j] =Integer.parseInt(st.nextToken());
		}
	}
	
	int result = 0;
	
	while(true) {
		v = new int[N][N];
		boolean check = false;
		for(int i =0; i<N; i++) {
			for(int j =0; j<N; j++) {
				
				if(v[i][j] == 1) continue;
				
				int now = map[i][j];
				for(int k =0; k<4; k++) {
					int x= i+dx[k];
					int y= j+dy[k];
				    if(x>=0 && y>=0 && x<N && y<N) {
				     if(v[x][y] == 0){
				    	int num = Math.abs(now-map[x][y]);
				    	if(num >=L && num<=R) {
				    	 v[i][j] = 1;	
				    	}
				     }
				     if(v[i][j] ==1) break;
				    }
				}
				
				if(v[i][j] ==0) continue;
				
				temp = new LinkedList<>();
				q = new LinkedList<>();
				temp.offer(new state(i,j));
				q.offer(new state(i,j));
				
				totalman = map[i][j];
				func();
				if(temp.size() > 1) check = true;
				
				//map change
				
				int blocknumber = temp.size();
				
				while(!temp.isEmpty()) {
					state p = temp.poll();
					map[p.x][p.y] = totalman/blocknumber;
				}
				
			}
		}
		
		if(check==false) break;
		result +=1;
	}
	
	System.out.println(result);
	bf.close();
	
 }
 
 static void func() {
	while(!q.isEmpty()) {
		state p = q.poll();
		for(int i =0; i<4; i++) {
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			if(x>=0 && y>=0 && x<N && y<N) {
				if(v[x][y] ==0) {
					int num = Math.abs(map[x][y] - map[p.x][p.y]);
					if(num >=L && num<=R) {
						v[x][y] = 1;
						temp.offer(new state(x,y));
						q.offer(new state(x,y));
						totalman += map[x][y];
					}
				}
			}
		}
	}
 }
 
}
