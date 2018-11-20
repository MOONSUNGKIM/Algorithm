package SWEX_Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 public class s5603 { // 건초더미 
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	int arr[] ;
	// 건초더미 크기의 평균을 구한 후 큰 건초더미들에서 얼마나 빼줘야하는지를 계산!
	for(int t=1; t<=testcase ; t++) {
		int n = Integer.parseInt(bf.readLine());
		arr= new int[n];
		int avg = 0;
		for(int i =0; i<n; i++){
			arr[i] = Integer.parseInt(bf.readLine());
		    avg += arr[i];
		}
		avg = avg/n;
		int result = 0;
		for(int i =0; i<n; i++){
			if(arr[i] <= avg) continue;
			result += (arr[i]-avg);
		}
		System.out.println("#"+t+" "+result);
	}
	
	bf.close();
 }
 
}
