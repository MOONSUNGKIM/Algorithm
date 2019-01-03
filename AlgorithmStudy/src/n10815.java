import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class n10815 { // 숫자카드 
	static int n,m,arr[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	arr = new int[n];
	StringTokenizer st  = new StringTokenizer(bf.readLine());
	for(int i =0; i<n; i++) {
		arr[i] =Integer.parseInt(st.nextToken());
	}
	StringBuilder sb = new StringBuilder();
	Arrays.sort(arr);
	m = Integer.parseInt(bf.readLine());
	st = new StringTokenizer(bf.readLine());
	for(int i =0; i<m; i++) {
		int findnumber = Integer.parseInt(st.nextToken());
		if(BSearch(findnumber) == false) {
			sb.append(0+" ");
		}else sb.append(1+" ");
	}
	System.out.println(sb.toString());
	bf.close();
 }
 
 static boolean BSearch(int findnumber) {
	 int left = 0, right = arr.length-1;
	 int mid =0;
	 while(left<=right) {
		 mid = (left+right)/2;
		 if(findnumber < arr[mid]) {
			right = mid-1;
		 }else if(findnumber > arr[mid]) {
			left = mid+1;
		 }else return true;
	 }
	 
	 return false;
 }
 
}
