import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class b5525 { // IOIOI
//kmp 알고리즘 적용
//패턴에서 실패함수(pi[i])를 구하는 부분과 
//이를 이용하여 전체 문자열에서 패턴을 찾는 부분으로 나누어 생각할 수 있다.
//실패함수를 찾는데 걸리는 시간 O(m), 전체 문자열에서 패턴을 찾는 시간 O(n)이므로 총 O(n+m)의 시간이 소모된다.
	static int n, m, pi[];
	static String str;
	
 public static void main(String[] args) throws IOException {
  BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
  n = Integer.parseInt(bf.readLine());
  m = Integer.parseInt(bf.readLine());
  str = bf.readLine();
  
  // pattern
  StringBuilder sb = new StringBuilder();
  sb.append("I");
  for(int i =0; i<n; i++) {
	  sb.append("OI");
  }
  //
  initPI(sb.toString());
  System.out.println(kmp(sb.toString()));
  bf.close();
 }
 
 static void initPI(String str) {
	 char arr[] = str.toCharArray(); // pattern
	 pi = new int[m];
	 int j = 0;
	 for(int i =1; i<arr.length; i++) { 
		 while(j>0 && arr[i] != arr[j]) {
			 j = pi[j-1];
		 }
		 if(arr[i] == arr[j]) {
			 pi[i] = (j+1);
			 j++;
		 }
	 }
 }
 
 static int kmp(String s) {
	 int cnt = 0;
	 int j =0 ;
	 char a[] = str.toCharArray();
	 char b[] = s.toCharArray(); //pattern
	 for(int i =0; i<m; i++) {
		 while(j>0 && a[i] != b[j]) {
			 j = pi[j-1];
		 }
		 
		 if(a[i] == b[j]) {
			 if(j == b.length-1) {
				 j = pi[j];
				 cnt ++;
			 }else {
				 j++;
			 }
		 }
		 
	 }
	 return cnt;
 }
 
 
}