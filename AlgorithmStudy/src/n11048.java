import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n11048 { //이동하기 dp
 static int n ,m,map[][],d[][];
 
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n+1][m+1];
	d = new int[n+1][m+1];
	for(int i =1; i<=n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =1; j<=m; j++){
			map[i][j]  =  Integer.parseInt(st.nextToken());
			//d[i][j] = -1;
		}
	}
	//Top down
	//d[n-1][m-1] = map[n-1][m-1];
	//System.out.println(Topdown(0,0));
	
	//Bottom up
	System.out.println(Bottomup());
	bf.close();
}
 static final int dx[] ={ 0,1}, dy[]={1,0};
 static int Topdown(int a, int b) {
	 if(d[a][b] !=-1) return d[a][b];
	 d[a][b] = 0;
	 for(int i =0; i<2; i++) {
		 int x =a+dx[i];
		 int y =b+dy[i];
		 if(x>=1 && y>=1 && x<=n && y<=m) {
			 d[a][b] = Math.max(d[a][b], Topdown(x,y)+map[a][b]);
		 }
	 }
	 
	 return d[a][b];
 }
 
 static int Bottomup(){
	 for(int i =1; i<=n; i++){
		 for(int j =1; j<=m; j++){
			d[i][j] = d[i][j-1] + map[i][j];
			if(d[i][j] < d[i-1][j] + map[i][j]){
				d[i][j] = d[i-1][j]+map[i][j];
			}
		 }
	 }
	 
	return  d[n][m];
 }
 
}
