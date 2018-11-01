import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14503 { // 로봇청소기
	static int n , m , map[][],v[][],sx,sy,sd;
	static final int dx[] = {-1,0,1,0},dy[]={0,1,0,-1}; // 북동남서 
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	st = new StringTokenizer(bf.readLine());
	sx = Integer.parseInt(st.nextToken());
	sy = Integer.parseInt(st.nextToken());
	sd = Integer.parseInt(st.nextToken());

	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++) {
			map[i][j]= Integer.parseInt(st.nextToken());
		}
	}
	int ans = 0;
	v = new int[n][m];
	func(sx,sy,sd);
	
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			if(v[i][j]==1 && map[i][j] ==0 ) {
				ans++;
			}
		}
	}
	
	System.out.println(ans);
	bf.close();
}
 
 /*
 현재 위치를 청소한다.
 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
 */
 
 static boolean finish;
 static void func(int a, int b, int d) {
	 if(finish) return;
	 int dir = d;
	 v[a][b] = 1;
	 
	 //4dir 
	 boolean check = false;
	 
	 for(int i =0; i<4; i++) {
		dir = rotation(dir);
		int x = a+dx[dir];
		int y = b+dy[dir];
		if(x>=0  && y>=0 && x<n && y<m) {
			if(map[x][y] ==0) { // 청소안한곳이고 벽이아닌곳
			 if(v[x][y] ==0){
				v[x][y] = 1;
				check = true;
				func(x,y,dir);
				break;
			 }
			}
		}
	 }
	 
	 if(!check) {
		 dir = reverse(d);
		 int x = a+dx[dir];
		 int y = b+dy[dir];
		 if(x>=0 && y>=0 && x<n && y<m){
			 if(map[x][y] == 0 ) {
				 func(x,y,d);
			 }
			 else {
				 finish=  true;
				 return;
			 }
		 }
	 }
	 
 }
 
 // 북동남서 
 static int rotation(int dir) {
	 if(dir ==0) return 3;
	 else if(dir==1) return 0;
	 else if(dir==2) return 1;
	 else if(dir==3) return 2;
	 else return - 99999;
 }
 
 static int reverse(int dir){
	 if(dir ==0) return 2;
	 else if(dir==1 ) return 3;
	 else if(dir==2) return 0;
	 else if(dir==3) return 1;
	 else return -99999;
 }
 
 
}
