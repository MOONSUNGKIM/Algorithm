import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15683 {
	static int n , m , map[][], cctv[][], cctvIndex,v[][],ans;
	static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st  = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	
	cctvIndex = 0;
	
	map = new int[n][m];
	cctv = new int[9][2];// cctv좌표 저장 
	
	v = new int[n][m];
	
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j]>=1 && map[i][j] <=5){
				cctv[cctvIndex][0] = i;
				cctv[cctvIndex][1] = j;
				cctvIndex ++;
				v[i][j] = 1;
			}
		}
	}
	
	ans = 2100000000;
	func(0);
	
	System.out.println(ans);
	bf.close();
 }
 
 static void func(int idx) {
	 if(idx >= cctvIndex){
		 int cnt = 0;
		 for(int i =0; i<n; i++) {
				for(int j =0; j<m; j++) {
					if(map[i][j] == 0 && v[i][j] ==0 ){
						cnt++;
					}
				}
			}	 
		 ans = Math.min(ans, cnt);
		 return;
		 
	 }
	 
		 int a = cctv[idx][0];
		 int b = cctv[idx][1];
		 if(map[a][b]==1) { // 0,1,2,3  // 동서남북 
			 for(int i =0; i<4; i++){
				 move(a,b,i,0);
				 func(idx+1);
				 move(a,b,i,1);
			 }
		 }else if(map[a][b] == 2) { //(0,1),(2,3)
			 for(int i =0; i<4; i+=2){
				 move(a,b,i,0);
				 move(a,b,i+1,0);
				 func(idx+1);
				 move(a,b,i,1);
				 move(a,b,i+1,1);
			 }
		 }else if(map[a][b] == 3) { // (0,3),(0,2),(1,2),(1,3)
			 move(a,b,0,0);
			 move(a,b,3,0);
			 func(idx+1);
			 move(a,b,0,1);
			 move(a,b,3,1);
			 //
			 move(a,b,0,0);
			 move(a,b,2,0);
			 func(idx+1);
			 move(a,b,0,1);
			 move(a,b,2,1);
			 //
			 move(a,b,1,0);
			 move(a,b,2,0);
			 func(idx+1);
			 move(a,b,1,1);
			 move(a,b,2,1);
			 //
			 move(a,b,1,0);
			 move(a,b,3,0);
			 func(idx+1);
			 move(a,b,1,1);
			 move(a,b,3,1);
			 
		 }else if(map[a][b] == 4) {//(0,1,3),(0,2,3),(0,1,2),(1,2,3)
			 move(a,b,0,0);
			 move(a,b,1,0);
			 move(a,b,3,0);
			 func(idx+1);
			 move(a,b,0,1);
			 move(a,b,1,1);
			 move(a,b,3,1);
			 //
			 move(a,b,0,0);
			 move(a,b,2,0);
			 move(a,b,3,0);
			 func(idx+1);
			 move(a,b,0,1);
			 move(a,b,2,1);
			 move(a,b,3,1);
			 //
			 move(a,b,0,0);
			 move(a,b,1,0);
			 move(a,b,2,0);
			 func(idx+1);
			 move(a,b,0,1);
			 move(a,b,1,1);
			 move(a,b,2,1);
			 //
			 move(a,b,1,0);
			 move(a,b,2,0);
			 move(a,b,3,0);
			 func(idx+1);
			 move(a,b,1,1);
			 move(a,b,2,1);
			 move(a,b,3,1);
			 
		 }else if(map[a][b] == 5) { // (0,1,2,3)
			 for(int i =0; i<4; i++){
				 move(a,b,i,0);
			 }
			 func(idx+1);
			 for(int i =0; i<4; i++){
				 move(a,b,i,1);
			 }
		 }
		 
 }
 
 static void move(int a, int b, int dir, int check) {
	 
	if(dir == 0|| dir==1) {
		for(int k=1; k<m; k++) {
			int x = a+dx[dir]*k;
			int y = b+dy[dir]*k;
			if(x>=0 && y>=0 && x<n && y<m) {
			 if(map[x][y] == 6) break; // 벽 
			 if(check ==0) {
			   v[x][y] +=1;
			 }
			 else if(check==1) {
				 v[x][y] -=1;
			 }
			}
			else break;
		}
	}
	
	else if(dir==2 || dir==3) {
		for(int k=1; k<n; k++) {
			int x = a+dx[dir]*k;
			int y = b+dy[dir]*k;
			if(x>=0 && y>=0 && x<n && y<m) {
			 if(map[x][y] == 6) break; // 벽 
			 if(check ==0) {
			  v[x][y] +=1;
			 }else if(check==1){
				 v[x][y] -=1;
			 }
			}
			else break;
		}
	}
 }
 
}
