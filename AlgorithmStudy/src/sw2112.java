import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2112 { //보호필름 
	static int d,w,k,map[][],temp[][],ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	int testcase=  Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		st = new StringTokenizer(bf.readLine());
		d = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[d][w];
		temp = new int[d][w];
		for(int i =0; i<d; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<w; j++) {
			 map[i][j]= Integer.parseInt(st.nextToken());
			 temp[i][j] = map[i][j];
			}
		}
		ans = 2100000000;
		func(0,0);
		System.out.println("#"+t+" "+ans);
	}
	
	bf.close();
 }
 
 static void func(int n,int c) {
	 if(n>=d) {
		 boolean check = false;
		 boolean finish = false;
		 int select ;
		 for(int j=0; j<w; j++) {
			 select = map[0][j];
			 check = false;
			 int count = 1;
			 for(int i=1; i<d; i++) {
				 if(map[i][j] == select) count++;
				 else {
					 select = map[i][j];
					 count = 1;
				 }
				 if(count == k) {
					 check = true;
					 break;
				 }
			 }
			 if(check==false){
				 finish = true;
				 break;
			 }
		 }
		 if(finish == false){
			 ans = Math.min(ans, c);
		 }
		 return;
	 }
	 
	 if(c >=ans) return;
	 
	  func(n+1,c);
	  for(int j =0; j<w; j++) {
			map[n][j] = 0;
	  }
	  func(n+1,c+1);
	  for(int j =0; j<w; j++) {
			map[n][j] = 1;
	  
	  }
	  func(n+1,c+1);
	  for(int j =0; j<w; j++){
		  map[n][j] = temp[n][j];
	  }
	  
//	  for(int p = 0 ; p <2; p++) {
//	   for(int j =0; j<w; j++) {
//		map[n][j] = p;
//	   }
//	   func(n+1,c+1);
//	   for(int j =0; j<w; j++) {
//		   map[n][j] = temp[n][j];
//	   }
//	  }
 }
 
}