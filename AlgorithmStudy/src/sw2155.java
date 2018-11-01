import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sw2155 { //벌꿀 채취 
	static int n , m, c, arr[][],v[][], one, two, ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
	 st = new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 c = Integer.parseInt(st.nextToken());
	 arr =new int[n][n];
	 v = new int[n][n];
	 for(int i =0; i<n; i++) {
		 st = new StringTokenizer(bf.readLine());
		 for(int j =0; j<n; j++) {
			 arr[i][j] = Integer.parseInt(st.nextToken());
		 }
	 }
	 
	 ans = 0;
	 for(int i =0; i<n; i++) {
		 for(int j =0; j<n; j++) {
			 if((j+(m-1))<n) {
				for(int k=j; k<(j+m); k++) {
					v[i][k] = 1;
				}
				one = 0;
			    func(i,j,(j+m),0,0,1);
				for(int i2=0; i2<n; i2++) {
					for(int j2=0; j2<n; j2++) {
						if(j2+(m-1) <n) {
							two = 0;
							boolean check = false;
							for(int k2= j2; k2<(j2+m); k2++) {
								if(v[i2][k2] == 1) {
									check = true;
									break;
								}
							}
							
							if(check==false) {
								 //
								func(i2,j2,(j2+m),0,0,2);
								ans = Math.max(ans, (one+two));
								
							}
						}
					}
				}
				
				//
				for(int k=j; k<(j+m); k++) {
					v[i][k] = 0;
				}
				
			 }
		 }
	 }
	 
	 System.out.println("#"+t+" "+ans);
	}
	bf.close();
 }
 
 static void func(int a, int b, int limit, int sum, int powsum, int select) {
	 if(b>=limit) {
		 return;
	 }
	 if(select == 1) {
		 if(sum+arr[a][b] <= c) {
			  one = Math.max(one, powsum+(arr[a][b] * arr[a][b]));
			 func(a,b+1,limit,sum+arr[a][b],powsum+(arr[a][b]*arr[a][b]),select);
		 }
		 
			 func(a,b+1,limit,sum,powsum,select);
		 
	 }
	 else if(select == 2) {
		 if(sum+arr[a][b] <= c) {
			 two = Math.max(two, powsum+(arr[a][b] * arr[a][b]));
			 func(a,b+1,limit,sum+arr[a][b],powsum+(arr[a][b]*arr[a][b]),select);
		 }
			 func(a,b+1,limit,sum,powsum,select);
		 
	 }
	 
 }
 
}
