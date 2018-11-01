import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class a1952 {
	static int d[],mon[],ans;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++){
		d = new int[4];
		mon = new int[12];
		st = new StringTokenizer(bf.readLine());
		for(int i =0; i<4; i++){
			d[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i =0; i<12; i++){
			mon[i] = Integer.parseInt(st.nextToken());
		}
		ans = d[3];
		func(0,0);
		System.out.println("#"+t+" "+ans);
	}
	bf.close();
}
 
 static void func(int idx, int money) {
	 if(idx>=12) {
		 ans = Math.min(ans, money);
		 return;
	 }
	 //1day
	 func(idx+1,money+(mon[idx]*d[0]));
	 //1month
	 func(idx+1,money+d[1]);
	 //3month
	 func(idx+3,money+d[2]);
	 
	 
 }
}
