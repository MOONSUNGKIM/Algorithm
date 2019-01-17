import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15874 { //Caesar Cipher
	static int k,s;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	k = Integer.parseInt(st.nextToken());// 
	s = Integer.parseInt(st.nextToken());
    String str = bf.readLine();
	char arr[] = str.toCharArray();
	StringBuilder sb = new StringBuilder();
	int cur = k;
	for(int i =0; i<s; i++) {
		if(arr[i] ==' '|| arr[i] == '.' || arr[i] == ',') {
			sb.append(arr[i]);
			continue;
		}
		cur = k ;
		if(arr[i] -'A' >=0 && arr[i] -'A' <=26) { //
			cur += arr[i]-'A';
			cur = func(cur);
			sb.append((char)(cur+'A'));
		}else {
			cur += arr[i]-'a';
			cur = func(cur);
			sb.append((char)(cur+'a'));
		}
	}
    System.out.println(sb.toString());
	bf.close();
 }
 
 static int func(int num) {
     //0,26,52,78... //a 
	 int x = num/26;
	 int sub = 26*x;
	 num-=sub;
	 return num;
 }
 
}
