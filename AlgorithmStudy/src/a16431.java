import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class a16431 { // 베시와 데이지
	static int Bx,By,Dx,Dy,Jx,Jy,Bcnt,Dcnt;
	static final int dx[] ={0,0,1,-1,1,1,-1,-1},dy[]={1,-1,0,0,1,-1,1,-1};
	static class state {
		int x, y ,c;
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
	Bx = Integer.parseInt(st.nextToken());
	By = Integer.parseInt(st.nextToken());
	st = new StringTokenizer(bf.readLine());
	Dx =Integer.parseInt(st.nextToken());
	Dy =Integer.parseInt(st.nextToken());
	st = new StringTokenizer(bf.readLine());
	Jx =Integer.parseInt(st.nextToken());
	Jy =Integer.parseInt(st.nextToken());
	q = new LinkedList<>();
	Bcnt = 0;
	q.offer(new state(Bx,By,0));
	func(0);
	q.clear();
	q.offer(new state(Dx,Dy,0));
	Dcnt = 0;
	func(1);
	String result = "";			
	if(Bcnt<Dcnt){
		 result = "bessie";
	}else if(Bcnt == Dcnt){
		result = "tie";
	}else{
		result = "daisy";
	}
	
	System.out.println(result);
	
    bf.close();	
 } 
 
 static void func(int who) {
	 int v[][]= new int[1001][1001];
	 int dirlimit = 8;
	 if(who == 1) {
		 dirlimit = 4;
	 }
	 
	 while(!q.isEmpty()) {
	   state p = q.poll();
	   if(p.x == Jx && p.y == Jy) {
		   if(who == 0){
			   Bcnt = p.c;
		   }else{
			   Dcnt = p.c;
		   }
		   break;
	   }
	   for(int i =0; i<dirlimit; i++) {
		   int x = p.x+dx[i];
		   int y = p.y+dy[i];
		   if(x>=1 && y>=1 && x<1001 && y<1001) {
			   if(v[x][y] == 0) {
				   v[x][y] = 1;
				   q.offer(new state(x,y,p.c+1));
			   }
		   }
	   }
	 }
	 
 }
 
}
