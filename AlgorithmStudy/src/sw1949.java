import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sw1949 { //등산로조성 
	static int n,k, map[][],top[][],topidx,max,v[][],ans,count;
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		max = 0;
		for(int i =0; i<n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<n; j++){
				map[i][j]  = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		topidx = 0;
		top= new int[5][2];
		for(int i =0; i<n; i++){
			for(int j =0; j<n; j++){
				if(map[i][j] == max){
					top[topidx][0] = i;
					top[topidx][1] = j;
					topidx++;
				}
			}
		}
		v = new int[n][n];
		ans = 0;
		//start 
		for(int i =0; i<topidx; i++) {
			int a = top[i][0];
			int b = top[i][1];
			count = 0;
			v[a][b] = 1;
			func(a,b,1,0);
			v[a][b] = 0;
			ans = Math.max(ans, count);
		}
		
		System.out.println("#"+t+" "+ans);
		
	}
	bf.close();
 }
 static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
 
 static void func(int a, int b, int cnt, int cut) {
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
			if (x >= 0 && y >= 0 && x < n && y < n) {
					if(v[x][y] == 0){
						v[x][y] = 1;
						if(cut ==0){
						 for(int r=0; r<=k; r++) {
							 map[x][y] -=r;
							if(map[x][y] < map[a][b]) {
								count = Math.max(count, cnt+1);
								if(r ==0){
									func(x,y,cnt+1,cut);
								}else{
								func(x,y,cnt+1,cut+1);
								}
							}
							map[x][y] +=r;
						 }
						}
						else{
							if(map[x][y] < map[a][b]) {
								count = Math.max(count, cnt+1);
								func(x,y,cnt+1,cut);
							}
						}
						
						v[x][y] = 0;
					}
				
			}
	 }
 }
 
}
