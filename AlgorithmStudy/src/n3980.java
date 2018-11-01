import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n3980 { //선발명단
	static int map[][], ps[],max;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++) {
		map = new int[11][11];
		
		for(int i =0; i<11; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<11; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ps = new int[11];
		max = 0;
		func(0,0);
		System.out.println(max);
	}
	
	bf.close();
 }
 
 static void func(int idx, int sum) {
	 if(idx>=11){
		 max = Math.max(max, sum);
		 return;
	 }
	 
	 for(int i =0; i<11; i++) {
		if(ps[i] ==0) { 
		 if(map[idx][i] !=0){
			 ps[i] = 1;
			 func(idx+1,sum+map[idx][i]);
			 ps[i] = 0;
		 }
		}
	 }
 }
 
}
