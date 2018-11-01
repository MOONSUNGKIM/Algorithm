import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a15686 { //치킨배달 
	static int n , m , ch[][],chindex, home[][],homeindex,ans,v[]; 
 public static void main(String[] args) throws IOException {
 	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	homeindex = 0;
	chindex = 0;
	home = new int[(2*n)+1][2];
	ch = new int[14][2];
	
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			int k = Integer.parseInt(st.nextToken());
			if(k == 1){//home
				home[homeindex][0] = i;
				home[homeindex][1] = j;
				homeindex++;
			}else if(k==2) {
				ch[chindex][0] = i ;
				ch[chindex][1] = j ;
				chindex ++;
			}
		}
	}
	
	v = new int[m];
	ans = 2100000000;
	func(0,0);
	System.out.println(ans);
	bf.close();
	
 }
 
 static void func(int idx, int pick) {
	 if(pick == m) {
		 solution();
		 return;
	 }
	 if(idx >= chindex) return;
	 v[pick] = idx;
	 func(idx+1,pick+1);
	 func(idx+1,pick);
	 
 }
 
 static void solution() {
	 int distance = 0;
    for(int i =0; i<homeindex;i++) {
    	int dis = 2100000000;
    	int hx = home[i][0];
    	int hy = home[i][1];
    	for(int j=0; j<m; j++) {
    	  int cx = ch[v[j]][0];
    	  int cy = ch[v[j]][1];
    	  dis = Math.min(dis, Math.abs(hx-cx)+Math.abs(hy-cy));
    	}
    	distance += dis; 
    }
    
    ans = Math.min(ans, distance);
 }
 
}
