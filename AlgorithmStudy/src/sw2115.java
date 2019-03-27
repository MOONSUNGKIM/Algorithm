import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2115 { //벌꿀채취
	static int n , m , c,map[][],visit[][],ans1,ans2,result;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));	
	StringTokenizer st ;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++) {
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		visit = new int[n][n];
		ans1=0;
		//A가 선택
		for(int i =0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j+(m-1) < n) {
					ans1=0;
					for(int k=j; k<j+m; k++) {
						visit[i][k] = 1;
					}
					func(1,i,j,0,0,0);
					//B가 선택 
					for(int i2=0; i2<n; i2++) {
						for(int j2=0; j2<n; j2++) {
							if(visit[i2][j2] ==0){
								if(j2+(m-1) < n){
									boolean check = false;
									for(int k2= j2; k2<j2+m; k2++) {
										if(visit[i2][k2] == 1){
											check = true;
											break;
										}
									}
									
									if(check==false) {
										ans2 = 0;
										func(2,i2,j2,0,0,0);
										
//										System.out.println(i+"/"+j +"///" + i2+"/"+j2 + "///"+ans1 +"//"+ans2);
										result = Math.max(result,(ans1+ans2));
									}
									
								}
							}
						}
					}

				}
			}
		}
		System.out.println("#"+t+" "+result);
	}
	bf.close();
 }
 
 
 static void func(int who, int a, int b, int idx, int s, int r) {
 if(idx >= m) return;
 if(s+map[a][b] <= c) {
	 int ts = map[a][b] * map[a][b];
	 if(who == 1){
		 ans1 = Math.max(ans1, r+ts);
	 }else if(who==2){
		 ans2 = Math.max(ans2, r+ts);
	 }
	 func(who,a,b+1,idx+1,s+map[a][b], r+(map[a][b]*map[a][b]) );
 }
 func(who,a,b+1,idx+1,s,r);
}
 
 
}
