import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw5656 {
	static int n , w, h,map[][],v[],temp[][],block,ans;
	static class sw {
		int x,y,c;
		sw(int x, int y, int c) {
			this.x=x;
			this.y=y;
			this.c=c;
		}
	}
	
	static Queue<sw> q;
	static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		temp = new int[h][w];
		v = new int[n];
		block =0;
		
		for(int i =0; i<h; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
				if(map[i][j] !=0) block ++;
			}
		}
		
		ans= 2100000000 ;
		func(0);
		System.out.println("#"+t+" "+ans);
		
	}
	
	bf.close();
 }
 
 static void func( int cnt) {
	 if(cnt >= n){
		 shot();
		 return;
	 }
	 
	 for(int j =0; j<w; j++) {
			 v[cnt] = j;
			 func(cnt+1);
			 v[cnt] = 0;
	 }
 }
 
 static void shot() {
	 int removeblock = 0;
	 for(int k =0; k<n; k++) {
		 q = new LinkedList<>();
		 int b = v[k];
		 
		 //내리다 벽돌만났을시 
		 for(int i =0; i<h; i++) {
			 if(map[i][b] !=0) {
				 q.offer(new sw(i,b,map[i][b]));
			   break;
			 }
		 }
		
		 while(!q.isEmpty()) {
			 sw p = q.poll();
			 for(int d=0; d<4; d++) {
				for(int r =0; r<p.c; r++) {
					int x = p.x+dx[d]*r;
					int y = p.y+dy[d]*r;
					if(x>=0 && y>=0 && x<h && y<w) {
						if(map[x][y] != 0) {
							 removeblock +=1;
							 q.offer(new sw(x,y,map[x][y]));
							 map[x][y] = 0;
						}
					}
				}
			 }
		 }
		 
		 down();
	  
	 }
	
	 ans = Math.min(ans , block - removeblock); 
	 init();
 }
 
 static void down() {
	 for(int j =0; j<w; j++) {
		for(int i =h-1; i>=0; i--) {
			 if(map[i][j] == 0) {
				 for(int k = i-1; k>=0; k--) {
					 if(map[k][j] != 0) {
						 map[i][j] = map[k][j];
						 map[k][j] = 0;
						 break;
					 }
				 }
			 }
	    }
	 }
 }
 
 //중요 
 static void init() {
	 for(int i =0; i<h; i++) {
		 for(int j =0; j<w; j++) {
			 map[i][j] = temp[i][j];
		 }
	 }
 }
 
}
