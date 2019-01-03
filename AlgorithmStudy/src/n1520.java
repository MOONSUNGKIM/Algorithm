import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n1520 { // 내리막길 
	static int n , m ,map[][],d[][];
	static final int dx[] = {0,0,1,-1},dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	d = new int[n][m];
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			d[i][j] = -1;
		}
	}
	System.out.println(func(0,0));
	bf.close();
}
 static int func(int a, int b) {
	 if(a == n-1 && b== m-1) return 1;
	 if(d[a][b] !=-1) return d[a][b];
	 d[a][b] =0 ;
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m) {
			 if(map[a][b] > map[x][y] ){
				d[a][b] += func(x,y); 
			 }
		 }
	 }
	 return d[a][b];
 }
 
}
