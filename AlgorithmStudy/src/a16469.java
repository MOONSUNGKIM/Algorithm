import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class a16469 { //소년점프 
	
	// 세명이 만나는 지점 
	
	static int n,m,map[][],num[][][];
	static class state{
		int x,y,cnt;
		state(int x, int y, int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	static Queue<state> q;
public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n+1][m+1];
	num = new int[3][n+1][m+1];
	
	for(int i =1; i<=n; i++){
		String str = bf.readLine();
		for(int j =1; j<=m; j++){
			map[i][j] = str.charAt(j-1)-48;
			for(int k =0; k<3; k++){
				num[k][i][j] = 2100000000;
			}
		}
	}
	for(int i =0; i<3; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		func(i,a,b);
	}
	int min = 2100000000, count=0;
	for(int i =1; i<=n; i++) {
		for(int j =1; j<=m; j++) {
			if(map[i][j] == 1) continue; // 세명이 만날수 없다 .
			int three = 0;
			int time = 0;
			for(int k =0; k<3; k++) {
				if(num[k][i][j] == 2100000000) break; // 세명이 만날 수 없다 
				time = Math.max(time, num[k][i][j]); // 세명이 만난지점에 가장 큰 값이 만나는데 걸린 시간 
				three++;
			}
			if(three !=3) continue; // 세명이 만날 수 없다.
			if(min>time) {
				min = time;
				count = 1;
			}else if(min == time) {
				count++;
			}
		}
	}
	
	if(min == 2100000000) min = -1;
	System.out.println(min);
	if(min !=-1){
	System.out.println(count);
	}
	bf.close();
	
 }
 static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};

 static void func(int number,int a, int b) {
	 q=  new LinkedList<>();
	 q.offer(new state(a,b,0));
	 num[number][a][b] = 0;
	 
	 while(!q.isEmpty()) {
		 state p = q.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 if(x>=1 &&y>=1 && x<=n && y<=m){
				 if(map[x][y] ==0) {
					 if(num[number][x][y] > (p.cnt+1)) {
						 num[number][x][y] = (p.cnt+1);
						 q.offer(new state(x,y,(p.cnt+1)));
					 }
				 }
			 }
		 }
	 }
	 
 }
 
}
