import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class n5568 {
	static int n , m ,arr[],ans,v[];
	static HashSet<String> hs;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	m = Integer.parseInt(bf.readLine());
	arr =new int[n];
	v = new int[n];
	for(int i =0; i<n; i++) {  
	 arr[i] = Integer.parseInt(bf.readLine());	
	}
	hs = new HashSet<>();
	func(0,"");
	System.out.println(ans);
	bf.close();
}
 
 static void func(int cnt,String s ) {
	 if(cnt == m) {
		 if(!hs.contains(s)){
			 hs.add(s);
			 ans++;
		 }
		 return;
	 }
	 
	 for(int i =0; i<n; i++) {
		 if(v[i] == 0){
			 v[i] = 1;
			 func(cnt+1,s+arr[i]);
			 v[i] = 0;
		 }
	 }
 }
 
}
