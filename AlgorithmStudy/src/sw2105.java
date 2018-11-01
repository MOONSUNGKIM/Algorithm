import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2105 { //디저트카페
	static int n ,map[][],ans,v[],sx,sy;
	static final int dx[] = {1,1,-1,-1},dy[]={1,-1,-1,1};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	 for(int t=1; t<=testcase ; t++) {
	  n = Integer.parseInt(bf.readLine());
	  map = new int[n][n];
	  v = new int[101];
	  for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j=0; j<n; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	   }
	  ans = -1;
	  for(int i =0; i<n; i++){
		  for(int j =0; j<n; j++){
			  sx = i;
			  sy=  j;
	         func(sx,sy,0,0,0);
		  }
	  }
	  System.out.println("#"+t+" "+ans);
	 }
	 
    bf.close();
 }
 
 static void func(int a, int b, int d,int sum,int c) {
	 if(a == sx && b== sy && d==3 && c >0) {
		 ans = Math.max(c, ans);
		 return;
	 }
	 if(d>=4) return;
	  int x =a+dx[d];
	  int y =b+dy[d];
	  if(x>=0 && y>=0 && x<n && y<n) {
		 if(v[map[x][y]] ==0) {
			 v[map[x][y]] = 1;
		  func(x,y,d,sum+map[x][y],c+1);
		  func(x,y,d+1,sum+map[x][y],c+1);
		  
		  v[map[x][y]] = 0;
		  return;
		 }else return;
	  }
	 
 }
 
}
