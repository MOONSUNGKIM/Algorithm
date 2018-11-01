import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a5566 {
	static int n , m , arr[],now,end;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	
	arr = new int[n+10000000];
	for(int i =10000000; i<10000000+n; i++) {
		arr[i] = Integer.parseInt(bf.readLine());
	}

	//order
	int order[] = new int[m];
	for(int i =0; i<m; i++) {
		order[i] = Integer.parseInt(bf.readLine());
	}
	//
	now = 10000000;
	end = 10000000+(n-1);
	int ans = 0;
	
	for(int i =0; i<m; i++) {
		now+=order[i];
		if(now >=end){ // 
			ans = (i+1);
			break;
		}
		if(arr[now]>0) {
			now+=arr[now];
			if(now >=end){ // 
				ans = (i+1);
				break;
			}	
		}else if(arr[now]<0) {
			now-=Math.abs(arr[now]);
		}
		
	}
	
	System.out.println(ans);
	bf.close();
	
 }
}
