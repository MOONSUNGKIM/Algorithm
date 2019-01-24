import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class a16569 { // 화산쇄설류 
	//js는화산못지나감//js있는 첫위치가 가장높은곳일 수 있다 그래서 카운트도 21억으로 초기화주면안됨 

	static int m,n,v,sx,sy,map[][],manvisit[][],voltime[][],maxh, ansh ,ansc;
	
	static class state implements Comparable<state> {
		int x,y,c;
		state(int x, int y, int c) {
			this.x=x;
			this.y=y;
			this.c=c;
		}
		public int compareTo(state s) {
			if(this.c > s.c) return 1;
			else if(this.c==s.c) return 0;
			else return -1;
		}
	}
	
	static PriorityQueue<state> vpq,pq;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in)); 
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	v = Integer.parseInt(st.nextToken());
	st = new StringTokenizer(bf.readLine());
	sx = Integer.parseInt(st.nextToken());
	sy = Integer.parseInt(st.nextToken());
	map = new int[n+1][m+1];
	voltime = new int[n+1][m+1];
	manvisit = new int[n+1][m+1];
	maxh = 0;
	ansc = 0;
	for(int i =1; i<=n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =1; j<=m; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
			voltime[i][j] = 2100000000;
			maxh = Math.max(maxh, map[i][j]);
		}
	}
	
	ansh = map[sx][sy]; // 현위치

	//vol
	
	vpq = new PriorityQueue<>();
	for(int i =0; i<v; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		vpq.offer(new state(a,b,t));
		voltime[a][b] = t;
		manvisit[a][b] = 1;
	}
	
	vol();
	//
	
	//js
	if(ansh == maxh){ //재상이가 가장높은곳에 있는경우
		System.out.println(ansh+" "+ansc);
	}
	else {
		func();
		System.out.println(ansh +" "+ansc);
	}
	
	bf.close();
 }
 
 static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
 static void vol() {
	 int v[][] = new int[n+1][m+1];
	 while(!vpq.isEmpty()) {
		 state vp = vpq.poll();
		 for(int i =0; i<4; i++) {
			 int x = vp.x+dx[i];
			 int y = vp.y+dy[i];
			 if(x>=1 && y>=1 && x<=n && y<=m) {
				 if(v[x][y] == 0) {
					 v[x][y] = 1;
					 voltime[x][y] = (vp.c+1);
					 vpq.offer(new state(x,y,vp.c+1));
				 }
			 }
		 }
	 }
 }
 
 static void func() {
	 pq = new PriorityQueue<>();
	 pq.offer(new state(sx,sy,0));
	 manvisit[sx][sy] = 1; // js 위치 
	 while(!pq.isEmpty()){
		 state p = pq.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 if(x>=1 && y>=1 && x<=n && y<=m){
				 if(manvisit[x][y] == 0) {
					 manvisit[x][y] = 1;
					 if( voltime[x][y] > (p.c+1)) {
						 if(map[x][y] > ansh ){
							 ansh = map[x][y];
							 ansc = (p.c+1);
						 }
						 else if(map[x][y] == ansh){
							 ansc = Math.min(ansc, (p.c+1));
						 }
						 pq.offer(new state(x,y,(p.c+1)));
					 }
				 }
			 }
		 }
	 }
	 
 }
 
}
