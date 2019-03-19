import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class a15787 { // 기차가 어둠을 헤지고 은하수를  
	static int n , m ;
	static StringBuilder arr[];
	static HashSet<String> hs;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr= new StringBuilder[100001];
	for(int i =1; i<=100000; i++){
		arr[i] = new StringBuilder();
		arr[i].append("00000000000000000000");
	}
    
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int ord = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int x = 0;
		if(ord <= 2 ) {
			x = Integer.parseInt(st.nextToken());
		}
		if(ord == 1){
			if(arr[a].charAt(x-1) == '0'){
				arr[a].replace(x-1, x, "1");
			}
		}else if(ord==2){
			if(arr[a].charAt(x-1) == '1'){
				arr[a].replace(x-1, x, "0");
			}
		}else if(ord==3){
			StringBuilder sb = new StringBuilder();
			sb.append("0");
			sb.append(arr[a]);
			sb.replace(20, 21, ""); // 0 추가 했기때문에  19, 20 에 +1씩해서  
			arr[a] = sb;
		}else if(ord==4){
			StringBuilder sb = new StringBuilder();
			sb.append(arr[a]);
			sb.replace(0, 1, "");
			sb.append("0");
			arr[a] = sb;
		}
		
//		System.out.println("taril: "+a + " num: "+x+"  "+arr[a].toString());
	}
	
	hs = new HashSet<String>();
	for(int i =1; i<=n; i++) {
		hs.add(arr[i].toString());
	}
	System.out.println(hs.size());
	bf.close();
 }
}
