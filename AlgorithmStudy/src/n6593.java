import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class n6593 { // 상범빌딩 
	static int L,R,C,sh,sx,sy,v[][][],ans;
	static char map[][][];
	static boolean finish;
    static class state{ 
    	int h,x,y,cnt;
    	state(int h , int x , int y, int cnt){
    		this.h= h ;
    		this.x=x;
    		this.y=y;
    		this.cnt = cnt;
    	}
    }
    static Queue<state> q ;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	while(true) {
		st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		if(L==0 && R==0 && C==0) break;
		map = new char[L][R][C];
		sh =0 ; sx = 0; sy=0;
		for(int k =0; k<L; k++) {
			for(int i =0; i<R; i++) {
				String str = bf.readLine();
				for(int j=0; j<C; j++) {
					map[k][i][j] = str.charAt(j);
					if(map[k][i][j] == 'S') {
						sh = k;
						sx = i;
						sy = j;
					}
				}
			}
			bf.readLine();
		}
		ans = 0;
		finish = false;
		// 
		func();
		if(finish){
			System.out.println("Escaped in "+ans+" minute(s).");
		}else System.out.println("Trapped!");
	}
	
	bf.close();
 }
 static final int dh[]={1,-1,0,0,0,0},dx[] = {0,0,0,0,1,-1}, dy[] ={0,0,1,-1,0,0};
 static void func() {
	 v = new int[L][R][C];
	 q = new LinkedList<>();
	 q.offer(new state(sh,sx,sy,0));
	 v[sh][sx][sy] = 1;
	 while(!q.isEmpty()) {
		 state p = q.poll();
		 if(map[p.h][p.x][p.y] == 'E') {
			 ans = p.cnt;
			 finish = true;
			 break;
		 }
		 
		 for(int i =0; i<6; i++) {
			 int h = p.h+dh[i];
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 if(h>=0 && x>=0 && y>=0 && h<L && x<R && y<C) {
				 if(v[h][x][y] == 0) {
					 v[h][x][y] = 1;
					 if(map[h][x][y] !='#'){
						 q.offer(new state(h,x,y,p.cnt+1));
					 }
				 }
			 }
		 }
		 
	 }
 }
 
}
