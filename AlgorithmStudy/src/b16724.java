import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b16724 { // 피리 부는 사나이 
	static int n, m ,safe;
	static char map[][];
	static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
	static int v[][];
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new char[n][m];
	for(int i =0; i<n; i++) {
		String str = bf.readLine();
		for(int j =0; j<m; j++) {
			map[i][j] = str.charAt(j);
		}
	}
	
	v = new int[n][m];
	safe = 0;
	int number = 1;
	for(int i =0; i<n; i++) {
		for(int j =0; j<m; j++) {
			if(v[i][j] == 0) {
				v[i][j] = number;
				check = false;
				safe++;
				func(i,j,number);
				number++;
			}
		}
	}
	
	System.out.println(safe);
	bf.close();
	
 }
 static boolean check ;
 static void func(int a, int b,int number) {
	 
	 if(check) return;
	 int dir = 0;
	 if(map[a][b] == 'R') {
		dir = 0;
	 }else if(map[a][b] =='L') {
		 dir = 1;
	 }else if(map[a][b] =='D') {
		 dir = 2;
	 }else if(map[a][b] =='U') {
		 dir = 3;
	 }
	 
	 int x = a+dx[dir];
	 int y = b+dy[dir];
	 
	 if(v[x][y] == 0) {
		 v[x][y] = number;
		 func(x,y,number);
	 }
	 
	 else if(v[x][y] <number) {
		 check = true;
		 safe --;
		 return;
	 }
	 //
	 
 }
 
}
