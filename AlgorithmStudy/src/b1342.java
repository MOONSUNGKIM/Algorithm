import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class b1342 { // 행운의 문자열 
	static String str;
	static int alpha[],ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	alpha = new int[26];
	str = bf.readLine();
	for(int i =0; i< str.length(); i++){
		alpha[str.charAt(i) -'a'] +=1;
	}
	ans = 0;
	for(int i =0; i<26; i++){
		if(alpha[i] > 0) {
			alpha[i] -=1;
		 func(i,1);
		 alpha[i] +=1;
		}
	}
	System.out.println(ans);
	bf.close();
 }
 
 static void func(int idx, int cnt) {
	 if(cnt == str.length()) {
		 ans++;
		 return;
	 }
	 for(int i =0; i<26; i++){
		 if(alpha[i] >0 && idx != i){
			 alpha[i] -=1;
			 func(i,cnt+1);
			 alpha[i] +=1;
		 }
	 }
 }
 
}
