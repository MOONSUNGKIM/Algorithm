import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class a3190 {
	static int n , k, map[][],order[],body[][],ans;
	static class sw{
		int x , y;
		sw(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static Deque<sw> dq;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	n = Integer.parseInt(bf.readLine());
	map = new int[n+1][n+1];
	body = new int[n+1][n+1];
	k = Integer.parseInt(bf.readLine());
	for(int i =0; i<k; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		map[a][b] = 1;
	}
	int L = Integer.parseInt(bf.readLine());
	order = new int[10001];
	for(int i =0; i<L; i++){
		st = new StringTokenizer(bf.readLine());
		int time = Integer.parseInt(st.nextToken());
		char ch = st.nextToken().charAt(0);
		if(ch == 'D') order[time] = 1; //right
		else if(ch == 'L') order[time] = -1; //left
	}
	dq = new ArrayDeque<>();
	dq.offerLast(new sw(1,1));
	body[1][1] = 1;
	ans = 0;
	func(1,1,0,1);
	System.out.println(ans);
	bf.close();
 }
 
 static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
 
 /*
 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
 */
 
 
 static void func(int a, int b, int d,int time) {
	 int x= a+dx[d];
	 int y= b+dy[d];
	 if(x>=1 && y>=1 && x<=n && y<=n) {
		 if(body[x][y] == 1) {
			 ans = time;
			 return;
		 }
		 if(map[x][y] !=0){ // 사과있다면 .
			 map[x][y] = 0;
			 dq.offerLast(new sw(x,y));
			 body[x][y] = 1;
		 }else {
			 dq.offerLast(new sw(x,y));
			 body[x][y] = 1;
			 sw p = dq.pollFirst();
			 body[p.x][p.y] = 0;
		 }
		 
		 if(order[time]!=0){
			 d = rotation(order[time],d);
		 }
		 
		func(x,y,d,time+1);
		 
	 }
	 else if(x==0 || y==0 || x>n || y>n) {
		 ans = time;
		 return;
	 }
 }
 
 static int rotation(int c, int d) {
	 if(c == 1) { // right 
		 if(d==0) return 2;
		 else if(d==1) return 3;
		 else if(d==2) return 1;
		 else if(d==3) return 0;
		 else return -999;
	 }
	 else if(c==-1) { //left
		if(d==0) return 3;
		else if(d==1) return 2;
		else if(d==2) return 0;
		else if(d==3) return 1;
		else return - 9999;
	 }else return -999;
 }
 
}
