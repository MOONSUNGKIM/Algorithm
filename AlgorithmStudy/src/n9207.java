import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class n9207 { // 페그솔리테어 
	static final int n = 5, m=9 ;
	static int k, pinnum, minCnt, minPin ;
	static char map[][] ;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int k = Integer.parseInt(bf.readLine());
	int t = 0;
	
	while(true) {
	 map = new char[n][m];
	 pinnum = 0; // pin의 개수 
	 for(int i =0; i<n; i++) {
		 String str = bf.readLine();
		 for(int j =0; j<m; j++) {
			 map[i][j] = str.charAt(j);
			 if(map[i][j] == 'o') pinnum ++; 
		 }
	 }
	 
	 minCnt = 2100000000;
	 minPin = pinnum;
	 
	 func(pinnum, 0);
	 System.out.println(minPin +" " +minCnt);
	 t++;
	 if(t!=k) bf.readLine();
	 
	 if(t == k) break;
	}
	
	bf.close();
 }
 
 static final int dx[]= {0,0,1,-1},dy[]={1,-1,0,0};
 static void func(int pin, int cnt ) { // pin 개수 // 이동횟수
	 if(pin < minPin) { //현재 저장된 pin보다  현재 pin의 개수가 더 적다면 
		 minPin = pin; 
		 minCnt = cnt;
	 }else if(pin == minPin){ // 현재pin개수와 저장된 pin 개수가 같다면 이동횟수 적은거를 저장 
		 minCnt = Math.min(minCnt, cnt);
	 }
	 
	 if(pin == 1 ){ //pin 1개 남았으면끝난것 . 
		 return;
	 }
	 
	 for(int i =0; i<n; i++) {
		 for(int j =0; j<m; j++) {
			 if(map[i][j] == 'o') { //현재 
			   for(int d =0; d<4; d++) { 
				   int x = i+dx[d];
				   int y= j+dy[d];
				   if(x>=0 && y>=0 && x<n && y<m) { 
					   if(map[x][y] =='o'){ // 다음갈 칸이 범위안에있고 'o'이면 
						  int x2 = x+dx[d];
						  int y2 = y+dy[d];
						  if(x2>=0 && y2>=0 && x2<n && y2<m) { 
							  if(map[x2][y2] == '.'){// 그방향으로 다음 한칸 더 간게 범위안에있고 '.'이면 
								  map[i][j] = '.';
								  map[x][y] = '.';
								  map[x2][y2] = 'o'; //3가지를 바꿔주고 
								  
								  func(pin-1, cnt+1);//재귀호출 
								  //back (원상복구)
								  map[i][j] = 'o';
								  map[x][y] = 'o';
								  map[x2][y2] = '.';
							  }
						  }
					   }
				   }
			   }
			 }
		 }
	 }
	 
 }
 
}
