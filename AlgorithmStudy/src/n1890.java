import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n1890 { // 점프
	static int n ,map[][];
	static long d[][];
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	map = new int[n][n];
	d = new long[n][n];
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			map[i][j]= Integer.parseInt(st.nextToken());
			d[i][j] = -1;
		}
	}
	System.out.println(func(0,0));
	bf.close();
}
 static final int dx[] ={0,1},dy[]={1,0};
 static long func(int a, int b){
	 if(a == n-1 && b== n-1) return 1;
	 if(d[a][b] !=-1) return d[a][b];
	 d[a][b] = 0;
	 for(int i =0; i<2; i++){
		 int x = a+dx[i] * map[a][b];
		 int y = b+dy[i] * map[a][b];
		 if(x>=0 && y>=0 && x<n && y<n){
			 d[a][b] += func(x,y);
		 }
	 }
	 return d[a][b];
 }
}
