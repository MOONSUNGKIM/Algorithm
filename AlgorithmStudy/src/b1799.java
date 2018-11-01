import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1799 { // 비숍 
	static int n , map[][],v[][],xy[][],index,ans;
	static final int dx[] ={-1,0,1,0,1,1,-1,-1},dy[]={0,-1,0,1,-1,1,1,-1};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ; 
	n = Integer.parseInt(bf.readLine());
	map = new int[n][n];
	xy = new int[(n*n)+1][2];
	v = new int[n][n];
	index = 0;
	
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			map[i][j]= Integer.parseInt(st.nextToken());
			if(map[i][j] ==1) {
				xy[index][0] = i;
				xy[index][1] = j;
				index++;
			} else {
				v[i][j] = 1;
			}
		}
	}
	
    ans = 0;
    
	for(int i =0; i<index; i++) {
		int a= xy[i][0];
		int b= xy[i][1];
	    v = new int[n][n];
		cnt = 0;
		v[a][b] = 1;
		func(a,b);
		ans = Math.max(ans, cnt);
	}
	System.out.println(ans);
	bf.close();
 }
 
 static int cnt;
 static void func(int a, int b) {
  if(map[a][b] == 1 &&check(a,b) == false) {
	  cnt++;
	  v[a][b] = 2;
  }
  
  for(int i =0; i<4; i++) {
	  int x = a+dx[i];
	  int y = b+dy[i];
	  if(x>=0 && y>=0 && x<n && y<n) {
		  if( v[x][y] ==0) {
			  v[x][y] = 1;
			  func(x,y);
		  }
	  }
  }
  
 }
 
 static boolean check(int a, int b) {
	  for(int i =4; i<8; i++) {
		  for(int k =1; k<n; k++) {
			  int x = a+dx[i]*k;
			  int y = b+dy[i]*k;
			  if(x>=0 && y>=0 && x<n && y<n) {
				  if(v[x][y] == 2) {
					  return true;
				  }
			  }
		  }
	  }
	  return false;
 }
 
}
