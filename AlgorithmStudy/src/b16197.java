import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b16197 {//두동전 
	
	static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
	static int n,m,ans;
	static char map[][];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new char[n][m];
	int sx=0,sy=0,sx2=0,sy2=0;
	int check = 0;
	for(int i =0; i<n; i++) {
		String str = bf.readLine();
		for(int j =0; j<m; j++) {
			map[i][j] = str.charAt(j);
			if(map[i][j] == 'o') {
				if(check == 0){
				sx = i;
				sy = j;
				check =1;
				}else{
					sx2= i;
					sy2 = j;
				}
			}
		}
	}
	
	ans = 2100000000;
	for(int i =0; i<4; i++) {
	 func(sx,sy,sx2,sy2,i,0,0,1);
	}
	
	if(ans == 2100000000) ans = -1;
	System.out.println(ans);
	bf.close();
 }
 
 //방향을 매개변수 안넣고 for(int i =0; i<4; i++)로 해서 이동하게  하면 안됨
 static void func(int a1, int b1, int a2, int b2,int dir, int check1, int check2, int cnt) {
	 if(cnt >10) {
		 return;
	 }
	 
		int x1 = a1;
		int y1 = b1;
		int x2 = a2;
		int y2 = b2;
		
		if(check1 ==0) {
		 x1= a1+dx[dir];
		 y1= b1+dy[dir];
		 if(x1>=0 && y1>=0 && x1<n && y1<m) {
			if(map[x1][y1] =='#'){
			 x1=  a1;
			 y1 = b1;
			}
		 }else {
			 check1 = 1; 
		 }
		}
		
		if(check2 == 0) {
			x2= a2+dx[dir];
			y2= b2+dy[dir];
			 if(x2>=0 && y2>=0 && x2<n && y2<m) {
				 if(map[x2][y2]=='#') {
				  x2= a2;
				  y2= b2;
				 }
			 }else {
				 check2 = 1;
			 }	
		}

		if((check1==1 && check2==0) || (check1 ==0 && check2==1)) {
			 ans = Math.min(cnt, ans);
			 return;
		}
		
		else if(check1==0 && check2==0) {
	     for(int i =0; i<4; i++){
		  func(x1,y1,x2,y2,i,check1,check2,cnt+1);
	     }
		}
		
 }
 
}
