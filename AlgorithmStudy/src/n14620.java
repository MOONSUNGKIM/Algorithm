import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14620 { // 꽃길
	static int n ,map[][],v[][],ans,sum;
	
 public static void main(String[] args)  throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	map = new int[n][n];
	v = new int[n][n];
	
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	sum = 0;
    ans = 2100000000;
    func(0);
	System.out.println(ans);
	bf.close();
	
 }
 
 static final int dx[] = {0,0,0,1,-1}, dy[]={0,1,-1,0,0};
 
 static void func(int cnt) {
	 if(cnt >= 3) {
		ans = Math.min(ans, sum);
		return; 
	 }

	 for(int i =0; i<n; i++) {
		 for(int j =0; j<n; j++) {
			 
				 boolean check = false;
				 for(int d =0; d<=4; d++) {
					 int x = i+dx[d];
					 int y = j+dy[d];
					 
					 if(x<0 || y<0 || x>=n || y>=n) {
						 check = true;
						 break;
					 }
					 
					 else if(x>=0 && y>=0 && x<n && y<n) {
						 if(v[x][y] != 0) {
							check = true;
							break;
						 }
					 }
				 }
				 
				 if(check == false) {

				  for(int d =0; d<=4; d++) {
					  int x = i+dx[d];
					  int y = j+dy[d];
					  if(x>=0 && y>=0 && x<n && y<n) {
						  if(v[x][y] ==0){
						  v[x][y] = 1;
						  sum+=map[x][y] ;
						  }
					  }
				  }
				  
				  func(cnt+1);
				  for(int d =0; d<=4; d++) {
					  int x = i+dx[d];
					  int y = j+dy[d];
					  if(x>=0 && y>=0 && x<n && y<n) {
						  v[x][y] = 0;
						  sum-=map[x][y] ;
					  }
				  }
				 
			 }
			 
		 }
	 }
	 
 }
 
}
