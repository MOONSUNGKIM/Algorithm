import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n16236 {
	static int n , time, map[][],sx,sy,minx,miny,mincount, v[][], check[][],ssize;
	static boolean finish;
	static class sw {
		int x, y, cnt;
		sw(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt = cnt;
		}
	}
	static Queue<sw> q;
 public static void main(String[] args) throws IOException {
	 
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	map = new int[n][n];
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j] == 9) {
				sx = i;
				sy = j;
			}
		}
	}
	
	time = 0;
	ssize = 2; 
	int pick = 1;
	while(true) {
		check = new int[n][n];
		check[sx][sy] = 1;
		minx =-1;
		miny =-1;
		mincount = 2100000000;
		
		while(true) {
			finish = false;
			func();
			if(finish == false) break;
		}
		
		if(mincount == 2100000000) break;
		
		if(pick == ssize) {
			pick = 0;
			ssize ++;
		}
		pick++;
		map[sx][sy] = 0;
		
		map[minx][miny] = 0;
		sx = minx;
		sy = miny;
		time += mincount;
	}
	
	System.out.println(time);
}
 
 static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
 
 static void func() {
	v = new int[n][n];
	q = new LinkedList<>();
	q.offer(new sw(sx,sy,0));
	v[sx][sy] = 1;
	
	while(!q.isEmpty()) {
		sw p = q.poll();
		for(int i =0; i<4; i++) {
			int x = p.x+dx[i];
			int y=  p.y+dy[i];
			if(x>=0 && y>=0 && x<n && y<n) {
				if(map[x][y] !=0 && map[x][y] <ssize && check[x][y] == 0 ) {
					check[x][y] = 1;
					finish = true;

					if(mincount > (p.cnt+1)) {
						mincount = (p.cnt+1);
						minx = x;
						miny = y;
					}
					
					else if(mincount == (p.cnt+1)) {
						if(minx > x) {
							minx = x;
							miny = y;
						}
//						else if(minx==x) {
//							if(miny >y){
//								miny= y;
//							}
//						}
					}
					
					break;
				}
				
				if(map[x][y] == 0 || map[x][y] == ssize) {
					if(v[x][y]==0) {
						v[x][y] = 1;
						q.offer(new sw(x,y,(p.cnt+1)));
					}
				}
				
			}
		}
		
	}
 }
 
}
