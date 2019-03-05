import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3752_2 { //가능한 시험점수 
	// -> 메모리 절약 (멤버변수에 temp배열 제거)
	static int n ,arr[],ans,v[],max;
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int testcase = Integer.parseInt(bf.readLine());
		for(int t=1; t<=testcase ; t++) {
			n = Integer.parseInt(bf.readLine());
			arr= new int[n];
			max = 0;
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max += arr[i];
			}
			v= new int[max+1];
			v[0] = 1;
			ans = 0;
			func(0);
			
			System.out.println("#"+t+" "+ans);
		}
		bf.close();
	}
	
	static void func(int idx) {
		if(idx >= n){
			check(v);
			return;
		}
		for(int i =max-1; i>=0;i --) {
			if(v[i] == 1) {
				v[i+arr[idx]] = 1;
			}
		}
		func(idx+1);
		
	}
	static void check(int v[]) {
		for(int i =0; i<=max; i++){
			if(v[i] == 1) ans++;
		}
	}
}