import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2186 { // 문자판 
	static int n, m , k ,d[][][];
	static char map[][];
	static String result ;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
	map = new char[n][m];
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j);
		}
	}
	result = bf.readLine();
	d = new int[n][m][result.length()];
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			for(int h =0 ; h<result.length(); h++){
				d[i][j][h] = -1;
			}
		}
	}
	int ans = 0;
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			if(map[i][j] == result.charAt(0)){
				ans += func(i,j,0);
			}
		}
	}
	
	System.out.println(ans);
	bf.close();
 }
 static final int dx [] = {0,0,1,-1},dy[] = {1,-1,0,0};
 
 static int func(int a, int b, int c) {
	 if(c == result.length()-1) {
		 return 1;
	 }
	 if(d[a][b][c] !=-1) return d[a][b][c];
	 d[a][b][c] = 0;
	 for(int i =0; i<4; i++){
	  for(int h=1; h<=k; h++) {
		  int x = a+dx[i]*h;
		  int y = b+dy[i]*h;
		  if(x>=0 && y>=0 && x<n && y<m){
			  if(map[x][y] == result.charAt(c+1)){
				  d[a][b][c] += func(x,y,c+1);
			  }
		  }
	  }
	 }

	 return d[a][b][c];
 }
 
}
